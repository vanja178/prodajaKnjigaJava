package forms.racun;

import controller.KupacKontroler;
import controller.KnjigaKontroler;
import controller.RacunKontroler;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import model.Kupac;
import model.ApstraktniDomenskiObjekat;
import model.Radnik;
import model.Racun;
import model.StavkaRacuna;
import model.Knjiga;
import tablemodel.ModelTabele;

public class RacunDodajForma extends javax.swing.JFrame {

    private static final DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    Radnik radnik;
    List<StavkaRacuna> stavke = new ArrayList<>();
    List<ApstraktniDomenskiObjekat> knjige = new ArrayList<>();
    Long id;
    Racun racun;
    RacunForma racunForma;

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(RacunDodajForma.class.getName());

    public RacunDodajForma(Radnik radnik) {
        initComponents();
        setTitle("Racun");
        txtPopust.setText("0");
        setSize(1150, 620);
        this.radnik = radnik;
        popuniForme();
    }

    public RacunDodajForma(RacunForma aThis, Racun i, Radnik radnik) {
        initComponents();
        setTitle("Racun");
        setSize(1150, 620);
        this.racun = i;
        this.racunForma = aThis;
        this.radnik = radnik;
        btnKreiraj.setVisible(false);
        popuniFormeZaIzmenu();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelSevera = new javax.swing.JPanel();
        lblRadnikCap = new javax.swing.JLabel();
        lblRadnik = new javax.swing.JLabel();
        lblKupacCap = new javax.swing.JLabel();
        cmbKupac = new javax.swing.JComboBox();
        lblDatumCap = new javax.swing.JLabel();
        txtDatum = new javax.swing.JTextField();
        lblPopustCap = new javax.swing.JLabel();
        txtPopust = new javax.swing.JTextField();
        panelCentar = new javax.swing.JPanel();
        scrollKnjige = new javax.swing.JScrollPane();
        tblKnjige = new javax.swing.JTable();
        panelStavke = new javax.swing.JPanel();
        scrollStavke = new javax.swing.JScrollPane();
        tblStavke = new javax.swing.JTable();
        panelUnos = new javax.swing.JPanel();
        lblKolicinaCap = new javax.swing.JLabel();
        txtKolicina = new javax.swing.JTextField();
        btnDodaj = new javax.swing.JButton();
        btnObrisi = new javax.swing.JButton();
        panelJug = new javax.swing.JPanel();
        lblUkupnoCap = new javax.swing.JLabel();
        lblUkupno = new javax.swing.JLabel();
        btnKreiraj = new javax.swing.JButton();
        btnSacuvaj = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblRadnikCap.setText("Radnik:");

        lblKupacCap.setText("Kupac:");

        lblDatumCap.setText("Datum (yyyy-MM-dd):");

        txtDatum.setText(LocalDate.now().toString());
        txtDatum.setColumns(10);

        lblPopustCap.setText("Popust (%):");

        txtPopust.setEditable(false);

        cmbKupac.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbKupacItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout panelSeveraLayout = new javax.swing.GroupLayout(panelSevera);
        panelSevera.setLayout(panelSeveraLayout);
        panelSeveraLayout.setHorizontalGroup(
            panelSeveraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSeveraLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDatumCap)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(lblPopustCap)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPopust, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(0, Short.MAX_VALUE))
        );
        panelSeveraLayout.setVerticalGroup(
            panelSeveraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSeveraLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSeveraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDatumCap)
                    .addComponent(txtDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPopustCap)
                    .addComponent(txtPopust, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        scrollKnjige.setViewportView(tblKnjige);

        scrollStavke.setViewportView(tblStavke);

        lblKolicinaCap.setText("Kolicina:");

        txtKolicina.setText("1");
        txtKolicina.setColumns(5);

        btnDodaj.setText("Dodaj stavku");
        btnDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajActionPerformed(evt);
            }
        });

        btnObrisi.setText("Ukloni stavku");
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelUnosLayout = new javax.swing.GroupLayout(panelUnos);
        panelUnos.setLayout(panelUnosLayout);
        panelUnosLayout.setHorizontalGroup(
            panelUnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelUnosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblKolicinaCap)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtKolicina, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnDodaj)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnObrisi)
                .addContainerGap(0, Short.MAX_VALUE))
        );
        panelUnosLayout.setVerticalGroup(
            panelUnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelUnosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelUnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblKolicinaCap)
                    .addComponent(txtKolicina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDodaj)
                    .addComponent(btnObrisi))
                .addContainerGap())
        );

        javax.swing.GroupLayout panelStavkeLayout = new javax.swing.GroupLayout(panelStavke);
        panelStavke.setLayout(panelStavkeLayout);
        panelStavkeLayout.setHorizontalGroup(
            panelStavkeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollStavke)
            .addComponent(panelUnos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelStavkeLayout.setVerticalGroup(
            panelStavkeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelStavkeLayout.createSequentialGroup()
                .addComponent(scrollStavke, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelUnos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout panelCentarLayout = new javax.swing.GroupLayout(panelCentar);
        panelCentar.setLayout(panelCentarLayout);
        panelCentarLayout.setHorizontalGroup(
            panelCentarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCentarLayout.createSequentialGroup()
                .addComponent(scrollKnjige, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelStavke, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE))
        );
        panelCentarLayout.setVerticalGroup(
            panelCentarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollKnjige, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
            .addComponent(panelStavke, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
        );

        lblUkupnoCap.setText("Ukupan iznos:");

        lblUkupno.setText("0");

        btnKreiraj.setText("Kreiraj racun");
        btnKreiraj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKreirajActionPerformed(evt);
            }
        });

        btnSacuvaj.setText("Sacuvaj izmene");
        btnSacuvaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacuvajActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelJugLayout = new javax.swing.GroupLayout(panelJug);
        panelJug.setLayout(panelJugLayout);
        panelJugLayout.setHorizontalGroup(
            panelJugLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelJugLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUkupnoCap)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblUkupno)
                .addGap(10, 10, 10)
                .addComponent(btnKreiraj)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSacuvaj)
                .addContainerGap(0, Short.MAX_VALUE))
            .addGroup(panelJugLayout.createSequentialGroup()
                .addContainerGap(0, Short.MAX_VALUE)
                .addComponent(lblRadnikCap)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblRadnik)
                .addGap(10, 10, 10)
                .addComponent(lblKupacCap)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbKupac, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelJugLayout.setVerticalGroup(
            panelJugLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelJugLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelJugLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUkupnoCap)
                    .addComponent(lblUkupno)
                    .addComponent(btnKreiraj)
                    .addComponent(btnSacuvaj))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelJugLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblRadnikCap)
                    .addComponent(lblRadnik)
                    .addComponent(lblKupacCap)
                    .addComponent(cmbKupac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelSevera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelCentar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelJug, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(panelSevera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelCentar, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelJug, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmbKupacItemStateChanged(java.awt.event.ItemEvent evt) {
        if (evt.getStateChange() != java.awt.event.ItemEvent.SELECTED) {
            return;
        }
        Kupac k = (Kupac) cmbKupac.getSelectedItem();
        if (k != null && k.getKategorija() != null) {
            txtPopust.setText(String.valueOf(k.getKategorija().getPopust()));
        }
        if (!stavke.isEmpty()) {
            azurirajTabeluStavki();
        }
    }

    private void btnDodajActionPerformed(java.awt.event.ActionEvent evt) {
        if (tblKnjige.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Morate izabrati knjigu!", "Greska", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Knjiga knjiga = (Knjiga) ((ModelTabele) tblKnjige.getModel()).getSelektovanaStavka(tblKnjige.getSelectedRow());
        int kolicina;
        try {
            kolicina = Integer.parseInt(txtKolicina.getText().trim());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Kolicina mora da bude ceo broj.", "Greska", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (kolicina <= 0) {
            JOptionPane.showMessageDialog(this, "Kolicina mora da bude veca od 0.", "Greska", JOptionPane.ERROR_MESSAGE);
            return;
        }

        StavkaRacuna postojeca = null;
        for (StavkaRacuna s : stavke) {
            if (s.getKnjiga().getIdKnjiga().equals(knjiga.getIdKnjiga())) {
                postojeca = s;
                break;
            }
        }
        if (postojeca != null) {
            postojeca.setKolicina(postojeca.getKolicina() + kolicina);
        } else {
            StavkaRacuna nova = new StavkaRacuna(racun, kolicina, knjiga);
            stavke.add(nova);
        }
        txtKolicina.setText("1");

        azurirajTabeluStavki();
    }

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {
        if (tblStavke.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Morate izabrati stavku!", "Greska", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int i = tblStavke.getSelectedRow();
        stavke.remove(i);
        azurirajTabeluStavki();
    }

    private String proveriRacun(Kupac k, double popust, LocalDate datum) {
        if (k == null || k.getIdKupac() == null || k.getIdKupac() <= 0) {
            return "Kupac je obavezan podatak.";
        }
        if (radnik == null || radnik.getIdRadnik() == null || radnik.getIdRadnik() <= 0) {
            return "Radnik je obavezan podatak.";
        }
        if (datum == null) {
            return "Datum je obavezan podatak.";
        }
        if (popust < 0 || popust > 100) {
            return "Popust mora da bude izmedju 0 i 100.";
        }
        if (stavke.isEmpty()) {
            return "Racun mora da ima bar jednu stavku.";
        }
        for (StavkaRacuna s : stavke) {
            if (s.getKnjiga() == null || s.getKnjiga().getIdKnjiga() == null) {
                return "Knjiga na stavci racuna je obavezan podatak.";
            }
            if (s.getKolicina() <= 0) {
                return "Kolicina na stavci racuna mora da bude veca od 0.";
            }
        }
        return null;
    }

    private void btnKreirajActionPerformed(java.awt.event.ActionEvent evt) {
        Kupac k = (Kupac) cmbKupac.getSelectedItem();
        double popust;
        try {
            popust = Double.parseDouble(txtPopust.getText().trim());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Sistem ne moze da zapamti racun.",
                    "Greska", JOptionPane.ERROR_MESSAGE);
            return;
        }
        LocalDate datum;
        try {
            datum = LocalDate.parse(txtDatum.getText().trim(), FORMAT);
        } catch (DateTimeParseException ex) {
            JOptionPane.showMessageDialog(this, "Sistem ne moze da zapamti racun.",
                    "Greska", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String greska = proveriRacun(k, popust, datum);
        if (greska != null) {
            JOptionPane.showMessageDialog(this, "Sistem ne moze da zapamti racun.",
                    "Greska", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int kolicina = Integer.parseInt(txtKolicina.getText().trim());
        double ukupno = izracunajUkupno() * (1 - popust / 100) * kolicina;

        Racun i = new Racun(datum, ukupno, popust, radnik, k, stavke);
        try {
            id = RacunKontroler.getInstance().dodajRacun(i);
            JOptionPane.showMessageDialog(this, "Sistem je zapamtio racun.",
                    "Info", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        } catch (Exception ex) {
            Logger.getLogger(RacunDodajForma.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Sistem ne moze da zapamti racun.",
                    "Greska", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void btnSacuvajActionPerformed(java.awt.event.ActionEvent evt) {
        Kupac k = (Kupac) cmbKupac.getSelectedItem();
        double popust;
        try {
            popust = Double.parseDouble(txtPopust.getText().trim());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Sistem ne moze da zapamti racun.",
                    "Greska", JOptionPane.ERROR_MESSAGE);
            return;
        }
        LocalDate datum;
        try {
            datum = LocalDate.parse(txtDatum.getText().trim(), FORMAT);
        } catch (DateTimeParseException ex) {
            JOptionPane.showMessageDialog(this, "Sistem ne moze da zapamti racun.",
                    "Greska", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String greska = proveriRacun(k, popust, datum);
        if (greska != null) {
            JOptionPane.showMessageDialog(this, "Sistem ne moze da zapamti racun.",
                    "Greska", JOptionPane.ERROR_MESSAGE);
            return;
        }

        double ukupno = izracunajUkupno() * (1 - popust / 100);

        racun.setKupac(k);
        racun.setRadnik(radnik);
        racun.setDatum(datum);
        racun.setPopust(popust);
        racun.setUkupanIznos(ukupno);
        racun.setStavke(stavke);

        try {
            RacunKontroler.getInstance().izmeniRacun(racun);
            JOptionPane.showMessageDialog(this, "Sistem je zapamtio racun.",
                    "Info", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        } catch (Exception ex) {
            Logger.getLogger(RacunDodajForma.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Sistem ne moze da zapamti racun.",
                    "Greska", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void popuniForme() {
        btnSacuvaj.setVisible(false);
        lblRadnik.setText(radnik.getIme() + " " + radnik.getPrezime());

        try {
            List<ApstraktniDomenskiObjekat> k = KupacKontroler.getInstance().getKupce();
            cmbKupac.setModel(new DefaultComboBoxModel(k.toArray()));
            if (!k.isEmpty()) {
                cmbKupac.setSelectedIndex(0);
            }
        } catch (Exception ex) {
            Logger.getLogger(RacunDodajForma.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            knjige = KnjigaKontroler.getInstance().getKnjige();
        } catch (Exception ex) {
            Logger.getLogger(RacunDodajForma.class.getName()).log(Level.SEVERE, null, ex);
        }
        tblKnjige.setModel(new ModelTabele(knjige));
        tblStavke.setModel(new ModelTabele(stavke));
    }

    private void popuniFormeZaIzmenu() {
        lblRadnik.setText(radnik.getIme() + " " + radnik.getPrezime());
        lblUkupno.setText(racun.getUkupanIznos() + "");
        txtPopust.setText(String.valueOf(racun.getPopust()));
        txtDatum.setText(racun.getDatum().toString());

        try {
            List<ApstraktniDomenskiObjekat> k = KupacKontroler.getInstance().getKupce();
            cmbKupac.setModel(new DefaultComboBoxModel(k.toArray()));
        } catch (Exception ex) {
            Logger.getLogger(RacunDodajForma.class.getName()).log(Level.SEVERE, null, ex);
        }
        cmbKupac.setSelectedItem(racun.getKupac());

        try {
            knjige = KnjigaKontroler.getInstance().getKnjige();
        } catch (Exception ex) {
            Logger.getLogger(RacunDodajForma.class.getName()).log(Level.SEVERE, null, ex);
        }
        tblKnjige.setModel(new ModelTabele(knjige));

        stavke.addAll(racun.getStavke());
        tblStavke.setModel(new ModelTabele(stavke));
    }

    private void azurirajTabeluStavki() {
        tblStavke.setModel(new ModelTabele(stavke));
        double popust;
        try {
            popust = Double.parseDouble(txtPopust.getText().trim());
        } catch (NumberFormatException ex) {
            popust = 0;
        }
        lblUkupno.setText((izracunajUkupno() * (1 - popust / 100)) + "");
    }

    private double izracunajUkupno() {
        double ukupno = 0;
        for (StavkaRacuna stavka : stavke) {
            ukupno += stavka.getIznos();
        }
        return ukupno;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodaj;
    private javax.swing.JButton btnKreiraj;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnSacuvaj;
    private javax.swing.JComboBox cmbKupac;
    private javax.swing.JLabel lblDatumCap;
    private javax.swing.JLabel lblKolicinaCap;
    private javax.swing.JLabel lblKupacCap;
    private javax.swing.JLabel lblPopustCap;
    private javax.swing.JLabel lblUkupno;
    private javax.swing.JLabel lblUkupnoCap;
    private javax.swing.JLabel lblRadnik;
    private javax.swing.JLabel lblRadnikCap;
    private javax.swing.JPanel panelCentar;
    private javax.swing.JPanel panelJug;
    private javax.swing.JPanel panelSevera;
    private javax.swing.JPanel panelStavke;
    private javax.swing.JPanel panelUnos;
    private javax.swing.JScrollPane scrollStavke;
    private javax.swing.JScrollPane scrollKnjige;
    private javax.swing.JTable tblStavke;
    private javax.swing.JTable tblKnjige;
    private javax.swing.JTextField txtDatum;
    private javax.swing.JTextField txtKolicina;
    private javax.swing.JTextField txtPopust;
    // End of variables declaration//GEN-END:variables
}
