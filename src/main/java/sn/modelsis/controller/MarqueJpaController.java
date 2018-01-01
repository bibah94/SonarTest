/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.modelsis.controller;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import sn.modelsis.entities.Marque;

/**
 *
 * @author SNNDIAYEH
 */
public class MarqueJpaController extends GenericDAO<Marque, Serializable> {

    public MarqueJpaController() {
        super(Marque.class);
        this.emf = Persistence.createEntityManagerFactory("Geolocalisation");
    }

    private EntityManagerFactory emf;

    public int getMarqueCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Marque> rt = cq.from(Marque.class);
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

}
