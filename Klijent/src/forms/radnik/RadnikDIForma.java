package forms.radnik;

import controller.RadnikKontroler;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Radnik;

public class RadnikDIForma extends javax.swing.JFrame {

    RadnikForma radnikForma;
    Radnik radnik;

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(RadnikDIForma.class.getName());

    public RadnikDIForma(RadnikForma aThis) {
        this.radnikForma = aThis;
        initComponents();
        setTitle("Radnik");
        btnIzmeni.setVisible(false);
        pack();
    }

    public RadnikDIForma(RadnikForma aThis, Radnik z) {
        this.radnikForma = aThis;
        this.radnik = z;
        initComponents();
        setTitle("Radnik");
        txtIme.setText(z.getIme());
        txtPrezime.setText(z.getPrezime());
        txtKorisnickoIme.setText(z.getKorisnickoIme());
        txtSifra.setText(z.getSifra());
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
        lblKorisnickoIme = new javax.swing.JLabel();
        txtKorisnickoIme = new javax.swing.JTextField();
        lblSifra = new javax.swing.JLabel();
        txtSifra = new javax.swing.JPasswordField();
        btnDodaj = new javax.swing.JButton();
        btnIzmeni = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblIme.setText("Ime:");

        lblPrezime.setText("Prezime:");

        lblKorisnickoIme.setText("Korisnicko ime:");

        lblSifra.setText("Sifra:");

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
                    .addComponent(lblKorisnickoIme)
                    .addComponent(lblSifra)
                    .addComponent(btnDodaj))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtIme, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtKorisnickoIme, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSifra, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(lblKorisnickoIme)
                    .addComponent(txtKorisnickoIme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSifra)
                    .addComponent(txtSifra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private String proveriPodatke(String ime, String prezime, String korisnickoIme, String sifra) {
        if (ime.isEmpty()) {
            return "Ime radnika je obavezan podatak.";
        }
        if (ime.length() < 2 || ime.length() > 50) {
            return "Ime radnika mora da ima izmedju 2 i 50 karaktera.";
        }
        if (!ime.matches("[\\p{L}][\\p{L} \\-]*")) {
            return "Ime radnika sme da sadrzi samo slova, bez brojeva i specijalnih znakova.";
        }

        if (prezime.isEmpty()) {
            return "Prezime radnika je obavezan podatak.";
        }
        if (prezime.length() < 2 || prezime.length() > 50) {
            return "Prezime radnika mora da ima izmedju 2 i 50 karaktera.";
        }
        if (!prezime.matches("[\\p{L}][\\p{L} \\-]*")) {
            return "Prezime radnika sme da sadrzi samo slova, bez brojeva i specijalnih znakova.";
        }

        if (korisnickoIme.isEmpty()) {
            return "Korisnicko ime radnika je obavezan podatak.";
        }
        if (korisnickoIme.length() < 3 || korisnickoIme.length() > 50) {
            return "Korisnicko ime radnika mora da ima izmedju 3 i 50 karaktera.";
        }
        if (!korisnickoIme.matches("[\\p{L}\\p{N}._\\-]+")) {
            return "Korisnicko ime radnika sme da sadrzi samo slova, brojeve, tacku, crtu i donju crtu.";
        }

        if (sifra.isEmpty()) {
            return "Sifra radnika je obavezan podatak.";
        }
        if (sifra.length() < 4 || sifra.length() > 50) {
            return "Sifra radnika mora da ima izmedju 4 i 50 karaktera.";
        }
        if (sifra.contains("'") || sifra.contains("\"") || sifra.contains(";") || sifra.contains("\\")) {
            return "Sifra radnika sadrzi nedozvoljene znake.";
        }
        return null;
    }

    private void btnDodajActionPerformed(java.awt.event.ActionEvent evt) {
        String ime = txtIme.getText().trim();
        String prezime = txtPrezime.getText().trim();
        String korisnickoIme = txtKorisnickoIme.getText().trim();
        String sifra = String.valueOf(txtSifra.getPassword());

        String greska = proveriPodatke(ime, prezime, korisnickoIme, sifra);
        if (greska != null) {
            JOptionPane.showMessageDialog(this, "Sistem ne moze da kreira radnika.",
                    "Greska", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            Radnik z = new Radnik(null, ime, prezime, korisnickoIme, sifra);
            RadnikKontroler.getInstance().dodajRadnika(z);
            radnikForma.popuniTabelu();
            JOptionPane.showMessageDialog(this, "Sistem je kreirao radnika.",
                    "Info", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        } catch (Exception ex) {
            Logger.getLogger(RadnikDIForma.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Sistem ne moze da kreira radnika.",
                    "Greska", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void btnIzmeniActionPerformed(java.awt.event.ActionEvent evt) {
        String ime = txtIme.getText().trim();
        String prezime = txtPrezime.getText().trim();
        String korisnickoIme = txtKorisnickoIme.getText().trim();
        String sifra = String.valueOf(txtSifra.getPassword());

        String greska = proveriPodatke(ime, prezime, korisnickoIme, sifra);
        if (greska != null) {
            JOptionPane.showMessageDialog(this, "Sistem ne moze da zapamti radnika.",
                    "Greska", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            radnik.setIme(ime);
            radnik.setPrezime(prezime);
            radnik.setKorisnickoIme(korisnickoIme);
            radnik.setSifra(sifra);
            RadnikKontroler.getInstance().izmeniRadnika(radnik);
            radnikForma.popuniTabelu();
            JOptionPane.showMessageDialog(this, "Sistem je zapamtio radnika.",
                    "Info", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        } catch (Exception ex) {
            Logger.getLogger(RadnikDIForma.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Sistem ne moze da zapamti radnika.",
                    "Greska", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodaj;
    private javax.swing.JButton btnIzmeni;
    private javax.swing.JLabel lblKorisnickoIme;
    private javax.swing.JLabel lblIme;
    private javax.swing.JLabel lblPrezime;
    private javax.swing.JLabel lblSifra;
    private javax.swing.JPanel panel;
    private javax.swing.JTextField txtKorisnickoIme;
    private javax.swing.JTextField txtIme;
    private javax.swing.JTextField txtPrezime;
    private javax.swing.JPasswordField txtSifra;
    // End of variables declaration//GEN-END:variables
}
