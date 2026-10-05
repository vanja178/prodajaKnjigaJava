package server;

import configuration.Konfiguracija;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Radnik;
import threads.ObradaKlijentskihZahteva;

public class Server extends Thread {

    boolean flag = false;
    ServerSocket serverSocket;

    List<ObradaKlijentskihZahteva> lista = Collections.synchronizedList(new ArrayList<>());

    private static final Set<Long> PRIJAVLJENI = Collections.synchronizedSet(new HashSet<>());

    public static void prijaviRadnika(Radnik radnik) throws Exception {
        if (radnik == null || radnik.getIdRadnik() == null) {
            throw new Exception("Korisnicko ime i sifra nisu ispravni.");
        }
        synchronized (PRIJAVLJENI) {
            if (PRIJAVLJENI.contains(radnik.getIdRadnik())) {
                throw new Exception("Korisnik " + radnik.getKorisnickoIme() + " je vec prijavljen na sistem.");
            }
            PRIJAVLJENI.add(radnik.getIdRadnik());
        }
        System.out.println("Prijavljen radnik: " + radnik.getKorisnickoIme()
                + " (trenutno prijavljenih: " + PRIJAVLJENI.size() + ")");
    }

    public static void odjaviRadnika(Radnik radnik) {
        if (radnik == null || radnik.getIdRadnik() == null) {
            return;
        }
        if (PRIJAVLJENI.remove(radnik.getIdRadnik())) {
            System.out.println("Odjavljen radnik: " + radnik.getKorisnickoIme()
                    + " (trenutno prijavljenih: " + PRIJAVLJENI.size() + ")");
        }
    }

    @Override
    public void run() {
        try {
            int port = Integer.parseInt(Konfiguracija.getInstance().getProperty("port"));
            serverSocket = new ServerSocket(port);
            System.out.println("Cekam klijenta na portu " + port);
            while (!flag) {
                Socket socket = serverSocket.accept();
                System.out.println("Klijent se povezao");
                ObradaKlijentskihZahteva klijent = new ObradaKlijentskihZahteva(socket);
                lista.add(klijent);
                klijent.start();
            }
        } catch (IOException ex) {
            if (!flag) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void zaustaviServer() {
        flag = true;
        try {
            synchronized (lista) {
                for (ObradaKlijentskihZahteva klijent : lista) {
                    klijent.zaustaviThread();
                }
                lista.clear();
            }
            PRIJAVLJENI.clear();
            if (serverSocket != null && !serverSocket.isClosed()) {
                serverSocket.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
