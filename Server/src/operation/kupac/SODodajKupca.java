package operation.kupac;

import model.Kupac;
import model.ApstraktniDomenskiObjekat;
import operation.SistemskaOperacija;

public class SODodajKupca extends SistemskaOperacija {

    private Long id;

    public Long getId() {
        return id;
    }

    @Override
    public void proveriOgranicenja(ApstraktniDomenskiObjekat objekat) throws Exception {
        if (!(objekat instanceof Kupac k)) {
            throw new Exception("Prosledjeni objekat nije kupac.");
        }

        String ime = k.getIme() == null ? "" : k.getIme().trim();
        String prezime = k.getPrezime() == null ? "" : k.getPrezime().trim();
        String email = k.getEmail() == null ? "" : k.getEmail().trim();
        String brojTelefona = k.getBrojTelefona() == null ? "" : k.getBrojTelefona().trim();

        if (ime.isEmpty()) {
            throw new Exception("Ime kupca je obavezan podatak.");
        }
        if (ime.length() < 2 || ime.length() > 50) {
            throw new Exception("Ime kupca mora da ima izmedju 2 i 50 karaktera.");
        }
        if (!ime.matches("[\\p{L}][\\p{L} \\-]*")) {
            throw new Exception("Ime kupca sme da sadrzi samo slova, bez brojeva i specijalnih znakova.");
        }

        if (prezime.isEmpty()) {
            throw new Exception("Prezime kupca je obavezan podatak.");
        }
        if (prezime.length() < 2 || prezime.length() > 50) {
            throw new Exception("Prezime kupca mora da ima izmedju 2 i 50 karaktera.");
        }
        if (!prezime.matches("[\\p{L}][\\p{L} \\-]*")) {
            throw new Exception("Prezime kupca sme da sadrzi samo slova, bez brojeva i specijalnih znakova.");
        }

        if (email.isEmpty()) {
            throw new Exception("Email kupca je obavezan podatak.");
        }
        if (email.length() > 100) {
            throw new Exception("Email kupca ne sme da bude duzi od 100 karaktera.");
        }
        if (!email.matches("[\\p{L}\\p{N}._%+\\-]+@[\\p{L}\\p{N}.\\-]+\\.[\\p{L}]{2,}")) {
            throw new Exception("Email kupca nije u ispravnom formatu (primer: pera@firma.com).");
        }

        if (brojTelefona.isEmpty()) {
            throw new Exception("Broj telefona kupca je obavezan podatak.");
        }
        if (brojTelefona.length() > 20) {
            throw new Exception("Broj telefona kupca ne sme da bude duzi od 20 karaktera.");
        }
        if (!brojTelefona.matches("[0-9+\\- ]+")) {
            throw new Exception("Broj telefona kupca sme da sadrzi samo cifre, razmak i znake + -.");
        }

        if (k.getKategorija() == null || k.getKategorija().getIdKategorija() == null
                || k.getKategorija().getIdKategorija() <= 0) {
            throw new Exception("Kategorija je obavezan podatak.");
        }
    }

    @Override
    public boolean izvrsi(ApstraktniDomenskiObjekat objekat) throws Exception {
        id = broker.dodaj(objekat);
        return id != null && id > 0;
    }
}
