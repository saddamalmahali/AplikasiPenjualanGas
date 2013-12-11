/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.adam.dao;

import com.adam.model.Penjualan;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author saddam
 */
public interface PenjualanDao {
    public void tambah(Penjualan p);
    public void update(Penjualan p);
    public void delete(int idPenjualan);
    public List<Penjualan> getAllPenjualan();
    public void addData(DefaultTableModel model);
    public Penjualan getPenjualan(int id);
}
