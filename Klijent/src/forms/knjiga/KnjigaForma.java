package forms.knjiga;

import controller.KnjigaKontroler;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import model.Knjiga;
import model.ApstraktniDomenskiObjekat;
import tablemodel.ModelTabele;

public class KnjigaForma extends javax.swing.JFrame {

    List<ApstraktniDomenskiObjekat> knjige = new ArrayList<>();

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(KnjigaForma.class.getName());

    public KnjigaForma() {
        initComponents();
        setTitle("Knjige");
        setSize(500, 350);
        popuniTabelu();
        dodajListenere();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollKnjiga = new javax.swing.JScrollPane();
        tblKnjiga = new javax.swing.JTable();
        panelJug = new javax.swing.JPanel();
        panelPretraga = new javax.swing.JPanel();
        lblPretraga = new javax.swing.JLabel();
        txtPretraga = new javax.swing.JTextField();
        panelDugmadi = new javax.swing.JPanel();
        btnDodaj = new javax.swing.JButton();
        btnIzmeni = new javax.swing.JButton();
        btnObrisi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        scrollKnjiga.setViewportView(tblKnjiga);

        lblPretraga.setText("Pretraga:");

        txtPretraga.setColumns(15);

        javax.swing.GroupLayout panelPretragaLayout = new javax.swing.GroupLayout(panelPretraga);
        panelPretraga.setLayout(panelPretragaLayout);
        panelPretragaLayout.setHorizontalGroup(
            panelPretragaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPretragaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblPretraga)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPretraga, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(0, Short.MAX_VALUE))
        );
        panelPretragaLayout.setVerticalGroup(
            panelPretragaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPretragaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPretragaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPretraga)
                    .addComponent(txtPretraga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

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
                .addContainerGap(0, Short.MAX_VALUE))
        );
        panelDugmadiLayout.setVerticalGroup(
            panelDugmadiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDugmadiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDugmadiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDodaj)
                    .addComponent(btnIzmeni)
                    .addComponent(btnObrisi))
                .addContainerGap())
        );

        javax.swing.GroupLayout panelJugLayout = new javax.swing.GroupLayout(panelJug);
        panelJug.setLayout(panelJugLayout);
        panelJugLayout.setHorizontalGroup(
            panelJugLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPretraga, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelDugmadi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelJugLayout.setVerticalGroup(
            panelJugLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelJugLayout.createSequentialGroup()
                .addComponent(panelPretraga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(panelDugmadi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollKnjiga, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
                    .addComponent(panelJug, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(scrollKnjiga, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelJug, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnDodajActionPerformed(java.awt.event.ActionEvent evt) {
        KnjigaDIForma f = new KnjigaDIForma(this);
        f.setVisible(true);
        f.setLocationRelativeTo(null);
    }

    private void btnIzmeniActionPerformed(java.awt.event.ActionEvent evt) {
        if (tblKnjiga.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Sistem ne moze da nadje knjigu.",
                    "Greska", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Knjiga s = (Knjiga) ((ModelTabele) tblKnjiga.getModel()).getSelektovanaStavka(tblKnjiga.getSelectedRow());
        JOptionPane.showMessageDialog(this, "Sistem je nasao knjigu.",
                "Info", JOptionPane.INFORMATION_MESSAGE);
        KnjigaDIForma f = new KnjigaDIForma(this, s);
        f.setVisible(true);
        f.setLocationRelativeTo(null);
    }

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {
        if (tblKnjiga.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Sistem ne moze da nadje knjigu.",
                    "Greska", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Knjiga s = (Knjiga) ((ModelTabele) tblKnjiga.getModel()).getSelektovanaStavka(tblKnjiga.getSelectedRow());
        int i = JOptionPane.showConfirmDialog(this, "Da li zelite da obrisete " + s.getNaziv() + "?", "Potvrda brisanja", JOptionPane.YES_NO_OPTION);
        if (i == JOptionPane.YES_OPTION) {
            try {
                KnjigaKontroler.getInstance().obrisiKnjigu(s);
                JOptionPane.showMessageDialog(this, "Sistem je obrisao knjigu.",
                        "Info", JOptionPane.INFORMATION_MESSAGE);
                popuniTabelu();
            } catch (Exception ex) {
                Logger.getLogger(KnjigaForma.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Sistem ne moze da obrise knjigu.",
                        "Greska", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void dodajListenere() {
        txtPretraga.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                pretrazi();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                pretrazi();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });
    }

    private void pretrazi() {
        try {
            List<ApstraktniDomenskiObjekat> l = KnjigaKontroler.getInstance().pretraziKnjige(txtPretraga.getText());
            tblKnjiga.setModel(new ModelTabele(l));
        } catch (Exception ex) {
            Logger.getLogger(KnjigaForma.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void popuniTabelu() {
        try {
            knjige = KnjigaKontroler.getInstance().getKnjige();
        } catch (Exception ex) {
            Logger.getLogger(KnjigaForma.class.getName()).log(Level.SEVERE, null, ex);
        }
        tblKnjiga.setModel(new ModelTabele(knjige));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodaj;
    private javax.swing.JButton btnIzmeni;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JLabel lblPretraga;
    private javax.swing.JPanel panelDugmadi;
    private javax.swing.JPanel panelJug;
    private javax.swing.JPanel panelPretraga;
    private javax.swing.JScrollPane scrollKnjiga;
    private javax.swing.JTable tblKnjiga;
    private javax.swing.JTextField txtPretraga;
    // End of variables declaration//GEN-END:variables
}
