package controller;

import communication.Operacija;
import java.util.List;
import model.Kupac;
import model.ApstraktniDomenskiObjekat;
import model.Kategorija;

public class KupacKontroler extends KlijentKontroler {

    private static KupacKontroler instanca;

    private KupacKontroler() {
    }

    public static KupacKontroler getInstance() {
        if (instanca == null) {
            instanca = new KupacKontroler();
        }
        return instanca;
    }

    public Long dodajKupca(Kupac k) throws Exception {
        return (Long) posaljiZahtev(Operacija.DODAJ_KUPCA, k);
    }

    public List<ApstraktniDomenskiObjekat> getKupce() throws Exception {
        return (List<ApstraktniDomenskiObjekat>) posaljiZahtev(Operacija.PRIKAZI_KUPCE, null);
    }

    public void obrisiKupca(Kupac k) throws Exception {
        posaljiZahtev(Operacija.OBRISI_KUPCA, k);
    }

    public boolean izmeniKupca(Kupac k) throws Exception {
        return (boolean) posaljiZahtev(Operacija.IZMENI_KUPCA, k);
    }

    public List<ApstraktniDomenskiObjekat> pretraziKupce(String tekst) throws Exception {
        Kupac k = new Kupac();
        k.setKriterijum(tekst);
        return (List<ApstraktniDomenskiObjekat>) posaljiZahtev(Operacija.USLOV_KUPAC, k);
    }

    public List<ApstraktniDomenskiObjekat> pretraziKupce(Kategorija k) throws Exception {
        return (List<ApstraktniDomenskiObjekat>) posaljiZahtev(Operacija.USLOV_KUPAC, k);
    }

    public List<ApstraktniDomenskiObjekat> pretraziKupce(Kupac k) throws Exception {
        k.setKriterijum(k);
        return (List<ApstraktniDomenskiObjekat>) posaljiZahtev(Operacija.USLOV_KUPAC, k);
    }
}
