package controller;

import java.util.List;
import model.Knjiga;
import model.Kupac;
import model.ApstraktniDomenskiObjekat;
import model.Radnik;
import model.RadnikSmena;
import model.Racun;
import model.Smena;
import model.Kategorija;
import operation.knjiga.SODodajKnjigu;
import operation.knjiga.SOIzmeniKnjigu;
import operation.knjiga.SOObrisiKnjigu;
import operation.knjiga.SOPrikaziKnjige;
import operation.kupac.SODodajKupca;
import operation.kupac.SOIzmeniKupca;
import operation.kupac.SOObrisiKupca;
import operation.kupac.SOPrikaziKupce;
import operation.radnik.SODodajRadnika;
import operation.radnik.SOIzmeniRadnika;
import operation.radnik.SOObrisiRadnika;
import operation.radnik.SOPrijava;
import operation.radnik.SOPrikaziRadnike;
import operation.radniksmena.SODodajRadnikSmenu;
import operation.radniksmena.SOIzmeniRadnikSmenu;
import operation.radniksmena.SOObrisiRadnikSmenu;
import operation.radniksmena.SOPrikaziRadnikSmene;
import operation.racun.SODodajRacun;
import operation.racun.SOIzmeniRacun;
import operation.racun.SOPrikaziRacune;
import operation.smena.SODodajSmenu;
import operation.smena.SOIzmeniSmenu;
import operation.smena.SOObrisiSmenu;
import operation.smena.SOPrikaziSmene;
import operation.kategorija.SODodajKategoriju;
import operation.kategorija.SOIzmeniKategoriju;
import operation.kategorija.SOObrisiKategoriju;
import operation.kategorija.SOPrikaziKategorije;

public class Kontroler {

    private static final Kontroler INSTANCA = new Kontroler();

    private Kontroler() {
    }

    public static Kontroler getInstance() {
        return INSTANCA;
    }

    public Radnik prijava(Radnik radnik) throws Exception {
        SOPrijava so = new SOPrijava();
        if (!so.izvrsiSO(radnik)) {
            throw new Exception("Korisnicko ime i sifra nisu ispravni.");
        }
        return so.getRadnik();
    }

    public List<ApstraktniDomenskiObjekat> getKategorije() throws Exception {
        SOPrikaziKategorije so = new SOPrikaziKategorije();
        so.izvrsiSO(new Kategorija());
        return so.getLista();
    }

    public Long dodajKategoriju(Kategorija k) throws Exception {
        SODodajKategoriju so = new SODodajKategoriju();
        so.izvrsiSO(k);
        return so.getId();
    }

    public boolean izmeniKategoriju(ApstraktniDomenskiObjekat objekat) throws Exception {
        SOIzmeniKategoriju so = new SOIzmeniKategoriju();
        return so.izvrsiSO(objekat);
    }

    public boolean obrisiKategoriju(ApstraktniDomenskiObjekat objekat) throws Exception {
        SOObrisiKategoriju so = new SOObrisiKategoriju();
        return so.izvrsiSO(objekat);
    }

    public List<ApstraktniDomenskiObjekat> getKupce() throws Exception {
        SOPrikaziKupce so = new SOPrikaziKupce();
        so.izvrsiSO(new Kupac());
        return so.getLista();
    }

    public Long dodajKupca(Kupac k) throws Exception {
        SODodajKupca so = new SODodajKupca();
        so.izvrsiSO(k);
        return so.getId();
    }

    public boolean izmeniKupca(ApstraktniDomenskiObjekat objekat) throws Exception {
        SOIzmeniKupca so = new SOIzmeniKupca();
        return so.izvrsiSO(objekat);
    }

    public boolean obrisiKupca(ApstraktniDomenskiObjekat objekat) throws Exception {
        SOObrisiKupca so = new SOObrisiKupca();
        return so.izvrsiSO(objekat);
    }

    public List<ApstraktniDomenskiObjekat> pretraziKupce(Kupac k) throws Exception {
        SOPrikaziKupce so = new SOPrikaziKupce();
        so.izvrsiSO(k);
        return so.getLista();
    }

    public List<ApstraktniDomenskiObjekat> pretraziKupce(Kategorija kat) throws Exception {
        SOPrikaziKupce so = new SOPrikaziKupce();
        Kupac k = new Kupac();
        k.setKategorija(kat);
        k.setKriterijum(k);
        so.izvrsiSO(k);
        return so.getLista();
    }

    public List<ApstraktniDomenskiObjekat> getKnjige() throws Exception {
        SOPrikaziKnjige so = new SOPrikaziKnjige();
        so.izvrsiSO(new Knjiga());
        return so.getLista();
    }

