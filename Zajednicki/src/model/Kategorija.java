package model;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Kategorija implements ApstraktniDomenskiObjekat, Serializable {

    private Long idKategorija;
    private String naziv;
    private double popust;
    private String kriterijum;

    public Kategorija() {
    }

    public Kategorija(Long idKategorija, String naziv, double popust) {
        this.idKategorija = idKategorija;
        this.naziv = naziv;
        this.popust = popust;
    }

    Kategorija(ResultSet rs) {
        try {
            idKategorija = rs.getLong("kategorija.idKategorija");
            naziv = rs.getString("kategorija.naziv");
            popust = rs.getDouble("kategorija.popust");
        } catch (SQLException ex) {
            Logger.getLogger(Kategorija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getKriterijum() {
        return kriterijum;
    }

    public void setKriterijum(String kriterijum) {
        this.kriterijum = kriterijum;
    }

    public Long getIdKategorija() {
        return idKategorija;
    }

    public void setIdKategorija(Long idKategorija) {
        this.idKategorija = idKategorija;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public double getPopust() {
        return popust;
    }

    public void setPopust(double popust) {
        this.popust = popust;
    }

    @Override
    public String toString() {
        return naziv;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.idKategorija);
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
        final Kategorija other = (Kategorija) obj;
        return Objects.equals(this.idKategorija, other.idKategorija);
    }

    @Override
    public String getNazivTabele() {
        return "kategorija";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> getLista(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> list = new ArrayList<>();
        while (rs.next()) {
            Long id = rs.getLong("kategorija.idKategorija");
            String naz = rs.getString("kategorija.naziv");
            double p = rs.getDouble("kategorija.popust");
            list.add(new Kategorija(id, naz, p));
        }
        return list;
    }

    @Override
    public String getKoloneZaUnos() {
        return "naziv, popust";
    }

    @Override
    public String getVrednostiZaUnos() {
        return "'" + naziv + "', " + popust;
    }

    @Override
    public String getGenerisaniKljuc() {
        return "kategorija.idKategorija=" + idKategorija;
    }

    @Override
    public ApstraktniDomenskiObjekat getObjekat(ResultSet rs) throws Exception {
        if (rs.next()) {
            Long id = rs.getLong("kategorija.idKategorija");
            String naz = rs.getString("kategorija.naziv");
            double p = rs.getDouble("kategorija.popust");
            return new Kategorija(id, naz, p);
        }
        return null;
    }

    @Override
    public String getVrednostZaIzmenu() {
        return "naziv='" + naziv + "', popust=" + popust;
    }

    @Override
    public String getUslov() {
        if (kriterijum != null) {
            return " WHERE naziv LIKE '%" + kriterijum + "%'";
        }
        return "";
    }

    @Override
    public Object[] getNizObjekta() {
        Object[] o = {naziv, popust};
        return o;
    }

    @Override
    public String join() {
        return " ";
    }

    @Override
    public String[] getNazivKolone() {
        String[] s = {"Naziv", "Popust (%)"};
        return s;
    }

    @Override
    public String getUslovRb() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
