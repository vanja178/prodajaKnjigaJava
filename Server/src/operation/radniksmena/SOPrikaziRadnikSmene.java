package operation.radniksmena;

import java.util.ArrayList;
import java.util.List;
import model.ApstraktniDomenskiObjekat;
import model.RadnikSmena;
import operation.SistemskaOperacija;

public class SOPrikaziRadnikSmene extends SistemskaOperacija {

    private List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();

    public List<ApstraktniDomenskiObjekat> getLista() {
        return lista;
    }

    @Override
    public void proveriOgranicenja(ApstraktniDomenskiObjekat objekat) throws Exception {
        if (!(objekat instanceof RadnikSmena zt)) {
            throw new Exception("Prosledjeni objekat nije radnik smena.");
        }
        String kriterijum = zt.getKriterijum();
        if (kriterijum != null && (kriterijum.contains(";") || kriterijum.contains("--"))) {
            throw new Exception("Kriterijum pretrage sadrzi nedozvoljene znake.");
        }
    }

    @Override
    public boolean izvrsi(ApstraktniDomenskiObjekat objekat) throws Exception {
        lista = broker.getSveJoin(objekat);
        return lista != null;
    }
}
