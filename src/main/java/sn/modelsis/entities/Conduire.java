/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.modelsis.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author SNNDIAYEH
 */
@Entity
@Table(name = "conduire", catalog = "geolocalisation", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Conduire.findAll", query = "SELECT c FROM Conduire c")
    , @NamedQuery(name = "Conduire.findByIdchauffeur", query = "SELECT c FROM Conduire c WHERE c.conduirePK.idchauffeur = :idchauffeur")
    , @NamedQuery(name = "Conduire.findByIdvehicule", query = "SELECT c FROM Conduire c WHERE c.conduirePK.idvehicule = :idvehicule")
    , @NamedQuery(name = "Conduire.findByDatedebut", query = "SELECT c FROM Conduire c WHERE c.datedebut = :datedebut")
    , @NamedQuery(name = "Conduire.findByDatefin", query = "SELECT c FROM Conduire c WHERE c.datefin = :datefin")})
public class Conduire implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ConduirePK conduirePK;
    @Column(name = "datedebut")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datedebut;
    @Column(name = "datefin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datefin;
    @JoinColumn(name = "idchauffeur", referencedColumnName = "idchauffeur", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Chauffeur chauffeur;
    @JoinColumn(name = "idvehicule", referencedColumnName = "idvehicule", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Vehicule vehicule;

    public Conduire() {
    }

    public Conduire(ConduirePK conduirePK) {
        this.conduirePK = conduirePK;
    }

    public Conduire(int idchauffeur, int idvehicule) {
        this.conduirePK = new ConduirePK(idchauffeur, idvehicule);
    }

    public ConduirePK getConduirePK() {
        return conduirePK;
    }

    public void setConduirePK(ConduirePK conduirePK) {
        this.conduirePK = conduirePK;
    }

    public Date getDatedebut() {
        return datedebut;
    }

    public void setDatedebut(Date datedebut) {
        this.datedebut = datedebut;
    }

    public Date getDatefin() {
        return datefin;
    }

    public void setDatefin(Date datefin) {
        this.datefin = datefin;
    }

    public Chauffeur getChauffeur() {
        return chauffeur;
    }

    public void setChauffeur(Chauffeur chauffeur) {
        this.chauffeur = chauffeur;
    }

    public Vehicule getVehicule() {
        return vehicule;
    }

    public void setVehicule(Vehicule vehicule) {
        this.vehicule = vehicule;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (conduirePK != null ? conduirePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Conduire)) {
            return false;
        }
        Conduire other = (Conduire) object;
        if ((this.conduirePK == null && other.conduirePK != null) || (this.conduirePK != null && !this.conduirePK.equals(other.conduirePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sn.modelsis.entities.Conduire[ conduirePK=" + conduirePK + " ]";
    }
    
}
