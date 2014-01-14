/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.adam.dao.impl;

import com.adam.model.Penjualan;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author saddam
 */
public class PenjualanDaoImplTest {
    
    public PenjualanDaoImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of tambah method, of class PenjualanDaoImpl.
     */
    @Test
    public void testTambah() {
        System.out.println("tambah");
        Penjualan p = new Penjualan();
        
        PenjualanDaoImpl instance = new PenjualanDaoImpl();
        instance.tambah(p);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class PenjualanDaoImpl.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Penjualan p = null;
        PenjualanDaoImpl instance = new PenjualanDaoImpl();
        instance.update(p);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class PenjualanDaoImpl.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        int idPenjualan = 0;
        PenjualanDaoImpl instance = new PenjualanDaoImpl();
        instance.delete(idPenjualan);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllPenjualan method, of class PenjualanDaoImpl.
     */
    @Test
    public void testGetAllPenjualan() {
        System.out.println("getAllPenjualan");
        PenjualanDaoImpl instance = new PenjualanDaoImpl();
        List<Penjualan> expResult = null;
        List<Penjualan> result = instance.getAllPenjualan();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addData method, of class PenjualanDaoImpl.
     */
    @Test
    public void testAddData() {
        System.out.println("addData");
        DefaultTableModel model = new DefaultTableModel();
        PenjualanDaoImpl instance = new PenjualanDaoImpl();
        instance.addData(model);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPenjualan method, of class PenjualanDaoImpl.
     */
    @Test
    public void testGetPenjualan() {
        System.out.println("getPenjualan");
        int id = 0;
        PenjualanDaoImpl instance = new PenjualanDaoImpl();
        Penjualan expResult = null;
        Penjualan result = instance.getPenjualan(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
