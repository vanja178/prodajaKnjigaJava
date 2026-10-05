package operation;

import database.BrokerBaze;
import model.ApstraktniDomenskiObjekat;

public abstract class SistemskaOperacija {

    public BrokerBaze broker = new BrokerBaze();

    public boolean izvrsiSO(ApstraktniDomenskiObjekat objekat) throws Exception {
        try {
            broker.otvoriKonekciju();
            proveriOgranicenja(objekat);
            boolean uspesno = izvrsi(objekat);
            if (uspesno) {
                broker.commit();
            } else {
                broker.rollback();
            }
            return uspesno;
        } catch (Exception e) {
            broker.rollback();
            throw e;
        } finally {
            broker.zatvoriKonekciju();
        }
    }

    abstract public void proveriOgranicenja(ApstraktniDomenskiObjekat objekat) throws Exception;

    abstract public boolean izvrsi(ApstraktniDomenskiObjekat objekat) throws Exception;
}
