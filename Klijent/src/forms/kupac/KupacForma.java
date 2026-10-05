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
import tablemodel.ModelTabele;

public class KupacForma extends javax.swing.JFrame {

    List<ApstraktniDomenskiObjekat> kupci = new ArrayList<>();

    private boolean ucitavanje = false;

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(KupacForma.class.getName());

    public KupacForma() {
        initComponents();
        setTitle("Kupci");
        setSize(680, 400);
        popuniForme();
        dodajSelekcioniListener();
    }

    private void dodajSelekcioniListener() {
        tblKupac.getSelectionModel().addListSelectionListener(evt -> {
            if (evt.getValueIsAdjusting() || tblKupac.getSelectedRow() == -1) {
                return;
            }
            JOptionPane.showMessageDialog(this, "Sistem je nasao kupca.",
                    "Info", JOptionPane.INFORMATION_MESSAGE);
        });
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollKupac = new javax.swing.JScrollPane();
        tblKupac = new javax.swing.JTable();
        panelJug = new javax.swing.JPanel();
        panelPretraga = new javax.swing.JPanel();
        lblImePrezime = new javax.swing.JLabel();
        txtPretraga = new javax.swing.JTextField();
        btnPretraga = new javax.swing.JButton();
        lblKategorija = new javax.swing.JLabel();
        cmbKategorija = new javax.swing.JComboBox();
        btnPonisti = new javax.swing.JButton();
        panelDugmadi = new javax.swing.JPanel();
        btnDodaj = new javax.swing.JButton();
        btnIzmeni = new javax.swing.JButton();
        btnObrisi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        scrollKupac.setViewportView(tblKupac);

        lblImePrezime.setText("Ime/Prezime:");

        txtPretraga.setColumns(15);

        btnPretraga.setText("Pretraži");
        btnPretraga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPretragaActionPerformed(evt);
            }
        });

        lblKategorija.setText("Kategorija:");

        cmbKategorija.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbKategorijaItemStateChanged(evt);
            }
        });

        btnPonisti.setText("X");
        btnPonisti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPonistiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelPretragaLayout = new javax.swing.GroupLayout(panelPretraga);
        panelPretraga.setLayout(panelPretragaLayout);
        panelPretragaLayout.setHorizontalGroup(
            panelPretragaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPretragaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblImePrezime)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPretraga, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPretraga)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblKategorija)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbKategorija, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPonisti)
                .addContainerGap(20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelPretragaLayout.setVerticalGroup(
            panelPretragaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPretragaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPretragaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblImePrezime)
                    .addComponent(txtPretraga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPretraga)
                    .addComponent(lblKategorija)
                    .addComponent(cmbKategorija, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPonisti))
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
                .addContainerGap(0, Short.MAX_VALUE)
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
        );
        panelJugLayout.setVerticalGroup(
            panelJugLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPretraga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelDugmadi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scrollKupac, javax.swing.GroupLayout.DEFAULT_SIZE, 568, Short.MAX_VALUE)
                    .addComponent(panelJug, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(panelDugmadi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollKupac, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelJug, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnDodajActionPerformed(java.awt.event.ActionEvent evt) {
        KupacDIForma f = new KupacDIForma(this);
        f.setVisible(true);
        f.setLocationRelativeTo(null);
    }

    private void btnIzmeniActionPerformed(java.awt.event.ActionEvent evt) {
        if (tblKupac.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Sistem ne moze da nadje kupca.",
                    "Greska", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Kupac k = (Kupac) ((ModelTabele) tblKupac.getModel()).getSelektovanaStavka(tblKupac.getSelectedRow());
        KupacDIForma f = new KupacDIForma(this, k);
        f.setVisible(true);
        f.setLocationRelativeTo(null);
    }

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {
        if (tblKupac.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Sistem ne moze da nadje kupca.",
                    "Greska", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Kupac k = (Kupac) ((ModelTabele) tblKupac.getModel()).getSelektovanaStavka(tblKupac.getSelectedRow());
        int i = JOptionPane.showConfirmDialog(this, "Da li zelite da obrisete " + k.getIme() + " " + k.getPrezime() + "?", "Potvrda brisanja", JOptionPane.YES_NO_OPTION);
        if (i == JOptionPane.YES_OPTION) {
            try {
                KupacKontroler.getInstance().obrisiKupca(k);
                JOptionPane.showMessageDialog(this, "Sistem je obrisao kupca.",
                        "Info", JOptionPane.INFORMATION_MESSAGE);
                popuniForme();
            } catch (Exception ex) {
                Logger.getLogger(KupacForma.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Sistem ne moze da obrise kupca.",
                        "Greska", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void btnPonistiActionPerformed(java.awt.event.ActionEvent evt) {
        cmbKategorija.setSelectedIndex(-1);
    }

    private void cmbKategorijaItemStateChanged(java.awt.event.ItemEvent evt) {
        pretraziPoKategoriji();
        if (evt.getStateChange() != java.awt.event.ItemEvent.SELECTED) {
            return;
        }
        if (!ucitavanje && cmbKategorija.getSelectedIndex() != -1) {
            prikaziPorukuPretrage();
        }
    }

    private void btnPretragaActionPerformed(java.awt.event.ActionEvent evt) {
        pretraziPoKategoriji();
        prikaziPorukuPretrage();
    }

    private void prikaziPorukuPretrage() {
        if (tblKupac.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Sistem ne moze da nadje kupce po zadatim kriterijumima.",
                    "Greska", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Sistem je nasao kupce po zadatim kriterijumima.",
                    "Info", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void popuniForme() {
        ucitavanje = true;
        try {
            kupci = KupacKontroler.getInstance().getKupce();
            List<ApstraktniDomenskiObjekat> l = KategorijaKontroler.getInstance().getKategorije();
            cmbKategorija.setModel(new DefaultComboBoxModel(l.toArray()));
            cmbKategorija.setSelectedIndex(-1);
        } catch (Exception ex) {
            Logger.getLogger(KupacForma.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ucitavanje = false;
        }
        tblKupac.setModel(new ModelTabele(kupci));
    }

    private void pretraziPoKategoriji() {
        try {
            Kategorija k = (Kategorija) cmbKategorija.getSelectedItem();
            Kupac kup = new Kupac();
            kup.setKategorija(k);
            kup.setIme(txtPretraga.getText());
            List<ApstraktniDomenskiObjekat> l = KupacKontroler.getInstance().pretraziKupce(kup);
            tblKupac.setModel(new ModelTabele(l));
        } catch (Exception ex) {
            Logger.getLogger(KupacForma.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodaj;
    private javax.swing.JButton btnIzmeni;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnPonisti;
    private javax.swing.JButton btnPretraga;
    private javax.swing.JComboBox cmbKategorija;
    private javax.swing.JLabel lblImePrezime;
    private javax.swing.JLabel lblKategorija;
    private javax.swing.JPanel panelDugmadi;
    private javax.swing.JPanel panelJug;
    private javax.swing.JPanel panelPretraga;
    private javax.swing.JScrollPane scrollKupac;
    private javax.swing.JTable tblKupac;
    private javax.swing.JTextField txtPretraga;
    // End of variables declaration//GEN-END:variables
}
