/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.adam.report.test;

import com.adam.dao.PenjualanDao;
import com.adam.dao.impl.PenjualanDaoImpl;
import com.adam.model.Penjualan;
import com.adam.report.model.PenjualanRpt;
import com.adam.report.servie.ReportPenjualanServices;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author saddam
 */
public class Report {
    private List<Penjualan> listPjl;
    private PenjualanDao dao;
    private List<PenjualanRpt> listPjlRpt;
    private ReportPenjualanServices services;
    private PenjualanRpt pjlRpt;
    
    public Report() {
         dao = new PenjualanDaoImpl();
        pjlRpt = new PenjualanRpt();
        
        listPjl = new ArrayList<>();
        listPjlRpt = new ArrayList<>();
        services = new ReportPenjualanServices();        
    }
    
    public JasperPrint view() throws JRException{
        ambilData();
        InputStream inputStream = JRLoader.getResourceInputStream("com/adam/report/Penjualan.jasper");
        JRDataSource dataSource = new JRBeanCollectionDataSource(listPjlRpt);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(JRParameter.REPORT_DATA_SOURCE, dataSource);
        
        JasperPrint print = null;
        
        return print = JasperFillManager.fillReport(inputStream, map);
        
        
    }
    
    public void ambilData(){
        listPjl = dao.getAllPenjualan();
        for(int i = 0; i<listPjl.size(); i++){
            Penjualan pjl = new Penjualan();
            pjl.setIdTrskPjl(listPjl.get(i).getIdTrskPjl());
            pjl.setTglTrskPjl(listPjl.get(i).getTglTrskPjl());
            pjl.setQtyPjl(listPjl.get(i).getQtyPjl());
            pjl.setHrgSatuan(listPjl.get(i).getHrgSatuan());
            pjl.setSubTotal(listPjl.get(i).getSubTotal());
            
            pjlRpt = services.buildModel(pjl);
            listPjlRpt.add(pjlRpt);            
        }
        
    }
    
}
