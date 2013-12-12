/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.adam.dao;

import com.adam.model.Persediaan;

/**
 *
 * @author saddam
 */
public interface PersediaanDao {
    public void edit(Persediaan p);
    public Persediaan getPersediaan(Persediaan p);
    
}
