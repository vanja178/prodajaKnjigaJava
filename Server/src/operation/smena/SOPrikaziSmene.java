package operation.smena;

import java.util.ArrayList;
import java.util.List;
import model.ApstraktniDomenskiObjekat;
import model.Smena;
import operation.SistemskaOperacija;

public class SOPrikaziSmene extends SistemskaOperacija {

    private List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();

    public List<ApstraktniDomenskiObjekat> getLista() {
        return lista;
    }

    @Override
    public void proveriOgranicenja(ApstraktniDomenskiObjekat objekat) throws Exception {
        if (!(objekat instanceof Smena s)) {
            throw new Exception("Prosledjeni objekat nije smena.");
        }
        String kriterijum = s.getKriterijum();
        if (kriterijum != null && (kriterijum.contains("'") || kriterijum.contains("\"")
                || kriterijum.contains(";") || kriterijum.contains("\\"))) {
            throw new Exception("Kriterijum pretrage sadrzi nedozvoljene znake.");
        }
    }

    @Override
    public boolean izvrsi(ApstraktniDomenskiObjekat objekat) throws Exception {
        lista = broker.getSve(objekat);
        return lista != null;
    }
}
