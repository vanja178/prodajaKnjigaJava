package operation.radniksmena;

import model.ApstraktniDomenskiObjekat;
import model.RadnikSmena;
import operation.SistemskaOperacija;

public class SODodajRadnikSmenu extends SistemskaOperacija {

    private Long id;

    public Long getId() {
        return id;
    }

    @Override
    public void proveriOgranicenja(ApstraktniDomenskiObjekat objekat) throws Exception {
        if (!(objekat instanceof RadnikSmena zt)) {
            throw new Exception("Prosledjeni objekat nije radnik smena.");
        }
        if (zt.getDatum() == null) {
            throw new Exception("Datum je obavezan podatak.");
        }
        if (zt.getRadnik() == null || zt.getRadnik().getIdRadnik() == null
                || zt.getRadnik().getIdRadnik() <= 0) {
            throw new Exception("Radnik je obavezan podatak.");
        }
        if (zt.getSmena() == null || zt.getSmena().getIdSmena() == null
                || zt.getSmena().getIdSmena() <= 0) {
            throw new Exception("Smena je obavezan podatak.");
        }
    }

    @Override
    public boolean izvrsi(ApstraktniDomenskiObjekat objekat) throws Exception {
        id = broker.dodaj(objekat);
        return id != null && id > 0;
    }
}
