package controller;

import communication.Operacija;
import java.util.List;
import model.ApstraktniDomenskiObjekat;
import model.RadnikSmena;

public class RadnikSmenaKontroler extends KlijentKontroler {

    private static RadnikSmenaKontroler instanca;

    private RadnikSmenaKontroler() {
    }

    public static RadnikSmenaKontroler getInstance() {
        if (instanca == null) {
            instanca = new RadnikSmenaKontroler();
        }
        return instanca;
    }

    public List<ApstraktniDomenskiObjekat> getRadnikSmene() throws Exception {
        return (List<ApstraktniDomenskiObjekat>) posaljiZahtev(Operacija.PRIKAZI_RADNIKSMENE, null);
    }

    public Long dodajRadnikSmenu(RadnikSmena zt) throws Exception {
        return (Long) posaljiZahtev(Operacija.DODAJ_RADNIKSMENU, zt);
    }

    public boolean izmeniRadnikSmenu(RadnikSmena zt) throws Exception {
        return (boolean) posaljiZahtev(Operacija.IZMENI_RADNIKSMENU, zt);
    }

    public void obrisiRadnikSmenu(RadnikSmena zt) throws Exception {
        posaljiZahtev(Operacija.OBRISI_RADNIKSMENU, zt);
    }
}
