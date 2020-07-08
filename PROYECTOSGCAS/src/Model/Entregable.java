/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Christian
 */
@Entity
@Table(name = "entregable")
@NamedQueries({
    @NamedQuery(name = "Entregable.findAll", query = "SELECT e FROM Entregable e")})
public class Entregable implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "entId")
    private Integer entId;
    @Basic(optional = false)
    @Column(name = "entNombre")
    private String entNombre;
    @JoinColumns({
        @JoinColumn(name = "FASE_fasId", referencedColumnName = "fasId"),
        @JoinColumn(name = "FASE_fasId", referencedColumnName = "fasId")})
    @ManyToOne(optional = false)
    private Fase fase;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eNTREGABLEentId")
    private Collection<Detalleentregable> detalleentregableCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eNTREGABLEentId1")
    private Collection<Relacionentregable> relacionentregableCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eNTREGABLEentId2")
    private Collection<Relacionentregable> relacionentregableCollection1;

    public Entregable() {
    }

    public Entregable(Integer entId) {
        this.entId = entId;
    }

    public Entregable(Integer entId, String entNombre) {
        this.entId = entId;
        this.entNombre = entNombre;
    }

    public Integer getEntId() {
        return entId;
    }

    public void setEntId(Integer entId) {
        this.entId = entId;
    }

    public String getEntNombre() {
        return entNombre;
    }

    public void setEntNombre(String entNombre) {
        this.entNombre = entNombre;
    }

    public Fase getFase() {
        return fase;
    }

    public void setFase(Fase fase) {
        this.fase = fase;
    }

    public Collection<Detalleentregable> getDetalleentregableCollection() {
        return detalleentregableCollection;
    }

    public void setDetalleentregableCollection(Collection<Detalleentregable> detalleentregableCollection) {
        this.detalleentregableCollection = detalleentregableCollection;
    }

    public Collection<Relacionentregable> getRelacionentregableCollection() {
        return relacionentregableCollection;
    }

    public void setRelacionentregableCollection(Collection<Relacionentregable> relacionentregableCollection) {
        this.relacionentregableCollection = relacionentregableCollection;
    }

    public Collection<Relacionentregable> getRelacionentregableCollection1() {
        return relacionentregableCollection1;
    }

    public void setRelacionentregableCollection1(Collection<Relacionentregable> relacionentregableCollection1) {
        this.relacionentregableCollection1 = relacionentregableCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (entId != null ? entId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Entregable)) {
            return false;
        }
        Entregable other = (Entregable) object;
        if ((this.entId == null && other.entId != null) || (this.entId != null && !this.entId.equals(other.entId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Entregable[ entId=" + entId + " ]";
    }
    
}
