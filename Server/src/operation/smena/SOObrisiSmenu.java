package operation.smena;

import model.ApstraktniDomenskiObjekat;
import model.Smena;
import operation.SistemskaOperacija;

public class SOObrisiSmenu extends SistemskaOperacija {

    @Override
    public void proveriOgranicenja(ApstraktniDomenskiObjekat objekat) throws Exception {
        if (!(objekat instanceof Smena s)) {
            throw new Exception("Prosledjeni objekat nije smena.");
        }
        if (s.getIdSmena() == null || s.getIdSmena() <= 0) {
            throw new Exception("Identifikator smene je obavezan podatak.");
        }
    }

    @Override
    public boolean izvrsi(ApstraktniDomenskiObjekat objekat) throws Exception {
        return broker.obrisi(objekat);
    }
}
