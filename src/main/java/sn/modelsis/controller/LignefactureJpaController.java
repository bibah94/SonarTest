/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.modelsis.controller;

import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import sn.modelsis.entities.Lignefacture;

/**
 *
 * @author SNNDIAYEH
 */
public class LignefactureJpaController extends GenericDAO<Lignefacture, Serializable> {

    private EntityManagerFactory emf;

    public LignefactureJpaController() {
        super(Lignefacture.class);
        this.emf = Persistence.createEntityManagerFactory("Geolocalisation");
    }

    public int getLignefactureCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Lignefacture> rt = cq.from(Lignefacture.class);
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
