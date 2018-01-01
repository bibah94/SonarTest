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
@Table(name = "incident", catalog = "geolocalisation", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Incident.findAll", query = "SELECT i FROM Incident i")
    , @NamedQuery(name = "Incident.findByIdincident", query = "SELECT i FROM Incident i WHERE i.idincident = :idincident")
    , @NamedQuery(name = "Incident.findByLibelleincident", query = "SELECT i FROM Incident i WHERE i.libelleincident = :libelleincident")
    , @NamedQuery(name = "Incident.findByDescriptionincident", query = "SELECT i FROM Incident i WHERE i.descriptionincident = :descriptionincident")})
public class Incident implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idincident")
    private Integer idincident;
    @Basic(optional = false)
    @Column(name = "libelleincident")
    private String libelleincident;
    @Column(name = "descriptionincident")
    private String descriptionincident;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "incident")
    private List<Notification> notificationList;
    @JoinColumn(name = "idtypeincident", referencedColumnName = "idtypeincident")
    @ManyToOne(optional = false)
    private Typeincident idtypeincident;

    public Incident() {
    }

    public Incident(Integer idincident) {
        this.idincident = idincident;
    }

    public Incident(Integer idincident, String libelleincident) {
        this.idincident = idincident;
        this.libelleincident = libelleincident;
    }

    public Integer getIdincident() {
        return idincident;
    }

    public void setIdincident(Integer idincident) {
        this.idincident = idincident;
    }

    public String getLibelleincident() {
        return libelleincident;
    }

    public void setLibelleincident(String libelleincident) {
        this.libelleincident = libelleincident;
    }

    public String getDescriptionincident() {
        return descriptionincident;
    }

    public void setDescriptionincident(String descriptionincident) {
        this.descriptionincident = descriptionincident;
    }

    @XmlTransient
    public List<Notification> getNotificationList() {
        return notificationList;
    }

    public void setNotificationList(List<Notification> notificationList) {
        this.notificationList = notificationList;
    }

    public Typeincident getIdtypeincident() {
        return idtypeincident;
    }

    public void setIdtypeincident(Typeincident idtypeincident) {
        this.idtypeincident = idtypeincident;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idincident != null ? idincident.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Incident)) {
            return false;
        }
        Incident other = (Incident) object;
        if ((this.idincident == null && other.idincident != null) || (this.idincident != null && !this.idincident.equals(other.idincident))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sn.modelsis.entities.Incident[ idincident=" + idincident + " ]";
    }
    
}
