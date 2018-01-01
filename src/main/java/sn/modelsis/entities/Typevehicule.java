/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.modelsis.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author SNNDIAYEH
 */
@Entity
@Table(name = "typevehicule", catalog = "geolocalisation", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Typevehicule.findAll", query = "SELECT t FROM Typevehicule t")
    , @NamedQuery(name = "Typevehicule.findByIdtypevehicule", query = "SELECT t FROM Typevehicule t WHERE t.idtypevehicule = :idtypevehicule")
    , @NamedQuery(name = "Typevehicule.findByLibelletypevehicule", query = "SELECT t FROM Typevehicule t WHERE t.libelletypevehicule = :libelletypevehicule")})
public class Typevehicule implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtypevehicule")
    private Short idtypevehicule;
    @Basic(optional = false)
    @Column(name = "libelletypevehicule")
    private String libelletypevehicule;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtypevehicule")
    private List<Vehicule> vehiculeList;

    public Typevehicule() {
    }

    public Typevehicule(Short idtypevehicule) {
        this.idtypevehicule = idtypevehicule;
    }

    public Typevehicule(Short idtypevehicule, String libelletypevehicule) {
        this.idtypevehicule = idtypevehicule;
        this.libelletypevehicule = libelletypevehicule;
    }

    public Short getIdtypevehicule() {
        return idtypevehicule;
    }

    public void setIdtypevehicule(Short idtypevehicule) {
        this.idtypevehicule = idtypevehicule;
    }

    public String getLibelletypevehicule() {
        return libelletypevehicule;
    }

    public void setLibelletypevehicule(String libelletypevehicule) {
        this.libelletypevehicule = libelletypevehicule;
    }

    @XmlTransient
    public List<Vehicule> getVehiculeList() {
        return vehiculeList;
    }

    public void setVehiculeList(List<Vehicule> vehiculeList) {
        this.vehiculeList = vehiculeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtypevehicule != null ? idtypevehicule.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Typevehicule)) {
            return false;
        }
        Typevehicule other = (Typevehicule) object;
        if ((this.idtypevehicule == null && other.idtypevehicule != null) || (this.idtypevehicule != null && !this.idtypevehicule.equals(other.idtypevehicule))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sn.modelsis.entities.Typevehicule[ idtypevehicule=" + idtypevehicule + " ]";
    }
    
}
