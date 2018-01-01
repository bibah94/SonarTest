/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.modelsis.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author SNNDIAYEH
 */
@Embeddable
public class ConcernerPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idvehicule")
    private int idvehicule;
    @Basic(optional = false)
    @Column(name = "idcontrat")
    private int idcontrat;
    @Basic(optional = false)
    @Column(name = "idbalise")
    private int idbalise;

    public ConcernerPK() {
    }

    public ConcernerPK(int idvehicule, int idcontrat, int idbalise) {
        this.idvehicule = idvehicule;
        this.idcontrat = idcontrat;
        this.idbalise = idbalise;
    }

    public int getIdvehicule() {
        return idvehicule;
    }

    public void setIdvehicule(int idvehicule) {
        this.idvehicule = idvehicule;
    }

    public int getIdcontrat() {
        return idcontrat;
    }

    public void setIdcontrat(int idcontrat) {
        this.idcontrat = idcontrat;
    }

    public int getIdbalise() {
        return idbalise;
    }

    public void setIdbalise(int idbalise) {
        this.idbalise = idbalise;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idvehicule;
        hash += (int) idcontrat;
        hash += (int) idbalise;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConcernerPK)) {
            return false;
        }
        ConcernerPK other = (ConcernerPK) object;
        if (this.idvehicule != other.idvehicule) {
            return false;
        }
        if (this.idcontrat != other.idcontrat) {
            return false;
        }
        if (this.idbalise != other.idbalise) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sn.modelsis.entities.ConcernerPK[ idvehicule=" + idvehicule + ", idcontrat=" + idcontrat + ", idbalise=" + idbalise + " ]";
    }
    
}
