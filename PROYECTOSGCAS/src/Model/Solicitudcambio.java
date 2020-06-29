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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@Table(name = "solicitudcambio")
@NamedQueries({
    @NamedQuery(name = "Solicitudcambio.findAll", query = "SELECT s FROM Solicitudcambio s")})
public class Solicitudcambio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "solCambioId")
    private Integer solCambioId;
    @Basic(optional = false)
    @Lob
    @Column(name = "solCambioComentario")
    private String solCambioComentario;
    @Basic(optional = false)
    @Column(name = "solCambioFecha")
    @Temporal(TemporalType.DATE)
    private Date solCambioFecha;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "solicitudCAMBIOsolCambioId")
    private Collection<Solicitudaprobacion> solicitudaprobacionCollection;
    @JoinColumn(name = "detalleEntregable_detEntregableId", referencedColumnName = "detEntregableId")
    @ManyToOne(optional = false)
    private Detalleentregable detalleEntregabledetEntregableId;
    @JoinColumn(name = "PROYECTO_proId", referencedColumnName = "proId")
    @ManyToOne(optional = false)
    private Proyecto pROYECTOproId;

    public Solicitudcambio() {
    }

    public Solicitudcambio(Integer solCambioId) {
        this.solCambioId = solCambioId;
    }

    public Solicitudcambio(Integer solCambioId, String solCambioComentario, Date solCambioFecha) {
        this.solCambioId = solCambioId;
        this.solCambioComentario = solCambioComentario;
        this.solCambioFecha = solCambioFecha;
    }

    public Integer getSolCambioId() {
        return solCambioId;
    }

    public void setSolCambioId(Integer solCambioId) {
        this.solCambioId = solCambioId;
    }

    public String getSolCambioComentario() {
        return solCambioComentario;
    }

    public void setSolCambioComentario(String solCambioComentario) {
        this.solCambioComentario = solCambioComentario;
    }

    public Date getSolCambioFecha() {
        return solCambioFecha;
    }

    public void setSolCambioFecha(Date solCambioFecha) {
        this.solCambioFecha = solCambioFecha;
    }

    public Collection<Solicitudaprobacion> getSolicitudaprobacionCollection() {
        return solicitudaprobacionCollection;
    }

    public void setSolicitudaprobacionCollection(Collection<Solicitudaprobacion> solicitudaprobacionCollection) {
        this.solicitudaprobacionCollection = solicitudaprobacionCollection;
    }

    public Detalleentregable getDetalleEntregabledetEntregableId() {
        return detalleEntregabledetEntregableId;
    }

    public void setDetalleEntregabledetEntregableId(Detalleentregable detalleEntregabledetEntregableId) {
        this.detalleEntregabledetEntregableId = detalleEntregabledetEntregableId;
    }

    public Proyecto getPROYECTOproId() {
        return pROYECTOproId;
    }

    public void setPROYECTOproId(Proyecto pROYECTOproId) {
        this.pROYECTOproId = pROYECTOproId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (solCambioId != null ? solCambioId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Solicitudcambio)) {
            return false;
        }
        Solicitudcambio other = (Solicitudcambio) object;
        if ((this.solCambioId == null && other.solCambioId != null) || (this.solCambioId != null && !this.solCambioId.equals(other.solCambioId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Solicitudcambio[ solCambioId=" + solCambioId + " ]";
    }
    
}
