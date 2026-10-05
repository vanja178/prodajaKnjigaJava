package operation.racun;

import java.util.List;
import model.ApstraktniDomenskiObjekat;
import model.Racun;
import model.StavkaRacuna;
import operation.SistemskaOperacija;

public class SODodajRacun extends SistemskaOperacija {

    private Long id;

    public Long getId() {
        return id;
    }

    @Override
    public void proveriOgranicenja(ApstraktniDomenskiObjekat objekat) throws Exception {
        if (!(objekat instanceof Racun i)) {
            throw new Exception("Prosledjeni objekat nije racun.");
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
        id = broker.dodaj(i);
        if (id == null || id <= 0) {
            return false;
        }
        i.setIdRacun(id);

        for (StavkaRacuna stavka : i.getStavke()) {
            stavka.setRacun(i);
            Long rb = broker.dodaj(stavka);
            if (rb == null || rb <= 0) {
                return false;
            }
        }
        return true;
    }
}
