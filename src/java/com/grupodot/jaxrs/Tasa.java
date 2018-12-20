/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupodot.jaxrs;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ander
 */
@Entity
@Table(name = "tasa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tasa.findAll", query = "SELECT t FROM Tasa t")
    , @NamedQuery(name = "Tasa.findById", query = "SELECT t FROM Tasa t WHERE t.id = :id")
    , @NamedQuery(name = "Tasa.findByTasa", query = "SELECT t FROM Tasa t WHERE t.tasa = :tasa")
    , @NamedQuery(name = "Tasa.findByMontoMax", query = "SELECT t FROM Tasa t WHERE t.montoMax = :montoMax")})
public class Tasa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 16777215)
    @Column(name = "socio")
    private String socio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tasa")
    private double tasa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "monto_max")
    private int montoMax;

    public Tasa() {
    }

    public Tasa(Long id) {
        this.id = id;
    }

    public Tasa(Long id, String socio, double tasa, int montoMax) {
        this.id = id;
        this.socio = socio;
        this.tasa = tasa;
        this.montoMax = montoMax;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSocio() {
        return socio;
    }

    public void setSocio(String socio) {
        this.socio = socio;
    }

    public double getTasa() {
        return tasa;
    }

    public void setTasa(double tasa) {
        this.tasa = tasa;
    }

    public int getMontoMax() {
        return montoMax;
    }

    public void setMontoMax(int montoMax) {
        this.montoMax = montoMax;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tasa)) {
            return false;
        }
        Tasa other = (Tasa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.grupodot.jaxrs.Tasa[ id=" + id + " ]";
    }
    
}
