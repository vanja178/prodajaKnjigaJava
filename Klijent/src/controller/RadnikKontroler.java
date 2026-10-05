package controller;

import communication.Operacija;
import java.util.List;
import model.ApstraktniDomenskiObjekat;
import model.Radnik;

public class RadnikKontroler extends KlijentKontroler {

    private static RadnikKontroler instanca;

    private RadnikKontroler() {
    }

    public static RadnikKontroler getInstance() {
        if (instanca == null) {
            instanca = new RadnikKontroler();
        }
        return instanca;
    }

    public Radnik prijava(Radnik z) throws Exception {
        return (Radnik) posaljiZahtev(Operacija.PRIJAVA, z);
    }

    public void odjava() throws Exception {
        posaljiZahtev(Operacija.ODJAVA, null);
    }

    public List<ApstraktniDomenskiObjekat> getRadnike() throws Exception {
        return (List<ApstraktniDomenskiObjekat>) posaljiZahtev(Operacija.PRIKAZI_RADNIKE, null);
    }

    public Long dodajRadnika(Radnik z) throws Exception {
        return (Long) posaljiZahtev(Operacija.DODAJ_RADNIKA, z);
    }

    public boolean izmeniRadnika(Radnik z) throws Exception {
        return (boolean) posaljiZahtev(Operacija.IZMENI_RADNIKA, z);
    }

    public void obrisiRadnika(Radnik z) throws Exception {
        posaljiZahtev(Operacija.OBRISI_RADNIKA, z);
    }

    public List<ApstraktniDomenskiObjekat> pretraziRadnike(String tekst) throws Exception {
        Radnik z = new Radnik();
        z.setKriterijum(tekst);
        return (List<ApstraktniDomenskiObjekat>) posaljiZahtev(Operacija.USLOV_RADNIK, z);
    }
}
