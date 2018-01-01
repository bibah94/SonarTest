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
@Table(name = "typecontrat", catalog = "geolocalisation", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Typecontrat.findAll", query = "SELECT t FROM Typecontrat t")
    , @NamedQuery(name = "Typecontrat.findByIdtypecontrat", query = "SELECT t FROM Typecontrat t WHERE t.idtypecontrat = :idtypecontrat")
    , @NamedQuery(name = "Typecontrat.findByLibelletypecontrat", query = "SELECT t FROM Typecontrat t WHERE t.libelletypecontrat = :libelletypecontrat")
    , @NamedQuery(name = "Typecontrat.findByGps", query = "SELECT t FROM Typecontrat t WHERE t.gps = :gps")
    , @NamedQuery(name = "Typecontrat.findByNotificationzone", query = "SELECT t FROM Typecontrat t WHERE t.notificationzone = :notificationzone")
    , @NamedQuery(name = "Typecontrat.findByJaugecarburant", query = "SELECT t FROM Typecontrat t WHERE t.jaugecarburant = :jaugecarburant")})
public class Typecontrat implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtypecontrat")
    private Short idtypecontrat;
    @Column(name = "libelletypecontrat")
    private String libelletypecontrat;
    @Column(name = "gps")
    private Boolean gps;
    @Column(name = "notificationzone")
    private Boolean notificationzone;
    @Column(name = "jaugecarburant")
    private Boolean jaugecarburant;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtypecontrat")
    private List<Contrat> contratList;

    public Typecontrat() {
    }

    public Typecontrat(Short idtypecontrat) {
        this.idtypecontrat = idtypecontrat;
    }

    public Short getIdtypecontrat() {
        return idtypecontrat;
    }

    public void setIdtypecontrat(Short idtypecontrat) {
        this.idtypecontrat = idtypecontrat;
    }

    public String getLibelletypecontrat() {
        return libelletypecontrat;
    }

    public void setLibelletypecontrat(String libelletypecontrat) {
        this.libelletypecontrat = libelletypecontrat;
    }

    public Boolean getGps() {
        return gps;
    }

    public void setGps(Boolean gps) {
        this.gps = gps;
    }

    public Boolean getNotificationzone() {
        return notificationzone;
    }

    public void setNotificationzone(Boolean notificationzone) {
        this.notificationzone = notificationzone;
    }

    public Boolean getJaugecarburant() {
        return jaugecarburant;
    }

    public void setJaugecarburant(Boolean jaugecarburant) {
        this.jaugecarburant = jaugecarburant;
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
        hash += (idtypecontrat != null ? idtypecontrat.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Typecontrat)) {
            return false;
        }
        Typecontrat other = (Typecontrat) object;
        if ((this.idtypecontrat == null && other.idtypecontrat != null) || (this.idtypecontrat != null && !this.idtypecontrat.equals(other.idtypecontrat))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sn.modelsis.entities.Typecontrat[ idtypecontrat=" + idtypecontrat + " ]";
    }
    
}
