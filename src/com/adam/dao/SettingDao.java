/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.adam.dao;

import com.adam.model.Setting;

/**
 *
 * @author saddam
 */
public interface SettingDao {
    public Setting getSetting(Setting setting);
    public void editSetting(Setting setting);
}
