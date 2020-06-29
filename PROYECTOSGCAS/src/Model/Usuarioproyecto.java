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
@Table(name = "usuarioproyecto")
@NamedQueries({
    @NamedQuery(name = "Usuarioproyecto.findAll", query = "SELECT u FROM Usuarioproyecto u")})
public class Usuarioproyecto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "usuProyectoId")
    private Integer usuProyectoId;
    @Basic(optional = false)
    @Column(name = "usuProyectoEstado")
    private int usuProyectoEstado;
    @Basic(optional = false)
    @Column(name = "usuProyectoCargo")
    private int usuProyectoCargo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioProyectousuProyectoId")
    private Collection<Detalleentregable> detalleentregableCollection;
    @JoinColumn(name = "PROYECTO_proId", referencedColumnName = "proId")
    @ManyToOne(optional = false)
    private Proyecto pROYECTOproId;
    @JoinColumn(name = "USUARIO_usuId", referencedColumnName = "usuId")
    @ManyToOne(optional = false)
    private Usuario uSUARIOusuId;

    public Usuarioproyecto() {
    }

    public Usuarioproyecto(Integer usuProyectoId) {
        this.usuProyectoId = usuProyectoId;
    }

    public Usuarioproyecto(Integer usuProyectoId, int usuProyectoEstado, int usuProyectoCargo) {
        this.usuProyectoId = usuProyectoId;
        this.usuProyectoEstado = usuProyectoEstado;
        this.usuProyectoCargo = usuProyectoCargo;
    }

    public Integer getUsuProyectoId() {
        return usuProyectoId;
    }

    public void setUsuProyectoId(Integer usuProyectoId) {
        this.usuProyectoId = usuProyectoId;
    }

    public int getUsuProyectoEstado() {
        return usuProyectoEstado;
    }

    public void setUsuProyectoEstado(int usuProyectoEstado) {
        this.usuProyectoEstado = usuProyectoEstado;
    }

    public int getUsuProyectoCargo() {
        return usuProyectoCargo;
    }

    public void setUsuProyectoCargo(int usuProyectoCargo) {
        this.usuProyectoCargo = usuProyectoCargo;
    }

    public Collection<Detalleentregable> getDetalleentregableCollection() {
        return detalleentregableCollection;
    }

    public void setDetalleentregableCollection(Collection<Detalleentregable> detalleentregableCollection) {
        this.detalleentregableCollection = detalleentregableCollection;
    }

    public Proyecto getPROYECTOproId() {
        return pROYECTOproId;
    }

    public void setPROYECTOproId(Proyecto pROYECTOproId) {
        this.pROYECTOproId = pROYECTOproId;
    }

    public Usuario getUSUARIOusuId() {
        return uSUARIOusuId;
    }

    public void setUSUARIOusuId(Usuario uSUARIOusuId) {
        this.uSUARIOusuId = uSUARIOusuId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuProyectoId != null ? usuProyectoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuarioproyecto)) {
            return false;
        }
        Usuarioproyecto other = (Usuarioproyecto) object;
        if ((this.usuProyectoId == null && other.usuProyectoId != null) || (this.usuProyectoId != null && !this.usuProyectoId.equals(other.usuProyectoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Usuarioproyecto[ usuProyectoId=" + usuProyectoId + " ]";
    }
    
}
