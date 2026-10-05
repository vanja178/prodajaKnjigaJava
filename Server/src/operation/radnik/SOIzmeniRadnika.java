package operation.radnik;

import model.ApstraktniDomenskiObjekat;
import model.Radnik;
import operation.SistemskaOperacija;

public class SOIzmeniRadnika extends SistemskaOperacija {

    @Override
    public void proveriOgranicenja(ApstraktniDomenskiObjekat objekat) throws Exception {
        if (!(objekat instanceof Radnik z)) {
            throw new Exception("Prosledjeni objekat nije radnik.");
        }
        if (z.getIdRadnik() == null || z.getIdRadnik() <= 0) {
            throw new Exception("Identifikator radnika je obavezan podatak.");
        }

        String ime = z.getIme() == null ? "" : z.getIme().trim();
        String prezime = z.getPrezime() == null ? "" : z.getPrezime().trim();
        String korisnickoIme = z.getKorisnickoIme() == null ? "" : z.getKorisnickoIme().trim();
        String sifra = z.getSifra() == null ? "" : z.getSifra();

        if (ime.isEmpty()) {
            throw new Exception("Ime radnika je obavezan podatak.");
        }
        if (ime.length() < 2 || ime.length() > 50) {
            throw new Exception("Ime radnika mora da ima izmedju 2 i 50 karaktera.");
        }
        if (!ime.matches("[\\p{L}][\\p{L} \\-]*")) {
            throw new Exception("Ime radnika sme da sadrzi samo slova, bez brojeva i specijalnih znakova.");
        }

        if (prezime.isEmpty()) {
            throw new Exception("Prezime radnika je obavezan podatak.");
        }
        if (prezime.length() < 2 || prezime.length() > 50) {
            throw new Exception("Prezime radnika mora da ima izmedju 2 i 50 karaktera.");
        }
        if (!prezime.matches("[\\p{L}][\\p{L} \\-]*")) {
            throw new Exception("Prezime radnika sme da sadrzi samo slova, bez brojeva i specijalnih znakova.");
        }

        if (korisnickoIme.isEmpty()) {
            throw new Exception("Korisnicko ime radnika je obavezan podatak.");
        }
        if (korisnickoIme.length() < 3 || korisnickoIme.length() > 50) {
            throw new Exception("Korisnicko ime radnika mora da ima izmedju 3 i 50 karaktera.");
        }
        if (!korisnickoIme.matches("[\\p{L}\\p{N}._\\-]+")) {
            throw new Exception("Korisnicko ime radnika sme da sadrzi samo slova, brojeve, tacku, crtu i donju crtu.");
        }

        if (sifra.isEmpty()) {
            throw new Exception("Sifra radnika je obavezan podatak.");
        }
        if (sifra.length() < 4 || sifra.length() > 50) {
            throw new Exception("Sifra radnika mora da ima izmedju 4 i 50 karaktera.");
        }
        if (sifra.contains("'") || sifra.contains("\"") || sifra.contains(";") || sifra.contains("\\")) {
            throw new Exception("Sifra radnika sadrzi nedozvoljene znake.");
        }
    }

    @Override
    public boolean izvrsi(ApstraktniDomenskiObjekat objekat) throws Exception {
        return broker.izmeni(objekat);
    }
}
