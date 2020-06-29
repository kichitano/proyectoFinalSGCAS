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
import javax.persistence.Lob;
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
@Table(name = "usuario")
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "usuId")
    private Integer usuId;
    @Basic(optional = false)
    @Column(name = "usuDNI")
    private String usuDNI;
    @Basic(optional = false)
    @Column(name = "usuNombres")
    private String usuNombres;
    @Basic(optional = false)
    @Column(name = "usuApellidos")
    private String usuApellidos;
    @Basic(optional = false)
    @Column(name = "usuCorreo")
    private String usuCorreo;
    @Basic(optional = false)
    @Column(name = "usuNivel")
    private int usuNivel;
    @Basic(optional = false)
    @Column(name = "usuNombreUsuario")
    private String usuNombreUsuario;
    @Basic(optional = false)
    @Lob
    @Column(name = "usuContrasena")
    private String usuContrasena;
    @Basic(optional = false)
    @Column(name = "usuFechaRegistro")
    @Temporal(TemporalType.DATE)
    private Date usuFechaRegistro;
    @Basic(optional = false)
    @Column(name = "usuEstado")
    private int usuEstado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "uSUARIOusuId")
    private Collection<Proyecto> proyectoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "uSUARIOusuId")
    private Collection<Usuarioproyecto> usuarioproyectoCollection;

    public Usuario() {
    }

    public Usuario(Integer usuId) {
        this.usuId = usuId;
    }

    public Usuario(Integer usuId, String usuDNI, String usuNombres, String usuApellidos, String usuCorreo, int usuNivel, String usuNombreUsuario, String usuContrasena, Date usuFechaRegistro, int usuEstado) {
        this.usuId = usuId;
        this.usuDNI = usuDNI;
        this.usuNombres = usuNombres;
        this.usuApellidos = usuApellidos;
        this.usuCorreo = usuCorreo;
        this.usuNivel = usuNivel;
        this.usuNombreUsuario = usuNombreUsuario;
        this.usuContrasena = usuContrasena;
        this.usuFechaRegistro = usuFechaRegistro;
        this.usuEstado = usuEstado;
    }

    public Integer getUsuId() {
        return usuId;
    }

    public void setUsuId(Integer usuId) {
        this.usuId = usuId;
    }

    public String getUsuDNI() {
        return usuDNI;
    }

    public void setUsuDNI(String usuDNI) {
        this.usuDNI = usuDNI;
    }

    public String getUsuNombres() {
        return usuNombres;
    }

    public void setUsuNombres(String usuNombres) {
        this.usuNombres = usuNombres;
    }

    public String getUsuApellidos() {
        return usuApellidos;
    }

    public void setUsuApellidos(String usuApellidos) {
        this.usuApellidos = usuApellidos;
    }

    public String getUsuCorreo() {
        return usuCorreo;
    }

    public void setUsuCorreo(String usuCorreo) {
        this.usuCorreo = usuCorreo;
    }

    public int getUsuNivel() {
        return usuNivel;
    }

    public void setUsuNivel(int usuNivel) {
        this.usuNivel = usuNivel;
    }

    public String getUsuNombreUsuario() {
        return usuNombreUsuario;
    }

    public void setUsuNombreUsuario(String usuNombreUsuario) {
        this.usuNombreUsuario = usuNombreUsuario;
    }

    public String getUsuContrasena() {
        return usuContrasena;
    }

    public void setUsuContrasena(String usuContrasena) {
        this.usuContrasena = usuContrasena;
    }

    public Date getUsuFechaRegistro() {
        return usuFechaRegistro;
    }

    public void setUsuFechaRegistro(Date usuFechaRegistro) {
        this.usuFechaRegistro = usuFechaRegistro;
    }

    public int getUsuEstado() {
        return usuEstado;
    }

    public void setUsuEstado(int usuEstado) {
        this.usuEstado = usuEstado;
    }

    public Collection<Proyecto> getProyectoCollection() {
        return proyectoCollection;
    }

    public void setProyectoCollection(Collection<Proyecto> proyectoCollection) {
        this.proyectoCollection = proyectoCollection;
    }

    public Collection<Usuarioproyecto> getUsuarioproyectoCollection() {
        return usuarioproyectoCollection;
    }

    public void setUsuarioproyectoCollection(Collection<Usuarioproyecto> usuarioproyectoCollection) {
        this.usuarioproyectoCollection = usuarioproyectoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuId != null ? usuId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.usuId == null && other.usuId != null) || (this.usuId != null && !this.usuId.equals(other.usuId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Usuario[ usuId=" + usuId + " ]";
    }
    
}
