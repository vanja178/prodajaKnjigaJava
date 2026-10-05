package operation.racun;

import java.util.List;
import model.ApstraktniDomenskiObjekat;
import model.Racun;
import model.StavkaRacuna;
import operation.SistemskaOperacija;

public class SOIzmeniRacun extends SistemskaOperacija {

    @Override
    public void proveriOgranicenja(ApstraktniDomenskiObjekat objekat) throws Exception {
        if (!(objekat instanceof Racun i)) {
            throw new Exception("Prosledjeni objekat nije racun.");
        }
        if (i.getIdRacun() == null || i.getIdRacun() <= 0) {
            throw new Exception("Identifikator racuna je obavezan podatak.");
        }
        if (i.getDatum() == null) {
            throw new Exception("Datum je obavezan podatak.");
        }

        if (i.getRadnik() == null || i.getRadnik().getIdRadnik() == null
                || i.getRadnik().getIdRadnik() <= 0) {
            throw new Exception("Radnik je obavezan podatak.");
        }
        if (i.getKupac() == null || i.getKupac().getIdKupac() == null
                || i.getKupac().getIdKupac() <= 0) {
            throw new Exception("Kupac je obavezan podatak.");
        }

        if (i.getPopust() < 0 || i.getPopust() > 100) {
            throw new Exception("Popust na racunu mora da bude izmedju 0 i 100.");
        }

        List<StavkaRacuna> stavke = i.getStavke();
        if (stavke == null || stavke.isEmpty()) {
            throw new Exception("Racun mora da ima bar jednu stavku.");
        }

        double zbir = 0;
        for (StavkaRacuna s : stavke) {
            if (s == null) {
                throw new Exception("Racun sadrzi praznu stavku.");
            }
            if (s.getKnjiga() == null || s.getKnjiga().getIdKnjiga() == null
                    || s.getKnjiga().getIdKnjiga() <= 0) {
                throw new Exception("Knjiga na stavci racuna je obavezan podatak.");
            }
            if (s.getKolicina() <= 0) {
                throw new Exception("Kolicina na stavci racuna mora da bude veca od 0.");
            }
            if (s.getCena() <= 0) {
                throw new Exception("Cena na stavci racuna mora da bude veca od 0.");
            }
            if (Math.abs(s.getCena() * s.getKolicina() - s.getIznos()) > 0.01) {
                throw new Exception("Iznos stavke mora da bude jednak cena * kolicina.");
            }
            zbir += s.getIznos();
        }

        if (i.getUkupanIznos() < 0) {
            throw new Exception("Ukupan iznos racuna ne sme da bude manji od 0.");
        }
        if (Math.abs(zbir * (1 - i.getPopust() / 100) - i.getUkupanIznos()) > 0.01) {
            throw new Exception("Ukupan iznos racuna mora da bude jednak zbiru iznosa svih stavki * (1 - popust/100).");
        }
    }

    @Override
    public boolean izvrsi(ApstraktniDomenskiObjekat objekat) throws Exception {
        Racun i = (Racun) objekat;

        if (!broker.izmeni(i)) {
            return false;
        }

        StavkaRacuna si = new StavkaRacuna();
        si.setRacun(i);
        List<ApstraktniDomenskiObjekat> stavkeIzBaze = broker.getSveJoin(si);

        for (StavkaRacuna stavka : i.getStavke()) {
            stavka.setRacun(i);
            if (stavka.getRb() != null && broker.getObjekat(stavka) != null) {
                broker.izmeni(stavka);
            } else {
                broker.dodaj(stavka);
            }
        }
        for (ApstraktniDomenskiObjekat s : stavkeIzBaze) {
            if (!i.getStavke().contains(s)) {
                broker.obrisi(s);
            }
        }
        return true;
    }
}
