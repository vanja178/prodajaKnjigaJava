package controller;

import communication.Operacija;
import java.util.List;
import model.ApstraktniDomenskiObjekat;
import model.Kategorija;

public class KategorijaKontroler extends KlijentKontroler {

    private static KategorijaKontroler instanca;

    private KategorijaKontroler() {
    }

    public static KategorijaKontroler getInstance() {
        if (instanca == null) {
            instanca = new KategorijaKontroler();
        }
        return instanca;
    }

    public Long dodajKategoriju(Kategorija k) throws Exception {
        return (Long) posaljiZahtev(Operacija.DODAJ_KATEGORIJU, k);
    }

    public List<ApstraktniDomenskiObjekat> getKategorije() throws Exception {
        return (List<ApstraktniDomenskiObjekat>) posaljiZahtev(Operacija.PRIKAZI_KATEGORIJE, null);
    }

    public void obrisiKategoriju(Kategorija k) throws Exception {
        posaljiZahtev(Operacija.OBRISI_KATEGORIJU, k);
    }

    public boolean izmeniKategoriju(Kategorija k) throws Exception {
        return (boolean) posaljiZahtev(Operacija.IZMENI_KATEGORIJU, k);
    }
}
