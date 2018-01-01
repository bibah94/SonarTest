/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.modelsis.controller;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import sn.modelsis.entities.Vehicule;

/**
 *
 * @author SNNDIAYEH
 */
public class VehiculeJpaController extends GenericDAO<Vehicule, Serializable> {

    private EntityManagerFactory emf;

    public VehiculeJpaController() {
        super(Vehicule.class);
        this.emf = Persistence.createEntityManagerFactory("Geolocalisation");
    }

    public int getVehiculeCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Vehicule> rt = cq.from(Vehicule.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    @Override
    protected EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public List<Vehicule> getVehiculeByMarque(String marque) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createNamedQuery("Vehicule.findByMarque")
                    .setParameter("marque", marque);
            return (List<Vehicule>) q.getResultList();
        } finally {
            em.close();
        }
    }

    public List<Vehicule> getVehiculeByModele(String modele) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createNamedQuery("Vehicule.findByModele")
                    .setParameter("modele", modele);
            return (List<Vehicule>) q.getResultList();
        } finally {
            em.close();
        }
    }

    public Vehicule getVehiculeByImmatriculation(String immatriculation) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createNamedQuery("Vehicule.findByImmatriculation")
                    .setParameter("immatriculation", immatriculation);
            return (Vehicule) q.getSingleResult();
        } finally {
            em.close();
        }

    }

    public Vehicule getVehiculeByChassis(String chassis) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createNamedQuery("Vehicule.findByChassis")
                    .setParameter("chassis", chassis);
            return (Vehicule) q.getSingleResult();
        } finally {
            em.close();
        }

    }
}
