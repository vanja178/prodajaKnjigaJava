package operation.racun;

import java.util.ArrayList;
import java.util.List;
import model.ApstraktniDomenskiObjekat;
import model.Racun;
import model.StavkaRacuna;
import operation.SistemskaOperacija;

public class SOPrikaziRacune extends SistemskaOperacija {

    private List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();

    public List<ApstraktniDomenskiObjekat> getLista() {
        return lista;
    }

    @Override
    public void proveriOgranicenja(ApstraktniDomenskiObjekat objekat) throws Exception {
        if (!(objekat instanceof Racun i)) {
            throw new Exception("Prosledjeni objekat nije racun.");
        }
        String kriterijum = i.getKriterijum();
        if (kriterijum != null && (kriterijum.contains(";") || kriterijum.contains("--"))) {
            throw new Exception("Kriterijum pretrage sadrzi nedozvoljene znake.");
        }
    }

    @Override
    public boolean izvrsi(ApstraktniDomenskiObjekat objekat) throws Exception {
        lista = broker.getSveJoin(objekat);
        for (ApstraktniDomenskiObjekat o : lista) {
            Racun i = (Racun) o;
            StavkaRacuna si = new StavkaRacuna();
            si.setRacun(i);
            List<ApstraktniDomenskiObjekat> oLista = broker.getSveJoin(si);
            List<StavkaRacuna> l = new ArrayList<>();
            for (ApstraktniDomenskiObjekat opstiDomenskiObjekat : oLista) {
                l.add((StavkaRacuna) opstiDomenskiObjekat);
            }
            i.setStavke(l);
        }
        return lista != null;
    }
}
