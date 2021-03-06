/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.adam.view;

import com.adam.dao.PersediaanDao;
import com.adam.dao.SettingDao;
import com.adam.dao.impl.PersediaanDaoImpl;
import com.adam.dao.impl.SettingDaoImpl;
import com.adam.model.Persediaan;
import com.adam.model.Setting;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author saddam
 */
public class FormAplikasi extends javax.swing.JFrame {
    InternalPenjualan intPjl;
    /**
     * Creates new form FormAplikasi
     */
    private DialogSettingPembelian dialogStgPbl;
    InternalPembelian intPbl;
    SettingDao sDao;
    DialogSetting settingView;
    PersediaanDao pDao;
    Persediaan persediaan;
    com.adam.model.Setting setting;
    Setting settingPbl;
    public FormAplikasi() {
        initComponents();
        
        
        sDao = new SettingDaoImpl();
        pDao = new PersediaanDaoImpl();
        persediaan = new Persediaan(1);
        setting = new com.adam.model.Setting(1);
        settingPbl = new Setting(2);
        refresh();
        txtHrgDefault.setText("Rp. "+setting.getHrgStg());
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        layerAplikasi = new javax.swing.JDesktopPane();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        jLabel1 = new javax.swing.JLabel();
        txtPrsdGas = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtHrgDefault = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        mniStgPbl = new javax.swing.JMenu();
        mniExit = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        mniPbl = new javax.swing.JMenuItem();
        mniSetting = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        mniTentang = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Aplikasi Penjualan Dan Pembelian Gas");

        jLabel3.setFont(new java.awt.Font("FreeSerif", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Kopontren Annajaat Sumursari");

        jLabel4.setFont(new java.awt.Font("FreeSerif", 1, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Alamat : Kp. Sumursari, Ds. Sukasono, Kec. Sukawening-Garut");

        jLabel5.setFont(new java.awt.Font("FreeSerif", 1, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Email : yps.annajaat@gmail.com");

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/adam/img/Logo Annajaat_1.png"))); // NOI18N

        javax.swing.GroupLayout layerAplikasiLayout = new javax.swing.GroupLayout(layerAplikasi);
        layerAplikasi.setLayout(layerAplikasiLayout);
        layerAplikasiLayout.setHorizontalGroup(
            layerAplikasiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layerAplikasiLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layerAplikasiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layerAplikasiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator1))
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layerAplikasiLayout.setVerticalGroup(
            layerAplikasiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layerAplikasiLayout.createSequentialGroup()
                .addContainerGap(444, Short.MAX_VALUE)
                .addGroup(layerAplikasiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layerAplikasiLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5))
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layerAplikasi.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        layerAplikasi.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        layerAplikasi.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        layerAplikasi.setLayer(jSeparator1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        layerAplikasi.setLayer(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        jLabel1.setText("Persediaan Gas : ");
        jToolBar1.add(jLabel1);

        txtPrsdGas.setEditable(false);
        jToolBar1.add(txtPrsdGas);

        jLabel2.setText("  Harga Satuan Gas : ");
        jToolBar1.add(jLabel2);

        txtHrgDefault.setEditable(false);
        jToolBar1.add(txtHrgDefault);

        mniStgPbl.setText("Menu");

        mniExit.setText("Setting Penjualan");
        mniExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniExitActionPerformed(evt);
            }
        });
        mniStgPbl.add(mniExit);

        jMenuItem1.setText("Setting Pembelian");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        mniStgPbl.add(jMenuItem1);

        jMenuItem4.setText("Exit");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        mniStgPbl.add(jMenuItem4);

        jMenuBar1.add(mniStgPbl);

        jMenu1.setText("Transaksi");

        mniPbl.setText("Penjualan");
        mniPbl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniPblActionPerformed(evt);
            }
        });
        jMenu1.add(mniPbl);

        mniSetting.setText("Pembelian");
        mniSetting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniSettingActionPerformed(evt);
            }
        });
        jMenu1.add(mniSetting);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Help");

        mniTentang.setText("Tentang Aplikasi");
        mniTentang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniTentangActionPerformed(evt);
            }
        });
        jMenu2.add(mniTentang);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 694, Short.MAX_VALUE))
            .addComponent(layerAplikasi)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(layerAplikasi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mniPblActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniPblActionPerformed
        
        if(intPjl == null){
            intPjl = new InternalPenjualan(setting);
        }
        if(intPjl.isVisible()){
            JOptionPane.showMessageDialog(this, "Internal Penjualan telah aktif..", "Warning", JOptionPane.ERROR_MESSAGE);
        }else{
            
            layerAplikasi.add(intPjl);
            intPjl.setSetting(setting);
             intPjl.setFormUtama(this);
        intPjl.setVisible(true);
        try {
            intPjl.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(FormAplikasi.class.getName()).log(Level.SEVERE, null, ex);
        }
        }       
        
    }//GEN-LAST:event_mniPblActionPerformed

    private void mniExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniExitActionPerformed
        settingView = new DialogSetting(this, true);
        settingView.setDao(sDao);
        settingView.setTxtHrg(String.valueOf(sDao.getSetting(setting).getHrgStg()));
        settingView.setLocationRelativeTo(null);
        settingView.setVisible(true);
        settingView.setAlwaysOnTop(true);
        refresh();
        System.out.println("Setting harga : "+setting.getHrgStg());
    }//GEN-LAST:event_mniExitActionPerformed

    private void mniSettingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniSettingActionPerformed
        if(intPbl==null)
            intPbl = new InternalPembelian(setting);
        if(intPbl.isVisible()){
            JOptionPane.showMessageDialog(rootPane, "Jendela Pembelian Telah Aktif", "Warning", JOptionPane.ERROR_MESSAGE);
        }else{
            layerAplikasi.add(intPbl);
            intPbl.setSetting(setting);
            intPbl.setFormUtama(this);
            
            intPbl.setVisible(true);
            try {
                intPbl.setMaximum(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(FormAplikasi.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_mniSettingActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        dialogStgPbl = new DialogSettingPembelian(this, true);
        dialogStgPbl.setDao(sDao);
        dialogStgPbl.setTxtHrg(String.valueOf(sDao.getSetting(settingPbl).getHrgStg()));
        dialogStgPbl.setLocationRelativeTo(null);
        dialogStgPbl.setVisible(true);
        dialogStgPbl.setAlwaysOnTop(true);
        refresh();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void mniTentangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniTentangActionPerformed
        DialogAbout about = new DialogAbout(this, rootPaneCheckingEnabled);
        about.setLocationRelativeTo(null);
        about.setAlwaysOnTop(true);
            about.setVisible(true);
        
    }//GEN-LAST:event_mniTentangActionPerformed
    
    public void refresh(){
        setting = sDao.getSetting(new com.adam.model.Setting(1));
        persediaan = pDao.getPersediaan(new Persediaan(1));
        txtHrgDefault.setText("Rp. "+setting.getHrgStg());
        txtPrsdGas.setText(""+persediaan.getJmlPrsd()+" tabung");
    }
    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JDesktopPane layerAplikasi;
    private javax.swing.JMenuItem mniExit;
    private javax.swing.JMenuItem mniPbl;
    private javax.swing.JMenuItem mniSetting;
    private javax.swing.JMenu mniStgPbl;
    private javax.swing.JMenuItem mniTentang;
    private javax.swing.JTextField txtHrgDefault;
    private javax.swing.JTextField txtPrsdGas;
    // End of variables declaration//GEN-END:variables
}
