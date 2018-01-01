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
public class ConduirePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idchauffeur")
    private int idchauffeur;
    @Basic(optional = false)
    @Column(name = "idvehicule")
    private int idvehicule;

    public ConduirePK() {
    }

    public ConduirePK(int idchauffeur, int idvehicule) {
        this.idchauffeur = idchauffeur;
        this.idvehicule = idvehicule;
    }

    public int getIdchauffeur() {
        return idchauffeur;
    }

    public void setIdchauffeur(int idchauffeur) {
        this.idchauffeur = idchauffeur;
    }

    public int getIdvehicule() {
        return idvehicule;
    }

    public void setIdvehicule(int idvehicule) {
        this.idvehicule = idvehicule;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idchauffeur;
        hash += (int) idvehicule;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConduirePK)) {
            return false;
        }
        ConduirePK other = (ConduirePK) object;
        if (this.idchauffeur != other.idchauffeur) {
            return false;
        }
        if (this.idvehicule != other.idvehicule) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sn.modelsis.entities.ConduirePK[ idchauffeur=" + idchauffeur + ", idvehicule=" + idvehicule + " ]";
    }
    
}
