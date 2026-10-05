package form;

import javax.swing.JOptionPane;
import server.Server;

public class GlavnaForma extends javax.swing.JFrame {

    private Server server;

    public GlavnaForma() {
        initComponents();
        setTitle("Server - Racuni za knjige");
        initMeni();
        setSize(420, 200);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblStatus = new javax.swing.JLabel();
        panelDugmadi = new javax.swing.JPanel();
        btnPokreni = new javax.swing.JButton();
        btnZaustavi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblStatus.setText("Server je zaustavljen");
        lblStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        btnPokreni.setText("Pokreni server");
        btnPokreni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPokreniActionPerformed(evt);
            }
        });

        btnZaustavi.setText("Zaustavi server");
        btnZaustavi.setEnabled(false);
        btnZaustavi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnZaustaviActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelDugmadiLayout = new javax.swing.GroupLayout(panelDugmadi);
        panelDugmadi.setLayout(panelDugmadiLayout);
        panelDugmadiLayout.setHorizontalGroup(
            panelDugmadiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDugmadiLayout.createSequentialGroup()
                .addContainerGap(0, Short.MAX_VALUE)
                .addComponent(btnPokreni)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnZaustavi)
                .addContainerGap(0, Short.MAX_VALUE))
        );
        panelDugmadiLayout.setVerticalGroup(
            panelDugmadiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDugmadiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnPokreni)
                .addComponent(btnZaustavi))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelDugmadi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lblStatus, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelDugmadi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
    }
    // </editor-fold>//GEN-END:initComponents

    private void initMeni() {
        javax.swing.JMenuBar meniBar = new javax.swing.JMenuBar();
        javax.swing.JMenu meniPodesavanja = new javax.swing.JMenu("Podesavanja");
        javax.swing.JMenuItem stavkaBaza = new javax.swing.JMenuItem("Konfiguracija baze");
        stavkaBaza.addActionListener(e -> {
            KonfiguracijaBazePodataka forma = new KonfiguracijaBazePodataka();
            forma.setVisible(true);
            forma.setLocationRelativeTo(this);
        });
        javax.swing.JMenuItem stavkaPort = new javax.swing.JMenuItem("Konfiguracija porta");
        stavkaPort.addActionListener(e -> {
            KonfiguracijaPorta forma = new KonfiguracijaPorta();
            forma.setVisible(true);
            forma.setLocationRelativeTo(this);
        });
        meniPodesavanja.add(stavkaBaza);
        meniPodesavanja.add(stavkaPort);
        meniBar.add(meniPodesavanja);
        setJMenuBar(meniBar);
    }

    private void btnPokreniActionPerformed(java.awt.event.ActionEvent evt) {
        server = new Server();
        server.start();
        lblStatus.setText("Server je pokrenut");
        btnPokreni.setEnabled(false);
        btnZaustavi.setEnabled(true);
        JOptionPane.showMessageDialog(this, "Server je pokrenut!", "Info", JOptionPane.INFORMATION_MESSAGE);
    }

    private void btnZaustaviActionPerformed(java.awt.event.ActionEvent evt) {
        if (server != null) {
            server.zaustaviServer();
        }
        lblStatus.setText("Server je zaustavljen");
        btnPokreni.setEnabled(true);
        btnZaustavi.setEnabled(false);
        JOptionPane.showMessageDialog(this, "Server je zaustavljen!", "Info", JOptionPane.INFORMATION_MESSAGE);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPokreni;
    private javax.swing.JButton btnZaustavi;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JPanel panelDugmadi;
    // End of variables declaration//GEN-END:variables
}
