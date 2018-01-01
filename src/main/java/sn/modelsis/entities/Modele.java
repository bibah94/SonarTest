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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "modele", catalog = "geolocalisation", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Modele.findAll", query = "SELECT m FROM Modele m")
    , @NamedQuery(name = "Modele.findByIdmodele", query = "SELECT m FROM Modele m WHERE m.idmodele = :idmodele")
    , @NamedQuery(name = "Modele.findByLibellemodele", query = "SELECT m FROM Modele m WHERE m.libellemodele = :libellemodele")
    , @NamedQuery(name = "Modele.findByDescriptionmodele", query = "SELECT m FROM Modele m WHERE m.descriptionmodele = :descriptionmodele")})
public class Modele implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmodele")
    private Short idmodele;
    @Basic(optional = false)
    @Column(name = "libellemodele")
    private String libellemodele;
    @Column(name = "descriptionmodele")
    private String descriptionmodele;
    @ManyToMany(mappedBy = "modeleList")
    private List<Categorie> categorieList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idmodele")
    private List<Vehicule> vehiculeList;
    @JoinColumn(name = "idmarque", referencedColumnName = "idmarque")
    @ManyToOne(optional = false)
    private Marque idmarque;

    public Modele() {
    }

    public Modele(Short idmodele) {
        this.idmodele = idmodele;
    }

    public Modele(Short idmodele, String libellemodele) {
        this.idmodele = idmodele;
        this.libellemodele = libellemodele;
    }

    public Short getIdmodele() {
        return idmodele;
    }

    public void setIdmodele(Short idmodele) {
        this.idmodele = idmodele;
    }

    public String getLibellemodele() {
        return libellemodele;
    }

    public void setLibellemodele(String libellemodele) {
        this.libellemodele = libellemodele;
    }

    public String getDescriptionmodele() {
        return descriptionmodele;
    }

    public void setDescriptionmodele(String descriptionmodele) {
        this.descriptionmodele = descriptionmodele;
    }

    @XmlTransient
    public List<Categorie> getCategorieList() {
        return categorieList;
    }

    public void setCategorieList(List<Categorie> categorieList) {
        this.categorieList = categorieList;
    }

    @XmlTransient
    public List<Vehicule> getVehiculeList() {
        return vehiculeList;
    }

    public void setVehiculeList(List<Vehicule> vehiculeList) {
        this.vehiculeList = vehiculeList;
    }

    public Marque getIdmarque() {
        return idmarque;
    }

    public void setIdmarque(Marque idmarque) {
        this.idmarque = idmarque;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmodele != null ? idmodele.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Modele)) {
            return false;
        }
        Modele other = (Modele) object;
        if ((this.idmodele == null && other.idmodele != null) || (this.idmodele != null && !this.idmodele.equals(other.idmodele))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sn.modelsis.entities.Modele[ idmodele=" + idmodele + " ]";
    }
    
}
