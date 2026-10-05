package controller;

import communication.Operacija;
import java.util.List;
import model.ApstraktniDomenskiObjekat;
import model.Smena;

public class SmenaKontroler extends KlijentKontroler {

    private static SmenaKontroler instanca;

    private SmenaKontroler() {
    }

    public static SmenaKontroler getInstance() {
        if (instanca == null) {
            instanca = new SmenaKontroler();
        }
        return instanca;
    }

    public List<ApstraktniDomenskiObjekat> getSmene() throws Exception {
        return (List<ApstraktniDomenskiObjekat>) posaljiZahtev(Operacija.PRIKAZI_SMENE, null);
    }

    public Long dodajSmenu(Smena s) throws Exception {
        return (Long) posaljiZahtev(Operacija.DODAJ_SMENU, s);
    }

    public boolean izmeniSmenu(Smena s) throws Exception {
        return (boolean) posaljiZahtev(Operacija.IZMENI_SMENU, s);
    }

    public void obrisiSmenu(Smena s) throws Exception {
        posaljiZahtev(Operacija.OBRISI_SMENU, s);
    }
}
