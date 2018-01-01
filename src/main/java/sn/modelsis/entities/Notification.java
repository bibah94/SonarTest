/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.modelsis.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author SNNDIAYEH
 */
@Entity
@Table(name = "notification", catalog = "geolocalisation", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Notification.findAll", query = "SELECT n FROM Notification n")
    , @NamedQuery(name = "Notification.findByIdvehicule", query = "SELECT n FROM Notification n WHERE n.notificationPK.idvehicule = :idvehicule")
    , @NamedQuery(name = "Notification.findByIdperimetre", query = "SELECT n FROM Notification n WHERE n.notificationPK.idperimetre = :idperimetre")
    , @NamedQuery(name = "Notification.findByIdincident", query = "SELECT n FROM Notification n WHERE n.notificationPK.idincident = :idincident")
    , @NamedQuery(name = "Notification.findByDatenotification", query = "SELECT n FROM Notification n WHERE n.datenotification = :datenotification")})
public class Notification implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected NotificationPK notificationPK;
    @Column(name = "datenotification")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datenotification;
    @JoinColumn(name = "idincident", referencedColumnName = "idincident", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Incident incident;
    @JoinColumn(name = "idperimetre", referencedColumnName = "idperimetre", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Perimetre perimetre;
    @JoinColumn(name = "idvehicule", referencedColumnName = "idvehicule", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Vehicule vehicule;

    public Notification() {
    }

    public Notification(NotificationPK notificationPK) {
        this.notificationPK = notificationPK;
    }

    public Notification(int idvehicule, int idperimetre, int idincident) {
        this.notificationPK = new NotificationPK(idvehicule, idperimetre, idincident);
    }

    public NotificationPK getNotificationPK() {
        return notificationPK;
    }

    public void setNotificationPK(NotificationPK notificationPK) {
        this.notificationPK = notificationPK;
    }

    public Date getDatenotification() {
        return datenotification;
    }

    public void setDatenotification(Date datenotification) {
        this.datenotification = datenotification;
    }

    public Incident getIncident() {
        return incident;
    }

    public void setIncident(Incident incident) {
        this.incident = incident;
    }

    public Perimetre getPerimetre() {
        return perimetre;
    }

    public void setPerimetre(Perimetre perimetre) {
        this.perimetre = perimetre;
    }

    public Vehicule getVehicule() {
        return vehicule;
    }

    public void setVehicule(Vehicule vehicule) {
        this.vehicule = vehicule;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (notificationPK != null ? notificationPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Notification)) {
            return false;
        }
        Notification other = (Notification) object;
        if ((this.notificationPK == null && other.notificationPK != null) || (this.notificationPK != null && !this.notificationPK.equals(other.notificationPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sn.modelsis.entities.Notification[ notificationPK=" + notificationPK + " ]";
    }
    
}
