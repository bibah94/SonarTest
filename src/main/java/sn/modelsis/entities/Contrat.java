/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.modelsis.entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author SNNDIAYEH
 */
@Entity
@Table(name = "contrat", catalog = "geolocalisation", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contrat.findAll", query = "SELECT c FROM Contrat c")
    , @NamedQuery(name = "Contrat.findByIdcontrat", query = "SELECT c FROM Contrat c WHERE c.idcontrat = :idcontrat")
    , @NamedQuery(name = "Contrat.findByClient", query = "SELECT c FROM Contrat c, Client cl WHERE c.idclient = cl AND cl.cni = :cni")
    , @NamedQuery(name = "Contrat.findByDatedebutcontrat", query = "SELECT c FROM Contrat c WHERE c.datedebutcontrat = :datedebutcontrat")
    , @NamedQuery(name = "Contrat.findByDatefincontrat", query = "SELECT c FROM Contrat c WHERE c.datefincontrat = :datefincontrat")
    , @NamedQuery(name = "Contrat.findByBaliseapporte", query = "SELECT c FROM Contrat c WHERE c.baliseapporte = :baliseapporte")
    , @NamedQuery(name = "Contrat.findByFrequenceenvoi", query = "SELECT c FROM Contrat c WHERE c.frequenceenvoi = :frequenceenvoi")})
public class Contrat implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcontrat")
    private Integer idcontrat;
    @Column(name = "datedebutcontrat")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datedebutcontrat;
    @Column(name = "datefincontrat")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datefincontrat;
    @Column(name = "baliseapporte")
    private Integer baliseapporte;
    @Column(name = "frequenceenvoi")
    private Integer frequenceenvoi;
    @JoinColumn(name = "idclient", referencedColumnName = "idclient")
    @ManyToOne(optional = false)
    private Client idclient;
    @JoinColumn(name = "idtypecontrat", referencedColumnName = "idtypecontrat")
    @ManyToOne(optional = false)
    private Typecontrat idtypecontrat;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contrat")
    private List<Concerner> concernerList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcontrat")
    private List<Facture> factureList;

    public Contrat() {
    }

    public Contrat(Integer idcontrat) {
        this.idcontrat = idcontrat;
    }

    public Integer getIdcontrat() {
        return idcontrat;
    }

    public void setIdcontrat(Integer idcontrat) {
        this.idcontrat = idcontrat;
    }

    public Date getDatedebutcontrat() {
        return datedebutcontrat;
    }

    public void setDatedebutcontrat(Date datedebutcontrat) {
        this.datedebutcontrat = datedebutcontrat;
    }

    public Date getDatefincontrat() {
        return datefincontrat;
    }

    public void setDatefincontrat(Date datefincontrat) {
        this.datefincontrat = datefincontrat;
    }

    public Integer getBaliseapporte() {
        return baliseapporte;
    }

    public void setBaliseapporte(Integer baliseapporte) {
        this.baliseapporte = baliseapporte;
    }

    public Integer getFrequenceenvoi() {
        return frequenceenvoi;
    }

    public void setFrequenceenvoi(Integer frequenceenvoi) {
        this.frequenceenvoi = frequenceenvoi;
    }

    public Client getIdclient() {
        return idclient;
    }

    public void setIdclient(Client idclient) {
        this.idclient = idclient;
    }

    public Typecontrat getIdtypecontrat() {
        return idtypecontrat;
    }

    public void setIdtypecontrat(Typecontrat idtypecontrat) {
        this.idtypecontrat = idtypecontrat;
    }

    @XmlTransient
    public List<Concerner> getConcernerList() {
        return concernerList;
    }

    public void setConcernerList(List<Concerner> concernerList) {
        this.concernerList = concernerList;
    }

    @XmlTransient
    public List<Facture> getFactureList() {
        return factureList;
    }

    public void setFactureList(List<Facture> factureList) {
        this.factureList = factureList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcontrat != null ? idcontrat.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contrat)) {
            return false;
        }
        Contrat other = (Contrat) object;
        if ((this.idcontrat == null && other.idcontrat != null) || (this.idcontrat != null && !this.idcontrat.equals(other.idcontrat))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sn.modelsis.entities.Contrat[ idcontrat=" + idcontrat + " ]";
    }

}
