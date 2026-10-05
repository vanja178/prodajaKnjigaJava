package model;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Knjiga implements ApstraktniDomenskiObjekat, Serializable {

    private Long idKnjiga;
    private String naziv;
    private double cena;
    private String kriterijum;

    public Knjiga() {
    }

    public Knjiga(Long idKnjiga, String naziv, double cena) {
        this.idKnjiga = idKnjiga;
        this.naziv = naziv;
        this.cena = cena;
    }

    Knjiga(ResultSet rs) {
        try {
            idKnjiga = rs.getLong("knjiga.idKnjiga");
            naziv = rs.getString("knjiga.naziv");
            cena = rs.getDouble("knjiga.cena");
        } catch (SQLException ex) {
            Logger.getLogger(Knjiga.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getKriterijum() {
        return kriterijum;
    }

    public void setKriterijum(String kriterijum) {
        this.kriterijum = kriterijum;
    }

    public Long getIdKnjiga() {
        return idKnjiga;
    }

    public void setIdKnjiga(Long idKnjiga) {
        this.idKnjiga = idKnjiga;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    @Override
    public String toString() {
        return naziv;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.idKnjiga);
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
        final Knjiga other = (Knjiga) obj;
        return Objects.equals(this.idKnjiga, other.idKnjiga);
    }

    @Override
    public String getNazivTabele() {
        return "knjiga";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> getLista(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> list = new ArrayList<>();
        while (rs.next()) {
            Long id = rs.getLong("knjiga.idKnjiga");
            String naz = rs.getString("knjiga.naziv");
            double c = rs.getDouble("knjiga.cena");
            list.add(new Knjiga(id, naz, c));
        }
        return list;
    }

    @Override
    public String getKoloneZaUnos() {
        return "naziv, cena";
    }

    @Override
    public String getVrednostiZaUnos() {
        return "'" + naziv + "', " + cena;
    }

    @Override
    public String getGenerisaniKljuc() {
        return "knjiga.idKnjiga=" + idKnjiga;
    }

    @Override
    public ApstraktniDomenskiObjekat getObjekat(ResultSet rs) throws Exception {
        if (rs.next()) {
            Long id = rs.getLong("knjiga.idKnjiga");
            String naz = rs.getString("knjiga.naziv");
            double c = rs.getDouble("knjiga.cena");
            return new Knjiga(id, naz, c);
        }
        return null;
    }

    @Override
    public String getVrednostZaIzmenu() {
        return "naziv='" + naziv + "', cena=" + cena;
    }

    @Override
    public String getUslov() {
        if (kriterijum != null) {
            return " WHERE knjiga.naziv LIKE '%" + kriterijum + "%'";
        }
        return "";
    }

    @Override
    public Object[] getNizObjekta() {
        Object[] o = {naziv, cena};
        return o;
    }

    @Override
    public String join() {
        return "";
    }

    @Override
    public String[] getNazivKolone() {
        String[] s = {"Naziv", "Cena"};
        return s;
    }

    @Override
    public String getUslovRb() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    String getUslovRacun() {
        if (idKnjiga != null && idKnjiga > 0) {
            return " stavkaracuna.knjiga = " + idKnjiga;
        }
        if (naziv != null) {
            return " LOWER(knjiga.naziv) LIKE '%" + naziv.toLowerCase() + "%' ";
        }
        return "";
    }
}
