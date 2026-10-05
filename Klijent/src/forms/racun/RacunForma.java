package forms.racun;

import controller.KnjigaKontroler;
import controller.KupacKontroler;
import controller.RadnikKontroler;
import controller.RacunKontroler;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import model.Knjiga;
import model.Kupac;
import model.ApstraktniDomenskiObjekat;
import model.Radnik;
import model.Racun;
import model.StavkaRacuna;
import tablemodel.ModelTabele;

public class RacunForma extends javax.swing.JFrame {

    List<ApstraktniDomenskiObjekat> kupci = new ArrayList<>();
    List<ApstraktniDomenskiObjekat> radnikLista = new ArrayList<>();
    List<ApstraktniDomenskiObjekat> knjige = new ArrayList<>();
    List<ApstraktniDomenskiObjekat> racuni = new ArrayList<>();
    Radnik prijavljeniRadnik;

    private boolean ucitavanje = false;

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(RacunForma.class.getName());

    public RacunForma() {
        initComponents();
        setTitle("Pretraga racuna");
        setSize(750, 500);
        popuniPodatke();
        dodajItemListenere();
        dodajSelekcioniListener();
    }

    public RacunForma(Radnik z) {
        this();
        this.prijavljeniRadnik = z;
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollRacun = new javax.swing.JScrollPane();
        tblRacun = new javax.swing.JTable();
        panelJug = new javax.swing.JPanel();
        panelFilter = new javax.swing.JPanel();
        lblKupac = new javax.swing.JLabel();
        txtKupac = new javax.swing.JTextField();
        cmbKupac = new javax.swing.JComboBox();
        btnResetKupac = new javax.swing.JButton();
        lblRadnik = new javax.swing.JLabel();
        txtRadnik = new javax.swing.JTextField();
        cmbRadnik = new javax.swing.JComboBox();
        btnResetRadnik = new javax.swing.JButton();
        lblKnjiga = new javax.swing.JLabel();
        txtKnjiga = new javax.swing.JTextField();
        cmbKnjiga = new javax.swing.JComboBox();
        btnResetKnjiga = new javax.swing.JButton();
        lblIdRacun = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        cmbId = new javax.swing.JComboBox();
        btnResetId = new javax.swing.JButton();
        panelDugmadi = new javax.swing.JPanel();
        btnPretraziRacune = new javax.swing.JButton();
        btnIzmeni = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        scrollRacun.setViewportView(tblRacun);

        lblKupac.setText("Kupac:");

        txtKupac.setColumns(10);

        lblRadnik.setText("Radnik:");

        txtRadnik.setColumns(10);

        lblKnjiga.setText("Knjiga:");

        txtKnjiga.setColumns(10);

        lblIdRacun.setText("idRacun:");

        txtId.setColumns(6);

        btnResetKupac.setText("X");
        btnResetKupac.setMargin(new java.awt.Insets(2, 4, 2, 4));
        btnResetKupac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetKupacActionPerformed(evt);
            }
        });

        btnResetRadnik.setText("X");
        btnResetRadnik.setMargin(new java.awt.Insets(2, 4, 2, 4));
        btnResetRadnik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetRadnikActionPerformed(evt);
            }
        });

        btnResetKnjiga.setText("X");
        btnResetKnjiga.setMargin(new java.awt.Insets(2, 4, 2, 4));
        btnResetKnjiga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetKnjigaActionPerformed(evt);
            }
        });

        btnResetId.setText("X");
        btnResetId.setMargin(new java.awt.Insets(2, 4, 2, 4));
        btnResetId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetIdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelFilterLayout = new javax.swing.GroupLayout(panelFilter);
        panelFilter.setLayout(panelFilterLayout);
        panelFilterLayout.setHorizontalGroup(
            panelFilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFilterLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelFilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblKupac)
                    .addComponent(lblRadnik)
                    .addComponent(lblKnjiga)
                    .addComponent(lblIdRacun))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelFilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtKupac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRadnik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtKnjiga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelFilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbKupac, javax.swing.GroupLayout.PREFERRED_SIZE, 160, Short.MAX_VALUE)
                    .addComponent(cmbRadnik, javax.swing.GroupLayout.PREFERRED_SIZE, 160, Short.MAX_VALUE)
                    .addComponent(cmbKnjiga, javax.swing.GroupLayout.PREFERRED_SIZE, 160, Short.MAX_VALUE)
                    .addComponent(cmbId, javax.swing.GroupLayout.PREFERRED_SIZE, 160, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelFilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnResetKupac, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnResetRadnik, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnResetKnjiga, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnResetId, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        panelFilterLayout.setVerticalGroup(
            panelFilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFilterLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelFilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblKupac)
                    .addComponent(txtKupac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbKupac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnResetKupac))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelFilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblRadnik)
                    .addComponent(txtRadnik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbRadnik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnResetRadnik))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelFilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblKnjiga)
                    .addComponent(txtKnjiga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbKnjiga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnResetKnjiga))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelFilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIdRacun)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnResetId))
                .addContainerGap())
        );

        btnPretraziRacune.setText("Pretraži");
        btnPretraziRacune.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPretraziRacuneActionPerformed(evt);
            }
        });

        btnIzmeni.setText("Izmeni");
        btnIzmeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzmeniActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelDugmadiLayout = new javax.swing.GroupLayout(panelDugmadi);
        panelDugmadi.setLayout(panelDugmadiLayout);
        panelDugmadiLayout.setHorizontalGroup(
            panelDugmadiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDugmadiLayout.createSequentialGroup()
                .addContainerGap(0, Short.MAX_VALUE)
                .addComponent(btnPretraziRacune)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnIzmeni)
                .addContainerGap())
        );
        panelDugmadiLayout.setVerticalGroup(
            panelDugmadiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDugmadiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDugmadiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPretraziRacune)
                    .addComponent(btnIzmeni))
                .addContainerGap())
        );

        javax.swing.GroupLayout panelJugLayout = new javax.swing.GroupLayout(panelJug);
        panelJug.setLayout(panelJugLayout);
        panelJugLayout.setHorizontalGroup(
            panelJugLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFilter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelDugmadi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelJugLayout.setVerticalGroup(
            panelJugLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelJugLayout.createSequentialGroup()
                .addComponent(panelFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelDugmadi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollRacun, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
                    .addComponent(panelJug, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(panelJug, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollRacun, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void dodajItemListenere() {
        cmbKupac.addItemListener(this::pretraziIPrikaziPoruku);
        cmbRadnik.addItemListener(this::pretraziIPrikaziPoruku);
        cmbKnjiga.addItemListener(this::pretraziIPrikaziPoruku);
        cmbId.addItemListener(this::pretraziIPrikaziPoruku);
    }

    private void dodajSelekcioniListener() {
        tblRacun.getSelectionModel().addListSelectionListener(evt -> {
            if (evt.getValueIsAdjusting() || tblRacun.getSelectedRow() == -1) {
                return;
            }
            JOptionPane.showMessageDialog(this, "Sistem je nasao racun.",
                    "Info", JOptionPane.INFORMATION_MESSAGE);
        });
    }

    private void pretraziIPrikaziPoruku(java.awt.event.ItemEvent evt) {
        azurirajTabelu();
        if (ucitavanje || evt.getStateChange() != java.awt.event.ItemEvent.SELECTED) {
            return;
        }
        prikaziPorukuPretrageRacuna();
    }

    private void btnPretraziRacuneActionPerformed(java.awt.event.ActionEvent evt) {
        azurirajTabelu();
        prikaziPorukuPretrageRacuna();
    }

    private void prikaziPorukuPretrageRacuna() {
        if (tblRacun.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Sistem ne moze da nadje racune po zadatim kriterijumima.",
                    "Greska", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Sistem je nasao racune po zadatim kriterijumima.",
                    "Info", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void btnResetKupacActionPerformed(java.awt.event.ActionEvent evt) {
        ucitavanje = true;
        cmbKupac.setSelectedIndex(-1);
        ucitavanje = false;
        azurirajTabelu();
    }

    private void btnResetRadnikActionPerformed(java.awt.event.ActionEvent evt) {
        ucitavanje = true;
        cmbRadnik.setSelectedIndex(-1);
        ucitavanje = false;
        azurirajTabelu();
    }

    private void btnResetKnjigaActionPerformed(java.awt.event.ActionEvent evt) {
        ucitavanje = true;
        cmbKnjiga.setSelectedIndex(-1);
        ucitavanje = false;
        azurirajTabelu();
    }

    private void btnResetIdActionPerformed(java.awt.event.ActionEvent evt) {
        ucitavanje = true;
        cmbId.setSelectedIndex(-1);
        ucitavanje = false;
        azurirajTabelu();
    }

    private void btnIzmeniActionPerformed(java.awt.event.ActionEvent evt) {
        if (tblRacun.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Sistem ne moze da nadje racun.",
                    "Greska", JOptionPane.ERROR_MESSAGE);
            return;
        }
        ModelTabele tm = (ModelTabele) tblRacun.getModel();
        int i = tblRacun.getSelectedRow();
        Racun ra = (Racun) tm.getLista().get(i);

        RacunDodajForma f = new RacunDodajForma(this, ra, prijavljeniRadnik != null ? prijavljeniRadnik : ra.getRadnik());
        f.setVisible(true);
        f.setLocationRelativeTo(null);
        this.dispose();
    }

    private void azurirajTabelu() {
        Radnik z = odrediRadnika();
        Kupac k = odrediKupca();
        Knjiga knj = odrediKnjigu();
        Long idRacuna = odrediIdRacuna();

        StavkaRacuna si = new StavkaRacuna(knj);
        List<StavkaRacuna> lista = new ArrayList<>();
        lista.add(si);

        Racun racun = new Racun(z, k, lista);
        if (idRacuna != null) {
            racun.setIdRacun(idRacuna);
        }

        try {
            List<ApstraktniDomenskiObjekat> l = RacunKontroler.getInstance().pretraziRacune(racun);
            tblRacun.setModel(new ModelTabele(l));
        } catch (Exception ex) {
            Logger.getLogger(RacunForma.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Radnik odrediRadnika() {
        if (cmbRadnik.getSelectedIndex() != -1) {
            return (Radnik) cmbRadnik.getSelectedItem();
        }
        if (!txtRadnik.getText().trim().isEmpty()) {
            Radnik z = new Radnik();
            z.setIme(txtRadnik.getText().trim());
            return z;
        }
        return null;
    }

    private Kupac odrediKupca() {
        if (cmbKupac.getSelectedIndex() != -1) {
            return (Kupac) cmbKupac.getSelectedItem();
        }
        if (!txtKupac.getText().trim().isEmpty()) {
            Kupac k = new Kupac();
            k.setIme(txtKupac.getText().trim());
            return k;
        }
        return null;
    }

    private Knjiga odrediKnjigu() {
        if (cmbKnjiga.getSelectedIndex() != -1) {
            return (Knjiga) cmbKnjiga.getSelectedItem();
        }
        if (!txtKnjiga.getText().trim().isEmpty()) {
            Knjiga knj = new Knjiga();
            knj.setNaziv(txtKnjiga.getText().trim());
            return knj;
        }
        return null;
    }

    private Long odrediIdRacuna() {
        if (cmbId.getSelectedIndex() != -1) {
            return ((Racun) cmbId.getSelectedItem()).getIdRacun();
        }
        if (!txtId.getText().trim().isEmpty()) {
            try {
                return Long.parseLong(txtId.getText().trim());
            } catch (NumberFormatException ex) {
                return null;
            }
        }
        return null;
    }

    private void popuniPodatke() {
        ucitavanje = true;
        try {
            racuni = RacunKontroler.getInstance().getRacune();
            cmbId.setModel(new DefaultComboBoxModel(racuni.toArray()));
        } catch (Exception ex) {
            Logger.getLogger(RacunForma.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            kupci = KupacKontroler.getInstance().getKupce();
            cmbKupac.setModel(new DefaultComboBoxModel(kupci.toArray()));
        } catch (Exception ex) {
            Logger.getLogger(RacunForma.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            radnikLista = RadnikKontroler.getInstance().getRadnike();
            cmbRadnik.setModel(new DefaultComboBoxModel(radnikLista.toArray()));
        } catch (Exception ex) {
            Logger.getLogger(RacunForma.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            knjige = KnjigaKontroler.getInstance().getKnjige();
            cmbKnjiga.setModel(new DefaultComboBoxModel(knjige.toArray()));
        } catch (Exception ex) {
            Logger.getLogger(RacunForma.class.getName()).log(Level.SEVERE, null, ex);
        }
        tblRacun.setModel(new ModelTabele(racuni));
        cmbKupac.setSelectedIndex(-1);
        cmbRadnik.setSelectedIndex(-1);
        cmbKnjiga.setSelectedIndex(-1);
        cmbId.setSelectedIndex(-1);
        ucitavanje = false;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIzmeni;
    private javax.swing.JButton btnPretraziRacune;
    private javax.swing.JButton btnResetKnjiga;
    private javax.swing.JButton btnResetId;
    private javax.swing.JButton btnResetKupac;
    private javax.swing.JButton btnResetRadnik;
    private javax.swing.JComboBox cmbKnjiga;
    private javax.swing.JComboBox cmbId;
    private javax.swing.JComboBox cmbKupac;
    private javax.swing.JComboBox cmbRadnik;
    private javax.swing.JLabel lblKnjiga;
    private javax.swing.JLabel lblIdRacun;
    private javax.swing.JLabel lblKupac;
    private javax.swing.JLabel lblRadnik;
    private javax.swing.JPanel panelDugmadi;
    private javax.swing.JPanel panelFilter;
    private javax.swing.JPanel panelJug;
    private javax.swing.JScrollPane scrollRacun;
    private javax.swing.JTable tblRacun;
    private javax.swing.JTextField txtKnjiga;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtKupac;
    private javax.swing.JTextField txtRadnik;
    // End of variables declaration//GEN-END:variables
}
