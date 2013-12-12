/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.adam.dao.impl;

import com.adam.controller.PersediaanJpaController;
import com.adam.dao.PersediaanDao;
import com.adam.model.Persediaan;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author saddam
 */
public class PersediaanDaoImpl implements PersediaanDao{
    
    PersediaanJpaController controller;
    EntityManagerFactory emf;
    public PersediaanDaoImpl() {
        emf = Persistence.createEntityManagerFactory("AplikasiGasPU");
        controller = new PersediaanJpaController(emf);
    }
    
    
    
    @Override
    public void edit(Persediaan p) {
        try {
            controller.edit(p);
        } catch (Exception ex) {
            Logger.getLogger(PersediaanDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Persediaan getPersediaan(Persediaan p) {
        return controller.findPersediaan(p.getIdPrsd());
    }
    
}
