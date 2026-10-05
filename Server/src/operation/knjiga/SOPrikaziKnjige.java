package operation.knjiga;

import java.util.ArrayList;
import java.util.List;
import model.Knjiga;
import model.ApstraktniDomenskiObjekat;
import operation.SistemskaOperacija;

public class SOPrikaziKnjige extends SistemskaOperacija {

    private List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();

    public List<ApstraktniDomenskiObjekat> getLista() {
        return lista;
    }

    @Override
    public void proveriOgranicenja(ApstraktniDomenskiObjekat objekat) throws Exception {
        if (!(objekat instanceof Knjiga k)) {
            throw new Exception("Prosledjeni objekat nije knjiga.");
        }
        String kriterijum = k.getKriterijum();
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
