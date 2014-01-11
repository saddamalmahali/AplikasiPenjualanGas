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
 * 
 */

public class ReportPenjualanMain {  
        
    public static void main(String[]args) throws JRException{
        
        Report re = new Report();
        re.view();
        
    }
    
}
