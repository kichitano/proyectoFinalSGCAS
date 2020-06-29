/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Christian
 */
@Entity
@Table(name = "metodologia")
@NamedQueries({
    @NamedQuery(name = "Metodologia.findAll", query = "SELECT m FROM Metodologia m")})
public class Metodologia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "metId")
    private Integer metId;
    @Basic(optional = false)
    @Column(name = "metNombre")
    private String metNombre;
    @Basic(optional = false)
    @Column(name = "metFechaRegistro")
    @Temporal(TemporalType.DATE)
    private Date metFechaRegistro;
    @Basic(optional = false)
    @Column(name = "metEstado")
    private int metEstado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mETODOLOGIAmetId")
    private Collection<Fase> faseCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "metodologia")
    private Collection<Proyecto> proyectoCollection;

    public Metodologia() {
    }

    public Metodologia(Integer metId) {
        this.metId = metId;
    }

    public Metodologia(Integer metId, String metNombre, Date metFechaRegistro, int metEstado) {
        this.metId = metId;
        this.metNombre = metNombre;
        this.metFechaRegistro = metFechaRegistro;
        this.metEstado = metEstado;
    }

    public Integer getMetId() {
        return metId;
    }

    public void setMetId(Integer metId) {
        this.metId = metId;
    }

    public String getMetNombre() {
        return metNombre;
    }

    public void setMetNombre(String metNombre) {
        this.metNombre = metNombre;
    }

    public Date getMetFechaRegistro() {
        return metFechaRegistro;
    }

    public void setMetFechaRegistro(Date metFechaRegistro) {
        this.metFechaRegistro = metFechaRegistro;
    }

    public int getMetEstado() {
        return metEstado;
    }

    public void setMetEstado(int metEstado) {
        this.metEstado = metEstado;
    }

    public Collection<Fase> getFaseCollection() {
        return faseCollection;
    }

    public void setFaseCollection(Collection<Fase> faseCollection) {
        this.faseCollection = faseCollection;
    }

    public Collection<Proyecto> getProyectoCollection() {
        return proyectoCollection;
    }

    public void setProyectoCollection(Collection<Proyecto> proyectoCollection) {
        this.proyectoCollection = proyectoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (metId != null ? metId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Metodologia)) {
            return false;
        }
        Metodologia other = (Metodologia) object;
        if ((this.metId == null && other.metId != null) || (this.metId != null && !this.metId.equals(other.metId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Metodologia[ metId=" + metId + " ]";
    }
    
}
