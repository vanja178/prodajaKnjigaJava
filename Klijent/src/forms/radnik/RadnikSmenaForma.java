package forms.radnik;

import controller.RadnikKontroler;
import controller.SmenaKontroler;
import controller.RadnikSmenaKontroler;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import model.ApstraktniDomenskiObjekat;
import model.Radnik;
import model.RadnikSmena;
import model.Smena;
import tablemodel.ModelTabele;

public class RadnikSmenaForma extends javax.swing.JFrame {

    List<ApstraktniDomenskiObjekat> radnikSmene = new ArrayList<>();

    private static final DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(RadnikSmenaForma.class.getName());

    public RadnikSmenaForma() {
        initComponents();
        setTitle("Raspored smena");
        txtDatum.setText(LocalDate.now().toString());
        setSize(650, 400);
        popuniForme();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollRadnikSmena = new javax.swing.JScrollPane();
        tblRadnikSmena = new javax.swing.JTable();
        panelJug = new javax.swing.JPanel();
        panelUnos = new javax.swing.JPanel();
        lblRadnik = new javax.swing.JLabel();
        cmbRadnik = new javax.swing.JComboBox();
        lblSmena = new javax.swing.JLabel();
        cmbSmena = new javax.swing.JComboBox();
        lblDatum = new javax.swing.JLabel();
        txtDatum = new javax.swing.JTextField();
        panelDugmadi = new javax.swing.JPanel();
        btnDodaj = new javax.swing.JButton();
        btnObrisi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        scrollRadnikSmena.setViewportView(tblRadnikSmena);

        lblRadnik.setText("Radnik:");

        lblSmena.setText("Smena:");

        lblDatum.setText("Datum (yyyy-MM-dd):");

        javax.swing.GroupLayout panelUnosLayout = new javax.swing.GroupLayout(panelUnos);
        panelUnos.setLayout(panelUnosLayout);
        panelUnosLayout.setHorizontalGroup(
            panelUnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelUnosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblRadnik)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbRadnik, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(lblSmena)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbSmena, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(lblDatum)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDatum, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelUnosLayout.setVerticalGroup(
            panelUnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelUnosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelUnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblRadnik)
                    .addComponent(cmbRadnik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSmena)
                    .addComponent(cmbSmena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDatum)
                    .addComponent(txtDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        btnDodaj.setText("Dodaj");
        btnDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajActionPerformed(evt);
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
                .addComponent(btnObrisi)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelDugmadiLayout.setVerticalGroup(
            panelDugmadiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDugmadiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDugmadiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDodaj)
                    .addComponent(btnObrisi))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelJugLayout = new javax.swing.GroupLayout(panelJug);
        panelJug.setLayout(panelJugLayout);
        panelJugLayout.setHorizontalGroup(
            panelJugLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelUnos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelDugmadi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelJugLayout.setVerticalGroup(
            panelJugLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelJugLayout.createSequentialGroup()
                .addComponent(panelUnos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(panelDugmadi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollRadnikSmena, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                    .addComponent(panelJug, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(scrollRadnikSmena, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                .addGap(10, 10, 10)
                .addComponent(panelJug, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnDodajActionPerformed(java.awt.event.ActionEvent evt) {
        Radnik z = (Radnik) cmbRadnik.getSelectedItem();
        Smena s = (Smena) cmbSmena.getSelectedItem();
        LocalDate datum;
        try {
            datum = LocalDate.parse(txtDatum.getText().trim(), FORMAT);
        } catch (DateTimeParseException ex) {
            JOptionPane.showMessageDialog(this, "Sistem ne moze da zapamti raspored smena.",
                    "Greska", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (z == null || z.getIdRadnik() == null || z.getIdRadnik() <= 0) {
            JOptionPane.showMessageDialog(this, "Sistem ne moze da zapamti raspored smena.",
                    "Greska", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (s == null || s.getIdSmena() == null || s.getIdSmena() <= 0) {
            JOptionPane.showMessageDialog(this, "Sistem ne moze da zapamti raspored smena.",
                    "Greska", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            RadnikSmena zt = new RadnikSmena(datum, z, s);
            RadnikSmenaKontroler.getInstance().dodajRadnikSmenu(zt);
            popuniForme();
            JOptionPane.showMessageDialog(this, "Sistem je zapamtio raspored smena.",
                    "Info", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            Logger.getLogger(RadnikSmenaForma.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Sistem ne moze da zapamti raspored smena.",
                    "Greska", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {
        if (tblRadnikSmena.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Sistem ne moze da nadje raspored smena.",
                    "Greska", JOptionPane.ERROR_MESSAGE);
            return;
        }
        RadnikSmena zt = (RadnikSmena) ((ModelTabele) tblRadnikSmena.getModel()).getSelektovanaStavka(tblRadnikSmena.getSelectedRow());
        int i = JOptionPane.showConfirmDialog(this, "Da li zelite da obrisete izabrani raspored smena?", "Potvrda brisanja", JOptionPane.YES_NO_OPTION);
        if (i == JOptionPane.YES_OPTION) {
            try {
                RadnikSmenaKontroler.getInstance().obrisiRadnikSmenu(zt);
                JOptionPane.showMessageDialog(this, "Sistem je obrisao raspored smena.",
                        "Info", JOptionPane.INFORMATION_MESSAGE);
                popuniForme();
            } catch (Exception ex) {
                Logger.getLogger(RadnikSmenaForma.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Sistem ne moze da obrise raspored smena.",
                        "Greska", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void popuniForme() {
        try {
            radnikSmene = RadnikSmenaKontroler.getInstance().getRadnikSmene();
            tblRadnikSmena.setModel(new ModelTabele(radnikSmene));

            List<ApstraktniDomenskiObjekat> radnik = RadnikKontroler.getInstance().getRadnike();
            cmbRadnik.setModel(new DefaultComboBoxModel(radnik.toArray()));
            cmbRadnik.setSelectedIndex(-1);

            List<ApstraktniDomenskiObjekat> smene = SmenaKontroler.getInstance().getSmene();
            cmbSmena.setModel(new DefaultComboBoxModel(smene.toArray()));
            cmbSmena.setSelectedIndex(-1);
        } catch (Exception ex) {
            Logger.getLogger(RadnikSmenaForma.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodaj;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JComboBox cmbRadnik;
    private javax.swing.JComboBox cmbSmena;
    private javax.swing.JLabel lblDatum;
    private javax.swing.JLabel lblRadnik;
    private javax.swing.JLabel lblSmena;
    private javax.swing.JPanel panelDugmadi;
    private javax.swing.JPanel panelJug;
    private javax.swing.JPanel panelUnos;
    private javax.swing.JScrollPane scrollRadnikSmena;
    private javax.swing.JTable tblRadnikSmena;
    private javax.swing.JTextField txtDatum;
    // End of variables declaration//GEN-END:variables
}
