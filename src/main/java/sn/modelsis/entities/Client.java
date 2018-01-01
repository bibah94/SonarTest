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
@Table(name = "client", catalog = "geolocalisation", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Client.findAll", query = "SELECT c FROM Client c")
    , @NamedQuery(name = "Client.findByIdclient", query = "SELECT c FROM Client c WHERE c.idclient = :idclient")
    , @NamedQuery(name = "Client.findByNomclient", query = "SELECT c FROM Client c WHERE c.nomclient = :nomclient")
    , @NamedQuery(name = "Client.findByPrenomclient", query = "SELECT c FROM Client c WHERE c.prenomclient = :prenomclient")
    , @NamedQuery(name = "Client.findByTelephoneclient", query = "SELECT c FROM Client c WHERE c.telephoneclient = :telephoneclient")
    , @NamedQuery(name = "Client.findByAdresseclient", query = "SELECT c FROM Client c WHERE c.adresseclient = :adresseclient")
    , @NamedQuery(name = "Client.findByEmailclient", query = "SELECT c FROM Client c WHERE c.emailclient = :emailclient")
    , @NamedQuery(name = "Client.findByUsername", query = "SELECT c FROM Client c WHERE c.username = :username")
    , @NamedQuery(name = "Client.findByPswd", query = "SELECT c FROM Client c WHERE c.pswd = :pswd")
    , @NamedQuery(name = "Client.auth", query = "SELECT c FROM Client c WHERE c.username = :username AND c.pswd = :pswd")
    , @NamedQuery(name = "Client.findByCni", query = "SELECT c FROM Client c WHERE c.cni = :cni")
    , @NamedQuery(name = "Client.findByNinea", query = "SELECT c FROM Client c WHERE c.ninea = :ninea")
    , @NamedQuery(name = "Client.findByRaisonsociale", query = "SELECT c FROM Client c WHERE c.raisonsociale = :raisonsociale")})
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idclient")
    private Integer idclient;
    @Basic(optional = false)
    @Column(name = "nomclient")
    private String nomclient;
    @Basic(optional = false)
    @Column(name = "prenomclient")
    private String prenomclient;
    @Basic(optional = false)
    @Column(name = "telephoneclient")
    private String telephoneclient;
    @Basic(optional = false)
    @Column(name = "adresseclient")
    private String adresseclient;
    @Basic(optional = false)
    @Column(name = "emailclient")
    private String emailclient;
    @Basic(optional = false)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @Column(name = "pswd")
    private String pswd;
    @Column(name = "cni")
    private String cni;
    @Column(name = "ninea")
    private String ninea;
    @Column(name = "raisonsociale")
    private String raisonsociale;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idclient")
    private List<Contrat> contratList;

    public Client() {
    }

    public Client(Integer idclient) {
        this.idclient = idclient;
    }

    public Client(Integer idclient, String nomclient, String prenomclient, String telephoneclient, String adresseclient, String emailclient, String username, String pswd) {
        this.idclient = idclient;
        this.nomclient = nomclient;
        this.prenomclient = prenomclient;
        this.telephoneclient = telephoneclient;
        this.adresseclient = adresseclient;
        this.emailclient = emailclient;
        this.username = username;
        this.pswd = pswd;
    }

    public Integer getIdclient() {
        return idclient;
    }

    public void setIdclient(Integer idclient) {
        this.idclient = idclient;
    }

    public String getNomclient() {
        return nomclient;
    }

    public void setNomclient(String nomclient) {
        this.nomclient = nomclient;
    }

    public String getPrenomclient() {
        return prenomclient;
    }

    public void setPrenomclient(String prenomclient) {
        this.prenomclient = prenomclient;
    }

    public String getTelephoneclient() {
        return telephoneclient;
    }

    public void setTelephoneclient(String telephoneclient) {
        this.telephoneclient = telephoneclient;
    }

    public String getAdresseclient() {
        return adresseclient;
    }

    public void setAdresseclient(String adresseclient) {
        this.adresseclient = adresseclient;
    }

    public String getEmailclient() {
        return emailclient;
    }

    public void setEmailclient(String emailclient) {
        this.emailclient = emailclient;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPswd() {
        return pswd;
    }

    public void setPswd(String pswd) {
        this.pswd = pswd;
    }

    public String getCni() {
        return cni;
    }

    public void setCni(String cni) {
        this.cni = cni;
    }

    public String getNinea() {
        return ninea;
    }

    public void setNinea(String ninea) {
        this.ninea = ninea;
    }

    public String getRaisonsociale() {
        return raisonsociale;
    }

    public void setRaisonsociale(String raisonsociale) {
        this.raisonsociale = raisonsociale;
    }

    @XmlTransient
    public List<Contrat> getContratList() {
        return contratList;
    }

    public void setContratList(List<Contrat> contratList) {
        this.contratList = contratList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idclient != null ? idclient.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        if ((this.idclient == null && other.idclient != null) || (this.idclient != null && !this.idclient.equals(other.idclient))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sn.modelsis.entities.Client[ idclient=" + idclient + " ]";
    }

}
