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
@Table(name = "typebalise", catalog = "geolocalisation", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Typebalise.findAll", query = "SELECT t FROM Typebalise t")
    , @NamedQuery(name = "Typebalise.findByIdtypebalise", query = "SELECT t FROM Typebalise t WHERE t.idtypebalise = :idtypebalise")
    , @NamedQuery(name = "Typebalise.findByLibelletypebalise", query = "SELECT t FROM Typebalise t WHERE t.libelletypebalise = :libelletypebalise")
    , @NamedQuery(name = "Typebalise.findByDescriptiontypebalise", query = "SELECT t FROM Typebalise t WHERE t.descriptiontypebalise = :descriptiontypebalise")
    , @NamedQuery(name = "Typebalise.findByFrequence", query = "SELECT t FROM Typebalise t WHERE t.frequence = :frequence")})
public class Typebalise implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtypebalise")
    private Short idtypebalise;
    @Basic(optional = false)
    @Column(name = "libelletypebalise")
    private String libelletypebalise;
    @Column(name = "descriptiontypebalise")
    private String descriptiontypebalise;
    @Column(name = "frequence")
    private Integer frequence;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtypebalise")
    private List<Balise> baliseList;

    public Typebalise() {
    }

    public Typebalise(Short idtypebalise) {
        this.idtypebalise = idtypebalise;
    }

    public Typebalise(Short idtypebalise, String libelletypebalise) {
        this.idtypebalise = idtypebalise;
        this.libelletypebalise = libelletypebalise;
    }

    public Short getIdtypebalise() {
        return idtypebalise;
    }

    public void setIdtypebalise(Short idtypebalise) {
        this.idtypebalise = idtypebalise;
    }

    public String getLibelletypebalise() {
        return libelletypebalise;
    }

    public void setLibelletypebalise(String libelletypebalise) {
        this.libelletypebalise = libelletypebalise;
    }

    public String getDescriptiontypebalise() {
        return descriptiontypebalise;
    }

    public void setDescriptiontypebalise(String descriptiontypebalise) {
        this.descriptiontypebalise = descriptiontypebalise;
    }

    public Integer getFrequence() {
        return frequence;
    }

    public void setFrequence(Integer frequence) {
        this.frequence = frequence;
    }

    @XmlTransient
    public List<Balise> getBaliseList() {
        return baliseList;
    }

    public void setBaliseList(List<Balise> baliseList) {
        this.baliseList = baliseList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtypebalise != null ? idtypebalise.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Typebalise)) {
            return false;
        }
        Typebalise other = (Typebalise) object;
        if ((this.idtypebalise == null && other.idtypebalise != null) || (this.idtypebalise != null && !this.idtypebalise.equals(other.idtypebalise))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sn.modelsis.entities.Typebalise[ idtypebalise=" + idtypebalise + " ]";
    }
    
}
