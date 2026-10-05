package forms.kupac;

import controller.KupacKontroler;
import controller.KategorijaKontroler;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import model.Kupac;
import model.ApstraktniDomenskiObjekat;
import model.Kategorija;

public class KupacDIForma extends javax.swing.JFrame {

    KupacForma kupacForma;
    Kupac kupac;

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(KupacDIForma.class.getName());

    public KupacDIForma(KupacForma aThis) {
        this.kupacForma = aThis;
        initComponents();
        setTitle("Kupac");
        popuniCmb();
        btnIzmeni.setVisible(false);
        pack();
    }

    public KupacDIForma(KupacForma aThis, Kupac k) {
        this.kupacForma = aThis;
        this.kupac = k;
        initComponents();
        setTitle("Kupac");
        popuniCmb();
        txtIme.setText(k.getIme());
        txtPrezime.setText(k.getPrezime());
        txtEmail.setText(k.getEmail());
        txtBrojTelefona.setText(k.getBrojTelefona());
        cmbKategorija.setSelectedItem(k.getKategorija());
        btnDodaj.setVisible(false);
        pack();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        lblIme = new javax.swing.JLabel();
        txtIme = new javax.swing.JTextField();
        lblPrezime = new javax.swing.JLabel();
        txtPrezime = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblBrojTelefona = new javax.swing.JLabel();
        txtBrojTelefona = new javax.swing.JTextField();
        lblKategorija = new javax.swing.JLabel();
        cmbKategorija = new javax.swing.JComboBox();
        btnDodaj = new javax.swing.JButton();
        btnIzmeni = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblIme.setText("Ime:");

        lblPrezime.setText("Prezime:");

        lblEmail.setText("Email:");

        lblBrojTelefona.setText("Broj telefona:");

        lblKategorija.setText("Kategorija:");

        btnDodaj.setText("Dodaj");
        btnDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajActionPerformed(evt);
            }
        });

        btnIzmeni.setText("Izmeni");
        btnIzmeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzmeniActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIme)
                    .addComponent(lblPrezime)
                    .addComponent(lblEmail)
                    .addComponent(lblBrojTelefona)
                    .addComponent(lblKategorija)
                    .addComponent(btnDodaj))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtIme, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBrojTelefona, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbKategorija, 0, 220, Short.MAX_VALUE)
                    .addComponent(btnIzmeni))
                .addContainerGap())
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIme)
                    .addComponent(txtIme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPrezime)
                    .addComponent(txtPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEmail)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblBrojTelefona)
                    .addComponent(txtBrojTelefona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblKategorija)
                    .addComponent(cmbKategorija, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDodaj)
                    .addComponent(btnIzmeni))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void popuniCmb() {
        List<ApstraktniDomenskiObjekat> kategorije = new ArrayList<>();
        try {
            kategorije = KategorijaKontroler.getInstance().getKategorije();
        } catch (Exception ex) {
            Logger.getLogger(KupacDIForma.class.getName()).log(Level.SEVERE, null, ex);
        }
        cmbKategorija.setModel(new DefaultComboBoxModel(kategorije.toArray()));
    }

    private String proveriPodatke(String ime, String prezime, String email, String brojTelefona, Kategorija k) {
        if (ime.isEmpty()) {
            return "Ime kupca je obavezan podatak.";
        }
        if (ime.length() < 2 || ime.length() > 50) {
            return "Ime kupca mora da ima izmedju 2 i 50 karaktera.";
        }
        if (!ime.matches("[\\p{L}][\\p{L} \\-]*")) {
            return "Ime kupca sme da sadrzi samo slova, bez brojeva i specijalnih znakova.";
        }

        if (prezime.isEmpty()) {
            return "Prezime kupca je obavezan podatak.";
        }
        if (prezime.length() < 2 || prezime.length() > 50) {
            return "Prezime kupca mora da ima izmedju 2 i 50 karaktera.";
        }
        if (!prezime.matches("[\\p{L}][\\p{L} \\-]*")) {
            return "Prezime kupca sme da sadrzi samo slova, bez brojeva i specijalnih znakova.";
        }

        if (email.isEmpty()) {
            return "Email kupca je obavezan podatak.";
        }
        if (email.length() > 100) {
            return "Email kupca ne sme da bude duzi od 100 karaktera.";
        }
        if (!email.matches("[\\p{L}\\p{N}._%+\\-]+@[\\p{L}\\p{N}.\\-]+\\.[\\p{L}]{2,}")) {
            return "Email kupca nije u ispravnom formatu (primer: pera@firma.com).";
        }

        if (brojTelefona.isEmpty()) {
            return "Broj telefona kupca je obavezan podatak.";
        }
        if (brojTelefona.length() > 20) {
            return "Broj telefona kupca ne sme da bude duzi od 20 karaktera.";
        }
        if (!brojTelefona.matches("[0-9+\\- ]+")) {
            return "Broj telefona kupca sme da sadrzi samo cifre, razmak i znake + -.";
        }

        if (k == null || k.getIdKategorija() == null || k.getIdKategorija() <= 0) {
            return "Kategorija je obavezan podatak.";
        }
        return null;
    }

    private void btnDodajActionPerformed(java.awt.event.ActionEvent evt) {
        String ime = txtIme.getText().trim();
        String prezime = txtPrezime.getText().trim();
        String email = txtEmail.getText().trim();
        String brojTelefona = txtBrojTelefona.getText().trim();
        Kategorija k = (Kategorija) cmbKategorija.getSelectedItem();

        String greska = proveriPodatke(ime, prezime, email, brojTelefona, k);
        if (greska != null) {
            JOptionPane.showMessageDialog(this, "Sistem ne moze da zapamti kupca.",
                    "Greska", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            Kupac kup = new Kupac(ime, prezime, email, brojTelefona, k);
            KupacKontroler.getInstance().dodajKupca(kup);
            kupacForma.popuniForme();
            JOptionPane.showMessageDialog(this, "Sistem je zapamtio kupca.",
                    "Info", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        } catch (Exception ex) {
            Logger.getLogger(KupacDIForma.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Sistem ne moze da zapamti kupca.",
                    "Greska", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void btnIzmeniActionPerformed(java.awt.event.ActionEvent evt) {
        String ime = txtIme.getText().trim();
        String prezime = txtPrezime.getText().trim();
        String email = txtEmail.getText().trim();
        String brojTelefona = txtBrojTelefona.getText().trim();
        Kategorija k = (Kategorija) cmbKategorija.getSelectedItem();

        String greska = proveriPodatke(ime, prezime, email, brojTelefona, k);
        if (greska != null) {
            JOptionPane.showMessageDialog(this, "Sistem ne moze da zapamti kupca.",
                    "Greska", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            kupac.setIme(ime);
            kupac.setPrezime(prezime);
            kupac.setEmail(email);
            kupac.setBrojTelefona(brojTelefona);
            kupac.setKategorija(k);
            KupacKontroler.getInstance().izmeniKupca(kupac);
            kupacForma.popuniForme();
            JOptionPane.showMessageDialog(this, "Sistem je zapamtio kupca.",
                    "Info", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        } catch (Exception ex) {
            Logger.getLogger(KupacDIForma.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Sistem ne moze da zapamti kupca.",
                    "Greska", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodaj;
    private javax.swing.JButton btnIzmeni;
    private javax.swing.JComboBox cmbKategorija;
    private javax.swing.JLabel lblBrojTelefona;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblIme;
    private javax.swing.JLabel lblPrezime;
    private javax.swing.JLabel lblKategorija;
    private javax.swing.JPanel panel;
    private javax.swing.JTextField txtBrojTelefona;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtIme;
    private javax.swing.JTextField txtPrezime;
    // End of variables declaration//GEN-END:variables
}
