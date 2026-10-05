package model;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Kupac implements ApstraktniDomenskiObjekat, Serializable {

    private Long idKupac;
    private String ime;
    private String prezime;
    private String email;
    private String brojTelefona;
    private Kategorija kategorija;
    private String kriterijum;

    public Kupac() {
    }

    public Kupac(String ime, String prezime, String email, String brojTelefona, Kategorija kategorija) {
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.brojTelefona = brojTelefona;
        this.kategorija = kategorija;
    }

    public Kupac(Long idKupac, String ime, String prezime, String email, String brojTelefona, Kategorija kategorija) {
        this.idKupac = idKupac;
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.brojTelefona = brojTelefona;
        this.kategorija = kategorija;
    }

    Kupac(ResultSet rs) {
        try {
            idKupac = rs.getLong("kupac.idKupac");
            ime = rs.getString("kupac.ime");
            prezime = rs.getString("kupac.prezime");
            email = rs.getString("kupac.email");
            brojTelefona = rs.getString("kupac.brojTelefona");

            Kategorija k = new Kategorija();
            k.setIdKategorija(rs.getLong("kategorija.idKategorija"));
            k.setNaziv(rs.getString("kategorija.naziv"));
            k.setPopust(rs.getDouble("kategorija.popust"));
            kategorija = k;
        } catch (SQLException ex) {
            Logger.getLogger(Kupac.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getKriterijum() {
        return kriterijum;
    }

    public void setKriterijum(String tekst) {
        String uslov = "(kupac.ime LIKE '%" + tekst + "%'"
                + " OR kupac.prezime LIKE '%" + tekst + "%'"
                + " OR CONCAT(kupac.ime, ' ', kupac.prezime) LIKE '%" + tekst + "%')";
        if (this.kriterijum != null) {
            this.kriterijum += " AND " + uslov;
            return;
        }
        this.kriterijum = " WHERE " + uslov;
    }

    public Long getIdKupac() {
        return idKupac;
    }

    public void setIdKupac(Long idKupac) {
        this.idKupac = idKupac;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBrojTelefona() {
        return brojTelefona;
    }

    public void setBrojTelefona(String brojTelefona) {
        this.brojTelefona = brojTelefona;
    }

    public Kategorija getKategorija() {
        return kategorija;
    }

    public void setKategorija(Kategorija kategorija) {
        this.kategorija = kategorija;
    }

    @Override
    public String toString() {
        return ime + " " + prezime;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.idKupac);
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
        final Kupac other = (Kupac) obj;
        return Objects.equals(this.idKupac, other.idKupac);
    }

    @Override
    public String getNazivTabele() {
        return "kupac";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> getLista(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> list = new ArrayList<>();
        while (rs.next()) {
            Long id = rs.getLong("kupac.idKupac");
            String im = rs.getString("kupac.ime");
            String prez = rs.getString("kupac.prezime");
            String em = rs.getString("kupac.email");
            String tel = rs.getString("kupac.brojTelefona");

            Kategorija k = new Kategorija();
            k.setIdKategorija(rs.getLong("kategorija.idKategorija"));
            k.setNaziv(rs.getString("kategorija.naziv"));
            k.setPopust(rs.getDouble("kategorija.popust"));

            list.add(new Kupac(id, im, prez, em, tel, k));
        }
        return list;
    }

    @Override
    public String getKoloneZaUnos() {
        return "ime, prezime, email, brojTelefona, kategorija";
    }

    @Override
    public String getVrednostiZaUnos() {
        return "'" + ime + "', '" + prezime + "', '" + email + "', '" + brojTelefona + "', " + kategorija.getIdKategorija();
    }

    @Override
    public String getGenerisaniKljuc() {
        return "kupac.idKupac=" + idKupac;
    }

    @Override
    public ApstraktniDomenskiObjekat getObjekat(ResultSet rs) throws Exception {
        if (rs.next()) {
            Long id = rs.getLong("kupac.idKupac");
            String im = rs.getString("kupac.ime");
            String prez = rs.getString("kupac.prezime");
            String em = rs.getString("kupac.email");
            String tel = rs.getString("kupac.brojTelefona");

            Kategorija k = new Kategorija();
            k.setIdKategorija(rs.getLong("kategorija.idKategorija"));
            k.setNaziv(rs.getString("kategorija.naziv"));
            k.setPopust(rs.getDouble("kategorija.popust"));

            return new Kupac(id, im, prez, em, tel, k);
        }
        return null;
    }

    @Override
    public String getVrednostZaIzmenu() {
        return "ime='" + ime + "', prezime='" + prezime + "', email='" + email + "', brojTelefona='" + brojTelefona + "', kategorija=" + kategorija.getIdKategorija();
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
        Object[] o = {ime, prezime, email, brojTelefona, kategorija.getNaziv()};
        return o;
    }

    @Override
    public String join() {
        return " JOIN kategorija ON kategorija.idKategorija = kupac.kategorija";
    }

    @Override
    public String[] getNazivKolone() {
        String[] s = {"Ime", "Prezime", "Email", "Broj telefona", "Kategorija"};
        return s;
    }

    @Override
    public String getUslovRb() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setKriterijum(Kupac k) {
        if (k == null) {
            return;
        }
        kriterijum = null;
        if (k.getKategorija() != null) {
            setKriterijum(k.getKategorija());
        }
        if (k.getIme() != null && !k.getIme().trim().isEmpty()) {
            setKriterijum(k.getIme().trim());
        }
    }

    public void setKriterijum() {
        setKriterijum(this);
    }

    public void setKriterijum(Kategorija k) {
        if (k == null) {
            return;
        }
        if (kriterijum != null) {
            kriterijum += " AND kupac.kategorija=" + k.getIdKategorija();
            return;
        }
        kriterijum = " WHERE kupac.kategorija=" + k.getIdKategorija();
    }
}
