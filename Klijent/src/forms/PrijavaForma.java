package forms;

import controller.RadnikKontroler;
import forms.GlavnaForma;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Radnik;

public class PrijavaForma extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(PrijavaForma.class.getName());

    public PrijavaForma() {
        initComponents();
        setTitle("Prijava");
        pack();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        lblKorisnickoIme = new javax.swing.JLabel();
        txtKorisnickoIme = new javax.swing.JTextField();
        lblSifra = new javax.swing.JLabel();
        txtSifra = new javax.swing.JPasswordField();
        lblEmpty = new javax.swing.JLabel();
        btnPrijava = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel.setPreferredSize(new java.awt.Dimension(350, 91));

        lblKorisnickoIme.setText("Korisnicko ime:");

        txtKorisnickoIme.setText("nikola");

        lblSifra.setText("Sifra:");

        txtSifra.setText("nikola123");
        txtSifra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSifraActionPerformed(evt);
            }
        });

        btnPrijava.setText("Prijava");
        btnPrijava.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrijavaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblKorisnickoIme)
                            .addComponent(lblSifra)
                            .addComponent(lblEmpty))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtSifra, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                            .addComponent(txtKorisnickoIme)))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(btnPrijava)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblKorisnickoIme)
                    .addComponent(txtKorisnickoIme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSifra)
                    .addComponent(txtSifra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblEmpty)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPrijava, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 8, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtSifraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSifraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSifraActionPerformed

    private void btnPrijavaActionPerformed(java.awt.event.ActionEvent evt) {
        String korisnickoIme = txtKorisnickoIme.getText().trim();
        String sifra = String.valueOf(txtSifra.getPassword());

        if (korisnickoIme.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Korisnicko ime je obavezan podatak.",
                    "Greska", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (korisnickoIme.length() > 50) {
            JOptionPane.showMessageDialog(this, "Korisnicko ime ne sme da bude duze od 50 karaktera.",
                    "Greska", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (sifra.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Sifra je obavezan podatak.",
                    "Greska", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (sifra.length() > 50) {
            JOptionPane.showMessageDialog(this, "Sifra ne sme da bude duza od 50 karaktera.",
                    "Greska", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Radnik radnik;
        try {
            radnik = RadnikKontroler.getInstance().prijava(new Radnik(korisnickoIme, sifra));
        } catch (Exception ex) {
            Logger.getLogger(PrijavaForma.class.getName()).log(Level.SEVERE, null, ex);
            if ("Korisnicko ime i sifra nisu ispravni.".equals(ex.getMessage())) {
                JOptionPane.showMessageDialog(this, "Korisnicko ime i sifra nisu ispravni.",
                        "Greska", JOptionPane.ERROR_MESSAGE);
                return;
            }
            JOptionPane.showMessageDialog(this, "Ne moze da se otvori glavna forma i meni.",
                    "Greska", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (radnik == null) {
            JOptionPane.showMessageDialog(this, "Korisnicko ime i sifra nisu ispravni.",
                    "Greska", JOptionPane.ERROR_MESSAGE);
            return;
        }

        JOptionPane.showMessageDialog(this, "Korisnicko ime i sifra su ispravni.",
                "Info", JOptionPane.INFORMATION_MESSAGE);

        try {
            GlavnaForma gf = new GlavnaForma(radnik);
            gf.setVisible(true);
            gf.setLocationRelativeTo(null);
            this.dispose();
        } catch (Exception ex) {
            Logger.getLogger(PrijavaForma.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Server nije pokrenut.",
                    "Greska", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPrijava;
    private javax.swing.JLabel lblEmpty;
    private javax.swing.JLabel lblKorisnickoIme;
    private javax.swing.JLabel lblSifra;
    private javax.swing.JPanel panel;
    private javax.swing.JTextField txtKorisnickoIme;
    private javax.swing.JPasswordField txtSifra;
    // End of variables declaration//GEN-END:variables
}
