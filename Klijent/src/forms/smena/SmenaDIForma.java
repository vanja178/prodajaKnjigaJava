package forms.smena;

import controller.SmenaKontroler;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Smena;

public class SmenaDIForma extends javax.swing.JFrame {

    SmenaForma smenaForma;
    Smena smena;

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(SmenaDIForma.class.getName());

    public SmenaDIForma(SmenaForma aThis) {
        this.smenaForma = aThis;
        initComponents();
        btnIzmeni.setVisible(false);
        pack();
    }

    public SmenaDIForma(SmenaForma aThis, Smena s) {
        this.smenaForma = aThis;
        this.smena = s;
        initComponents();
        txtNaziv.setText(s.getNaziv());
        btnDodaj.setVisible(false);
        pack();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        lblNaziv = new javax.swing.JLabel();
        txtNaziv = new javax.swing.JTextField();
        btnDodaj = new javax.swing.JButton();
        btnIzmeni = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblNaziv.setText("Naziv:");

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
                    .addComponent(btnDodaj))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnIzmeni))
                .addGap(0, 0, Short.MAX_VALUE))
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
                    .addComponent(btnDodaj)
                    .addComponent(btnIzmeni))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );
    }// </editor-fold>//GEN-END:initComponents

    private String proveriPodatke(String naziv) {
        if (naziv.isEmpty()) {
            return "Naziv smene je obavezan podatak.";
        }
        if (naziv.length() < 2 || naziv.length() > 50) {
            return "Naziv smene mora da ima izmedju 2 i 50 karaktera.";
        }
        if (!naziv.matches("[\\p{L}][\\p{L} \\-]*")) {
            return "Naziv smene sme da sadrzi samo slova, bez brojeva i specijalnih znakova.";
        }
        return null;
    }

    private void btnDodajActionPerformed(java.awt.event.ActionEvent evt) {
        String naziv = txtNaziv.getText().trim();

        String greska = proveriPodatke(naziv);
        if (greska != null) {
            JOptionPane.showMessageDialog(this, "Sistem ne moze da zapamti smenu.",
                    "Greska", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            Smena s = new Smena(naziv);
            SmenaKontroler.getInstance().dodajSmenu(s);
            smenaForma.popuniTabelu();
            JOptionPane.showMessageDialog(this, "Sistem je zapamtio smenu.",
                    "Info", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        } catch (Exception ex) {
            Logger.getLogger(SmenaDIForma.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Sistem ne moze da zapamti smenu.",
                    "Greska", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void btnIzmeniActionPerformed(java.awt.event.ActionEvent evt) {
        String naziv = txtNaziv.getText().trim();

        String greska = proveriPodatke(naziv);
        if (greska != null) {
            JOptionPane.showMessageDialog(this, "Sistem ne moze da zapamti smenu.",
                    "Greska", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            smena.setNaziv(naziv);
            SmenaKontroler.getInstance().izmeniSmenu(smena);
            smenaForma.popuniTabelu();
            JOptionPane.showMessageDialog(this, "Sistem je zapamtio smenu.",
                    "Info", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        } catch (Exception ex) {
            Logger.getLogger(SmenaDIForma.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Sistem ne moze da zapamti smenu.",
                    "Greska", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodaj;
    private javax.swing.JButton btnIzmeni;
    private javax.swing.JLabel lblNaziv;
    private javax.swing.JPanel panel;
    private javax.swing.JTextField txtNaziv;
    // End of variables declaration//GEN-END:variables
}
