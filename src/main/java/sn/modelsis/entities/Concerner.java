/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.modelsis.entities;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author SNNDIAYEH
 */
@Entity
@Table(name = "concerner", catalog = "geolocalisation", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Concerner.findAll", query = "SELECT c FROM Concerner c")
    , @NamedQuery(name = "Concerner.findByIdvehicule", query = "SELECT c FROM Concerner c WHERE c.concernerPK.idvehicule = :idvehicule")
    , @NamedQuery(name = "Concerner.findByIdcontrat", query = "SELECT c FROM Concerner c WHERE c.concernerPK.idcontrat = :idcontrat")
    , @NamedQuery(name = "Concerner.getActual", query = "SELECT t FROM Concerner c, Tracking t, Balise b, Vehicule v, Client cl, Contrat co WHERE co.idclient=cl AND c.concernerPK.idcontrat=co.idcontrat AND c.concernerPK.idvehicule=v.idvehicule AND c.concernerPK.idbalise=b.idbalise AND t.idbalise =b AND cl.idclient=:idclient")
    , @NamedQuery(name = "Concerner.findContrat", query = "SELECT c FROM Concerner c, Balise b, Vehicule v, Contrat co, Client cl WHERE c.contrat = co AND c.vehicule = v AND c.balise = b AND co.idclient = cl AND cl.idclient = :id")
    , @NamedQuery(name = "Concerner.findByIdbalise", query = "SELECT c FROM Concerner c WHERE c.concernerPK.idbalise = :idbalise")})
public class Concerner implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ConcernerPK concernerPK;
    @JoinColumn(name = "idbalise", referencedColumnName = "idbalise", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Balise balise;
    @JoinColumn(name = "idcontrat", referencedColumnName = "idcontrat", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Contrat contrat;
    @JoinColumn(name = "idvehicule", referencedColumnName = "idvehicule", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Vehicule vehicule;

    public Concerner() {
    }

    public Concerner(ConcernerPK concernerPK) {
        this.concernerPK = concernerPK;
    }

    public Concerner(int idvehicule, int idcontrat, int idbalise) {
        this.concernerPK = new ConcernerPK(idvehicule, idcontrat, idbalise);
    }

    public ConcernerPK getConcernerPK() {
        return concernerPK;
    }

    public void setConcernerPK(ConcernerPK concernerPK) {
        this.concernerPK = concernerPK;
    }

    public Balise getBalise() {
        return balise;
    }

    public void setBalise(Balise balise) {
        this.balise = balise;
    }

    public Contrat getContrat() {
        return contrat;
    }

    public void setContrat(Contrat contrat) {
        this.contrat = contrat;
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
        hash += (concernerPK != null ? concernerPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Concerner)) {
            return false;
        }
        Concerner other = (Concerner) object;
        if ((this.concernerPK == null && other.concernerPK != null) || (this.concernerPK != null && !this.concernerPK.equals(other.concernerPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sn.modelsis.entities.Concerner[ concernerPK=" + concernerPK + " ]";
    }

}
