package controller;

import communication.Operacija;
import java.util.List;
import model.ApstraktniDomenskiObjekat;
import model.Racun;

public class RacunKontroler extends KlijentKontroler {

    private static RacunKontroler instanca;

    private RacunKontroler() {
    }

    public static RacunKontroler getInstance() {
        if (instanca == null) {
            instanca = new RacunKontroler();
        }
        return instanca;
    }

    public Long dodajRacun(Racun racun) throws Exception {
        return (Long) posaljiZahtev(Operacija.DODAJ_RACUN, racun);
    }

    public List<ApstraktniDomenskiObjekat> pretraziRacune(Racun racun) throws Exception {
        return (List<ApstraktniDomenskiObjekat>) posaljiZahtev(Operacija.USLOV_RACUN, racun);
    }

    public List<ApstraktniDomenskiObjekat> getRacune() throws Exception {
        return (List<ApstraktniDomenskiObjekat>) posaljiZahtev(Operacija.PRIKAZI_RACUNE, null);
    }

    public boolean izmeniRacun(Racun i) throws Exception {
        return (boolean) posaljiZahtev(Operacija.IZMENI_RACUN, i);
    }
}
