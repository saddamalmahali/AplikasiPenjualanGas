/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.adam.dao;

import com.adam.model.Pembelian;
import com.adam.model.Penjualan;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author saddam
 */
public interface PembelianDao {
    public void tambah(Pembelian pbl);
    public void hapus(int idPbl);
    public List<Pembelian> getAllPembelian();
    public void addData(DefaultTableModel model);
    public Pembelian getPembelian(int idPbl);
}
