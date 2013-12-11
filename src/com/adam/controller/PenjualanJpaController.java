/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.adam.controller;

import com.adam.controller.exceptions.NonexistentEntityException;
import com.adam.model.Penjualan;
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
public class PenjualanJpaController implements Serializable {

    public PenjualanJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Penjualan penjualan) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(penjualan);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Penjualan penjualan) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            penjualan = em.merge(penjualan);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = penjualan.getIdTrskPjl();
                if (findPenjualan(id) == null) {
                    throw new NonexistentEntityException("The penjualan with id " + id + " no longer exists.");
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
            Penjualan penjualan;
            try {
                penjualan = em.getReference(Penjualan.class, id);
                penjualan.getIdTrskPjl();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The penjualan with id " + id + " no longer exists.", enfe);
            }
            em.remove(penjualan);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Penjualan> findPenjualanEntities() {
        return findPenjualanEntities(true, -1, -1);
    }

    public List<Penjualan> findPenjualanEntities(int maxResults, int firstResult) {
        return findPenjualanEntities(false, maxResults, firstResult);
    }

    private List<Penjualan> findPenjualanEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Penjualan.class));
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

    public Penjualan findPenjualan(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Penjualan.class, id);
        } finally {
            em.close();
        }
    }

    public int getPenjualanCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Penjualan> rt = cq.from(Penjualan.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
