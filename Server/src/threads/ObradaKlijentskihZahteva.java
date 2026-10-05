package threads;

import communication.Primalac;
import communication.Zahtev;
import communication.Odgovor;
import communication.Posiljalac;
import controller.Kontroler;
import java.io.IOException;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Knjiga;
import model.Kupac;
import model.ApstraktniDomenskiObjekat;
import model.Radnik;
import model.RadnikSmena;
import model.Racun;
import model.Smena;
import model.Kategorija;
import server.Server;

public class ObradaKlijentskihZahteva extends Thread {

    Socket socket;
    Posiljalac posiljalac;
    Primalac primalac;
    boolean flag = false;
    Object o;
    Long id = 0L;

    private Radnik prijavljeniRadnik;

    public ObradaKlijentskihZahteva(Socket socket) {
        this.socket = socket;
        posiljalac = new Posiljalac(socket);
        primalac = new Primalac(socket);
    }

    public Radnik getPrijavljeniRadnik() {
        return prijavljeniRadnik;
    }

    @Override
    public void run() {

        while (!flag && socket != null && !socket.isClosed()) {

            Zahtev zahtev;
            try {
                zahtev = (Zahtev) primalac.primi();
            } catch (Exception ex) {
                System.out.println("Klijent je prekinuo vezu.");
                break;
            }

            Odgovor odgovor = new Odgovor();

            switch (zahtev.getOperacija()) {
                case PRIJAVA:
                    Radnik z = (Radnik) zahtev.getArgument();
                    try {
                        z = Kontroler.getInstance().prijava(z);
                        Server.prijaviRadnika(z);
                        prijavljeniRadnik = z;
                        odgovor.setRezultat(z);
                    } catch (Exception e) {
                        odgovor.setIzuzetak(e);
                    }
                    break;

                case ODJAVA:
                    try {
                        Server.odjaviRadnika(prijavljeniRadnik);
                        prijavljeniRadnik = null;
                        odgovor.setRezultat(true);
                    } catch (Exception e) {
                        odgovor.setIzuzetak(e);
                    }
                    break;

                case DODAJ_KUPCA:
                    Kupac k = (Kupac) zahtev.getArgument();
                    try {
                        id = Kontroler.getInstance().dodajKupca(k);
                        if (id != null && id > 0) {
                            odgovor.setRezultat(id);
                        } else {
                            throw new Exception("Kupac nije dodat!");
                        }
                    } catch (Exception e) {
                        odgovor.setIzuzetak(e);
                    }
                    break;

                case PRIKAZI_KUPCE:
                    try {
                        odgovor.setRezultat(Kontroler.getInstance().getKupce());
                    } catch (Exception e) {
                        odgovor.setIzuzetak(e);
                    }
                    break;

                case OBRISI_KUPCA:
                    try {
                        if (Kontroler.getInstance().obrisiKupca((ApstraktniDomenskiObjekat) zahtev.getArgument())) {
                            odgovor.setRezultat(true);
                        } else {
                            throw new Exception("Sistem nije obrisao kupca!");
                        }
                    } catch (Exception e) {
                        odgovor.setIzuzetak(e);
                    }
                    break;

                case IZMENI_KUPCA:
                    try {
                        if (Kontroler.getInstance().izmeniKupca((ApstraktniDomenskiObjekat) zahtev.getArgument())) {
                            odgovor.setRezultat(true);
                        } else {
                            throw new Exception("Kupac nije izmenjen!");
                        }
                    } catch (Exception e) {
                        odgovor.setIzuzetak(e);
                    }
                    break;

                case USLOV_KUPAC:
                    o = zahtev.getArgument();
                    try {
                        if (o instanceof Kategorija) {
                            List<ApstraktniDomenskiObjekat> l = Kontroler.getInstance().pretraziKupce((Kategorija) o);
                            odgovor.setRezultat(l);
                        }
                        if (o instanceof Kupac) {
                            List<ApstraktniDomenskiObjekat> l = Kontroler.getInstance().pretraziKupce((Kupac) o);
                            odgovor.setRezultat(l);
                        }
                    } catch (Exception e) {
                        odgovor.setIzuzetak(e);
                    }
                    break;

                case DODAJ_KATEGORIJU:
                    Kategorija kat = (Kategorija) zahtev.getArgument();
                    try {
                        id = Kontroler.getInstance().dodajKategoriju(kat);
                        if (id != null && id > 0) {
                            odgovor.setRezultat(id);
                        } else {
                            throw new Exception("Kategorija nije dodata!");
                        }
                    } catch (Exception e) {
                        odgovor.setIzuzetak(e);
                    }
                    break;

                case PRIKAZI_KATEGORIJE:
                    try {
                        odgovor.setRezultat(Kontroler.getInstance().getKategorije());
                    } catch (Exception e) {
                        odgovor.setIzuzetak(e);
                    }
                    break;

                case IZMENI_KATEGORIJU:
                    try {
                        if (Kontroler.getInstance().izmeniKategoriju((ApstraktniDomenskiObjekat) zahtev.getArgument())) {
                            odgovor.setRezultat(true);
                        } else {
                            throw new Exception("Kategorija nije izmenjena!");
                        }
                    } catch (Exception e) {
                        odgovor.setIzuzetak(e);
                    }
                    break;

                case OBRISI_KATEGORIJU:
                    try {
                        if (Kontroler.getInstance().obrisiKategoriju((ApstraktniDomenskiObjekat) zahtev.getArgument())) {
                            odgovor.setRezultat(true);
                        } else {
                            throw new Exception("Kategorija nije obrisana!");
                        }
                    } catch (Exception e) {
                        odgovor.setIzuzetak(e);
                    }
                    break;

                case DODAJ_KNJIGU:
                    Knjiga kn = (Knjiga) zahtev.getArgument();
                    try {
                        id = Kontroler.getInstance().dodajKnjigu(kn);
                        if (id != null && id > 0) {
                            odgovor.setRezultat(id);
                        } else {
                            throw new Exception("Knjiga nije dodata!");
                        }
                    } catch (Exception e) {
                        odgovor.setIzuzetak(e);
                    }
                    break;

                case PRIKAZI_KNJIGE:
                    try {
                        odgovor.setRezultat(Kontroler.getInstance().getKnjige());
                    } catch (Exception e) {
                        odgovor.setIzuzetak(e);
                    }
                    break;

                case IZMENI_KNJIGU:
                    try {
                        if (Kontroler.getInstance().izmeniKnjigu((ApstraktniDomenskiObjekat) zahtev.getArgument())) {
                            odgovor.setRezultat(true);
                        } else {
                            throw new Exception("Knjiga nije izmenjena!");
                        }
                    } catch (Exception e) {
                        odgovor.setIzuzetak(e);
                    }
                    break;

                case OBRISI_KNJIGU:
                    try {
                        if (Kontroler.getInstance().obrisiKnjigu((ApstraktniDomenskiObjekat) zahtev.getArgument())) {
                            odgovor.setRezultat(true);
                        } else {
                            throw new Exception("Knjiga nije obrisana!");
                        }
                    } catch (Exception e) {
                        odgovor.setIzuzetak(e);
                    }
                    break;

                case USLOV_KNJIGA:
                    try {
                        List<ApstraktniDomenskiObjekat> l = Kontroler.getInstance().pretraziKnjige((ApstraktniDomenskiObjekat) zahtev.getArgument());
                        odgovor.setRezultat(l);
                    } catch (Exception e) {
                        odgovor.setIzuzetak(e);
                    }
                    break;

                case DODAJ_RADNIKA:
                    Radnik zap = (Radnik) zahtev.getArgument();
                    try {
                        id = Kontroler.getInstance().dodajRadnika(zap);
                        if (id != null && id > 0) {
                            odgovor.setRezultat(id);
                        } else {
                            throw new Exception("Radnik nije dodat!");
                        }
                    } catch (Exception e) {
                        odgovor.setIzuzetak(e);
                    }
                    break;

                case PRIKAZI_RADNIKE:
                    try {
                        odgovor.setRezultat(Kontroler.getInstance().getRadnike());
                    } catch (Exception e) {
                        odgovor.setIzuzetak(e);
                    }
                    break;

                case IZMENI_RADNIKA:
                    try {
                        if (Kontroler.getInstance().izmeniRadnika((ApstraktniDomenskiObjekat) zahtev.getArgument())) {
                            odgovor.setRezultat(true);
                        } else {
                            throw new Exception("Radnik nije izmenjen!");
                        }
                    } catch (Exception e) {
                        odgovor.setIzuzetak(e);
                    }
                    break;

                case OBRISI_RADNIKA:
                    try {
                        if (Kontroler.getInstance().obrisiRadnika((ApstraktniDomenskiObjekat) zahtev.getArgument())) {
                            odgovor.setRezultat(true);
                        } else {
                            throw new Exception("Radnik nije obrisan!");
                        }
                    } catch (Exception e) {
                        odgovor.setIzuzetak(e);
                    }
                    break;

                case USLOV_RADNIK:
                    try {
                        List<ApstraktniDomenskiObjekat> l = Kontroler.getInstance().pretraziRadnike((ApstraktniDomenskiObjekat) zahtev.getArgument());
                        odgovor.setRezultat(l);
                    } catch (Exception e) {
                        odgovor.setIzuzetak(e);
                    }
                    break;

                case DODAJ_SMENU:
                    Smena sm = (Smena) zahtev.getArgument();
                    try {
                        id = Kontroler.getInstance().dodajSmenu(sm);
                        if (id != null && id > 0) {
                            odgovor.setRezultat(id);
                        } else {
                            throw new Exception("Smena nije dodata!");
                        }
                    } catch (Exception e) {
                        odgovor.setIzuzetak(e);
                    }
                    break;

                case PRIKAZI_SMENE:
                    try {
                        odgovor.setRezultat(Kontroler.getInstance().getSmene());
                    } catch (Exception e) {
                        odgovor.setIzuzetak(e);
                    }
                    break;

                case IZMENI_SMENU:
                    try {
                        if (Kontroler.getInstance().izmeniSmenu((ApstraktniDomenskiObjekat) zahtev.getArgument())) {
                            odgovor.setRezultat(true);
                        } else {
                            throw new Exception("Smena nije izmenjena!");
                        }
                    } catch (Exception e) {
                        odgovor.setIzuzetak(e);
                    }
                    break;

                case OBRISI_SMENU:
                    try {
                        if (Kontroler.getInstance().obrisiSmenu((ApstraktniDomenskiObjekat) zahtev.getArgument())) {
                            odgovor.setRezultat(true);
                        } else {
                            throw new Exception("Smena nije obrisana!");
                        }
                    } catch (Exception e) {
                        odgovor.setIzuzetak(e);
                    }
                    break;

                case DODAJ_RACUN:
                    Racun i = (Racun) zahtev.getArgument();
                    try {
                        id = Kontroler.getInstance().dodajRacun(i);
                        if (id != null && id > 0) {
                            odgovor.setRezultat(id);
                        } else {
                            throw new Exception("Racun nije dodat!");
                        }
                    } catch (Exception e) {
                        odgovor.setIzuzetak(e);
                    }
                    break;

                case PRIKAZI_RACUNE:
                    try {
                        odgovor.setRezultat(Kontroler.getInstance().getRacune());
                    } catch (Exception e) {
                        odgovor.setIzuzetak(e);
                    }
                    break;

                case IZMENI_RACUN:
                    try {
                        if (Kontroler.getInstance().izmeniRacun((ApstraktniDomenskiObjekat) zahtev.getArgument())) {
                            odgovor.setRezultat(true);
                        } else {
                            throw new Exception("Racun nije izmenjen!");
                        }
                    } catch (Exception e) {
                        odgovor.setIzuzetak(e);
                    }
                    break;

                case USLOV_RACUN:
                    Racun i2 = (Racun) zahtev.getArgument();
                    try {
                        List<ApstraktniDomenskiObjekat> l = Kontroler.getInstance().pretraziRacune(i2);
                        odgovor.setRezultat(l);
                    } catch (Exception e) {
                        odgovor.setIzuzetak(e);
                    }
                    break;

                case DODAJ_RADNIKSMENU:
                    RadnikSmena zt = (RadnikSmena) zahtev.getArgument();
                    try {
                        id = Kontroler.getInstance().dodajRadnikSmenu(zt);
                        if (id != null && id > 0) {
                            odgovor.setRezultat(id);
                        } else {
                            throw new Exception("Radnik smena nije dodata!");
                        }
                    } catch (Exception e) {
                        odgovor.setIzuzetak(e);
                    }
                    break;

                case PRIKAZI_RADNIKSMENE:
                    try {
                        odgovor.setRezultat(Kontroler.getInstance().getRadnikSmene());
                    } catch (Exception e) {
                        odgovor.setIzuzetak(e);
                    }
                    break;

                case IZMENI_RADNIKSMENU:
                    try {
                        if (Kontroler.getInstance().izmeniRadnikSmenu((ApstraktniDomenskiObjekat) zahtev.getArgument())) {
                            odgovor.setRezultat(true);
                        } else {
                            throw new Exception("Radnik smena nije izmenjena!");
                        }
                    } catch (Exception e) {
                        odgovor.setIzuzetak(e);
                    }
                    break;

                case OBRISI_RADNIKSMENU:
                    try {
                        if (Kontroler.getInstance().obrisiRadnikSmenu((ApstraktniDomenskiObjekat) zahtev.getArgument())) {
                            odgovor.setRezultat(true);
                        } else {
                            throw new Exception("Radnik smena nije obrisana!");
                        }
                    } catch (Exception e) {
                        odgovor.setIzuzetak(e);
                    }
                    break;

                default:
                    odgovor.setIzuzetak(new Exception("Nepoznata operacija!"));
                    break;
            }

            try {
                posiljalac.posalji(odgovor);
            } catch (Exception ex) {
                Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
                break;
            }

            if (zahtev.getOperacija() == communication.Operacija.ODJAVA) {
                break;
            }
        }

        oslobodiResurse();
    }

    private void oslobodiResurse() {
        Server.odjaviRadnika(prijavljeniRadnik);
        prijavljeniRadnik = null;
        try {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void zaustaviThread() {
        flag = true;
        oslobodiResurse();
        interrupt();
    }
}
