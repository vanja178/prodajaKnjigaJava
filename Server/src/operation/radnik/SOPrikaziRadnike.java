package operation.radnik;

import java.util.ArrayList;
import java.util.List;
import model.ApstraktniDomenskiObjekat;
import model.Radnik;
import operation.SistemskaOperacija;

public class SOPrikaziRadnike extends SistemskaOperacija {

    private List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();

    public List<ApstraktniDomenskiObjekat> getLista() {
        return lista;
    }

    @Override
    public void proveriOgranicenja(ApstraktniDomenskiObjekat objekat) throws Exception {
        if (!(objekat instanceof Radnik z)) {
            throw new Exception("Prosledjeni objekat nije radnik.");
        }
        String kriterijum = z.getKriterijum();
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
