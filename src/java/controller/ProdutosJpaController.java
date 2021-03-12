/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.exceptions.IllegalOrphanException;
import controller.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import persistencia.ComandaItens;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import persistencia.Produtos;

/**
 *
 * @author sala308b
 */
public class ProdutosJpaController implements Serializable {

    public ProdutosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Produtos produtos) {
        if (produtos.getComandaItensCollection() == null) {
            produtos.setComandaItensCollection(new ArrayList<ComandaItens>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<ComandaItens> attachedComandaItensCollection = new ArrayList<ComandaItens>();
            for (ComandaItens comandaItensCollectionComandaItensToAttach : produtos.getComandaItensCollection()) {
                comandaItensCollectionComandaItensToAttach = em.getReference(comandaItensCollectionComandaItensToAttach.getClass(), comandaItensCollectionComandaItensToAttach.getItemId());
                attachedComandaItensCollection.add(comandaItensCollectionComandaItensToAttach);
            }
            produtos.setComandaItensCollection(attachedComandaItensCollection);
            em.persist(produtos);
            for (ComandaItens comandaItensCollectionComandaItens : produtos.getComandaItensCollection()) {
                Produtos oldProdutoIdOfComandaItensCollectionComandaItens = comandaItensCollectionComandaItens.getProdutoId();
                comandaItensCollectionComandaItens.setProdutoId(produtos);
                comandaItensCollectionComandaItens = em.merge(comandaItensCollectionComandaItens);
                if (oldProdutoIdOfComandaItensCollectionComandaItens != null) {
                    oldProdutoIdOfComandaItensCollectionComandaItens.getComandaItensCollection().remove(comandaItensCollectionComandaItens);
                    oldProdutoIdOfComandaItensCollectionComandaItens = em.merge(oldProdutoIdOfComandaItensCollectionComandaItens);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Produtos produtos) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Produtos persistentProdutos = em.find(Produtos.class, produtos.getProdutoId());
            Collection<ComandaItens> comandaItensCollectionOld = persistentProdutos.getComandaItensCollection();
            Collection<ComandaItens> comandaItensCollectionNew = produtos.getComandaItensCollection();
            List<String> illegalOrphanMessages = null;
            for (ComandaItens comandaItensCollectionOldComandaItens : comandaItensCollectionOld) {
                if (!comandaItensCollectionNew.contains(comandaItensCollectionOldComandaItens)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain ComandaItens " + comandaItensCollectionOldComandaItens + " since its produtoId field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<ComandaItens> attachedComandaItensCollectionNew = new ArrayList<ComandaItens>();
            for (ComandaItens comandaItensCollectionNewComandaItensToAttach : comandaItensCollectionNew) {
                comandaItensCollectionNewComandaItensToAttach = em.getReference(comandaItensCollectionNewComandaItensToAttach.getClass(), comandaItensCollectionNewComandaItensToAttach.getItemId());
                attachedComandaItensCollectionNew.add(comandaItensCollectionNewComandaItensToAttach);
            }
            comandaItensCollectionNew = attachedComandaItensCollectionNew;
            produtos.setComandaItensCollection(comandaItensCollectionNew);
            produtos = em.merge(produtos);
            for (ComandaItens comandaItensCollectionNewComandaItens : comandaItensCollectionNew) {
                if (!comandaItensCollectionOld.contains(comandaItensCollectionNewComandaItens)) {
                    Produtos oldProdutoIdOfComandaItensCollectionNewComandaItens = comandaItensCollectionNewComandaItens.getProdutoId();
                    comandaItensCollectionNewComandaItens.setProdutoId(produtos);
                    comandaItensCollectionNewComandaItens = em.merge(comandaItensCollectionNewComandaItens);
                    if (oldProdutoIdOfComandaItensCollectionNewComandaItens != null && !oldProdutoIdOfComandaItensCollectionNewComandaItens.equals(produtos)) {
                        oldProdutoIdOfComandaItensCollectionNewComandaItens.getComandaItensCollection().remove(comandaItensCollectionNewComandaItens);
                        oldProdutoIdOfComandaItensCollectionNewComandaItens = em.merge(oldProdutoIdOfComandaItensCollectionNewComandaItens);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = produtos.getProdutoId();
                if (findProdutos(id) == null) {
                    throw new NonexistentEntityException("The produtos with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Produtos produtos;
            try {
                produtos = em.getReference(Produtos.class, id);
                produtos.getProdutoId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The produtos with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<ComandaItens> comandaItensCollectionOrphanCheck = produtos.getComandaItensCollection();
            for (ComandaItens comandaItensCollectionOrphanCheckComandaItens : comandaItensCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Produtos (" + produtos + ") cannot be destroyed since the ComandaItens " + comandaItensCollectionOrphanCheckComandaItens + " in its comandaItensCollection field has a non-nullable produtoId field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(produtos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Produtos> findProdutosEntities() {
        return findProdutosEntities(true, -1, -1);
    }

    public List<Produtos> findProdutosEntities(int maxResults, int firstResult) {
        return findProdutosEntities(false, maxResults, firstResult);
    }

    private List<Produtos> findProdutosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Produtos.class));
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

    public Produtos findProdutos(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Produtos.class, id);
        } finally {
            em.close();
        }
    }

    public int getProdutosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Produtos> rt = cq.from(Produtos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
