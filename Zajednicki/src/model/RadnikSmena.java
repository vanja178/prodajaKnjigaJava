package model;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RadnikSmena implements ApstraktniDomenskiObjekat, Serializable {

    private LocalDate datum;
    private Radnik radnik;
    private Smena smena;

    private String kriterijum;

    public RadnikSmena() {
    }

    public RadnikSmena(LocalDate datum, Radnik radnik, Smena smena) {
        this.datum = datum;
        this.radnik = radnik;
        this.smena = smena;
    }

    public String getKriterijum() {
        return kriterijum;
    }

    public void setKriterijum(String kriterijum) {
        this.kriterijum = kriterijum;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.datum);
        hash = 53 * hash + Objects.hashCode(this.radnik);
        hash = 53 * hash + Objects.hashCode(this.smena);
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
        final RadnikSmena other = (RadnikSmena) obj;
        return Objects.equals(this.datum, other.datum)
                && Objects.equals(this.radnik, other.radnik)
                && Objects.equals(this.smena, other.smena);
    }

    @Override
    public String toString() {
        return "RadnikSmena{" + "datum=" + datum + ", radnik=" + radnik + ", smena=" + smena + '}';
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public Radnik getRadnik() {
        return radnik;
    }

    public void setRadnik(Radnik radnik) {
        this.radnik = radnik;
    }

    public Smena getSmena() {
        return smena;
    }

    public void setSmena(Smena smena) {
        this.smena = smena;
    }

    @Override
    public String getNazivTabele() {
        return "radniksmena";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> getLista(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> list = new ArrayList<>();
        while (rs.next()) {
            Timestamp ts = rs.getTimestamp("radniksmena.datum");
            LocalDate d = ts != null ? ts.toLocalDateTime().toLocalDate() : null;
            Radnik z = new Radnik(rs);
            Smena s = new Smena(rs);
            list.add(new RadnikSmena(d, z, s));
        }
        return list;
    }

    @Override
    public String getKoloneZaUnos() {
        return "datum, idRadnik, idSmena";
    }

    @Override
    public String getVrednostiZaUnos() {
        return "'" + datum + "', " + radnik.getIdRadnik() + ", " + smena.getIdSmena();
    }

    @Override
    public String getGenerisaniKljuc() {
        return "radniksmena.datum='" + datum + "' AND radniksmena.idRadnik=" + radnik.getIdRadnik() + " AND radniksmena.idSmena=" + smena.getIdSmena();
    }

    @Override
    public ApstraktniDomenskiObjekat getObjekat(ResultSet rs) throws Exception {
        if (rs.next()) {
            Timestamp ts = rs.getTimestamp("radniksmena.datum");
            LocalDate d = ts != null ? ts.toLocalDateTime().toLocalDate() : null;
            Radnik z = new Radnik(rs);
            Smena s = new Smena(rs);
            return new RadnikSmena(d, z, s);
        }
        return null;
    }

    @Override
    public String getVrednostZaIzmenu() {
        return "datum='" + datum + "'";
    }

    @Override
    public String getUslov() {
        if (kriterijum != null) {
            return kriterijum;
        }
        return "";
    }

    @Override
    public Object[] getNizObjekta() {
        Object[] o = {
            datum,
            radnik.getIdRadnik() + " - " + radnik.getIme(),
            smena.getIdSmena() + " - " + smena.getNaziv()
        };
        return o;
    }

    @Override
    public String join() {
        return " JOIN radnik ON radnik.idRadnik=radniksmena.idRadnik "
                + " JOIN smena ON smena.idSmena=radniksmena.idSmena";
    }

    @Override
    public String[] getNazivKolone() {
        String[] s = {"Datum", "Radnik", "Smena"};
        return s;
    }

    @Override
    public String getUslovRb() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setKriterijum() {
        if (getRadnik() != null && getRadnik().getIdRadnik() > 0) {
            setKriterijum(getRadnik());
        }
        if (getSmena() != null && getSmena().getIdSmena() > 0) {
            setKriterijum(getSmena());
        }
    }

    public void setKriterijum(RadnikSmena zt) {
        if (zt.getRadnik() != null && zt.getRadnik().getIdRadnik() > 0) {
            setKriterijum(zt.getRadnik());
        }
        if (zt.getSmena() != null && zt.getSmena().getIdSmena() > 0) {
            setKriterijum(zt.getSmena());
        }
    }

    public void setKriterijum(Radnik z) {
        if (kriterijum == null || kriterijum.length() == 0) {
            kriterijum = " WHERE radniksmena.idRadnik = " + z.getIdRadnik();
        } else {
            kriterijum += " AND radniksmena.idRadnik = " + z.getIdRadnik();
        }
    }

    public void setKriterijum(Smena s) {
        if (kriterijum == null || kriterijum.length() == 0) {
            kriterijum = " WHERE radniksmena.idSmena = " + s.getIdSmena();
        } else {
            kriterijum += " AND radniksmena.idSmena = " + s.getIdSmena();
        }
    }
}
