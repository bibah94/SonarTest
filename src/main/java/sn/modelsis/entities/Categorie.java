/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.modelsis.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author SNNDIAYEH
 */
@Entity
@Table(name = "categorie", catalog = "geolocalisation", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Categorie.findAll", query = "SELECT c FROM Categorie c")
    , @NamedQuery(name = "Categorie.findByIdcategorie", query = "SELECT c FROM Categorie c WHERE c.idcategorie = :idcategorie")
    , @NamedQuery(name = "Categorie.findByLibellecategorie", query = "SELECT c FROM Categorie c WHERE c.libellecategorie = :libellecategorie")})
public class Categorie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcategorie")
    private Short idcategorie;
    @Basic(optional = false)
    @Column(name = "libellecategorie")
    private String libellecategorie;
    @JoinTable(name = "comporter", joinColumns = {
        @JoinColumn(name = "idcategorie", referencedColumnName = "idcategorie")}, inverseJoinColumns = {
        @JoinColumn(name = "idmodele", referencedColumnName = "idmodele")})
    @ManyToMany
    private List<Modele> modeleList;

    public Categorie() {
    }

    public Categorie(Short idcategorie) {
        this.idcategorie = idcategorie;
    }

    public Categorie(Short idcategorie, String libellecategorie) {
        this.idcategorie = idcategorie;
        this.libellecategorie = libellecategorie;
    }

    public Short getIdcategorie() {
        return idcategorie;
    }

    public void setIdcategorie(Short idcategorie) {
        this.idcategorie = idcategorie;
    }

    public String getLibellecategorie() {
        return libellecategorie;
    }

    public void setLibellecategorie(String libellecategorie) {
        this.libellecategorie = libellecategorie;
    }

    @XmlTransient
    public List<Modele> getModeleList() {
        return modeleList;
    }

    public void setModeleList(List<Modele> modeleList) {
        this.modeleList = modeleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcategorie != null ? idcategorie.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categorie)) {
            return false;
        }
        Categorie other = (Categorie) object;
        if ((this.idcategorie == null && other.idcategorie != null) || (this.idcategorie != null && !this.idcategorie.equals(other.idcategorie))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sn.modelsis.entities.Categorie[ idcategorie=" + idcategorie + " ]";
    }
    
}
