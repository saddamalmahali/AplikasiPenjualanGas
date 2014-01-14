/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adam.report.servie;

import com.adam.dao.PenjualanDao;
import com.adam.dao.impl.PenjualanDaoImpl;
import com.adam.model.Pembelian;
import com.adam.model.Penjualan;
import com.adam.report.model.PenjualanRpt;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 *
 * @author saddam
 */
public class ReportPenjualanServices {

    public PenjualanRpt buildModel(Penjualan pjl) {
        PenjualanRpt pjlRpt = new PenjualanRpt();
        pjlRpt.setId("" + pjl.getIdTrskPjl());
        SimpleDateFormat format = new SimpleDateFormat("dd/M/yyyy");
        String tanggal = format.format(pjl.getTglTrskPjl());
        pjlRpt.setTanggal(tanggal);
        pjlRpt.setBanyak("" + pjl.getQtyPjl());
        pjlRpt.setSatuan("Rp. " + pjl.getHrgSatuan() + ",-");
        pjlRpt.setJumlah("Rp. " + pjl.getSubTotal() + ",-");
        List<Penjualan> list = getListPenjualan();
        int jumlah = 0;
        for(int i =0; i<list.size(); i++){
            Pembelian pbl = new Pembelian();
            jumlah = (int) (jumlah + list.get(i).getSubTotal());
        }
        
        String subtotal = "Rp. "+jumlah;
        
        pjlRpt.setSubtotal(subtotal);
        return pjlRpt;
    }

    public List<Penjualan> getListPenjualan() {
        PenjualanDao dao = new PenjualanDaoImpl();
        List<Penjualan> list = dao.getAllPenjualan();
        return list;
    }
}
