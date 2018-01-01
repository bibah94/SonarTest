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
@Table(name = "typeincident", catalog = "geolocalisation", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Typeincident.findAll", query = "SELECT t FROM Typeincident t")
    , @NamedQuery(name = "Typeincident.findByIdtypeincident", query = "SELECT t FROM Typeincident t WHERE t.idtypeincident = :idtypeincident")
    , @NamedQuery(name = "Typeincident.findByLibelletypeincident", query = "SELECT t FROM Typeincident t WHERE t.libelletypeincident = :libelletypeincident")})
public class Typeincident implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtypeincident")
    private Short idtypeincident;
    @Basic(optional = false)
    @Column(name = "libelletypeincident")
    private String libelletypeincident;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtypeincident")
    private List<Incident> incidentList;

    public Typeincident() {
    }

    public Typeincident(Short idtypeincident) {
        this.idtypeincident = idtypeincident;
    }

    public Typeincident(Short idtypeincident, String libelletypeincident) {
        this.idtypeincident = idtypeincident;
        this.libelletypeincident = libelletypeincident;
    }

    public Short getIdtypeincident() {
        return idtypeincident;
    }

    public void setIdtypeincident(Short idtypeincident) {
        this.idtypeincident = idtypeincident;
    }

    public String getLibelletypeincident() {
        return libelletypeincident;
    }

    public void setLibelletypeincident(String libelletypeincident) {
        this.libelletypeincident = libelletypeincident;
    }

    @XmlTransient
    public List<Incident> getIncidentList() {
        return incidentList;
    }

    public void setIncidentList(List<Incident> incidentList) {
        this.incidentList = incidentList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtypeincident != null ? idtypeincident.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Typeincident)) {
            return false;
        }
        Typeincident other = (Typeincident) object;
        if ((this.idtypeincident == null && other.idtypeincident != null) || (this.idtypeincident != null && !this.idtypeincident.equals(other.idtypeincident))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sn.modelsis.entities.Typeincident[ idtypeincident=" + idtypeincident + " ]";
    }
    
}
