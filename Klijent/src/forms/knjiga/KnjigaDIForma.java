package forms.knjiga;

import controller.KnjigaKontroler;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Knjiga;

public class KnjigaDIForma extends javax.swing.JFrame {

    KnjigaForma knjigaForma;
    Knjiga knjiga;

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(KnjigaDIForma.class.getName());

    public KnjigaDIForma(KnjigaForma aThis) {
        this.knjigaForma = aThis;
        initComponents();
        setTitle("Knjiga");
        btnIzmeni.setVisible(false);
        pack();
    }

    public KnjigaDIForma(KnjigaForma aThis, Knjiga s) {
        this.knjigaForma = aThis;
        this.knjiga = s;
        initComponents();
        setTitle("Knjiga");
        txtNaziv.setText(s.getNaziv());
        txtCena.setText(String.valueOf(s.getCena()));
        btnDodaj.setVisible(false);
        pack();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        lblNaziv = new javax.swing.JLabel();
        txtNaziv = new javax.swing.JTextField();
        lblCena = new javax.swing.JLabel();
        txtCena = new javax.swing.JTextField();
        btnDodaj = new javax.swing.JButton();
        btnIzmeni = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblNaziv.setText("Naziv:");

        lblCena.setText("Cena:");

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
                    .addComponent(lblNaziv)
                    .addComponent(lblCena)
                    .addComponent(btnDodaj))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCena, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnIzmeni))
                .addContainerGap())
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNaziv)
                    .addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCena)
                    .addComponent(txtCena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private String proveriPodatke(String naziv, double cena) {
        if (naziv.isEmpty()) {
            return "Naziv knjige je obavezan podatak.";
        }
        if (naziv.length() < 2 || naziv.length() > 50) {
            return "Naziv knjige mora da ima izmedju 2 i 50 karaktera.";
        }
        if (!naziv.matches("[\\p{L}\\p{N}][\\p{L}\\p{N} \\-\\.\\+/]*")) {
            return "Naziv knjige sme da sadrzi samo slova, brojeve i znake - . + /";
        }
        if (cena <= 0) {
            return "Cena knjige mora da bude veca od 0.";
        }
        return null;
    }

    private void btnDodajActionPerformed(java.awt.event.ActionEvent evt) {
        String naziv = txtNaziv.getText().trim();
        double cena;
        try {
            cena = Double.parseDouble(txtCena.getText().trim());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Sistem ne moze da kreira knjigu.",
                    "Greska", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String greska = proveriPodatke(naziv, cena);
        if (greska != null) {
            JOptionPane.showMessageDialog(this, "Sistem ne moze da kreira knjigu.",
                    "Greska", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            Knjiga s = new Knjiga(null, naziv, cena);
            KnjigaKontroler.getInstance().dodajKnjigu(s);
            knjigaForma.popuniTabelu();
            JOptionPane.showMessageDialog(this, "Sistem je kreirao knjigu.",
                    "Info", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        } catch (Exception ex) {
            Logger.getLogger(KnjigaDIForma.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Sistem ne moze da kreira knjigu.",
                    "Greska", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void btnIzmeniActionPerformed(java.awt.event.ActionEvent evt) {
        String naziv = txtNaziv.getText().trim();
        double cena;
        try {
            cena = Double.parseDouble(txtCena.getText().trim());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Sistem ne moze da zapamti knjigu.",
                    "Greska", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String greska = proveriPodatke(naziv, cena);
        if (greska != null) {
            JOptionPane.showMessageDialog(this, "Sistem ne moze da zapamti knjigu.",
                    "Greska", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            knjiga.setNaziv(naziv);
            knjiga.setCena(cena);
            KnjigaKontroler.getInstance().izmeniKnjigu(knjiga);
            knjigaForma.popuniTabelu();
            JOptionPane.showMessageDialog(this, "Sistem je zapamtio knjigu.",
                    "Info", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        } catch (Exception ex) {
            Logger.getLogger(KnjigaDIForma.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Sistem ne moze da zapamti knjigu.",
                    "Greska", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodaj;
    private javax.swing.JButton btnIzmeni;
    private javax.swing.JLabel lblCena;
    private javax.swing.JLabel lblNaziv;
    private javax.swing.JPanel panel;
    private javax.swing.JTextField txtCena;
    private javax.swing.JTextField txtNaziv;
    // End of variables declaration//GEN-END:variables
}
