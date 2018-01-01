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
@Table(name = "marque", catalog = "geolocalisation", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Marque.findAll", query = "SELECT m FROM Marque m")
    , @NamedQuery(name = "Marque.findByIdmarque", query = "SELECT m FROM Marque m WHERE m.idmarque = :idmarque")
    , @NamedQuery(name = "Marque.findByLibellemarque", query = "SELECT m FROM Marque m WHERE m.libellemarque = :libellemarque")})
public class Marque implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmarque")
    private Short idmarque;
    @Basic(optional = false)
    @Column(name = "libellemarque")
    private String libellemarque;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idmarque")
    private List<Modele> modeleList;

    public Marque() {
    }

    public Marque(Short idmarque) {
        this.idmarque = idmarque;
    }

    public Marque(Short idmarque, String libellemarque) {
        this.idmarque = idmarque;
        this.libellemarque = libellemarque;
    }

    public Short getIdmarque() {
        return idmarque;
    }

    public void setIdmarque(Short idmarque) {
        this.idmarque = idmarque;
    }

    public String getLibellemarque() {
        return libellemarque;
    }

    public void setLibellemarque(String libellemarque) {
        this.libellemarque = libellemarque;
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
        hash += (idmarque != null ? idmarque.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Marque)) {
            return false;
        }
        Marque other = (Marque) object;
        if ((this.idmarque == null && other.idmarque != null) || (this.idmarque != null && !this.idmarque.equals(other.idmarque))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sn.modelsis.entities.Marque[ idmarque=" + idmarque + " ]";
    }
    
}
