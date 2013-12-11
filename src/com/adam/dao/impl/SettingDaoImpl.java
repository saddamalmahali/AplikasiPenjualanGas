/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.adam.dao.impl;

import com.adam.controller.SettingJpaController;
import com.adam.dao.SettingDao;
import com.adam.model.Setting;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author saddam
 */
public class SettingDaoImpl implements SettingDao{
    SettingJpaController controller;
    EntityManagerFactory emf;

    public SettingDaoImpl() {
        emf = Persistence.createEntityManagerFactory("AplikasiGasPU");
        controller = new SettingJpaController(emf);
    }
    
    
    
    
    
    @Override
    public Setting getSetting(Setting setting) {
        return controller.findSetting(setting.getIdStg());
    }

    @Override
    public void editSetting(Setting setting) {
        try {
            controller.edit(setting);
        } catch (Exception ex) {
            Logger.getLogger(SettingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
