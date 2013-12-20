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
    InternalPembelian intPbl;
    SettingDao sDao;
    DialogSetting settingView;
    PersediaanDao pDao;
    Persediaan persediaan;
    com.adam.model.Setting setting;
    public FormAplikasi() {
        initComponents();
        
        
        sDao = new SettingDaoImpl();
        pDao = new PersediaanDaoImpl();
        persediaan = new Persediaan(1);
        setting = new com.adam.model.Setting(1);
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
        jToolBar1 = new javax.swing.JToolBar();
        jLabel1 = new javax.swing.JLabel();
        txtPrsdGas = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtHrgDefault = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        mniPjl = new javax.swing.JMenu();
        mniPbl = new javax.swing.JMenuItem();
        mniSetting = new javax.swing.JMenuItem();
        mniExit = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        mniTentang = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Aplikasi Penjualan Dan Pembelian Gas");

        javax.swing.GroupLayout layerAplikasiLayout = new javax.swing.GroupLayout(layerAplikasi);
        layerAplikasi.setLayout(layerAplikasiLayout);
        layerAplikasiLayout.setHorizontalGroup(
            layerAplikasiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        layerAplikasiLayout.setVerticalGroup(
            layerAplikasiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 340, Short.MAX_VALUE)
        );

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

        mniPjl.setText("Menu");

        mniPbl.setText("Penjualan");
        mniPbl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniPblActionPerformed(evt);
            }
        });
        mniPjl.add(mniPbl);

        mniSetting.setText("Pembelian");
        mniSetting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniSettingActionPerformed(evt);
            }
        });
        mniPjl.add(mniSetting);

        mniExit.setText("Setting");
        mniExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniExitActionPerformed(evt);
            }
        });
        mniPjl.add(mniExit);

        jMenuItem4.setText("Exit");
        mniPjl.add(jMenuItem4);

        jMenuBar1.add(mniPjl);

        jMenu2.setText("Help");

        mniTentang.setText("Tentang Aplikasi");
        jMenu2.add(mniTentang);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(layerAplikasi)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE))
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
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JDesktopPane layerAplikasi;
    private javax.swing.JMenuItem mniExit;
    private javax.swing.JMenuItem mniPbl;
    private javax.swing.JMenu mniPjl;
    private javax.swing.JMenuItem mniSetting;
    private javax.swing.JMenuItem mniTentang;
    private javax.swing.JTextField txtHrgDefault;
    private javax.swing.JTextField txtPrsdGas;
    // End of variables declaration//GEN-END:variables
}
