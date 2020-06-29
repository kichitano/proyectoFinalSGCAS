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
@Table(name = "fase")
@NamedQueries({
    @NamedQuery(name = "Fase.findAll", query = "SELECT f FROM Fase f")})
public class Fase implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "fasId")
    private Integer fasId;
    @Basic(optional = false)
    @Column(name = "fasNombre")
    private String fasNombre;
    @Basic(optional = false)
    @Column(name = "fasEstado")
    private int fasEstado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fase")
    private Collection<Entregable> entregableCollection;
    @JoinColumn(name = "METODOLOGIA_metId", referencedColumnName = "metId")
    @ManyToOne(optional = false)
    private Metodologia mETODOLOGIAmetId;

    public Fase() {
    }

    public Fase(Integer fasId) {
        this.fasId = fasId;
    }

    public Fase(Integer fasId, String fasNombre, int fasEstado) {
        this.fasId = fasId;
        this.fasNombre = fasNombre;
        this.fasEstado = fasEstado;
    }

    public Integer getFasId() {
        return fasId;
    }

    public void setFasId(Integer fasId) {
        this.fasId = fasId;
    }

    public String getFasNombre() {
        return fasNombre;
    }

    public void setFasNombre(String fasNombre) {
        this.fasNombre = fasNombre;
    }

    public int getFasEstado() {
        return fasEstado;
    }

    public void setFasEstado(int fasEstado) {
        this.fasEstado = fasEstado;
    }

    public Collection<Entregable> getEntregableCollection() {
        return entregableCollection;
    }

    public void setEntregableCollection(Collection<Entregable> entregableCollection) {
        this.entregableCollection = entregableCollection;
    }

    public Metodologia getMETODOLOGIAmetId() {
        return mETODOLOGIAmetId;
    }

    public void setMETODOLOGIAmetId(Metodologia mETODOLOGIAmetId) {
        this.mETODOLOGIAmetId = mETODOLOGIAmetId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fasId != null ? fasId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fase)) {
            return false;
        }
        Fase other = (Fase) object;
        if ((this.fasId == null && other.fasId != null) || (this.fasId != null && !this.fasId.equals(other.fasId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Fase[ fasId=" + fasId + " ]";
    }
    
}
