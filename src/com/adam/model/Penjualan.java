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
@Table(name = "penjualan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Penjualan.findAll", query = "SELECT p FROM Penjualan p"),
    @NamedQuery(name = "Penjualan.findByIdTrskPjl", query = "SELECT p FROM Penjualan p WHERE p.idTrskPjl = :idTrskPjl"),
    @NamedQuery(name = "Penjualan.findByTglTrskPjl", query = "SELECT p FROM Penjualan p WHERE p.tglTrskPjl = :tglTrskPjl"),
    @NamedQuery(name = "Penjualan.findByQtyPjl", query = "SELECT p FROM Penjualan p WHERE p.qtyPjl = :qtyPjl"),
    @NamedQuery(name = "Penjualan.findByHrgSatuan", query = "SELECT p FROM Penjualan p WHERE p.hrgSatuan = :hrgSatuan"),
    @NamedQuery(name = "Penjualan.findBySubTotal", query = "SELECT p FROM Penjualan p WHERE p.subTotal = :subTotal")})
public class Penjualan implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_trsk_pjl")
    private Integer idTrskPjl;
    @Basic(optional = false)
    @Column(name = "tgl_trsk_pjl")
    @Temporal(TemporalType.DATE)
    private Date tglTrskPjl;
    @Basic(optional = false)
    @Column(name = "qty_pjl")
    private int qtyPjl;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "hrg_satuan")
    private Float hrgSatuan;
    @Column(name = "sub_total")
    private Float subTotal;

    public Penjualan() {
    }

    public Penjualan(Integer idTrskPjl) {
        this.idTrskPjl = idTrskPjl;
    }

    public Penjualan(Integer idTrskPjl, Date tglTrskPjl, int qtyPjl) {
        this.idTrskPjl = idTrskPjl;
        this.tglTrskPjl = tglTrskPjl;
        this.qtyPjl = qtyPjl;
    }

    public Integer getIdTrskPjl() {
        return idTrskPjl;
    }

    public void setIdTrskPjl(Integer idTrskPjl) {
        this.idTrskPjl = idTrskPjl;
    }

    public Date getTglTrskPjl() {
        return tglTrskPjl;
    }

    public void setTglTrskPjl(Date tglTrskPjl) {
        this.tglTrskPjl = tglTrskPjl;
    }

    public int getQtyPjl() {
        return qtyPjl;
    }

    public void setQtyPjl(int qtyPjl) {
        this.qtyPjl = qtyPjl;
    }

    public Float getHrgSatuan() {
        return hrgSatuan;
    }

    public void setHrgSatuan(Float hrgSatuan) {
        this.hrgSatuan = hrgSatuan;
    }

    public Float getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Float subTotal) {
        this.subTotal = subTotal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTrskPjl != null ? idTrskPjl.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Penjualan)) {
            return false;
        }
        Penjualan other = (Penjualan) object;
        if ((this.idTrskPjl == null && other.idTrskPjl != null) || (this.idTrskPjl != null && !this.idTrskPjl.equals(other.idTrskPjl))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.adam.model.Penjualan[ idTrskPjl=" + idTrskPjl + " ]";
    }
    
}
