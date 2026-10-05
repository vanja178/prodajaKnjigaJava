package controller;

import communication.Operacija;
import communication.Primalac;
import communication.Zahtev;
import communication.Odgovor;
import communication.Posiljalac;
import java.io.IOException;
import java.net.Socket;

public class KlijentKontroler {

    private static Socket socket;
    private static Posiljalac posiljalac;
    private static Primalac primalac;

    private static final Object KLJUC = new Object();

    public KlijentKontroler() {
        povezi();
    }

    private static void povezi() {
        synchronized (KLJUC) {
            if (socket != null && !socket.isClosed()) {
                return;
            }
            try {
                socket = new Socket("localhost", 9000);
                posiljalac = new Posiljalac(socket);
                primalac = new Primalac(socket);
                System.out.println("Klijent je povezan na server.");
            } catch (IOException ex) {
                socket = null;
                posiljalac = null;
                primalac = null;
                System.out.println("Greska prilikom povezivanja na server!");
            }
        }
    }

    public Object posaljiZahtev(Operacija operacija, Object objekat) throws Exception {
        synchronized (KLJUC) {
            if (socket == null || socket.isClosed()) {
                povezi();
            }
            if (socket == null || socket.isClosed()) {
                throw new Exception("Nije uspostavljena veza sa serverom.");
            }

            posiljalac.posalji(new Zahtev(operacija, objekat));
            Odgovor odgovor = (Odgovor) primalac.primi();

            if (odgovor.getIzuzetak() != null) {
                throw odgovor.getIzuzetak();
            }
            return odgovor.getRezultat();
        }
    }

    public void prekiniVezu() {
        synchronized (KLJUC) {
            try {
                if (socket != null && !socket.isClosed()) {
                    socket.close();
                }
            } catch (IOException ex) {
                System.out.println("Greska prilikom zatvaranja veze: " + ex.getMessage());
            }
            socket = null;
            posiljalac = null;
            primalac = null;
        }
    }
}
