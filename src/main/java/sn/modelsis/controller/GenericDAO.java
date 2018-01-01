/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.modelsis.controller;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author SNNDIAYEH
 * @param <T>
 * @param <PK>
 */
public abstract class GenericDAO<T, PK extends Serializable> {

    static final Logger log = Logger.getGlobal();

    protected abstract EntityManager getEntityManager();

    private final Class<T> instance;

    public GenericDAO(Class<T> instance) {
        this.instance = instance;
    }

    public boolean create(T t) {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            if (t.getClass().equals(instance)) {
                tx.begin();
                em.persist(t);
                tx.commit();
                return true;
            }
            return false;
        } catch (Exception e) {
            tx.rollback();
            log.severe(e.getMessage());
            return false;
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
    }

    public T read(PK id) {
        EntityManager em = getEntityManager();
        try {
            return (T) em.find(instance, id != null ? id : null);
        } catch (Exception e) {
            log.severe(e.getMessage());
            return null;
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
    }

    public boolean update(T t) {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            if (t.getClass().equals(instance)) {
                tx.begin();
                em.merge(t);
                tx.commit();
                return true;
            }
            return false;
        } catch (Exception e) {
            tx.rollback();
            log.severe(e.getMessage());
            return false;
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
    }

    public boolean delete(PK id) {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            T entity = em.merge(read(id));
            em.remove(entity);
            tx.commit();
            return true;
        } catch (Exception e) {
            tx.rollback();
            log.severe(e.getMessage());
            return false;
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
    }

    public boolean delete(T entity) {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            entity = em.merge(entity);
            em.remove(entity);
            tx.commit();
            return true;
        } catch (Exception e) {
            tx.rollback();
            log.severe(e.getMessage());
            return false;
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
    }

    public List<T> findAll() {
        CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(instance));
        return getEntityManager().createQuery(cq).getResultList();
    }

    public List<T> getList(String request, Map<String, String> map) {
        EntityManager em = getEntityManager();
        Query q = em.createNamedQuery(request);
        map.entrySet().forEach((entry) -> {
            q.setParameter(entry.getKey(), entry.getValue());
        });
        return (List<T>) q.getResultList();
    }

}
