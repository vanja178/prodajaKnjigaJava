package forms.smena;

import controller.SmenaKontroler;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.ApstraktniDomenskiObjekat;
import model.Smena;
import tablemodel.ModelTabele;

public class SmenaForma extends javax.swing.JFrame {

    List<ApstraktniDomenskiObjekat> smene = new ArrayList<>();

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(SmenaForma.class.getName());

    public SmenaForma() {
        initComponents();
        setTitle("Smene");
        setSize(400, 350);
        popuniTabelu();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollSmena = new javax.swing.JScrollPane();
        tblSmena = new javax.swing.JTable();
        panelDugmadi = new javax.swing.JPanel();
        btnDodaj = new javax.swing.JButton();
        btnIzmeni = new javax.swing.JButton();
        btnObrisi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        scrollSmena.setViewportView(tblSmena);

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

        btnObrisi.setText("Obrisi");
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelDugmadiLayout = new javax.swing.GroupLayout(panelDugmadi);
        panelDugmadi.setLayout(panelDugmadiLayout);
        panelDugmadiLayout.setHorizontalGroup(
            panelDugmadiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDugmadiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnDodaj)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnIzmeni)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnObrisi)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelDugmadiLayout.setVerticalGroup(
            panelDugmadiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDugmadiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDugmadiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDodaj)
                    .addComponent(btnIzmeni)
                    .addComponent(btnObrisi))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollSmena, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                    .addComponent(panelDugmadi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(scrollSmena, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                .addGap(10, 10, 10)
                .addComponent(panelDugmadi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnDodajActionPerformed(java.awt.event.ActionEvent evt) {
        SmenaDIForma f = new SmenaDIForma(this);
        f.setVisible(true);
        f.setLocationRelativeTo(null);
    }

    private void btnIzmeniActionPerformed(java.awt.event.ActionEvent evt) {
        if (tblSmena.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Sistem ne moze da nadje smenu.",
                    "Greska", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Smena s = (Smena) ((ModelTabele) tblSmena.getModel()).getSelektovanaStavka(tblSmena.getSelectedRow());
        JOptionPane.showMessageDialog(this, "Sistem je nasao smenu.",
                "Info", JOptionPane.INFORMATION_MESSAGE);
        SmenaDIForma f = new SmenaDIForma(this, s);
        f.setVisible(true);
        f.setLocationRelativeTo(null);
    }

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {
        if (tblSmena.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Sistem ne moze da nadje smenu.",
                    "Greska", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Smena s = (Smena) ((ModelTabele) tblSmena.getModel()).getSelektovanaStavka(tblSmena.getSelectedRow());
        int i = JOptionPane.showConfirmDialog(this, "Da li zelite da obrisete " + s.getNaziv() + "?", "Potvrda brisanja", JOptionPane.YES_NO_OPTION);
        if (i == JOptionPane.YES_OPTION) {
            try {
                SmenaKontroler.getInstance().obrisiSmenu(s);
                JOptionPane.showMessageDialog(this, "Sistem je obrisao smenu.",
                        "Info", JOptionPane.INFORMATION_MESSAGE);
                popuniTabelu();
            } catch (Exception ex) {
                Logger.getLogger(SmenaForma.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Sistem ne moze da obrise smenu.",
                        "Greska", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void popuniTabelu() {
        try {
            smene = SmenaKontroler.getInstance().getSmene();
        } catch (Exception ex) {
            Logger.getLogger(SmenaForma.class.getName()).log(Level.SEVERE, null, ex);
        }
        tblSmena.setModel(new ModelTabele(smene));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodaj;
    private javax.swing.JButton btnIzmeni;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JPanel panelDugmadi;
    private javax.swing.JScrollPane scrollSmena;
    private javax.swing.JTable tblSmena;
    // End of variables declaration//GEN-END:variables
}
