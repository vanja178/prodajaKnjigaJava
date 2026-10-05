package forms;

import forms.kategorija.KategorijaForma;
import forms.smena.SmenaForma;
import forms.racun.RacunForma;
import forms.racun.RacunDodajForma;
import forms.radnik.RadnikForma;
import forms.radnik.RadnikSmenaForma;
import forms.knjiga.KnjigaForma;
import forms.kupac.KupacForma;
import controller.RadnikKontroler;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import model.Radnik;

public class GlavnaForma extends javax.swing.JFrame {

    Radnik radnik;

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(GlavnaForma.class.getName());

    public GlavnaForma() {
        initComponents();
        setTitle("Racuni za knjige");
        initMeni();
        initOdjavu();
        setSize(900, 600);
        setLocationRelativeTo(null);
    }

    GlavnaForma(Radnik radnik) {
        this.radnik = radnik;
        initComponents();
        setTitle("Racuni za knjige");
        initMeni();
        initOdjavu();
        setSize(900, 600);
        setLocationRelativeTo(null);
    }


    private void initOdjavu() {
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                try {
                    RadnikKontroler.getInstance().odjava();
                } catch (Exception ex) {
                    logger.log(java.util.logging.Level.WARNING, "Greska pri odjavi", ex);
                }
                RadnikKontroler.getInstance().prekiniVezu();
                System.exit(0);
            }
        });
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblBanner = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblBanner.setPreferredSize(new java.awt.Dimension(840, 560));
        lblBanner.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBanner.setVerticalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblBanner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblBanner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }
    // </editor-fold>//GEN-END:initComponents

    private void initMeni() {
        JMenuBar meniBar = new JMenuBar();

        JMenu meniRacun = new JMenu("Racun");
        JMenuItem stavkaDodajRacun = new JMenuItem("Dodaj racun");
        stavkaDodajRacun.addActionListener(evt -> {
            RacunDodajForma i = new RacunDodajForma(radnik);
            i.setVisible(true);
            i.setLocationRelativeTo(null);
        });
        JMenuItem stavkaPretraziRacun = new JMenuItem("Pretrazi racune");
        stavkaPretraziRacun.addActionListener(evt -> {
            RacunForma i = new RacunForma(radnik);
            i.setVisible(true);
            i.setLocationRelativeTo(null);
        });
        meniRacun.add(stavkaDodajRacun);
        meniRacun.add(stavkaPretraziRacun);
        meniBar.add(meniRacun);

        JMenu meniRadnik = new JMenu("Radnik");
        meniRadnik.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RadnikForma zf = new RadnikForma();
                zf.setVisible(true);
                zf.setLocationRelativeTo(null);
            }
        });
        meniBar.add(meniRadnik);

        JMenu meniKnjiga = new JMenu("Knjiga");
        meniKnjiga.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                KnjigaForma sf = new KnjigaForma();
                sf.setVisible(true);
                sf.setLocationRelativeTo(null);
            }
        });
        meniBar.add(meniKnjiga);

        JMenu meniKupac = new JMenu("Kupac");
        meniKupac.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                KupacForma kf = new KupacForma();
                kf.setVisible(true);
                kf.setLocationRelativeTo(null);
            }
        });
        meniBar.add(meniKupac);

        JMenu meniSmena = new JMenu("Smena");
        meniSmena.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SmenaForma tf = new SmenaForma();
                tf.setVisible(true);
                tf.setLocationRelativeTo(null);
            }
        });
        meniBar.add(meniSmena);

        JMenu meniKategorija = new JMenu("Kategorija");
        meniKategorija.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                KategorijaForma tf = new KategorijaForma();
                tf.setVisible(true);
                tf.setLocationRelativeTo(null);
            }
        });
        meniBar.add(meniKategorija);

        JMenu meniRadnikSmena = new JMenu("Raspored smena");
        meniRadnikSmena.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RadnikSmenaForma ztf = new RadnikSmenaForma();
                ztf.setVisible(true);
                ztf.setLocationRelativeTo(null);
            }
        });
        meniBar.add(meniRadnikSmena);

        setJMenuBar(meniBar);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblBanner;
    // End of variables declaration//GEN-END:variables
}
