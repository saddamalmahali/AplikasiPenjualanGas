/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.adam.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author saddam
 */
@Entity
@Table(name = "pembelian")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pembelian.findAll", query = "SELECT p FROM Pembelian p"),
    @NamedQuery(name = "Pembelian.findByIdPbl", query = "SELECT p FROM Pembelian p WHERE p.idPbl = :idPbl"),
    @NamedQuery(name = "Pembelian.findByTglTrskPbl", query = "SELECT p FROM Pembelian p WHERE p.tglTrskPbl = :tglTrskPbl"),
    @NamedQuery(name = "Pembelian.findByQtyTrskPbl", query = "SELECT p FROM Pembelian p WHERE p.qtyTrskPbl = :qtyTrskPbl"),
    @NamedQuery(name = "Pembelian.findBySatuanTrskPbl", query = "SELECT p FROM Pembelian p WHERE p.satuanTrskPbl = :satuanTrskPbl"),
    @NamedQuery(name = "Pembelian.findBySubtotalTrskPbl", query = "SELECT p FROM Pembelian p WHERE p.subtotalTrskPbl = :subtotalTrskPbl")})
public class Pembelian implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_pbl")
    private Integer idPbl;
    @Basic(optional = false)
    @Column(name = "tgl_trsk_pbl")
    @Temporal(TemporalType.DATE)
    private Date tglTrskPbl;
    @Basic(optional = false)
    @Column(name = "qty_trsk_pbl")
    private int qtyTrskPbl;
    @Basic(optional = false)
    @Column(name = "satuan_trsk_pbl")
    private float satuanTrskPbl;
    @Basic(optional = false)
    @Column(name = "subtotal_trsk_pbl")
    private float subtotalTrskPbl;

    public Pembelian() {
    }

    public Pembelian(Integer idPbl) {
        this.idPbl = idPbl;
    }

    public Pembelian(Integer idPbl, Date tglTrskPbl, int qtyTrskPbl, float satuanTrskPbl, float subtotalTrskPbl) {
        this.idPbl = idPbl;
        this.tglTrskPbl = tglTrskPbl;
        this.qtyTrskPbl = qtyTrskPbl;
        this.satuanTrskPbl = satuanTrskPbl;
        this.subtotalTrskPbl = subtotalTrskPbl;
    }

    public Integer getIdPbl() {
        return idPbl;
    }

    public void setIdPbl(Integer idPbl) {
        this.idPbl = idPbl;
    }

    public Date getTglTrskPbl() {
        return tglTrskPbl;
    }

    public void setTglTrskPbl(Date tglTrskPbl) {
        this.tglTrskPbl = tglTrskPbl;
    }

    public int getQtyTrskPbl() {
        return qtyTrskPbl;
    }

    public void setQtyTrskPbl(int qtyTrskPbl) {
        this.qtyTrskPbl = qtyTrskPbl;
    }

    public float getSatuanTrskPbl() {
        return satuanTrskPbl;
    }

    public void setSatuanTrskPbl(float satuanTrskPbl) {
        this.satuanTrskPbl = satuanTrskPbl;
    }

    public float getSubtotalTrskPbl() {
        return subtotalTrskPbl;
    }

    public void setSubtotalTrskPbl(float subtotalTrskPbl) {
        this.subtotalTrskPbl = subtotalTrskPbl;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPbl != null ? idPbl.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pembelian)) {
            return false;
        }
        Pembelian other = (Pembelian) object;
        if ((this.idPbl == null && other.idPbl != null) || (this.idPbl != null && !this.idPbl.equals(other.idPbl))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.adam.model.Pembelian[ idPbl=" + idPbl + " ]";
    }
    
}
