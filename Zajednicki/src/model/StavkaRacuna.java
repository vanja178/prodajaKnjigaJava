package model;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StavkaRacuna implements ApstraktniDomenskiObjekat, Serializable {

    private Long rb;
    private Racun racun;
    private double cena;
    private int kolicina;
    private double iznos;
    private Knjiga knjiga;

    public StavkaRacuna() {
    }

    public StavkaRacuna(Knjiga knjiga) {
        this.knjiga = knjiga;
    }

    public StavkaRacuna(Long rb, Racun racun, double cena, int kolicina, double iznos, Knjiga knjiga) {
        this.rb = rb;
        this.racun = racun;
        this.cena = cena;
        this.kolicina = kolicina;
        this.iznos = iznos;
        this.knjiga = knjiga;
    }

    public StavkaRacuna(Racun racun, int kolicina, Knjiga knjiga) {
        this.racun = racun;
        this.kolicina = kolicina;
        this.knjiga = knjiga;
        this.cena = knjiga.getCena();
        izracunaj();
    }

    @Override
    public String toString() {
        return "StavkaRacuna{" + "rb=" + rb + ", racun=" + racun + ", cena=" + cena
                + ", kolicina=" + kolicina + ", iznos=" + iznos + ", knjiga=" + knjiga + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.rb);
        hash = 79 * hash + Objects.hashCode(this.racun);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final StavkaRacuna other = (StavkaRacuna) obj;
        return Objects.equals(this.rb, other.rb) && Objects.equals(this.racun, other.racun);
    }

    public Long getRb() {
        return rb;
    }

    public void setRb(Long rb) {
        this.rb = rb;
    }

    public Racun getRacun() {
        return racun;
    }

    public void setRacun(Racun racun) {
        this.racun = racun;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
        izracunaj();
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
        izracunaj();
    }

    public Knjiga getKnjiga() {
        return knjiga;
    }

    public void setKnjiga(Knjiga knjiga) {
        this.knjiga = knjiga;
    }

    public double getIznos() {
        return iznos;
    }

    public void setIznos(double iznos) {
        this.iznos = iznos;
    }

    public void izracunaj() {
        this.iznos = this.cena * this.kolicina;
    }

    @Override
    public String getNazivTabele() {
        return "stavkaracuna";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> getLista(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> list = new ArrayList<>();
        while (rs.next()) {
            Long r = rs.getLong("stavkaracuna.rb");
            Racun rac = new Racun(rs);
            double c = rs.getDouble("stavkaracuna.cena");
            int kol = rs.getInt("stavkaracuna.kolicina");
            double izn2 = rs.getDouble("stavkaracuna.iznos");
            Knjiga kn = new Knjiga(rs);
            list.add(new StavkaRacuna(r, rac, c, kol, izn2, kn));
        }
        return list;
    }

    @Override
    public String getKoloneZaUnos() {
        return "racun, cena, kolicina, iznos, knjiga";
    }

    @Override
    public String getVrednostiZaUnos() {
        return racun.getIdRacun() + ", " + cena + ", " + kolicina + ", " + iznos + ", " + knjiga.getIdKnjiga();
    }

    @Override
    public String getGenerisaniKljuc() {
        return "stavkaracuna.rb=" + rb + " AND stavkaracuna.racun=" + racun.getIdRacun();
    }

    @Override
    public ApstraktniDomenskiObjekat getObjekat(ResultSet rs) throws Exception {
        if (rs.next()) {
            Long r = rs.getLong("stavkaracuna.rb");
            Racun rac = new Racun(rs);
            double c = rs.getDouble("stavkaracuna.cena");
            int kol = rs.getInt("stavkaracuna.kolicina");
            double izn2 = rs.getDouble("stavkaracuna.iznos");
            Knjiga kn = new Knjiga(rs);
            return new StavkaRacuna(r, rac, c, kol, izn2, kn);
        }
        return null;
    }

    @Override
    public String getVrednostZaIzmenu() {
        return "cena=" + cena + ", kolicina=" + kolicina + ", iznos=" + iznos + ", knjiga=" + knjiga.getIdKnjiga();
    }

    @Override
    public String getUslov() {
        return " WHERE stavkaracuna.racun=" + racun.getIdRacun();
    }

    @Override
    public Object[] getNizObjekta() {
        Object[] o = {knjiga.getNaziv(), cena, kolicina, iznos};
        return o;
    }

    @Override
    public String join() {
        return " JOIN knjiga ON stavkaracuna.knjiga = knjiga.idKnjiga "
                + " JOIN racun ON stavkaracuna.racun = racun.idRacun "
                + " JOIN radnik ON racun.radnik = radnik.idRadnik "
                + " JOIN kupac ON racun.kupac = kupac.idKupac "
                + " JOIN kategorija ON kupac.kategorija = kategorija.idKategorija ";
    }

    @Override
    public String[] getNazivKolone() {
        String[] s = {"Knjiga", "Cena", "Kolicina", "Iznos"};
        return s;
    }

    @Override
    public String getUslovRb() {
        return " WHERE stavkaracuna.rb=" + rb + " AND stavkaracuna.racun=" + racun.getIdRacun();
    }
}
