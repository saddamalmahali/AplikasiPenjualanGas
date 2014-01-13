/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.adam.report.servie;

import com.adam.dao.PembelianDao;
import com.adam.dao.impl.PembelianDaoImpl;
import com.adam.model.Pembelian;
import com.adam.report.model.PembelianRpt;
import java.util.List;

/**
 *
 * @author saddam
 */
public class ReportPembelianServices {
    public PembelianRpt buildModel(Pembelian pbl){
        PembelianRpt rpt = new PembelianRpt();
        rpt.setId(""+pbl.getIdPbl());
        rpt.setTanggal(pbl.getTglTrskPbl());
        rpt.setBanyak(pbl.getQtyTrskPbl());
        rpt.setSatuan("Rp. "+pbl.getSatuanTrskPbl()+",-");
        List<Pembelian> listPbl = getList();
        float jumlah = 0;
        for(int i=0; i<listPbl.size(); i++){
            float sub = listPbl.get(i).getSubtotalTrskPbl();
            jumlah = jumlah+sub;
            
        }
        rpt.setTotal("Rp. "+jumlah+",-");
        rpt.setSubtotal("Rp. "+pbl.getSubtotalTrskPbl()+",-");
        return rpt;
    }
    
    public List<Pembelian> getList(){
        PembelianDao dao = new PembelianDaoImpl();
        
        return dao.getAllPembelian();
    }
}
