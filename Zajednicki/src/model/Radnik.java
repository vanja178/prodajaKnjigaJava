package model;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Radnik implements ApstraktniDomenskiObjekat, Serializable {

    private Long idRadnik;
    private String ime;
    private String prezime;
    private String korisnickoIme;
    private String sifra;
    private String kriterijum;

    public Radnik() {
    }

    public Radnik(Long idRadnik, String ime, String prezime, String korisnickoIme, String sifra) {
        this.idRadnik = idRadnik;
        this.ime = ime;
        this.prezime = prezime;
        this.korisnickoIme = korisnickoIme;
        this.sifra = sifra;
    }

    public Radnik(String korisnickoIme, String sifra) {
        this.korisnickoIme = korisnickoIme;
        this.sifra = sifra;
    }

    public String getKriterijum() {
        return kriterijum;
    }

    public void setKriterijum(String kriterijum) {
        this.kriterijum = kriterijum;
    }

    Radnik(ResultSet rs) {
        try {
            idRadnik = rs.getLong("radnik.idRadnik");
            ime = rs.getString("radnik.ime");
            prezime = rs.getString("radnik.prezime");
            korisnickoIme = rs.getString("radnik.korisnickoIme");
            sifra = rs.getString("radnik.sifra");
        } catch (SQLException ex) {
            Logger.getLogger(Radnik.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Long getIdRadnik() {
        return idRadnik;
    }

    public void setIdRadnik(Long idRadnik) {
        this.idRadnik = idRadnik;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.korisnickoIme);
        hash = 29 * hash + Objects.hashCode(this.sifra);
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
        final Radnik other = (Radnik) obj;
        if (!Objects.equals(this.korisnickoIme, other.korisnickoIme)) {
            return false;
        }
        return Objects.equals(this.sifra, other.sifra);
    }

    @Override
    public String toString() {
        return ime + " " + prezime;
    }

    @Override
    public String getNazivTabele() {
        return "radnik";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> getLista(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> list = new ArrayList<>();
        while (rs.next()) {
            Long id = rs.getLong("radnik.idRadnik");
            String im = rs.getString("radnik.ime");
            String prez = rs.getString("radnik.prezime");
            String korisnicko = rs.getString("radnik.korisnickoIme");
            String s = rs.getString("radnik.sifra");
            list.add(new Radnik(id, im, prez, korisnicko, s));
        }
        return list;
    }

    @Override
    public String getKoloneZaUnos() {
        return "ime,prezime,korisnickoIme,sifra";
    }

    @Override
    public String getVrednostiZaUnos() {
        return "'" + ime + "', '" + prezime + "', '" + korisnickoIme + "', '" + sifra + "'";
    }

    @Override
    public String getGenerisaniKljuc() {
        return "radnik.idRadnik=" + idRadnik;
    }

    @Override
    public ApstraktniDomenskiObjekat getObjekat(ResultSet rs) throws Exception {
        if (rs.next()) {
            Long id = rs.getLong("radnik.idRadnik");
            String im = rs.getString("radnik.ime");
            String prez = rs.getString("radnik.prezime");
            String korisnicko = rs.getString("radnik.korisnickoIme");
            String s = rs.getString("radnik.sifra");
            return new Radnik(id, im, prez, korisnicko, s);
        }
        return null;
    }

    @Override
    public String getVrednostZaIzmenu() {
        return "ime='" + ime + "', prezime='" + prezime + "', korisnickoIme='" + korisnickoIme + "', sifra='" + sifra + "'";
    }

    @Override
    public String getUslov() {
        if (kriterijum != null) {
            return " WHERE radnik.ime LIKE '%" + kriterijum + "%' OR radnik.prezime LIKE '%" + kriterijum + "%' OR radnik.korisnickoIme LIKE '%" + kriterijum + "%'";
        }
        return "";
    }

    @Override
    public String join() {
        return "";
    }

    @Override
    public Object[] getNizObjekta() {
        Object[] o = {ime, prezime, korisnickoIme};
        return o;
    }

    @Override
    public String[] getNazivKolone() {
        String[] s = {"Ime", "Prezime", "Korisnicko ime"};
        return s;
    }

    @Override
    public String getUslovRb() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
