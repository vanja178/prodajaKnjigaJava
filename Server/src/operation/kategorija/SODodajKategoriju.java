package operation.kategorija;

import model.ApstraktniDomenskiObjekat;
import model.Kategorija;
import operation.SistemskaOperacija;

public class SODodajKategoriju extends SistemskaOperacija {

    private Long id;

    public Long getId() {
        return id;
    }

    @Override
    public void proveriOgranicenja(ApstraktniDomenskiObjekat objekat) throws Exception {
        if (!(objekat instanceof Kategorija k)) {
            throw new Exception("Prosledjeni objekat nije kategorija.");
        }

        String naziv = k.getNaziv() == null ? "" : k.getNaziv().trim();

        if (naziv.isEmpty()) {
            throw new Exception("Naziv kategorije je obavezan podatak.");
        }
        if (naziv.length() < 2 || naziv.length() > 50) {
            throw new Exception("Naziv kategorije mora da ima izmedju 2 i 50 karaktera.");
        }
        if (!naziv.matches("[\\p{L}][\\p{L} \\-]*")) {
            throw new Exception("Naziv kategorije sme da sadrzi samo slova, bez brojeva i specijalnih znakova.");
        }
        if (k.getPopust() < 0 || k.getPopust() > 100) {
            throw new Exception("Popust kategorije mora da bude izmedju 0 i 100.");
        }
    }

    @Override
    public boolean izvrsi(ApstraktniDomenskiObjekat objekat) throws Exception {
        id = broker.dodaj(objekat);
        return id != null && id > 0;
    }
}
