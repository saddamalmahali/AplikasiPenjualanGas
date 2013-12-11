/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.adam.dao.impl;

import com.adam.controller.PenjualanJpaController;
import com.adam.controller.exceptions.NonexistentEntityException;
import com.adam.dao.PenjualanDao;
import com.adam.model.Penjualan;
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
public class PenjualanDaoImpl implements PenjualanDao{
    PenjualanJpaController controller;
    EntityManagerFactory emf;
    
    public PenjualanDaoImpl() {
        emf = Persistence.createEntityManagerFactory("AplikasiGasPU");
        controller = new PenjualanJpaController(emf);
    }
    
    
    
    @Override
    public void tambah(Penjualan p) {
        controller.create(p);
    }

    @Override
    public void update(Penjualan p) {
        try {
            controller.edit(p);
        } catch (Exception ex) {
            Logger.getLogger(PenjualanDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(int idPenjualan) {
        try {
            controller.destroy(idPenjualan);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(PenjualanDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Penjualan> getAllPenjualan() {
        List<Penjualan> list = controller.findPenjualanEntities();
        return list;
    }

    @Override
    public void addData(DefaultTableModel model) {
        List<Penjualan> list = getAllPenjualan();
        String[] ColumnNames = {"ID Penjualan", "Tanggal Transaksi", "Qty", "Harga Satuan", "Jumlah"};
        for(int i=0; i<list.size(); i++){
            Penjualan p = new Penjualan();
            
            p.setIdTrskPjl(list.get(i).getIdTrskPjl());
            p.setTglTrskPjl(list.get(i).getTglTrskPjl());
            p.setQtyPjl(list.get(i).getQtyPjl());
            p.setHrgSatuan(list.get(i).getHrgSatuan());
            p.setSubTotal(list.get(i).getSubTotal());
            
            String hargaSatuan = "Rp. "+p.getHrgSatuan();
            String SubTotal = "Rp. "+p.getSubTotal();
            
            Object[] data = {p.getIdTrskPjl(), p.getTglTrskPjl().getDate(), p.getQtyPjl(), hargaSatuan, SubTotal };
            model.addRow(data);
            model.fireTableDataChanged();
                    
        }        
    }

    @Override
    public Penjualan getPenjualan(int id) {
        return controller.findPenjualan(id);
    }
    
}
