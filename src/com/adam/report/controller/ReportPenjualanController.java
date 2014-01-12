/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.adam.report.controller;

import com.adam.dao.PembelianDao;
import com.adam.dao.impl.PembelianDaoImpl;
import com.adam.model.Pembelian;
import com.adam.model.Penjualan;
import com.adam.report.model.PembelianRpt;
import com.adam.report.servie.ReportPembelianServices;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 *
 * @author saddam
 */
public class ReportPenjualanController {
    private List<Pembelian> listPbl;
    private PembelianDao pDao;
    private List<PembelianRpt> listPblRpt;
    private ReportPembelianServices rptPblSrv;

    public ReportPenjualanController() {
        pDao = new PembelianDaoImpl();
        
        listPbl = pDao.getAllPembelian();
        
        rptPblSrv = new ReportPembelianServices();
        listPblRpt = new ArrayList<>();
    }
    
    public JasperPrint view() throws JRException{
        ambilData();
        InputStream inputStream = JRLoader.getResourceInputStream("com/adam/report/Pembelian.jasper");
        JRDataSource dataSource = new JRBeanCollectionDataSource(listPblRpt);
        Map<String, Object> map = new HashMap<>();
        map.put(JRParameter.REPORT_DATA_SOURCE, dataSource);
        
        return JasperFillManager.fillReport(inputStream, map);
    }
    
    
    public void ambilData(){
        listPbl = pDao.getAllPembelian();
        
        for(int i =0; i<listPbl.size(); i++){
            Pembelian pbl = new Pembelian();
            
            pbl.setIdPbl(listPbl.get(i).getIdPbl());
            pbl.setQtyTrskPbl(listPbl.get(i).getQtyTrskPbl());
            pbl.setSatuanTrskPbl(listPbl.get(i).getSatuanTrskPbl());
            pbl.setSubtotalTrskPbl(listPbl.get(i).getSubtotalTrskPbl());
            pbl.setTglTrskPbl(listPbl.get(i).getTglTrskPbl());
            
            PembelianRpt rpt = rptPblSrv.buildModel(pbl);
            
            listPblRpt.add(rpt);
            
        }
    }
}
