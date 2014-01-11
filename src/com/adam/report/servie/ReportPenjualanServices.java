/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.adam.report.servie;

import com.adam.model.Penjualan;
import com.adam.report.model.PenjualanRpt;
import java.text.SimpleDateFormat;

/**
 *
 * @author saddam
 */
public class ReportPenjualanServices {
    public PenjualanRpt buildModel(Penjualan pjl){
        PenjualanRpt pjlRpt = new PenjualanRpt();
        pjlRpt.setId(""+pjl.getIdTrskPjl());
        SimpleDateFormat format = new SimpleDateFormat("dd/M/yyyy");
        String tanggal = format.format(pjl.getTglTrskPjl());
        pjlRpt.setTanggal(tanggal);
        pjlRpt.setBanyak(""+pjl.getQtyPjl());
        pjlRpt.setSatuan("Rp. "+pjl.getHrgSatuan()+",-");
        pjlRpt.setJumlah("Rp. "+pjl.getSubTotal()+",-");
        
        return pjlRpt;
    }
}
