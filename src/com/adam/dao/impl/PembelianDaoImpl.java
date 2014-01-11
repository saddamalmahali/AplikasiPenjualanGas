/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.adam.dao.impl;

import com.adam.controller.PembelianJpaController;
import com.adam.controller.exceptions.NonexistentEntityException;
import com.adam.dao.PembelianDao;
import com.adam.model.Pembelian;
import com.adam.model.Penjualan;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author saddam
 */
public class PembelianDaoImpl implements PembelianDao{
    PembelianJpaController controller;
    final EntityManagerFactory emf = Persistence.createEntityManagerFactory("AplikasiGasPU");
    public PembelianDaoImpl() {
        
        controller = new PembelianJpaController(emf);
    }
    
    
    
    
    @Override
    public void tambah(Pembelian pbl) {
        controller.create(pbl);
    }

    @Override
    public void hapus(int idPbl) {
        try {
            controller.destroy(idPbl);
        } catch (aplikasigas.exceptions.NonexistentEntityException ex) {
            Logger.getLogger(PembelianDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            System.out.println("Data Pembelian dengan id "+idPbl+" berhasil dihapus..");
        }
    }

    @Override
    public List<Pembelian> getAllPembelian() {
        List<Pembelian> list = controller.findPembelianEntities();
        return list;
    }

    @Override
    public void addData(DefaultTableModel model) {
        List<Pembelian> list = controller.findPembelianEntities();
        
        String[] columnNames = {"ID Pembelian", "Tanggal Transaksi", "Kuantitas", "Harga Satuan", "Jumlah"};
        
        for(int i=0; i<list.size(); i++){
            Pembelian pbl = new Pembelian();
            
            pbl.setIdPbl(list.get(i).getIdPbl());
            pbl.setQtyTrskPbl(list.get(i).getQtyTrskPbl());
            pbl.setSatuanTrskPbl(list.get(i).getSatuanTrskPbl());
            SimpleDateFormat frm = new SimpleDateFormat("dd/M/yyyy");
            String tanggal = frm.format(list.get(i).getTglTrskPbl());
            String hargaSatuan = "Rp. "+list.get(i).getSatuanTrskPbl()+",-";
            String subTotal = "Rp. "+list.get(i).getSubtotalTrskPbl()+",-";
            pbl.setSubtotalTrskPbl(list.get(i).getSubtotalTrskPbl());
            
            Object[] data = {pbl.getIdPbl(), tanggal, pbl.getQtyTrskPbl(), hargaSatuan, subTotal};
            
            model.addRow(data);
            model.fireTableDataChanged();
            
        }
    }

    @Override
    public Pembelian getPembelian(int idPbl) {
        return controller.findPembelian(idPbl);
    }
    
}
