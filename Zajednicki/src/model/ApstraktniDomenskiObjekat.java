package model;

import java.io.Serializable;
import java.sql.*;
import java.util.List;

public interface ApstraktniDomenskiObjekat extends Serializable {

    public String getNazivTabele();

    public List<ApstraktniDomenskiObjekat> getLista(ResultSet rs) throws Exception;

    public String getKoloneZaUnos();

    public String getVrednostiZaUnos();

    public String getGenerisaniKljuc();

    public ApstraktniDomenskiObjekat getObjekat(ResultSet rs) throws Exception;

    public String getVrednostZaIzmenu();

    public String getUslov();

    public Object[] getNizObjekta();

    public String join();

    public String[] getNazivKolone();

    public String getUslovRb();
}
