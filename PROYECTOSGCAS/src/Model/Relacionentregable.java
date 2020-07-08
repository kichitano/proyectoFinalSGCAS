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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Christian
 */
@Entity
@Table(name = "relacionentregable")
@NamedQueries({
    @NamedQuery(name = "Relacionentregable.findAll", query = "SELECT r FROM Relacionentregable r")})
public class Relacionentregable implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idrelacionENTREGABLE")
    private Integer idrelacionENTREGABLE;
    @JoinColumn(name = "ENTREGABLE_entId1", referencedColumnName = "entId")
    @ManyToOne(optional = false)
    private Entregable eNTREGABLEentId1;
    @JoinColumn(name = "ENTREGABLE_entId2", referencedColumnName = "entId")
    @ManyToOne(optional = false)
    private Entregable eNTREGABLEentId2;

    public Relacionentregable() {
    }

    public Relacionentregable(Integer idrelacionENTREGABLE) {
        this.idrelacionENTREGABLE = idrelacionENTREGABLE;
    }

    public Integer getIdrelacionENTREGABLE() {
        return idrelacionENTREGABLE;
    }

    public void setIdrelacionENTREGABLE(Integer idrelacionENTREGABLE) {
        this.idrelacionENTREGABLE = idrelacionENTREGABLE;
    }

    public Entregable getENTREGABLEentId1() {
        return eNTREGABLEentId1;
    }

    public void setENTREGABLEentId1(Entregable eNTREGABLEentId1) {
        this.eNTREGABLEentId1 = eNTREGABLEentId1;
    }

    public Entregable getENTREGABLEentId2() {
        return eNTREGABLEentId2;
    }

    public void setENTREGABLEentId2(Entregable eNTREGABLEentId2) {
        this.eNTREGABLEentId2 = eNTREGABLEentId2;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idrelacionENTREGABLE != null ? idrelacionENTREGABLE.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Relacionentregable)) {
            return false;
        }
        Relacionentregable other = (Relacionentregable) object;
        if ((this.idrelacionENTREGABLE == null && other.idrelacionENTREGABLE != null) || (this.idrelacionENTREGABLE != null && !this.idrelacionENTREGABLE.equals(other.idrelacionENTREGABLE))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Relacionentregable[ idrelacionENTREGABLE=" + idrelacionENTREGABLE + " ]";
    }
    
}
