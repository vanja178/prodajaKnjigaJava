package operation.kategorija;

import model.ApstraktniDomenskiObjekat;
import model.Kategorija;
import operation.SistemskaOperacija;

public class SOObrisiKategoriju extends SistemskaOperacija {

    @Override
    public void proveriOgranicenja(ApstraktniDomenskiObjekat objekat) throws Exception {
        if (!(objekat instanceof Kategorija k)) {
            throw new Exception("Prosledjeni objekat nije kategorija.");
        }
        if (k.getIdKategorija() == null || k.getIdKategorija() <= 0) {
            throw new Exception("Identifikator kategorije je obavezan podatak.");
        }
    }

    @Override
    public boolean izvrsi(ApstraktniDomenskiObjekat objekat) throws Exception {
        return broker.obrisi(objekat);
    }
}
