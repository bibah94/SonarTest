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
import sn.modelsis.entities.Perimetre;

/**
 *
 * @author SNNDIAYEH
 */
public class PerimetreJpaController extends GenericDAO<Perimetre, Serializable> {

    public PerimetreJpaController() {
        super(Perimetre.class);
        this.emf = Persistence.createEntityManagerFactory("Geolocalisation");
    }

    private EntityManagerFactory emf;

    public int getPerimetreCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Perimetre> rt = cq.from(Perimetre.class);
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
