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
public class NotificationPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idvehicule")
    private int idvehicule;
    @Basic(optional = false)
    @Column(name = "idperimetre")
    private int idperimetre;
    @Basic(optional = false)
    @Column(name = "idincident")
    private int idincident;

    public NotificationPK() {
    }

    public NotificationPK(int idvehicule, int idperimetre, int idincident) {
        this.idvehicule = idvehicule;
        this.idperimetre = idperimetre;
        this.idincident = idincident;
    }

    public int getIdvehicule() {
        return idvehicule;
    }

    public void setIdvehicule(int idvehicule) {
        this.idvehicule = idvehicule;
    }

    public int getIdperimetre() {
        return idperimetre;
    }

    public void setIdperimetre(int idperimetre) {
        this.idperimetre = idperimetre;
    }

    public int getIdincident() {
        return idincident;
    }

    public void setIdincident(int idincident) {
        this.idincident = idincident;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idvehicule;
        hash += (int) idperimetre;
        hash += (int) idincident;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NotificationPK)) {
            return false;
        }
        NotificationPK other = (NotificationPK) object;
        if (this.idvehicule != other.idvehicule) {
            return false;
        }
        if (this.idperimetre != other.idperimetre) {
            return false;
        }
        if (this.idincident != other.idincident) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sn.modelsis.entities.NotificationPK[ idvehicule=" + idvehicule + ", idperimetre=" + idperimetre + ", idincident=" + idincident + " ]";
    }
    
}
