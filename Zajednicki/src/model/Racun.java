package model;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Racun implements ApstraktniDomenskiObjekat, Serializable {

    private Long idRacun;
    private LocalDate datum;
    private double ukupanIznos;
    private double popust;
    private Radnik radnik;
    private Kupac kupac;

    private List<StavkaRacuna> stavke;

    private String kriterijum;

    public Racun() {
    }

    public Racun(Radnik z, Kupac k, List<StavkaRacuna> list) {
        radnik = z;
        kupac = k;
        stavke = list;
    }

    public Racun(LocalDate datum, double ukupanIznos, double popust, Radnik radnik, Kupac kupac, List<StavkaRacuna> stavke) {
        this.datum = datum;
        this.ukupanIznos = ukupanIznos;
        this.popust = popust;
        this.radnik = radnik;
        this.kupac = kupac;
        this.stavke = stavke;
    }

    public Racun(Long idRacun) {
        this.idRacun = idRacun;
    }

    public String getKriterijum() {
        return kriterijum;
    }

    public void setKriterijum(String kriterijum) {
        this.kriterijum = kriterijum;
    }

    public Racun(Long idRacun, LocalDate datum, double ukupanIznos, double popust, Radnik radnik, Kupac kupac, List<StavkaRacuna> stavke) {
        this.idRacun = idRacun;
        this.datum = datum;
        this.ukupanIznos = ukupanIznos;
        this.popust = popust;
        this.radnik = radnik;
        this.kupac = kupac;
        this.stavke = stavke;
    }

    public Racun(Long idRacun, LocalDate datum, double ukupanIznos, double popust, Radnik radnik, Kupac kupac) {
        this.idRacun = idRacun;
        this.datum = datum;
        this.ukupanIznos = ukupanIznos;
        this.popust = popust;
        this.radnik = radnik;
        this.kupac = kupac;
    }

    public List<StavkaRacuna> getStavke() {
        return stavke;
    }

    public void setStavke(List<StavkaRacuna> stavke) {
        this.stavke = stavke;
    }

    Racun(ResultSet rs) {
        try {
            idRacun = rs.getLong("racun.idRacun");
            datum = rs.getDate("racun.datum").toLocalDate();
            ukupanIznos = rs.getDouble("racun.ukupanIznos");
            popust = rs.getDouble("racun.popust");
            Radnik z = new Radnik(rs);
            Kupac k = new Kupac(rs);
            radnik = z;
            kupac = k;
        } catch (SQLException ex) {
            Logger.getLogger(Racun.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Long getIdRacun() {
        return idRacun;
    }

    public void setIdRacun(Long idRacun) {
        this.idRacun = idRacun;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public double getUkupanIznos() {
        return ukupanIznos;
    }

    public void setUkupanIznos(double ukupanIznos) {
        this.ukupanIznos = ukupanIznos;
    }

    public double getPopust() {
        return popust;
    }

    public void setPopust(double popust) {
        this.popust = popust;
    }

    public Radnik getRadnik() {
        return radnik;
    }

    public void setRadnik(Radnik radnik) {
        this.radnik = radnik;
    }

    public Kupac getKupac() {
        return kupac;
    }

    public void setKupac(Kupac kupac) {
        this.kupac = kupac;
    }

    @Override
    public String toString() {
        return "id=" + idRacun;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.idRacun);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Racun other = (Racun) obj;
        return Objects.equals(this.idRacun, other.idRacun);
    }

    @Override
    public String getNazivTabele() {
        return " racun ";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> getLista(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> list = new ArrayList<>();
        while (rs.next()) {
            Long id = rs.getLong("racun.idRacun");
            LocalDate d = rs.getDate("racun.datum").toLocalDate();
            double ukupno = rs.getDouble("racun.ukupanIznos");
            double p = rs.getDouble("racun.popust");
            Radnik z = new Radnik(rs);
            Kupac k = new Kupac(rs);
            Racun i = new Racun(id, d, ukupno, p, z, k);
            if (!list.contains(i)) {
                list.add(i);
            }
        }
        return list;
    }

    @Override
    public String getKoloneZaUnos() {
        return "datum,ukupanIznos,popust,radnik,kupac";
    }

    @Override
    public String getVrednostiZaUnos() {
        return "'" + datum + "', " + ukupanIznos + ", " + popust + ", " + radnik.getIdRadnik() + ", " + kupac.getIdKupac();
    }

    @Override
    public String getGenerisaniKljuc() {
        return " racun.idRacun=" + idRacun;
    }

    @Override
    public ApstraktniDomenskiObjekat getObjekat(ResultSet rs) throws Exception {
        if (rs.next()) {
            Long id = rs.getLong("racun.idRacun");
            LocalDate d = rs.getDate("racun.datum").toLocalDate();
            double ukupno = rs.getDouble("racun.ukupanIznos");
            double p = rs.getDouble("racun.popust");
            Radnik z = new Radnik(rs);
            Kupac k = new Kupac(rs);
            return new Racun(id, d, ukupno, p, z, k);
        }
        return null;
    }

    @Override
    public String getVrednostZaIzmenu() {
        return " radnik=" + radnik.getIdRadnik() + ", kupac=" + kupac.getIdKupac()
                + ", datum='" + datum + "', ukupanIznos=" + ukupanIznos + ", popust=" + popust;
    }

    @Override
    public String getUslov() {
        if (kriterijum == null) {
            return "";
        }
        return kriterijum;
    }

    @Override
    public String join() {
        return " JOIN radnik on racun.radnik=radnik.idRadnik JOIN kupac on kupac.idKupac=racun.kupac JOIN kategorija ON kategorija.idKategorija=kupac.kategorija JOIN stavkaracuna ON racun.idRacun=stavkaracuna.racun JOIN knjiga ON stavkaracuna.knjiga = knjiga.idKnjiga ";
    }

    @Override
    public Object[] getNizObjekta() {
        Object[] o = {datum, ukupanIznos, popust, radnik.getIme() + " " + radnik.getPrezime(), kupac.getIme() + " " + kupac.getPrezime()};
        return o;
    }

    @Override
    public String[] getNazivKolone() {
        String[] s = {"Datum", "Ukupan iznos", "Popust", "Radnik", "Kupac"};
        return s;
    }

    @Override
    public String getUslovRb() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setKriterijum(Racun i) {
        if (i == null) {
            return;
        }
        if (i.idRacun != null && i.idRacun > 0) {
            setUslov(i.idRacun);
        }
        if (i.getRadnik() != null) {
            setUslov(i.getRadnik());
        }
        if (i.getKupac() != null) {
            setUslov(i.getKupac());
        }
        if (i.getStavke() != null) {
            for (StavkaRacuna stavka : i.getStavke()) {
                if (stavka != null && stavka.getKnjiga() != null) {
                    setUslov(stavka.getKnjiga());
                }
            }
        }
    }

    private void setUslov(Long id) {
        if (kriterijum != null) {
            kriterijum += " AND racun.idRacun =" + id;
        } else {
            kriterijum = " WHERE racun.idRacun =" + id;
        }
    }

    private void setUslov(Radnik radnik) {
        if (radnik == null) {
            return;
        }
        String uslov;
        if (radnik.getIdRadnik() != null && radnik.getIdRadnik() > 0) {
            uslov = " radnik.idRadnik =" + radnik.getIdRadnik();
        } else if (radnik.getIme() != null && !radnik.getIme().trim().isEmpty()) {
            String tekst = radnik.getIme().trim();
            uslov = "(radnik.ime LIKE '%" + tekst + "%'"
                    + " OR radnik.prezime LIKE '%" + tekst + "%'"
                    + " OR CONCAT(radnik.ime, ' ', radnik.prezime) LIKE '%" + tekst + "%')";
        } else {
            return;
        }
        if (kriterijum != null) {
            kriterijum += " AND " + uslov;
            return;
        }
        kriterijum = " WHERE " + uslov;
    }

    private void setUslov(Kupac kupac) {
        if (kupac == null) {
            return;
        }
        String uslov;
        if (kupac.getIdKupac() != null && kupac.getIdKupac() > 0) {
            uslov = " kupac.idKupac =" + kupac.getIdKupac();
        } else if (kupac.getIme() != null && !kupac.getIme().trim().isEmpty()) {
            String tekst = kupac.getIme().trim();
            uslov = "(kupac.ime LIKE '%" + tekst + "%'"
                    + " OR kupac.prezime LIKE '%" + tekst + "%'"
                    + " OR CONCAT(kupac.ime, ' ', kupac.prezime) LIKE '%" + tekst + "%')";
        } else {
            return;
        }
        if (kriterijum != null) {
            kriterijum += " AND " + uslov;
            return;
        }
        kriterijum = " WHERE " + uslov;
    }

    private void setUslov(Knjiga knjiga) {
        if (knjiga == null || ((knjiga.getIdKnjiga() == null || knjiga.getIdKnjiga() <= 0) && knjiga.getNaziv() == null)) {
            return;
        }
        if (kriterijum != null) {
            kriterijum += " AND " + knjiga.getUslovRacun();
            return;
        }
        kriterijum = " WHERE " + knjiga.getUslovRacun();
    }
}
