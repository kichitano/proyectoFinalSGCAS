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
import javax.persistence.JoinColumns;
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
@Table(name = "proyecto")
@NamedQueries({
    @NamedQuery(name = "Proyecto.findAll", query = "SELECT p FROM Proyecto p")})
public class Proyecto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "proId")
    private Integer proId;
    @Basic(optional = false)
    @Column(name = "proNombre")
    private String proNombre;
    @Basic(optional = false)
    @Column(name = "proDescripcion")
    private String proDescripcion;
    @Column(name = "proFechaInicio")
    @Temporal(TemporalType.DATE)
    private Date proFechaInicio;
    @Column(name = "proFechaFin")
    @Temporal(TemporalType.DATE)
    private Date proFechaFin;
    @Basic(optional = false)
    @Column(name = "proEstado")
    private int proEstado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pROYECTOproId")
    private Collection<Detalleentregable> detalleentregableCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pROYECTOproId")
    private Collection<Relacionentregable> relacionentregableCollection;
    @JoinColumns({
        @JoinColumn(name = "METODOLOGIA_metId", referencedColumnName = "metId"),
        @JoinColumn(name = "METODOLOGIA_metId", referencedColumnName = "metId")})
    @ManyToOne(optional = false)
    private Metodologia metodologia;
    @JoinColumn(name = "USUARIO_usuId", referencedColumnName = "usuId")
    @ManyToOne(optional = false)
    private Usuario uSUARIOusuId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pROYECTOproId")
    private Collection<Usuarioproyecto> usuarioproyectoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pROYECTOproId")
    private Collection<Solicitudcambio> solicitudcambioCollection;

    public Proyecto() {
    }

    public Proyecto(Integer proId) {
        this.proId = proId;
    }

    public Proyecto(Integer proId, String proNombre, String proDescripcion, int proEstado) {
        this.proId = proId;
        this.proNombre = proNombre;
        this.proDescripcion = proDescripcion;
        this.proEstado = proEstado;
    }

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }

    public String getProNombre() {
        return proNombre;
    }

    public void setProNombre(String proNombre) {
        this.proNombre = proNombre;
    }

    public String getProDescripcion() {
        return proDescripcion;
    }

    public void setProDescripcion(String proDescripcion) {
        this.proDescripcion = proDescripcion;
    }

    public Date getProFechaInicio() {
        return proFechaInicio;
    }

    public void setProFechaInicio(Date proFechaInicio) {
        this.proFechaInicio = proFechaInicio;
    }

    public Date getProFechaFin() {
        return proFechaFin;
    }

    public void setProFechaFin(Date proFechaFin) {
        this.proFechaFin = proFechaFin;
    }

    public int getProEstado() {
        return proEstado;
    }

    public void setProEstado(int proEstado) {
        this.proEstado = proEstado;
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

    public Metodologia getMetodologia() {
        return metodologia;
    }

    public void setMetodologia(Metodologia metodologia) {
        this.metodologia = metodologia;
    }

    public Usuario getUSUARIOusuId() {
        return uSUARIOusuId;
    }

    public void setUSUARIOusuId(Usuario uSUARIOusuId) {
        this.uSUARIOusuId = uSUARIOusuId;
    }

    public Collection<Usuarioproyecto> getUsuarioproyectoCollection() {
        return usuarioproyectoCollection;
    }

    public void setUsuarioproyectoCollection(Collection<Usuarioproyecto> usuarioproyectoCollection) {
        this.usuarioproyectoCollection = usuarioproyectoCollection;
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
        hash += (proId != null ? proId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proyecto)) {
            return false;
        }
        Proyecto other = (Proyecto) object;
        if ((this.proId == null && other.proId != null) || (this.proId != null && !this.proId.equals(other.proId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Proyecto[ proId=" + proId + " ]";
    }
    
}
