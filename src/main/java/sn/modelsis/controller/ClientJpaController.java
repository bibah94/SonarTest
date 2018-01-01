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
import sn.modelsis.entities.Balise;
import sn.modelsis.entities.Client;
import sn.modelsis.entities.Tracking;
import sn.modelsis.entities.Vehicule;

/**
 *
 * @author SNNDIAYEH
 */
public class ClientJpaController extends GenericDAO<Client, Serializable> {

    public ClientJpaController() {
        super(Client.class);
        this.emf = Persistence.createEntityManagerFactory("Geolocalisation");
    }

    private final EntityManagerFactory emf;

    public int getClientCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Client> rt = cq.from(Client.class);
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
    
    public Client login(String username, String pswd){
        EntityManager em = getEntityManager();
        try{
            Query q = em.createNamedQuery("Client.auth")
                    .setParameter("username", username)
                    .setParameter("pswd", pswd);
            return (Client)q.getSingleResult(); 
        }finally{
            em.close();
        }
    }
    
    public List<Tracking> getActual(int id){
        EntityManager em = getEntityManager();
        try{
            Query q = em.createNamedQuery("Concerner.getActual")
                    .setParameter("idclient", id);
            return (List<Tracking>) q.getResultList();
        }finally{
            em.close();
        }
    }

}
