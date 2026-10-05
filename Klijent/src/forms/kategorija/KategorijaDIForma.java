package forms.kategorija;

import controller.KategorijaKontroler;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Kategorija;

public class KategorijaDIForma extends javax.swing.JFrame {

    KategorijaForma kategorijaForma;
    Kategorija kategorija;

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(KategorijaDIForma.class.getName());

    public KategorijaDIForma(KategorijaForma aThis) {
        this.kategorijaForma = aThis;
        initComponents();
        setTitle("Kategorija");
        btnIzmeni.setVisible(false);
        pack();
    }

    public KategorijaDIForma(KategorijaForma aThis, Kategorija k) {
        this.kategorijaForma = aThis;
        this.kategorija = k;
        initComponents();
        setTitle("Kategorija");
        txtNaziv.setText(k.getNaziv());
        txtPopust.setText(String.valueOf(k.getPopust()));
        btnDodaj.setVisible(false);
        pack();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        lblNaziv = new javax.swing.JLabel();
        txtNaziv = new javax.swing.JTextField();
        lblPopust = new javax.swing.JLabel();
        txtPopust = new javax.swing.JTextField();
        btnDodaj = new javax.swing.JButton();
        btnIzmeni = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblNaziv.setText("Naziv:");

        lblPopust.setText("Popust (%):");

        txtPopust.setText("0");

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
                    .addComponent(lblPopust)
                    .addComponent(btnDodaj))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPopust, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(lblPopust)
                    .addComponent(txtPopust, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private String proveriPodatke(String naziv, double popust) {
        if (naziv.isEmpty()) {
            return "Naziv kategorije je obavezan podatak.";
        }
        if (naziv.length() < 2 || naziv.length() > 50) {
            return "Naziv kategorije mora da ima izmedju 2 i 50 karaktera.";
        }
        if (!naziv.matches("[\\p{L}][\\p{L} \\-]*")) {
            return "Naziv kategorije sme da sadrzi samo slova, bez brojeva i specijalnih znakova.";
        }
        if (popust < 0 || popust > 100) {
            return "Popust kategorije mora da bude izmedju 0 i 100.";
        }
        return null;
    }

    private void btnDodajActionPerformed(java.awt.event.ActionEvent evt) {
        String naziv = txtNaziv.getText().trim();
        double popust;
        try {
            popust = Double.parseDouble(txtPopust.getText().trim());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Sistem ne moze da kreira kategoriju.",
                    "Greska", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String greska = proveriPodatke(naziv, popust);
        if (greska != null) {
            JOptionPane.showMessageDialog(this, "Sistem ne moze da kreira kategoriju.",
                    "Greska", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            Kategorija k = new Kategorija(null, naziv, popust);
            KategorijaKontroler.getInstance().dodajKategoriju(k);
            kategorijaForma.popuniTabelu();
            JOptionPane.showMessageDialog(this, "Sistem je kreirao kategoriju.",
                    "Info", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        } catch (Exception ex) {
            Logger.getLogger(KategorijaDIForma.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Sistem ne moze da kreira kategoriju.",
                    "Greska", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void btnIzmeniActionPerformed(java.awt.event.ActionEvent evt) {
        String naziv = txtNaziv.getText().trim();
        double popust;
        try {
            popust = Double.parseDouble(txtPopust.getText().trim());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Sistem ne moze da zapamti kategoriju.",
                    "Greska", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String greska = proveriPodatke(naziv, popust);
        if (greska != null) {
            JOptionPane.showMessageDialog(this, "Sistem ne moze da zapamti kategoriju.",
                    "Greska", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            kategorija.setNaziv(naziv);
            kategorija.setPopust(popust);
            KategorijaKontroler.getInstance().izmeniKategoriju(kategorija);
            kategorijaForma.popuniTabelu();
            JOptionPane.showMessageDialog(this, "Sistem je zapamtio kategoriju.",
                    "Info", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        } catch (Exception ex) {
            Logger.getLogger(KategorijaDIForma.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Sistem ne moze da zapamti kategoriju.",
                    "Greska", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodaj;
    private javax.swing.JButton btnIzmeni;
    private javax.swing.JLabel lblNaziv;
    private javax.swing.JLabel lblPopust;
    private javax.swing.JPanel panel;
    private javax.swing.JTextField txtNaziv;
    private javax.swing.JTextField txtPopust;
    // End of variables declaration//GEN-END:variables
}
