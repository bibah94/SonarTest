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
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import sn.modelsis.controller.exceptions.NonexistentEntityException;
import sn.modelsis.controller.exceptions.PreexistingEntityException;
import sn.modelsis.entities.Chauffeur;
import sn.modelsis.entities.Conduire;
import sn.modelsis.entities.ConduirePK;
import sn.modelsis.entities.Vehicule;

/**
 *
 * @author SNNDIAYEH
 */
public class ConduireJpaController implements Serializable {

    public ConduireJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Conduire conduire) throws PreexistingEntityException, Exception {
        if (conduire.getConduirePK() == null) {
            conduire.setConduirePK(new ConduirePK());
        }
        conduire.getConduirePK().setIdchauffeur(conduire.getChauffeur().getIdchauffeur());
        conduire.getConduirePK().setIdvehicule(conduire.getVehicule().getIdvehicule());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Chauffeur chauffeur = conduire.getChauffeur();
            if (chauffeur != null) {
                chauffeur = em.getReference(chauffeur.getClass(), chauffeur.getIdchauffeur());
                conduire.setChauffeur(chauffeur);
            }
            Vehicule vehicule = conduire.getVehicule();
            if (vehicule != null) {
                vehicule = em.getReference(vehicule.getClass(), vehicule.getIdvehicule());
                conduire.setVehicule(vehicule);
            }
            em.persist(conduire);
            if (chauffeur != null) {
                chauffeur.getConduireList().add(conduire);
                chauffeur = em.merge(chauffeur);
            }
            if (vehicule != null) {
                vehicule.getConduireList().add(conduire);
                vehicule = em.merge(vehicule);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findConduire(conduire.getConduirePK()) != null) {
                throw new PreexistingEntityException("Conduire " + conduire + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Conduire conduire) throws NonexistentEntityException, Exception {
        conduire.getConduirePK().setIdchauffeur(conduire.getChauffeur().getIdchauffeur());
        conduire.getConduirePK().setIdvehicule(conduire.getVehicule().getIdvehicule());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Conduire persistentConduire = em.find(Conduire.class, conduire.getConduirePK());
            Chauffeur chauffeurOld = persistentConduire.getChauffeur();
            Chauffeur chauffeurNew = conduire.getChauffeur();
            Vehicule vehiculeOld = persistentConduire.getVehicule();
            Vehicule vehiculeNew = conduire.getVehicule();
            if (chauffeurNew != null) {
                chauffeurNew = em.getReference(chauffeurNew.getClass(), chauffeurNew.getIdchauffeur());
                conduire.setChauffeur(chauffeurNew);
            }
            if (vehiculeNew != null) {
                vehiculeNew = em.getReference(vehiculeNew.getClass(), vehiculeNew.getIdvehicule());
                conduire.setVehicule(vehiculeNew);
            }
            conduire = em.merge(conduire);
            if (chauffeurOld != null && !chauffeurOld.equals(chauffeurNew)) {
                chauffeurOld.getConduireList().remove(conduire);
                chauffeurOld = em.merge(chauffeurOld);
            }
            if (chauffeurNew != null && !chauffeurNew.equals(chauffeurOld)) {
                chauffeurNew.getConduireList().add(conduire);
                chauffeurNew = em.merge(chauffeurNew);
            }
            if (vehiculeOld != null && !vehiculeOld.equals(vehiculeNew)) {
                vehiculeOld.getConduireList().remove(conduire);
                vehiculeOld = em.merge(vehiculeOld);
            }
            if (vehiculeNew != null && !vehiculeNew.equals(vehiculeOld)) {
                vehiculeNew.getConduireList().add(conduire);
                vehiculeNew = em.merge(vehiculeNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                ConduirePK id = conduire.getConduirePK();
                if (findConduire(id) == null) {
                    throw new NonexistentEntityException("The conduire with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(ConduirePK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Conduire conduire;
            try {
                conduire = em.getReference(Conduire.class, id);
                conduire.getConduirePK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The conduire with id " + id + " no longer exists.", enfe);
            }
            Chauffeur chauffeur = conduire.getChauffeur();
            if (chauffeur != null) {
                chauffeur.getConduireList().remove(conduire);
                chauffeur = em.merge(chauffeur);
            }
            Vehicule vehicule = conduire.getVehicule();
            if (vehicule != null) {
                vehicule.getConduireList().remove(conduire);
                vehicule = em.merge(vehicule);
            }
            em.remove(conduire);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Conduire> findConduireEntities() {
        return findConduireEntities(true, -1, -1);
    }

    public List<Conduire> findConduireEntities(int maxResults, int firstResult) {
        return findConduireEntities(false, maxResults, firstResult);
    }

    private List<Conduire> findConduireEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Conduire.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Conduire findConduire(ConduirePK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Conduire.class, id);
        } finally {
            em.close();
        }
    }

    public int getConduireCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Conduire> rt = cq.from(Conduire.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
