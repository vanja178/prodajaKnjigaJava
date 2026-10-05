package operation.kupac;

import model.Kupac;
import model.ApstraktniDomenskiObjekat;
import operation.SistemskaOperacija;

public class SOObrisiKupca extends SistemskaOperacija {

    @Override
    public void proveriOgranicenja(ApstraktniDomenskiObjekat objekat) throws Exception {
        if (!(objekat instanceof Kupac k)) {
            throw new Exception("Prosledjeni objekat nije kupac.");
        }
        if (k.getIdKupac() == null || k.getIdKupac() <= 0) {
            throw new Exception("Identifikator kupca je obavezan podatak.");
        }
    }

    @Override
    public boolean izvrsi(ApstraktniDomenskiObjekat objekat) throws Exception {
        return broker.obrisi(objekat);
    }
}
