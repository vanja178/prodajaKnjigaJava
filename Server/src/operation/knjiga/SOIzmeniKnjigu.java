package operation.knjiga;

import model.Knjiga;
import model.ApstraktniDomenskiObjekat;
import operation.SistemskaOperacija;

public class SOIzmeniKnjigu extends SistemskaOperacija {

    @Override
    public void proveriOgranicenja(ApstraktniDomenskiObjekat objekat) throws Exception {
        if (!(objekat instanceof Knjiga k)) {
            throw new Exception("Prosledjeni objekat nije knjiga.");
        }
        if (k.getIdKnjiga() == null || k.getIdKnjiga() <= 0) {
            throw new Exception("Identifikator knjige je obavezan podatak.");
        }

        String naziv = k.getNaziv() == null ? "" : k.getNaziv().trim();

        if (naziv.isEmpty()) {
            throw new Exception("Naziv knjige je obavezan podatak.");
        }
        if (naziv.length() < 2 || naziv.length() > 50) {
            throw new Exception("Naziv knjige mora da ima izmedju 2 i 50 karaktera.");
        }
        if (!naziv.matches("[\\p{L}\\p{N}][\\p{L}\\p{N} \\-\\.\\+/]*")) {
            throw new Exception("Naziv knjige sme da sadrzi samo slova, brojeve i znake - . + /");
        }

        if (k.getCena() <= 0) {
            throw new Exception("Cena knjige mora da bude veca od 0.");
        }
    }

    @Override
    public boolean izvrsi(ApstraktniDomenskiObjekat objekat) throws Exception {
        return broker.izmeni(objekat);
    }
}
