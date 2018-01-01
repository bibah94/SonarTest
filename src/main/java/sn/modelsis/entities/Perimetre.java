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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "perimetre", catalog = "geolocalisation", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Perimetre.findAll", query = "SELECT p FROM Perimetre p")
    , @NamedQuery(name = "Perimetre.findByIdperimetre", query = "SELECT p FROM Perimetre p WHERE p.idperimetre = :idperimetre")
    , @NamedQuery(name = "Perimetre.findByNomperimetre", query = "SELECT p FROM Perimetre p WHERE p.nomperimetre = :nomperimetre")})
public class Perimetre implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idperimetre")
    private Integer idperimetre;
    @Basic(optional = false)
    @Column(name = "nomperimetre")
    private String nomperimetre;
    @JoinTable(name = "rattacher", joinColumns = {
        @JoinColumn(name = "idperimetre", referencedColumnName = "idperimetre")}, inverseJoinColumns = {
        @JoinColumn(name = "idpoint", referencedColumnName = "idpoint")})
    @ManyToMany
    private List<Point> pointList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "perimetre")
    private List<Notification> notificationList;

    public Perimetre() {
    }

    public Perimetre(Integer idperimetre) {
        this.idperimetre = idperimetre;
    }

    public Perimetre(Integer idperimetre, String nomperimetre) {
        this.idperimetre = idperimetre;
        this.nomperimetre = nomperimetre;
    }

    public Integer getIdperimetre() {
        return idperimetre;
    }

    public void setIdperimetre(Integer idperimetre) {
        this.idperimetre = idperimetre;
    }

    public String getNomperimetre() {
        return nomperimetre;
    }

    public void setNomperimetre(String nomperimetre) {
        this.nomperimetre = nomperimetre;
    }

    @XmlTransient
    public List<Point> getPointList() {
        return pointList;
    }

    public void setPointList(List<Point> pointList) {
        this.pointList = pointList;
    }

    @XmlTransient
    public List<Notification> getNotificationList() {
        return notificationList;
    }

    public void setNotificationList(List<Notification> notificationList) {
        this.notificationList = notificationList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idperimetre != null ? idperimetre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Perimetre)) {
            return false;
        }
        Perimetre other = (Perimetre) object;
        if ((this.idperimetre == null && other.idperimetre != null) || (this.idperimetre != null && !this.idperimetre.equals(other.idperimetre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sn.modelsis.entities.Perimetre[ idperimetre=" + idperimetre + " ]";
    }
    
}
