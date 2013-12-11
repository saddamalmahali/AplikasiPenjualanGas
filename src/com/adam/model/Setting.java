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
@Table(name = "setting")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Setting.findAll", query = "SELECT s FROM Setting s"),
    @NamedQuery(name = "Setting.findByIdStg", query = "SELECT s FROM Setting s WHERE s.idStg = :idStg"),
    @NamedQuery(name = "Setting.findByHrgStg", query = "SELECT s FROM Setting s WHERE s.hrgStg = :hrgStg")})
public class Setting implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_stg")
    private Integer idStg;
    @Basic(optional = false)
    @Column(name = "hrg_stg")
    private float hrgStg;

    public Setting() {
    }

    public Setting(Integer idStg) {
        this.idStg = idStg;
    }

    public Setting(Integer idStg, float hrgStg) {
        this.idStg = idStg;
        this.hrgStg = hrgStg;
    }

    public Integer getIdStg() {
        return idStg;
    }

    public void setIdStg(Integer idStg) {
        this.idStg = idStg;
    }

    public float getHrgStg() {
        return hrgStg;
    }

    public void setHrgStg(float hrgStg) {
        this.hrgStg = hrgStg;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idStg != null ? idStg.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Setting)) {
            return false;
        }
        Setting other = (Setting) object;
        if ((this.idStg == null && other.idStg != null) || (this.idStg != null && !this.idStg.equals(other.idStg))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.adam.model.Setting[ idStg=" + idStg + " ]";
    }
    
}
