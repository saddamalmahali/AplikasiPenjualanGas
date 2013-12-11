/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.adam.controller;

import aplikasigas.exceptions.NonexistentEntityException;
import aplikasigas.exceptions.PreexistingEntityException;
import com.adam.model.Setting;
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
public class SettingJpaController implements Serializable {

    public SettingJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Setting setting) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(setting);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findSetting(setting.getIdStg()) != null) {
                throw new PreexistingEntityException("Setting " + setting + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Setting setting) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            setting = em.merge(setting);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = setting.getIdStg();
                if (findSetting(id) == null) {
                    throw new NonexistentEntityException("The setting with id " + id + " no longer exists.");
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
            Setting setting;
            try {
                setting = em.getReference(Setting.class, id);
                setting.getIdStg();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The setting with id " + id + " no longer exists.", enfe);
            }
            em.remove(setting);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Setting> findSettingEntities() {
        return findSettingEntities(true, -1, -1);
    }

    public List<Setting> findSettingEntities(int maxResults, int firstResult) {
        return findSettingEntities(false, maxResults, firstResult);
    }

    private List<Setting> findSettingEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Setting.class));
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

    public Setting findSetting(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Setting.class, id);
        } finally {
            em.close();
        }
    }

    public int getSettingCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Setting> rt = cq.from(Setting.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
