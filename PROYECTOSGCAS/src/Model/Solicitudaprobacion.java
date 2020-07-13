/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Christian
 */
@Entity
@Table(name = "solicitudaprobacion")
@NamedQueries({
    @NamedQuery(name = "Solicitudaprobacion.findAll", query = "SELECT s FROM Solicitudaprobacion s")})
public class Solicitudaprobacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "solAprobacionId")
    private Integer solAprobacionId;
    @Basic(optional = false)
    @Lob
    @Column(name = "solAprobacionComentario")
    private String solAprobacionComentario;
    @Basic(optional = false)
    @Column(name = "solAprobacionFecha")
    @Temporal(TemporalType.DATE)
    private Date solAprobacionFecha;
    @Basic(optional = false)
    @Column(name = "solAprobacionEstado")
    private int solAprobacionEstado;
    @JoinColumn(name = "solicitudCAMBIO_solCambioId", referencedColumnName = "solCambioId")
    @ManyToOne(optional = false)
    private Solicitudcambio solicitudCAMBIOsolCambioId;
    @JoinColumn(name = "usuarioProyecto_usuProyectoId", referencedColumnName = "usuProyectoId")
    @ManyToOne(optional = false)
    private Usuarioproyecto usuarioProyectousuProyectoId;

    public Solicitudaprobacion() {
    }

    public Solicitudaprobacion(Integer solAprobacionId) {
        this.solAprobacionId = solAprobacionId;
    }

    public Solicitudaprobacion(Integer solAprobacionId, String solAprobacionComentario, Date solAprobacionFecha, int solAprobacionEstado) {
        this.solAprobacionId = solAprobacionId;
        this.solAprobacionComentario = solAprobacionComentario;
        this.solAprobacionFecha = solAprobacionFecha;
        this.solAprobacionEstado = solAprobacionEstado;
    }

    public Integer getSolAprobacionId() {
        return solAprobacionId;
    }

    public void setSolAprobacionId(Integer solAprobacionId) {
        this.solAprobacionId = solAprobacionId;
    }

    public String getSolAprobacionComentario() {
        return solAprobacionComentario;
    }

    public void setSolAprobacionComentario(String solAprobacionComentario) {
        this.solAprobacionComentario = solAprobacionComentario;
    }

    public Date getSolAprobacionFecha() {
        return solAprobacionFecha;
    }

    public void setSolAprobacionFecha(Date solAprobacionFecha) {
        this.solAprobacionFecha = solAprobacionFecha;
    }

    public int getSolAprobacionEstado() {
        return solAprobacionEstado;
    }

    public void setSolAprobacionEstado(int solAprobacionEstado) {
        this.solAprobacionEstado = solAprobacionEstado;
    }

    public Solicitudcambio getSolicitudCAMBIOsolCambioId() {
        return solicitudCAMBIOsolCambioId;
    }

    public void setSolicitudCAMBIOsolCambioId(Solicitudcambio solicitudCAMBIOsolCambioId) {
        this.solicitudCAMBIOsolCambioId = solicitudCAMBIOsolCambioId;
    }

    public Usuarioproyecto getUsuarioProyectousuProyectoId() {
        return usuarioProyectousuProyectoId;
    }

    public void setUsuarioProyectousuProyectoId(Usuarioproyecto usuarioProyectousuProyectoId) {
        this.usuarioProyectousuProyectoId = usuarioProyectousuProyectoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (solAprobacionId != null ? solAprobacionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Solicitudaprobacion)) {
            return false;
        }
        Solicitudaprobacion other = (Solicitudaprobacion) object;
        if ((this.solAprobacionId == null && other.solAprobacionId != null) || (this.solAprobacionId != null && !this.solAprobacionId.equals(other.solAprobacionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Solicitudaprobacion[ solAprobacionId=" + solAprobacionId + " ]";
    }
    
}
