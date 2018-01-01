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
import sn.modelsis.entities.Concerner;

/**
 *
 * @author SNNDIAYEH
 */
public class ConcernerJpaController extends GenericDAO<Concerner, Serializable> {

    private final EntityManagerFactory emf;

    public ConcernerJpaController() {
        super(Concerner.class);
        this.emf = Persistence.createEntityManagerFactory("Geolocalisation");
    }

    public int getConcernerCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Concerner> rt = cq.from(Concerner.class);
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
    
    public List<Concerner> getConcernerContrat(int id){
        EntityManager em = getEntityManager();
        try{
            Query q = em.createNamedQuery("Concerner.findByIdcontrat")
                    .setParameter("idcontrat", id);
            return (List<Concerner>) q.getResultList();
        }finally{
            em.close();
        }
    }
    
    public List<Concerner> getContrat(int d){
        EntityManager em = getEntityManager();
        try{
            Query q = em.createNamedQuery("Concerner.findContrat")
                    .setParameter("id", d);
            return (List<Concerner>) q.getResultList();
        }finally{
            em.close();
        }
    }

}
