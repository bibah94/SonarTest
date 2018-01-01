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
@Table(name = "balise", catalog = "geolocalisation", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Balise.findAll", query = "SELECT b FROM Balise b")
    , @NamedQuery(name = "Balise.findByIdbalise", query = "SELECT b FROM Balise b WHERE b.idbalise = :idbalise")
    , @NamedQuery(name = "Balise.findByImeibalise", query = "SELECT b FROM Balise b WHERE b.imeibalise = :imeibalise")
    , @NamedQuery(name = "Balise.findByTelephonebalise", query = "SELECT b FROM Balise b WHERE b.telephonebalise = :telephonebalise")
    , @NamedQuery(name = "Balise.findByStatut", query = "SELECT b FROM Balise b WHERE b.statut = :statut")
    , @NamedQuery(name = "Balise.findByEtat", query = "SELECT b FROM Balise b WHERE b.etat = :etat")
    , @NamedQuery(name = "Balise.findByCouleurbalise", query = "SELECT b FROM Balise b WHERE b.couleurbalise = :couleurbalise")})
public class Balise implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idbalise")
    private Integer idbalise;
    @Basic(optional = false)
    @Column(name = "imeibalise")
    private String imeibalise;
    @Basic(optional = false)
    @Column(name = "telephonebalise")
    private String telephonebalise;
    @Basic(optional = false)
    @Column(name = "statut")
    private String statut;
    @Basic(optional = false)
    @Column(name = "etat")
    private String etat;
    @Column(name = "couleurbalise")
    private String couleurbalise;
    @JoinColumn(name = "idtypebalise", referencedColumnName = "idtypebalise")
    @ManyToOne(optional = false)
    private Typebalise idtypebalise;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idbalise")
    private List<Tracking> trackingList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "balise")
    private List<Concerner> concernerList;

    public Balise() {
    }

    public Balise(Integer idbalise) {
        this.idbalise = idbalise;
    }

    public Balise(Integer idbalise, String imeibalise, String telephonebalise, String statut, String etat) {
        this.idbalise = idbalise;
        this.imeibalise = imeibalise;
        this.telephonebalise = telephonebalise;
        this.statut = statut;
        this.etat = etat;
    }

    public Integer getIdbalise() {
        return idbalise;
    }

    public void setIdbalise(Integer idbalise) {
        this.idbalise = idbalise;
    }

    public String getImeibalise() {
        return imeibalise;
    }

    public void setImeibalise(String imeibalise) {
        this.imeibalise = imeibalise;
    }

    public String getTelephonebalise() {
        return telephonebalise;
    }

    public void setTelephonebalise(String telephonebalise) {
        this.telephonebalise = telephonebalise;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getCouleurbalise() {
        return couleurbalise;
    }

    public void setCouleurbalise(String couleurbalise) {
        this.couleurbalise = couleurbalise;
    }

    public Typebalise getIdtypebalise() {
        return idtypebalise;
    }

    public void setIdtypebalise(Typebalise idtypebalise) {
        this.idtypebalise = idtypebalise;
    }

    @XmlTransient
    public List<Tracking> getTrackingList() {
        return trackingList;
    }

    public void setTrackingList(List<Tracking> trackingList) {
        this.trackingList = trackingList;
    }

    @XmlTransient
    public List<Concerner> getConcernerList() {
        return concernerList;
    }

    public void setConcernerList(List<Concerner> concernerList) {
        this.concernerList = concernerList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idbalise != null ? idbalise.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Balise)) {
            return false;
        }
        Balise other = (Balise) object;
        if ((this.idbalise == null && other.idbalise != null) || (this.idbalise != null && !this.idbalise.equals(other.idbalise))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sn.modelsis.entities.Balise[ idbalise=" + idbalise + " ]";
    }

}