    public Long dodajKnjigu(Knjiga s) throws Exception {
        SODodajKnjigu so = new SODodajKnjigu();
        so.izvrsiSO(s);
        return so.getId();
    }

    public boolean izmeniKnjigu(ApstraktniDomenskiObjekat objekat) throws Exception {
        SOIzmeniKnjigu so = new SOIzmeniKnjigu();
        return so.izvrsiSO(objekat);
    }

    public boolean obrisiKnjigu(ApstraktniDomenskiObjekat objekat) throws Exception {
        SOObrisiKnjigu so = new SOObrisiKnjigu();
        return so.izvrsiSO(objekat);
    }

    public List<ApstraktniDomenskiObjekat> pretraziKnjige(ApstraktniDomenskiObjekat objekat) throws Exception {
        SOPrikaziKnjige so = new SOPrikaziKnjige();
        so.izvrsiSO((Knjiga) objekat);
        return so.getLista();
    }

    public Long dodajRacun(Racun i) throws Exception {
        SODodajRacun so = new SODodajRacun();
        so.izvrsiSO(i);
        return so.getId();
    }

    public List<ApstraktniDomenskiObjekat> pretraziRacune(Racun i2) throws Exception {
        SOPrikaziRacune so = new SOPrikaziRacune();
        Racun i = new Racun();
        i.setKriterijum(i2);
        so.izvrsiSO(i);
        return so.getLista();
    }

    public List<ApstraktniDomenskiObjekat> getRacune() throws Exception {
        SOPrikaziRacune so = new SOPrikaziRacune();
        so.izvrsiSO(new Racun());
        return so.getLista();
    }

    public boolean izmeniRacun(ApstraktniDomenskiObjekat objekat) throws Exception {
        SOIzmeniRacun so = new SOIzmeniRacun();
        return so.izvrsiSO(objekat);
    }

    public List<ApstraktniDomenskiObjekat> pretraziRadnike(ApstraktniDomenskiObjekat objekat) throws Exception {
        SOPrikaziRadnike so = new SOPrikaziRadnike();
        so.izvrsiSO((Radnik) objekat);
        return so.getLista();
    }

    public List<ApstraktniDomenskiObjekat> getRadnike() throws Exception {
        SOPrikaziRadnike so = new SOPrikaziRadnike();
        so.izvrsiSO(new Radnik());
        return so.getLista();
    }

    public Long dodajRadnika(Radnik z) throws Exception {
        SODodajRadnika so = new SODodajRadnika();
        so.izvrsiSO(z);
        return so.getId();
    }

    public boolean izmeniRadnika(ApstraktniDomenskiObjekat objekat) throws Exception {
        SOIzmeniRadnika so = new SOIzmeniRadnika();
        return so.izvrsiSO(objekat);
    }

    public boolean obrisiRadnika(ApstraktniDomenskiObjekat objekat) throws Exception {
        SOObrisiRadnika so = new SOObrisiRadnika();
        return so.izvrsiSO(objekat);
    }

    public List<ApstraktniDomenskiObjekat> getSmene() throws Exception {
        SOPrikaziSmene so = new SOPrikaziSmene();
        so.izvrsiSO(new Smena());
        return so.getLista();
    }

    public Long dodajSmenu(Smena s) throws Exception {
        SODodajSmenu so = new SODodajSmenu();
        so.izvrsiSO(s);
        return so.getId();
    }

    public boolean izmeniSmenu(ApstraktniDomenskiObjekat objekat) throws Exception {
        SOIzmeniSmenu so = new SOIzmeniSmenu();
        return so.izvrsiSO(objekat);
    }

    public boolean obrisiSmenu(ApstraktniDomenskiObjekat objekat) throws Exception {
        SOObrisiSmenu so = new SOObrisiSmenu();
        return so.izvrsiSO(objekat);
    }

    public List<ApstraktniDomenskiObjekat> getRadnikSmene() throws Exception {
        SOPrikaziRadnikSmene so = new SOPrikaziRadnikSmene();
        so.izvrsiSO(new RadnikSmena());
        return so.getLista();
    }

    public Long dodajRadnikSmenu(RadnikSmena zt) throws Exception {
        SODodajRadnikSmenu so = new SODodajRadnikSmenu();
        so.izvrsiSO(zt);
        return so.getId();
    }

    public boolean izmeniRadnikSmenu(ApstraktniDomenskiObjekat objekat) throws Exception {
        SOIzmeniRadnikSmenu so = new SOIzmeniRadnikSmenu();
        return so.izvrsiSO(objekat);
    }

    public boolean obrisiRadnikSmenu(ApstraktniDomenskiObjekat objekat) throws Exception {
        SOObrisiRadnikSmenu so = new SOObrisiRadnikSmenu();
        return so.izvrsiSO(objekat);
    }
}
