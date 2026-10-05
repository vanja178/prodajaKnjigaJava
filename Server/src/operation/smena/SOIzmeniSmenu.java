package operation.smena;

import model.ApstraktniDomenskiObjekat;
import model.Smena;
import operation.SistemskaOperacija;

public class SOIzmeniSmenu extends SistemskaOperacija {

    @Override
    public void proveriOgranicenja(ApstraktniDomenskiObjekat objekat) throws Exception {
        if (!(objekat instanceof Smena s)) {
            throw new Exception("Prosledjeni objekat nije smena.");
        }
        if (s.getIdSmena() == null || s.getIdSmena() <= 0) {
            throw new Exception("Identifikator smene je obavezan podatak.");
        }

        String naziv = s.getNaziv() == null ? "" : s.getNaziv().trim();

        if (naziv.isEmpty()) {
            throw new Exception("Naziv smene je obavezan podatak.");
        }
        if (naziv.length() < 2 || naziv.length() > 50) {
            throw new Exception("Naziv smene mora da ima izmedju 2 i 50 karaktera.");
        }
        if (!naziv.matches("[\\p{L}][\\p{L} \\-]*")) {
            throw new Exception("Naziv smene sme da sadrzi samo slova, bez brojeva i specijalnih znakova.");
        }
    }

    @Override
    public boolean izvrsi(ApstraktniDomenskiObjekat objekat) throws Exception {
        return broker.izmeni(objekat);
    }
}
