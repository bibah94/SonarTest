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
@Table(name = "facture", catalog = "geolocalisation", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Facture.findAll", query = "SELECT f FROM Facture f")
    , @NamedQuery(name = "Facture.findByIdfacture", query = "SELECT f FROM Facture f WHERE f.idfacture = :idfacture")
    , @NamedQuery(name = "Facture.findByMontanttotal", query = "SELECT f FROM Facture f WHERE f.montanttotal = :montanttotal")
    , @NamedQuery(name = "Facture.findByModepaiement", query = "SELECT f FROM Facture f WHERE f.modepaiement = :modepaiement")
    , @NamedQuery(name = "Facture.findByDatepaiement", query = "SELECT f FROM Facture f WHERE f.datepaiement = :datepaiement")
    , @NamedQuery(name = "Facture.findByRemise", query = "SELECT f FROM Facture f WHERE f.remise = :remise")
    , @NamedQuery(name = "Facture.findByTva", query = "SELECT f FROM Facture f WHERE f.tva = :tva")})
public class Facture implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idfacture")
    private Integer idfacture;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "montanttotal")
    private Float montanttotal;
    @Column(name = "modepaiement")
    private String modepaiement;
    @Column(name = "datepaiement")
    @Temporal(TemporalType.DATE)
    private Date datepaiement;
    @Column(name = "remise")
    private Float remise;
    @Column(name = "tva")
    private Float tva;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idfacture")
    private List<Lignefacture> lignefactureList;
    @JoinColumn(name = "idcontrat", referencedColumnName = "idcontrat")
    @ManyToOne(optional = false)
    private Contrat idcontrat;

    public Facture() {
    }

    public Facture(Integer idfacture) {
        this.idfacture = idfacture;
    }

    public Integer getIdfacture() {
        return idfacture;
    }

    public void setIdfacture(Integer idfacture) {
        this.idfacture = idfacture;
    }

    public Float getMontanttotal() {
        return montanttotal;
    }

    public void setMontanttotal(Float montanttotal) {
        this.montanttotal = montanttotal;
    }

    public String getModepaiement() {
        return modepaiement;
    }

    public void setModepaiement(String modepaiement) {
        this.modepaiement = modepaiement;
    }

    public Date getDatepaiement() {
        return datepaiement;
    }

    public void setDatepaiement(Date datepaiement) {
        this.datepaiement = datepaiement;
    }

    public Float getRemise() {
        return remise;
    }

    public void setRemise(Float remise) {
        this.remise = remise;
    }

    public Float getTva() {
        return tva;
    }

    public void setTva(Float tva) {
        this.tva = tva;
    }

    @XmlTransient
    public List<Lignefacture> getLignefactureList() {
        return lignefactureList;
    }

    public void setLignefactureList(List<Lignefacture> lignefactureList) {
        this.lignefactureList = lignefactureList;
    }

    public Contrat getIdcontrat() {
        return idcontrat;
    }

    public void setIdcontrat(Contrat idcontrat) {
        this.idcontrat = idcontrat;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfacture != null ? idfacture.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Facture)) {
            return false;
        }
        Facture other = (Facture) object;
        if ((this.idfacture == null && other.idfacture != null) || (this.idfacture != null && !this.idfacture.equals(other.idfacture))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sn.modelsis.entities.Facture[ idfacture=" + idfacture + " ]";
    }
    
}
