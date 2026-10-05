package model;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Smena implements ApstraktniDomenskiObjekat, Serializable {

    private Long idSmena;
    private String naziv;
    private String kriterijum;

    public Smena() {
    }

    public Smena(Long idSmena, String naziv) {
        this.idSmena = idSmena;
        this.naziv = naziv;
    }

    public Smena(String naziv) {
        this.naziv = naziv;
    }

    Smena(ResultSet rs) {
        try {
            idSmena = rs.getLong("smena.idSmena");
            naziv = rs.getString("smena.naziv");
        } catch (SQLException ex) {
            Logger.getLogger(Smena.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getKriterijum() {
        return kriterijum;
    }

    public void setKriterijum(String kriterijum) {
        this.kriterijum = kriterijum;
    }

    public Long getIdSmena() {
        return idSmena;
    }

    public void setIdSmena(Long idSmena) {
        this.idSmena = idSmena;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Override
    public String toString() {
        return naziv;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.idSmena);
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
        final Smena other = (Smena) obj;
        return Objects.equals(this.idSmena, other.idSmena);
    }

    @Override
    public String getNazivTabele() {
        return "smena";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> getLista(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> list = new ArrayList<>();
        while (rs.next()) {
            Long id = rs.getLong("smena.idSmena");
            String n = rs.getString("smena.naziv");
            list.add(new Smena(id, n));
        }
        return list;
    }

    @Override
    public String getKoloneZaUnos() {
        return "naziv";
    }

    @Override
    public String getVrednostiZaUnos() {
        return "'" + naziv + "'";
    }

    @Override
    public String getGenerisaniKljuc() {
        return "smena.idSmena=" + idSmena;
    }

    @Override
    public ApstraktniDomenskiObjekat getObjekat(ResultSet rs) throws Exception {
        if (rs.next()) {
            Long id = rs.getLong("smena.idSmena");
            String n = rs.getString("smena.naziv");
            return new Smena(id, n);
        }
        return null;
    }

    @Override
    public String getVrednostZaIzmenu() {
        return "naziv='" + naziv + "'";
    }

    @Override
    public String getUslov() {
        if (kriterijum != null) {
            return " WHERE smena.naziv LIKE '%" + kriterijum + "%'";
        }
        return "";
    }

    @Override
    public Object[] getNizObjekta() {
        Object[] o = {naziv};
        return o;
    }

    @Override
    public String join() {
        return "";
    }

    @Override
    public String[] getNazivKolone() {
        String[] s = {"Smena"};
        return s;
    }

    @Override
    public String getUslovRb() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
