/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import persistencia.ComandaItens;
import persistencia.Comandas;
import persistencia.Produtos;

/**
 *
 * @author sala308b
 */
public class ComandaItensJpaController implements Serializable {

    public ComandaItensJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ComandaItens comandaItens) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Comandas comandaId = comandaItens.getComandaId();
            if (comandaId != null) {
                comandaId = em.getReference(comandaId.getClass(), comandaId.getComandaId());
                comandaItens.setComandaId(comandaId);
            }
            Produtos produtoId = comandaItens.getProdutoId();
            if (produtoId != null) {
                produtoId = em.getReference(produtoId.getClass(), produtoId.getProdutoId());
                comandaItens.setProdutoId(produtoId);
            }
            em.persist(comandaItens);
            if (comandaId != null) {
                comandaId.getComandaItensCollection().add(comandaItens);
                comandaId = em.merge(comandaId);
            }
            if (produtoId != null) {
                produtoId.getComandaItensCollection().add(comandaItens);
                produtoId = em.merge(produtoId);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ComandaItens comandaItens) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ComandaItens persistentComandaItens = em.find(ComandaItens.class, comandaItens.getItemId());
            Comandas comandaIdOld = persistentComandaItens.getComandaId();
            Comandas comandaIdNew = comandaItens.getComandaId();
            Produtos produtoIdOld = persistentComandaItens.getProdutoId();
            Produtos produtoIdNew = comandaItens.getProdutoId();
            if (comandaIdNew != null) {
                comandaIdNew = em.getReference(comandaIdNew.getClass(), comandaIdNew.getComandaId());
                comandaItens.setComandaId(comandaIdNew);
            }
            if (produtoIdNew != null) {
                produtoIdNew = em.getReference(produtoIdNew.getClass(), produtoIdNew.getProdutoId());
                comandaItens.setProdutoId(produtoIdNew);
            }
            comandaItens = em.merge(comandaItens);
            if (comandaIdOld != null && !comandaIdOld.equals(comandaIdNew)) {
                comandaIdOld.getComandaItensCollection().remove(comandaItens);
                comandaIdOld = em.merge(comandaIdOld);
            }
            if (comandaIdNew != null && !comandaIdNew.equals(comandaIdOld)) {
                comandaIdNew.getComandaItensCollection().add(comandaItens);
                comandaIdNew = em.merge(comandaIdNew);
            }
            if (produtoIdOld != null && !produtoIdOld.equals(produtoIdNew)) {
                produtoIdOld.getComandaItensCollection().remove(comandaItens);
                produtoIdOld = em.merge(produtoIdOld);
            }
            if (produtoIdNew != null && !produtoIdNew.equals(produtoIdOld)) {
                produtoIdNew.getComandaItensCollection().add(comandaItens);
                produtoIdNew = em.merge(produtoIdNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = comandaItens.getItemId();
                if (findComandaItens(id) == null) {
                    throw new NonexistentEntityException("The comandaItens with id " + id + " no longer exists.");
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
            ComandaItens comandaItens;
            try {
                comandaItens = em.getReference(ComandaItens.class, id);
                comandaItens.getItemId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The comandaItens with id " + id + " no longer exists.", enfe);
            }
            Comandas comandaId = comandaItens.getComandaId();
            if (comandaId != null) {
                comandaId.getComandaItensCollection().remove(comandaItens);
                comandaId = em.merge(comandaId);
            }
            Produtos produtoId = comandaItens.getProdutoId();
            if (produtoId != null) {
                produtoId.getComandaItensCollection().remove(comandaItens);
                produtoId = em.merge(produtoId);
            }
            em.remove(comandaItens);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ComandaItens> findComandaItensEntities() {
        return findComandaItensEntities(true, -1, -1);
    }

    public List<ComandaItens> findComandaItensEntities(int maxResults, int firstResult) {
        return findComandaItensEntities(false, maxResults, firstResult);
    }

    private List<ComandaItens> findComandaItensEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ComandaItens.class));
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

    public ComandaItens findComandaItens(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ComandaItens.class, id);
        } finally {
            em.close();
        }
    }

    public int getComandaItensCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ComandaItens> rt = cq.from(ComandaItens.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
