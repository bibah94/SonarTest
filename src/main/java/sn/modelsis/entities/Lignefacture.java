/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.modelsis.entities;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author SNNDIAYEH
 */
@Entity
@Table(name = "lignefacture", catalog = "geolocalisation", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lignefacture.findAll", query = "SELECT l FROM Lignefacture l")
    , @NamedQuery(name = "Lignefacture.findByIdlignefacture", query = "SELECT l FROM Lignefacture l WHERE l.idlignefacture = :idlignefacture")
    , @NamedQuery(name = "Lignefacture.findByQuantite", query = "SELECT l FROM Lignefacture l WHERE l.quantite = :quantite")
    , @NamedQuery(name = "Lignefacture.findByPrixunitaire", query = "SELECT l FROM Lignefacture l WHERE l.prixunitaire = :prixunitaire")
    , @NamedQuery(name = "Lignefacture.findByTotal", query = "SELECT l FROM Lignefacture l WHERE l.total = :total")
    , @NamedQuery(name = "Lignefacture.findByLibelle", query = "SELECT l FROM Lignefacture l WHERE l.libelle = :libelle")})
public class Lignefacture implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idlignefacture")
    private Short idlignefacture;
    @Basic(optional = false)
    @Column(name = "quantite")
    private int quantite;
    @Basic(optional = false)
    @Column(name = "prixunitaire")
    private float prixunitaire;
    @Basic(optional = false)
    @Column(name = "total")
    private float total;
    @Basic(optional = false)
    @Column(name = "libelle")
    private String libelle;
    @JoinColumn(name = "idfacture", referencedColumnName = "idfacture")
    @ManyToOne(optional = false)
    private Facture idfacture;

    public Lignefacture() {
    }

    public Lignefacture(Short idlignefacture) {
        this.idlignefacture = idlignefacture;
    }

    public Lignefacture(Short idlignefacture, int quantite, float prixunitaire, float total, String libelle) {
        this.idlignefacture = idlignefacture;
        this.quantite = quantite;
        this.prixunitaire = prixunitaire;
        this.total = total;
        this.libelle = libelle;
    }

    public Short getIdlignefacture() {
        return idlignefacture;
    }

    public void setIdlignefacture(Short idlignefacture) {
        this.idlignefacture = idlignefacture;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public float getPrixunitaire() {
        return prixunitaire;
    }

    public void setPrixunitaire(float prixunitaire) {
        this.prixunitaire = prixunitaire;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Facture getIdfacture() {
        return idfacture;
    }

    public void setIdfacture(Facture idfacture) {
        this.idfacture = idfacture;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idlignefacture != null ? idlignefacture.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lignefacture)) {
            return false;
        }
        Lignefacture other = (Lignefacture) object;
        if ((this.idlignefacture == null && other.idlignefacture != null) || (this.idlignefacture != null && !this.idlignefacture.equals(other.idlignefacture))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sn.modelsis.entities.Lignefacture[ idlignefacture=" + idlignefacture + " ]";
    }
    
}
