/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.adam.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author saddam
 */
@Entity
@Table(name = "persediaan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Persediaan.findAll", query = "SELECT p FROM Persediaan p"),
    @NamedQuery(name = "Persediaan.findByIdPrsd", query = "SELECT p FROM Persediaan p WHERE p.idPrsd = :idPrsd"),
    @NamedQuery(name = "Persediaan.findByJmlPrsd", query = "SELECT p FROM Persediaan p WHERE p.jmlPrsd = :jmlPrsd")})
public class Persediaan implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_prsd")
    private Integer idPrsd;
    @Basic(optional = false)
    @Column(name = "jml_prsd")
    private int jmlPrsd;

    public Persediaan() {
    }

    public Persediaan(Integer idPrsd) {
        this.idPrsd = idPrsd;
    }

    public Persediaan(Integer idPrsd, int jmlPrsd) {
        this.idPrsd = idPrsd;
        this.jmlPrsd = jmlPrsd;
    }

    public Integer getIdPrsd() {
        return idPrsd;
    }

    public void setIdPrsd(Integer idPrsd) {
        this.idPrsd = idPrsd;
    }

    public int getJmlPrsd() {
        return jmlPrsd;
    }

    public void setJmlPrsd(int jmlPrsd) {
        this.jmlPrsd = jmlPrsd;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPrsd != null ? idPrsd.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persediaan)) {
            return false;
        }
        Persediaan other = (Persediaan) object;
        if ((this.idPrsd == null && other.idPrsd != null) || (this.idPrsd != null && !this.idPrsd.equals(other.idPrsd))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.adam.model.Persediaan[ idPrsd=" + idPrsd + " ]";
    }
    
}
