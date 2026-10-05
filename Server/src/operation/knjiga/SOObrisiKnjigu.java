package operation.knjiga;

import model.Knjiga;
import model.ApstraktniDomenskiObjekat;
import operation.SistemskaOperacija;

public class SOObrisiKnjigu extends SistemskaOperacija {

    @Override
    public void proveriOgranicenja(ApstraktniDomenskiObjekat objekat) throws Exception {
        if (!(objekat instanceof Knjiga k)) {
            throw new Exception("Prosledjeni objekat nije knjiga.");
        }
        if (k.getIdKnjiga() == null || k.getIdKnjiga() <= 0) {
            throw new Exception("Identifikator knjige je obavezan podatak.");
        }
    }

    @Override
    public boolean izvrsi(ApstraktniDomenskiObjekat objekat) throws Exception {
        return broker.obrisi(objekat);
    }
}
