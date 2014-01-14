/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.adam.dao.impl;

import com.adam.model.Pembelian;
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
public class PembelianDaoImplTest {
    
    public PembelianDaoImplTest() {
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
     * Test of tambah method, of class PembelianDaoImpl.
     */
    @Test
    public void testTambah() {
        System.out.println("tambah");
        Pembelian pbl = null;
        PembelianDaoImpl instance = new PembelianDaoImpl();
        instance.tambah(pbl);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hapus method, of class PembelianDaoImpl.
     */
    @Test
    public void testHapus() {
        System.out.println("hapus");
        int idPbl = 0;
        PembelianDaoImpl instance = new PembelianDaoImpl();
        instance.hapus(idPbl);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllPembelian method, of class PembelianDaoImpl.
     */
    @Test
    public void testGetAllPembelian() {
        System.out.println("getAllPembelian");
        PembelianDaoImpl instance = new PembelianDaoImpl();
        List<Pembelian> expResult = null;
        List<Pembelian> result = instance.getAllPembelian();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addData method, of class PembelianDaoImpl.
     */
    @Test
    public void testAddData() {
        System.out.println("addData");
        DefaultTableModel model = null;
        PembelianDaoImpl instance = new PembelianDaoImpl();
        instance.addData(model);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPembelian method, of class PembelianDaoImpl.
     */
    @Test
    public void testGetPembelian() {
        System.out.println("getPembelian");
        int idPbl = 0;
        PembelianDaoImpl instance = new PembelianDaoImpl();
        Pembelian expResult = null;
        Pembelian result = instance.getPembelian(idPbl);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
