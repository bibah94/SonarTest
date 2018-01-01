/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.modelsis.controller;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import sn.modelsis.entities.Tracking;

/**
 *
 * @author SNNDIAYEH
 */
public class TrackingJpaController extends GenericDAO<Tracking, Serializable> {

    public TrackingJpaController() {
        super(Tracking.class);
        this.emf = Persistence.createEntityManagerFactory("Geolocalisation");
    }

    private EntityManagerFactory emf;

    public int getTrackingCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Tracking> rt = cq.from(Tracking.class);
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

    public List<Tracking> getHistory(int id) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createNamedQuery("Tracking.findHistory")
                    .setParameter("id", id);
            return (List<Tracking>) q.getResultList();
        } finally {
            em.close();
        }
    }

    public List<Tracking> getActualPosition(int id) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createNamedQuery("Tracking.findActualPosition")
                    .setParameter("id", id);
            return (List<Tracking>) q.setMaxResults(1).getResultList();
        } finally {
            em.close();
        }
    }
    
    public List<Tracking> getContrat(int d){
        EntityManager em = getEntityManager();
        try{
            Query q = em.createNamedQuery("Tracking.findContrat")
                    .setParameter("id", d);
            return (List<Tracking>) q.getResultList();
        }finally{
            em.close();
        }
    }

}
