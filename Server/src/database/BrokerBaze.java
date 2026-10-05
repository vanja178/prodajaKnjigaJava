package database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.ApstraktniDomenskiObjekat;

public class BrokerBaze {

    Connection konekcija;
    String url;
    String korisnik;
    String lozinka;

    public BrokerBaze() {
        url = configuration.Konfiguracija.getInstance().getProperty("url");
        korisnik = configuration.Konfiguracija.getInstance().getProperty("username");
        lozinka = configuration.Konfiguracija.getInstance().getProperty("password");
    }

    public void otvoriKonekciju() throws SQLException {
        if (konekcija == null || konekcija.isClosed()) {
            System.out.println("URL je:" + url);
            konekcija = DriverManager.getConnection(url, korisnik, lozinka);
            konekcija.setAutoCommit(false);
        }
        System.out.println("Konekcija sa bazom - otvorena");
    }

    public void zatvoriKonekciju() throws SQLException {
        if (konekcija == null || konekcija.isClosed()) {
            return;
        }
        konekcija.close();
        System.out.println("Konekcija sa bazom - zatvorena");
    }

    public void commit() throws SQLException {
        if (konekcija == null || konekcija.isClosed()) {
            return;
        }
        konekcija.commit();
        System.out.println("Commit");
    }

    public void rollback() throws SQLException {
        if (konekcija == null || konekcija.isClosed()) {
            return;
        }
        konekcija.rollback();
        System.out.println("Rollback");
    }

    public List<ApstraktniDomenskiObjekat> getSve(ApstraktniDomenskiObjekat objekat) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        String upit = "SELECT * FROM " + objekat.getNazivTabele() + " " + objekat.getUslov();
        PreparedStatement ps = konekcija.prepareStatement(upit);
        ResultSet rs = ps.executeQuery();
        lista = objekat.getLista(rs);
        System.out.println(upit);
        return lista;
    }

    public List<ApstraktniDomenskiObjekat> getSveJoin(ApstraktniDomenskiObjekat objekat) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        String upit = "SELECT * FROM " + objekat.getNazivTabele() + objekat.join() + " " + objekat.getUslov();
        System.out.println(upit);
        Statement ps = konekcija.createStatement();
        ResultSet rs = ps.executeQuery(upit);
        lista = objekat.getLista(rs);
        return lista;
    }

    public Long dodaj(ApstraktniDomenskiObjekat objekat) throws Exception {
        String upit = "INSERT into " + objekat.getNazivTabele() + " (" + objekat.getKoloneZaUnos() + ") VALUES (" + objekat.getVrednostiZaUnos() + ")";
        System.out.println(upit);
        Statement statement = konekcija.createStatement();
        int brojUnetih = statement.executeUpdate(upit, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = statement.getGeneratedKeys();
        if (rs.next()) {
            return rs.getLong(1);
        }
        return brojUnetih > 0 ? 1L : 0L;
    }

    public boolean izmeni(ApstraktniDomenskiObjekat objekat) throws Exception {
        String upit = "UPDATE " + objekat.getNazivTabele() + " SET " + objekat.getVrednostZaIzmenu() + " WHERE " + objekat.getGenerisaniKljuc();
        System.out.println(upit);
        PreparedStatement preparedStatement = konekcija.prepareStatement(upit);
        int brojIzmenjenih = preparedStatement.executeUpdate();
        return brojIzmenjenih > 0;
    }

    public boolean obrisi(ApstraktniDomenskiObjekat objekat) throws Exception {
        String upit = "DELETE FROM " + objekat.getNazivTabele() + " WHERE " + objekat.getGenerisaniKljuc();
        System.out.println(upit);
        PreparedStatement preparedStatement = konekcija.prepareStatement(upit);
        int brojObrisanih = preparedStatement.executeUpdate();
        return brojObrisanih > 0;
    }

    public ApstraktniDomenskiObjekat getObjekat(ApstraktniDomenskiObjekat objekat) throws SQLException, Exception {
        String upit = "SELECT * from " + objekat.getNazivTabele() + " " + objekat.join() + " " + objekat.getUslovRb();
        System.out.println(upit);
        Statement statement = konekcija.createStatement();
        return objekat.getObjekat(statement.executeQuery(upit));
    }
}
