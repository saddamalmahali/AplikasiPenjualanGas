/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adam.report.model;

/**
 *
 * @author saddam
 */
public class PenjualanRpt {

    private String id;
    private String tanggal;
    private String banyak;
    private String satuan;
    private String subtotal;
    private String total;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getBanyak() {
        return banyak;
    }

    public void setBanyak(String banyak) {
        this.banyak = banyak;
    }

    public String getSatuan() {
        return satuan;
    }

    public void setSatuan(String satuan) {
        this.satuan = satuan;
    }

    public String getJumlah() {
        return total;
    }

    public void setJumlah(String total) {
        this.total=total;
    }

    public String getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(String subtotal) {
        this.subtotal = subtotal;
    }

}
