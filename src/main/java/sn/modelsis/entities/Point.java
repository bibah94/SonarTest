/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.modelsis.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author SNNDIAYEH
 */
@Entity
@Table(name = "point", catalog = "geolocalisation", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Point.findAll", query = "SELECT p FROM Point p")
    , @NamedQuery(name = "Point.findByIdpoint", query = "SELECT p FROM Point p WHERE p.idpoint = :idpoint")
    , @NamedQuery(name = "Point.findByLatitudepoint", query = "SELECT p FROM Point p WHERE p.latitudepoint = :latitudepoint")
    , @NamedQuery(name = "Point.findByLongitudepoint", query = "SELECT p FROM Point p WHERE p.longitudepoint = :longitudepoint")
    , @NamedQuery(name = "Point.findByOrdre", query = "SELECT p FROM Point p WHERE p.ordre = :ordre")})
public class Point implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpoint")
    private Integer idpoint;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "latitudepoint")
    private BigDecimal latitudepoint;
    @Basic(optional = false)
    @Column(name = "longitudepoint")
    private BigDecimal longitudepoint;
    @Basic(optional = false)
    @Column(name = "ordre")
    private int ordre;
    @ManyToMany(mappedBy = "pointList")
    private List<Perimetre> perimetreList;

    public Point() {
    }

    public Point(Integer idpoint) {
        this.idpoint = idpoint;
    }

    public Point(Integer idpoint, BigDecimal latitudepoint, BigDecimal longitudepoint, int ordre) {
        this.idpoint = idpoint;
        this.latitudepoint = latitudepoint;
        this.longitudepoint = longitudepoint;
        this.ordre = ordre;
    }

    public Integer getIdpoint() {
        return idpoint;
    }

    public void setIdpoint(Integer idpoint) {
        this.idpoint = idpoint;
    }

    public BigDecimal getLatitudepoint() {
        return latitudepoint;
    }

    public void setLatitudepoint(BigDecimal latitudepoint) {
        this.latitudepoint = latitudepoint;
    }

    public BigDecimal getLongitudepoint() {
        return longitudepoint;
    }

    public void setLongitudepoint(BigDecimal longitudepoint) {
        this.longitudepoint = longitudepoint;
    }

    public int getOrdre() {
        return ordre;
    }

    public void setOrdre(int ordre) {
        this.ordre = ordre;
    }

    @XmlTransient
    public List<Perimetre> getPerimetreList() {
        return perimetreList;
    }

    public void setPerimetreList(List<Perimetre> perimetreList) {
        this.perimetreList = perimetreList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpoint != null ? idpoint.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Point)) {
            return false;
        }
        Point other = (Point) object;
        if ((this.idpoint == null && other.idpoint != null) || (this.idpoint != null && !this.idpoint.equals(other.idpoint))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sn.modelsis.entities.Point[ idpoint=" + idpoint + " ]";
    }
    
}
