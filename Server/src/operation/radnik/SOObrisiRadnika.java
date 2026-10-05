package operation.radnik;

import model.ApstraktniDomenskiObjekat;
import model.Radnik;
import operation.SistemskaOperacija;

public class SOObrisiRadnika extends SistemskaOperacija {

    @Override
    public void proveriOgranicenja(ApstraktniDomenskiObjekat objekat) throws Exception {
        if (!(objekat instanceof Radnik z)) {
            throw new Exception("Prosledjeni objekat nije radnik.");
        }
        if (z.getIdRadnik() == null || z.getIdRadnik() <= 0) {
            throw new Exception("Identifikator radnika je obavezan podatak.");
        }
    }

    @Override
    public boolean izvrsi(ApstraktniDomenskiObjekat objekat) throws Exception {
        return broker.obrisi(objekat);
    }
}
