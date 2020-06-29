/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
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

/**
 *
 * @author Christian
 */
@Entity
@Table(name = "archivo")
@NamedQueries({
    @NamedQuery(name = "Archivo.findAll", query = "SELECT a FROM Archivo a")})
public class Archivo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "arcId")
    private Integer arcId;
    @Lob
    @Column(name = "arcRuta")
    private String arcRuta;
    @JoinColumn(name = "detalleEntregable_detEntregableId", referencedColumnName = "detEntregableId")
    @ManyToOne(optional = false)
    private Detalleentregable detalleEntregabledetEntregableId;

    public Archivo() {
    }

    public Archivo(Integer arcId) {
        this.arcId = arcId;
    }

    public Integer getArcId() {
        return arcId;
    }

    public void setArcId(Integer arcId) {
        this.arcId = arcId;
    }

    public String getArcRuta() {
        return arcRuta;
    }

    public void setArcRuta(String arcRuta) {
        this.arcRuta = arcRuta;
    }

    public Detalleentregable getDetalleEntregabledetEntregableId() {
        return detalleEntregabledetEntregableId;
    }

    public void setDetalleEntregabledetEntregableId(Detalleentregable detalleEntregabledetEntregableId) {
        this.detalleEntregabledetEntregableId = detalleEntregabledetEntregableId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (arcId != null ? arcId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Archivo)) {
            return false;
        }
        Archivo other = (Archivo) object;
        if ((this.arcId == null && other.arcId != null) || (this.arcId != null && !this.arcId.equals(other.arcId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Archivo[ arcId=" + arcId + " ]";
    }
    
}
