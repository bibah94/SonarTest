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
import sn.modelsis.entities.Contrat;

/**
 *
 * @author SNNDIAYEH
 */
public class ContratJpaController extends GenericDAO<Contrat, Serializable> {

    public ContratJpaController() {
        super(Contrat.class);
        this.emf = Persistence.createEntityManagerFactory("Geolocalisation");
    }

    private EntityManagerFactory emf;

    public int getContratCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Contrat> rt = cq.from(Contrat.class);
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
    
    public List<Contrat> getContrat(String cni){
        EntityManager em = getEntityManager();
        try{
            Query q = em.createNamedQuery("Contrat.findByClient")
                    .setParameter("cni", cni);
            return (List<Contrat>) q.getResultList();
        }finally{
            em.close();
        }
    }

}
