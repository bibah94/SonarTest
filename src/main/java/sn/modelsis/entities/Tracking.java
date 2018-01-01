/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.modelsis.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "tracking", catalog = "geolocalisation", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tracking.findAll", query = "SELECT t FROM Tracking t")
    , @NamedQuery(name = "Tracking.findByIdtracking", query = "SELECT t FROM Tracking t WHERE t.idtracking = :idtracking")
    , @NamedQuery(name = "Tracking.findByLibelletracking", query = "SELECT t FROM Tracking t WHERE t.libelletracking = :libelletracking")
    , @NamedQuery(name = "Tracking.findByLatitude", query = "SELECT t FROM Tracking t WHERE t.latitude = :latitude")
    , @NamedQuery(name = "Tracking.findByLongitude", query = "SELECT t FROM Tracking t WHERE t.longitude = :longitude")
    , @NamedQuery(name = "Tracking.findByAltitude", query = "SELECT t FROM Tracking t WHERE t.altitude = :altitude")
    , @NamedQuery(name = "Tracking.findByVitesse", query = "SELECT t FROM Tracking t WHERE t.vitesse = :vitesse")
    , @NamedQuery(name = "Tracking.findContrat", query = "SELECT DISTINCT(t) FROM Concerner c, Balise b, Vehicule v, Contrat co, Client cl, Tracking t WHERE c.contrat = co AND c.vehicule = v AND c.balise = b AND co.idclient = cl AND t.idbalise = b AND c.concernerPK.idcontrat = co.idcontrat AND cl.idclient = :id ORDER BY t.idtracking DESC")
    , @NamedQuery(name = "Tracking.findHistory", query = "SELECT t FROM Tracking t, Balise b WHERE t.idbalise = b AND b.idbalise = :id")
    , @NamedQuery(name = "Tracking.findActualPosition", query = "SELECT t FROM Tracking t, Balise b WHERE t.idbalise = b AND b.idbalise = :id ORDER BY t.idtracking DESC")
    , @NamedQuery(name = "Tracking.findByDateheure", query = "SELECT t FROM Tracking t WHERE t.dateheure = :dateheure")})
public class Tracking implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtracking")
    private Integer idtracking;
    @Column(name = "libelletracking")
    private String libelletracking;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "latitude")
    private BigDecimal latitude;
    @Basic(optional = false)
    @Column(name = "longitude")
    private BigDecimal longitude;
    @Column(name = "altitude")
    private Integer altitude;
    @Column(name = "vitesse")
    private Integer vitesse;
    @Column(name = "dateheure")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateheure;
    @JoinColumn(name = "idbalise", referencedColumnName = "idbalise")
    @ManyToOne(optional = false)
    private Balise idbalise;

    public Tracking() {
    }

    public Tracking(Integer idtracking) {
        this.idtracking = idtracking;
    }

    public Tracking(Integer idtracking, BigDecimal latitude, BigDecimal longitude) {
        this.idtracking = idtracking;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Integer getIdtracking() {
        return idtracking;
    }

    public void setIdtracking(Integer idtracking) {
        this.idtracking = idtracking;
    }

    public String getLibelletracking() {
        return libelletracking;
    }

    public void setLibelletracking(String libelletracking) {
        this.libelletracking = libelletracking;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public Integer getAltitude() {
        return altitude;
    }

    public void setAltitude(Integer altitude) {
        this.altitude = altitude;
    }

    public Integer getVitesse() {
        return vitesse;
    }

    public void setVitesse(Integer vitesse) {
        this.vitesse = vitesse;
    }

    public Date getDateheure() {
        return dateheure;
    }

    public void setDateheure(Date dateheure) {
        this.dateheure = dateheure;
    }

    public Balise getIdbalise() {
        return idbalise;
    }

    public void setIdbalise(Balise idbalise) {
        this.idbalise = idbalise;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtracking != null ? idtracking.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tracking)) {
            return false;
        }
        Tracking other = (Tracking) object;
        if ((this.idtracking == null && other.idtracking != null) || (this.idtracking != null && !this.idtracking.equals(other.idtracking))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sn.modelsis.entities.Tracking[ idtracking=" + idtracking + " ]";
    }

}
