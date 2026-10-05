package operation.radnik;

import java.util.List;
import model.ApstraktniDomenskiObjekat;
import model.Radnik;
import operation.SistemskaOperacija;

public class SOPrijava extends SistemskaOperacija {

    private Radnik radnik = null;

    public Radnik getRadnik() {
        return radnik;
    }

    @Override
    public void proveriOgranicenja(ApstraktniDomenskiObjekat objekat) throws Exception {
        if (!(objekat instanceof Radnik z)) {
            throw new Exception("Prosledjeni objekat nije radnik.");
        }

        String korisnickoIme = z.getKorisnickoIme() == null ? "" : z.getKorisnickoIme().trim();
        String sifra = z.getSifra() == null ? "" : z.getSifra();

        if (korisnickoIme.isEmpty()) {
            throw new Exception("Korisnicko ime je obavezan podatak.");
        }
        if (korisnickoIme.length() > 50) {
            throw new Exception("Korisnicko ime ne sme da bude duze od 50 karaktera.");
        }
        if (sifra.isEmpty()) {
            throw new Exception("Sifra je obavezan podatak.");
        }
        if (sifra.length() > 50) {
            throw new Exception("Sifra ne sme da bude duza od 50 karaktera.");
        }
    }

    @Override
    public boolean izvrsi(ApstraktniDomenskiObjekat objekat) throws Exception {
        Radnik prijava = (Radnik) objekat;
        List<ApstraktniDomenskiObjekat> lista = broker.getSve(new Radnik());
        for (ApstraktniDomenskiObjekat o : lista) {
            Radnik z = (Radnik) o;
            if (prijava.getKorisnickoIme().trim().equals(z.getKorisnickoIme()) && prijava.getSifra().equals(z.getSifra())) {
                radnik = z;
                return true;
            }
        }
        return false;
    }
}
