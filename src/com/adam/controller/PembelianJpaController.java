/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.adam.controller;

import aplikasigas.exceptions.NonexistentEntityException;
import com.adam.model.Pembelian;
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
public class PembelianJpaController implements Serializable {

    public PembelianJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Pembelian pembelian) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(pembelian);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Pembelian pembelian) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            pembelian = em.merge(pembelian);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = pembelian.getIdPbl();
                if (findPembelian(id) == null) {
                    throw new NonexistentEntityException("The pembelian with id " + id + " no longer exists.");
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
            Pembelian pembelian;
            try {
                pembelian = em.getReference(Pembelian.class, id);
                pembelian.getIdPbl();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The pembelian with id " + id + " no longer exists.", enfe);
            }
            em.remove(pembelian);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Pembelian> findPembelianEntities() {
        return findPembelianEntities(true, -1, -1);
    }

    public List<Pembelian> findPembelianEntities(int maxResults, int firstResult) {
        return findPembelianEntities(false, maxResults, firstResult);
    }

    private List<Pembelian> findPembelianEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Pembelian.class));
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

    public Pembelian findPembelian(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Pembelian.class, id);
        } finally {
            em.close();
        }
    }

    public int getPembelianCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Pembelian> rt = cq.from(Pembelian.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
