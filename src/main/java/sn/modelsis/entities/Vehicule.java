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
@Table(name = "vehicule", catalog = "geolocalisation", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vehicule.findAll", query = "SELECT v FROM Vehicule v")
    , @NamedQuery(name = "Vehicule.findByIdvehicule", query = "SELECT v FROM Vehicule v WHERE v.idvehicule = :idvehicule")
    , @NamedQuery(name = "Vehicule.findByImmatriculation", query = "SELECT v FROM Vehicule v WHERE v.immatriculation = :immatriculation")
    , @NamedQuery(name = "Vehicule.findByChassis", query = "SELECT v FROM Vehicule v WHERE v.chassis = :chassis")
    , @NamedQuery(name = "Vehicule.findByReservoir", query = "SELECT v FROM Vehicule v WHERE v.reservoir = :reservoir")
    , @NamedQuery(name = "Vehicule.findByEnergie", query = "SELECT v FROM Vehicule v WHERE v.energie = :energie")
    , @NamedQuery(name = "Vehicule.findByModele", query = "SELECT v FROM Vehicule v, Modele m WHERE v.idmodele = m AND m.libellemodele = :modele")
    , @NamedQuery(name = "Vehicule.findByMarque", query = "SELECT v FROM Vehicule v, Modele mo, Marque ma WHERE v.idmodele = mo AND mo.idmarque = ma AND ma.libellemarque = :marque")
    , @NamedQuery(name = "Vehicule.findByCouleur", query = "SELECT v FROM Vehicule v WHERE v.couleur = :couleur")})
public class Vehicule implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idvehicule")
    private Integer idvehicule;
    @Basic(optional = false)
    @Column(name = "immatriculation")
    private String immatriculation;
    @Basic(optional = false)
    @Column(name = "chassis")
    private String chassis;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "reservoir")
    private Float reservoir;
    @Column(name = "energie")
    private String energie;
    @Column(name = "couleur")
    private String couleur;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehicule")
    private List<Notification> notificationList;
    @JoinColumn(name = "idmodele", referencedColumnName = "idmodele")
    @ManyToOne(optional = false)
    private Modele idmodele;
    @JoinColumn(name = "idtypevehicule", referencedColumnName = "idtypevehicule")
    @ManyToOne(optional = false)
    private Typevehicule idtypevehicule;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehicule")
    private List<Concerner> concernerList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehicule")
    private List<Conduire> conduireList;

    public Vehicule() {
    }

    public Vehicule(Integer idvehicule) {
        this.idvehicule = idvehicule;
    }

    public Vehicule(Integer idvehicule, String immatriculation, String chassis) {
        this.idvehicule = idvehicule;
        this.immatriculation = immatriculation;
        this.chassis = chassis;
    }

    public Integer getIdvehicule() {
        return idvehicule;
    }

    public void setIdvehicule(Integer idvehicule) {
        this.idvehicule = idvehicule;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public String getChassis() {
        return chassis;
    }

    public void setChassis(String chassis) {
        this.chassis = chassis;
    }

    public Float getReservoir() {
        return reservoir;
    }

    public void setReservoir(Float reservoir) {
        this.reservoir = reservoir;
    }

    public String getEnergie() {
        return energie;
    }

    public void setEnergie(String energie) {
        this.energie = energie;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    @XmlTransient
    public List<Notification> getNotificationList() {
        return notificationList;
    }

    public void setNotificationList(List<Notification> notificationList) {
        this.notificationList = notificationList;
    }

    public Modele getIdmodele() {
        return idmodele;
    }

    public void setIdmodele(Modele idmodele) {
        this.idmodele = idmodele;
    }

    public Typevehicule getIdtypevehicule() {
        return idtypevehicule;
    }

    public void setIdtypevehicule(Typevehicule idtypevehicule) {
        this.idtypevehicule = idtypevehicule;
    }

    @XmlTransient
    public List<Concerner> getConcernerList() {
        return concernerList;
    }

    public void setConcernerList(List<Concerner> concernerList) {
        this.concernerList = concernerList;
    }

    @XmlTransient
    public List<Conduire> getConduireList() {
        return conduireList;
    }

    public void setConduireList(List<Conduire> conduireList) {
        this.conduireList = conduireList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idvehicule != null ? idvehicule.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vehicule)) {
            return false;
        }
        Vehicule other = (Vehicule) object;
        if ((this.idvehicule == null && other.idvehicule != null) || (this.idvehicule != null && !this.idvehicule.equals(other.idvehicule))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sn.modelsis.entities.Vehicule[ idvehicule=" + idvehicule + " ]";
    }

}
