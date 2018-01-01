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
@Table(name = "chauffeur", catalog = "geolocalisation", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Chauffeur.findAll", query = "SELECT c FROM Chauffeur c")
    , @NamedQuery(name = "Chauffeur.findByIdchauffeur", query = "SELECT c FROM Chauffeur c WHERE c.idchauffeur = :idchauffeur")
    , @NamedQuery(name = "Chauffeur.findByNomchauffeur", query = "SELECT c FROM Chauffeur c WHERE c.nomchauffeur = :nomchauffeur")
    , @NamedQuery(name = "Chauffeur.findByPrenomchauffeur", query = "SELECT c FROM Chauffeur c WHERE c.prenomchauffeur = :prenomchauffeur")
    , @NamedQuery(name = "Chauffeur.findByAdressechauffeur", query = "SELECT c FROM Chauffeur c WHERE c.adressechauffeur = :adressechauffeur")
    , @NamedQuery(name = "Chauffeur.findByNumeropermis", query = "SELECT c FROM Chauffeur c WHERE c.numeropermis = :numeropermis")
    , @NamedQuery(name = "Chauffeur.findByTelephonechauffeur", query = "SELECT c FROM Chauffeur c WHERE c.telephonechauffeur = :telephonechauffeur")
    , @NamedQuery(name = "Chauffeur.findByCnichauffeur", query = "SELECT c FROM Chauffeur c WHERE c.cnichauffeur = :cnichauffeur")})
public class Chauffeur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idchauffeur")
    private Integer idchauffeur;
    @Basic(optional = false)
    @Column(name = "nomchauffeur")
    private String nomchauffeur;
    @Basic(optional = false)
    @Column(name = "prenomchauffeur")
    private String prenomchauffeur;
    @Basic(optional = false)
    @Column(name = "adressechauffeur")
    private String adressechauffeur;
    @Basic(optional = false)
    @Column(name = "numeropermis")
    private String numeropermis;
    @Basic(optional = false)
    @Column(name = "telephonechauffeur")
    private String telephonechauffeur;
    @Basic(optional = false)
    @Column(name = "cnichauffeur")
    private String cnichauffeur;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "chauffeur")
    private List<Conduire> conduireList;

    public Chauffeur() {
    }

    public Chauffeur(Integer idchauffeur) {
        this.idchauffeur = idchauffeur;
    }

    public Chauffeur(Integer idchauffeur, String nomchauffeur, String prenomchauffeur, String adressechauffeur, String numeropermis, String telephonechauffeur, String cnichauffeur) {
        this.idchauffeur = idchauffeur;
        this.nomchauffeur = nomchauffeur;
        this.prenomchauffeur = prenomchauffeur;
        this.adressechauffeur = adressechauffeur;
        this.numeropermis = numeropermis;
        this.telephonechauffeur = telephonechauffeur;
        this.cnichauffeur = cnichauffeur;
    }

    public Integer getIdchauffeur() {
        return idchauffeur;
    }

    public void setIdchauffeur(Integer idchauffeur) {
        this.idchauffeur = idchauffeur;
    }

    public String getNomchauffeur() {
        return nomchauffeur;
    }

    public void setNomchauffeur(String nomchauffeur) {
        this.nomchauffeur = nomchauffeur;
    }

    public String getPrenomchauffeur() {
        return prenomchauffeur;
    }

    public void setPrenomchauffeur(String prenomchauffeur) {
        this.prenomchauffeur = prenomchauffeur;
    }

    public String getAdressechauffeur() {
        return adressechauffeur;
    }

    public void setAdressechauffeur(String adressechauffeur) {
        this.adressechauffeur = adressechauffeur;
    }

    public String getNumeropermis() {
        return numeropermis;
    }

    public void setNumeropermis(String numeropermis) {
        this.numeropermis = numeropermis;
    }

    public String getTelephonechauffeur() {
        return telephonechauffeur;
    }

    public void setTelephonechauffeur(String telephonechauffeur) {
        this.telephonechauffeur = telephonechauffeur;
    }

    public String getCnichauffeur() {
        return cnichauffeur;
    }

    public void setCnichauffeur(String cnichauffeur) {
        this.cnichauffeur = cnichauffeur;
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
        hash += (idchauffeur != null ? idchauffeur.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Chauffeur)) {
            return false;
        }
        Chauffeur other = (Chauffeur) object;
        if ((this.idchauffeur == null && other.idchauffeur != null) || (this.idchauffeur != null && !this.idchauffeur.equals(other.idchauffeur))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sn.modelsis.entities.Chauffeur[ idchauffeur=" + idchauffeur + " ]";
    }
    
}
