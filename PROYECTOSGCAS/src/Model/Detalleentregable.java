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
@Table(name = "detalleentregable")
@NamedQueries({
    @NamedQuery(name = "Detalleentregable.findAll", query = "SELECT d FROM Detalleentregable d")})
public class Detalleentregable implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "detEntregableId")
    private Integer detEntregableId;
    @Basic(optional = false)
    @Column(name = "detEntregableNombreArchivo")
    private String detEntregableNombreArchivo;
    @Basic(optional = false)
    @Column(name = "detEntregableFechaInicio")
    @Temporal(TemporalType.DATE)
    private Date detEntregableFechaInicio;
    @Basic(optional = false)
    @Column(name = "detEntregableFechaFin")
    @Temporal(TemporalType.DATE)
    private Date detEntregableFechaFin;
    @Column(name = "detEntregableFechaEntrega")
    @Temporal(TemporalType.DATE)
    private Date detEntregableFechaEntrega;
    @Basic(optional = false)
    @Column(name = "detEntregableEstado")
    private int detEntregableEstado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "detalleEntregabledetEntregableId")
    private Collection<Archivo> archivoCollection;
    @JoinColumn(name = "ENTREGABLE_entId", referencedColumnName = "entId")
    @ManyToOne(optional = false)
    private Entregable eNTREGABLEentId;
    @JoinColumn(name = "PROYECTO_proId", referencedColumnName = "proId")
    @ManyToOne(optional = false)
    private Proyecto pROYECTOproId;
    @JoinColumn(name = "usuarioProyecto_usuProyectoId", referencedColumnName = "usuProyectoId")
    @ManyToOne(optional = false)
    private Usuarioproyecto usuarioProyectousuProyectoId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "detalleENTREGABLEdetEntregableId1")
    private Collection<Relacionentregable> relacionentregableCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "detalleENTREGABLEdetEntregableId2")
    private Collection<Relacionentregable> relacionentregableCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "detalleEntregabledetEntregableId")
    private Collection<Solicitudcambio> solicitudcambioCollection;

    public Detalleentregable() {
    }

    public Detalleentregable(Integer detEntregableId) {
        this.detEntregableId = detEntregableId;
    }

    public Detalleentregable(Integer detEntregableId, String detEntregableNombreArchivo, Date detEntregableFechaInicio, Date detEntregableFechaFin, int detEntregableEstado) {
        this.detEntregableId = detEntregableId;
        this.detEntregableNombreArchivo = detEntregableNombreArchivo;
        this.detEntregableFechaInicio = detEntregableFechaInicio;
        this.detEntregableFechaFin = detEntregableFechaFin;
        this.detEntregableEstado = detEntregableEstado;
    }

    public Integer getDetEntregableId() {
        return detEntregableId;
    }

    public void setDetEntregableId(Integer detEntregableId) {
        this.detEntregableId = detEntregableId;
    }

    public String getDetEntregableNombreArchivo() {
        return detEntregableNombreArchivo;
    }

    public void setDetEntregableNombreArchivo(String detEntregableNombreArchivo) {
        this.detEntregableNombreArchivo = detEntregableNombreArchivo;
    }

    public Date getDetEntregableFechaInicio() {
        return detEntregableFechaInicio;
    }

    public void setDetEntregableFechaInicio(Date detEntregableFechaInicio) {
        this.detEntregableFechaInicio = detEntregableFechaInicio;
    }

    public Date getDetEntregableFechaFin() {
        return detEntregableFechaFin;
    }

    public void setDetEntregableFechaFin(Date detEntregableFechaFin) {
        this.detEntregableFechaFin = detEntregableFechaFin;
    }

    public Date getDetEntregableFechaEntrega() {
        return detEntregableFechaEntrega;
    }

    public void setDetEntregableFechaEntrega(Date detEntregableFechaEntrega) {
        this.detEntregableFechaEntrega = detEntregableFechaEntrega;
    }

    public int getDetEntregableEstado() {
        return detEntregableEstado;
    }

    public void setDetEntregableEstado(int detEntregableEstado) {
        this.detEntregableEstado = detEntregableEstado;
    }

    public Collection<Archivo> getArchivoCollection() {
        return archivoCollection;
    }

    public void setArchivoCollection(Collection<Archivo> archivoCollection) {
        this.archivoCollection = archivoCollection;
    }

    public Entregable getENTREGABLEentId() {
        return eNTREGABLEentId;
    }

    public void setENTREGABLEentId(Entregable eNTREGABLEentId) {
        this.eNTREGABLEentId = eNTREGABLEentId;
    }

    public Proyecto getPROYECTOproId() {
        return pROYECTOproId;
    }

    public void setPROYECTOproId(Proyecto pROYECTOproId) {
        this.pROYECTOproId = pROYECTOproId;
    }

    public Usuarioproyecto getUsuarioProyectousuProyectoId() {
        return usuarioProyectousuProyectoId;
    }

    public void setUsuarioProyectousuProyectoId(Usuarioproyecto usuarioProyectousuProyectoId) {
        this.usuarioProyectousuProyectoId = usuarioProyectousuProyectoId;
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

    public Collection<Solicitudcambio> getSolicitudcambioCollection() {
        return solicitudcambioCollection;
    }

    public void setSolicitudcambioCollection(Collection<Solicitudcambio> solicitudcambioCollection) {
        this.solicitudcambioCollection = solicitudcambioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detEntregableId != null ? detEntregableId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detalleentregable)) {
            return false;
        }
        Detalleentregable other = (Detalleentregable) object;
        if ((this.detEntregableId == null && other.detEntregableId != null) || (this.detEntregableId != null && !this.detEntregableId.equals(other.detEntregableId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Detalleentregable[ detEntregableId=" + detEntregableId + " ]";
    }
    
}
