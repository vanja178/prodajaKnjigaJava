package controller;

import communication.Operacija;
import java.util.List;
import model.Knjiga;
import model.ApstraktniDomenskiObjekat;

public class KnjigaKontroler extends KlijentKontroler {

    private static KnjigaKontroler instanca;

    private KnjigaKontroler() {
    }

    public static KnjigaKontroler getInstance() {
        if (instanca == null) {
            instanca = new KnjigaKontroler();
        }
        return instanca;
    }

    public Long dodajKnjigu(Knjiga s) throws Exception {
        return (Long) posaljiZahtev(Operacija.DODAJ_KNJIGU, s);
    }

    public List<ApstraktniDomenskiObjekat> getKnjige() throws Exception {
        return (List<ApstraktniDomenskiObjekat>) posaljiZahtev(Operacija.PRIKAZI_KNJIGE, null);
    }

    public void obrisiKnjigu(Knjiga s) throws Exception {
        posaljiZahtev(Operacija.OBRISI_KNJIGU, s);
    }

    public boolean izmeniKnjigu(Knjiga s) throws Exception {
        return (boolean) posaljiZahtev(Operacija.IZMENI_KNJIGU, s);
    }

    public List<ApstraktniDomenskiObjekat> pretraziKnjige(String tekst) throws Exception {
        Knjiga s = new Knjiga();
        s.setKriterijum(tekst);
        return (List<ApstraktniDomenskiObjekat>) posaljiZahtev(Operacija.USLOV_KNJIGA, s);
    }
}
