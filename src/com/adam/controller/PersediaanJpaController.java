/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.adam.controller;

import aplikasigas.exceptions.NonexistentEntityException;
import aplikasigas.exceptions.PreexistingEntityException;
import com.adam.model.Persediaan;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author saddam
 */
public class PersediaanJpaController implements Serializable {

    public PersediaanJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Persediaan persediaan) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(persediaan);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPersediaan(persediaan.getIdPrsd()) != null) {
                throw new PreexistingEntityException("Persediaan " + persediaan + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Persediaan persediaan) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            persediaan = em.merge(persediaan);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = persediaan.getIdPrsd();
                if (findPersediaan(id) == null) {
                    throw new NonexistentEntityException("The persediaan with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Persediaan persediaan;
            try {
                persediaan = em.getReference(Persediaan.class, id);
                persediaan.getIdPrsd();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The persediaan with id " + id + " no longer exists.", enfe);
            }
            em.remove(persediaan);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Persediaan> findPersediaanEntities() {
        return findPersediaanEntities(true, -1, -1);
    }

    public List<Persediaan> findPersediaanEntities(int maxResults, int firstResult) {
        return findPersediaanEntities(false, maxResults, firstResult);
    }

    private List<Persediaan> findPersediaanEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Persediaan.class));
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

    public Persediaan findPersediaan(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Persediaan.class, id);
        } finally {
            em.close();
        }
    }

    public int getPersediaanCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Persediaan> rt = cq.from(Persediaan.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
