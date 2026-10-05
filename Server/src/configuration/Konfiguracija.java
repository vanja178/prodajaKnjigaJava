package configuration;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Konfiguracija {

    private static Konfiguracija instanca;
    private Properties konfiguracija;
    private static final String PUTANJA = "config/config.properties";

    private Konfiguracija() {
        try {
            konfiguracija = new Properties();
            konfiguracija.load(new FileInputStream(PUTANJA));
        } catch (IOException ex) {
            ex.printStackTrace();
            Logger.getLogger(Konfiguracija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Konfiguracija getInstance() {
        if (instanca == null) {
            instanca = new Konfiguracija();
        }
        return instanca;
    }

    public String getProperty(String kljuc) {
        return konfiguracija.getProperty(kljuc, "n/a");
    }

    public void setProperty(String kljuc, String vrednost) {
        konfiguracija.setProperty(kljuc, vrednost);
    }

    public void sacuvajIzmene() {
        try {
            konfiguracija.store(new FileOutputStream(PUTANJA), "Azurirana konfiguracija");
        } catch (IOException ex) {
            ex.printStackTrace();
            Logger.getLogger(Konfiguracija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
