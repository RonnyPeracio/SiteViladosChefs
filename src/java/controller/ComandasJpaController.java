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
import persistencia.Clientes;
import persistencia.ComandaItens;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import persistencia.Comandas;

/**
 *
 * @author sala308b
 */
public class ComandasJpaController implements Serializable {

    public ComandasJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Comandas comandas) {
        if (comandas.getComandaItensCollection() == null) {
            comandas.setComandaItensCollection(new ArrayList<ComandaItens>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Clientes clienteId = comandas.getClienteId();
            if (clienteId != null) {
                clienteId = em.getReference(clienteId.getClass(), clienteId.getClienteId());
                comandas.setClienteId(clienteId);
            }
            Collection<ComandaItens> attachedComandaItensCollection = new ArrayList<ComandaItens>();
            for (ComandaItens comandaItensCollectionComandaItensToAttach : comandas.getComandaItensCollection()) {
                comandaItensCollectionComandaItensToAttach = em.getReference(comandaItensCollectionComandaItensToAttach.getClass(), comandaItensCollectionComandaItensToAttach.getItemId());
                attachedComandaItensCollection.add(comandaItensCollectionComandaItensToAttach);
            }
            comandas.setComandaItensCollection(attachedComandaItensCollection);
            em.persist(comandas);
            if (clienteId != null) {
                clienteId.getComandasCollection().add(comandas);
                clienteId = em.merge(clienteId);
            }
            for (ComandaItens comandaItensCollectionComandaItens : comandas.getComandaItensCollection()) {
                Comandas oldComandaIdOfComandaItensCollectionComandaItens = comandaItensCollectionComandaItens.getComandaId();
                comandaItensCollectionComandaItens.setComandaId(comandas);
                comandaItensCollectionComandaItens = em.merge(comandaItensCollectionComandaItens);
                if (oldComandaIdOfComandaItensCollectionComandaItens != null) {
                    oldComandaIdOfComandaItensCollectionComandaItens.getComandaItensCollection().remove(comandaItensCollectionComandaItens);
                    oldComandaIdOfComandaItensCollectionComandaItens = em.merge(oldComandaIdOfComandaItensCollectionComandaItens);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Comandas comandas) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Comandas persistentComandas = em.find(Comandas.class, comandas.getComandaId());
            Clientes clienteIdOld = persistentComandas.getClienteId();
            Clientes clienteIdNew = comandas.getClienteId();
            Collection<ComandaItens> comandaItensCollectionOld = persistentComandas.getComandaItensCollection();
            Collection<ComandaItens> comandaItensCollectionNew = comandas.getComandaItensCollection();
            List<String> illegalOrphanMessages = null;
            for (ComandaItens comandaItensCollectionOldComandaItens : comandaItensCollectionOld) {
                if (!comandaItensCollectionNew.contains(comandaItensCollectionOldComandaItens)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain ComandaItens " + comandaItensCollectionOldComandaItens + " since its comandaId field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (clienteIdNew != null) {
                clienteIdNew = em.getReference(clienteIdNew.getClass(), clienteIdNew.getClienteId());
                comandas.setClienteId(clienteIdNew);
            }
            Collection<ComandaItens> attachedComandaItensCollectionNew = new ArrayList<ComandaItens>();
            for (ComandaItens comandaItensCollectionNewComandaItensToAttach : comandaItensCollectionNew) {
                comandaItensCollectionNewComandaItensToAttach = em.getReference(comandaItensCollectionNewComandaItensToAttach.getClass(), comandaItensCollectionNewComandaItensToAttach.getItemId());
                attachedComandaItensCollectionNew.add(comandaItensCollectionNewComandaItensToAttach);
            }
            comandaItensCollectionNew = attachedComandaItensCollectionNew;
            comandas.setComandaItensCollection(comandaItensCollectionNew);
            comandas = em.merge(comandas);
            if (clienteIdOld != null && !clienteIdOld.equals(clienteIdNew)) {
                clienteIdOld.getComandasCollection().remove(comandas);
                clienteIdOld = em.merge(clienteIdOld);
            }
            if (clienteIdNew != null && !clienteIdNew.equals(clienteIdOld)) {
                clienteIdNew.getComandasCollection().add(comandas);
                clienteIdNew = em.merge(clienteIdNew);
            }
            for (ComandaItens comandaItensCollectionNewComandaItens : comandaItensCollectionNew) {
                if (!comandaItensCollectionOld.contains(comandaItensCollectionNewComandaItens)) {
                    Comandas oldComandaIdOfComandaItensCollectionNewComandaItens = comandaItensCollectionNewComandaItens.getComandaId();
                    comandaItensCollectionNewComandaItens.setComandaId(comandas);
                    comandaItensCollectionNewComandaItens = em.merge(comandaItensCollectionNewComandaItens);
                    if (oldComandaIdOfComandaItensCollectionNewComandaItens != null && !oldComandaIdOfComandaItensCollectionNewComandaItens.equals(comandas)) {
                        oldComandaIdOfComandaItensCollectionNewComandaItens.getComandaItensCollection().remove(comandaItensCollectionNewComandaItens);
                        oldComandaIdOfComandaItensCollectionNewComandaItens = em.merge(oldComandaIdOfComandaItensCollectionNewComandaItens);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = comandas.getComandaId();
                if (findComandas(id) == null) {
                    throw new NonexistentEntityException("The comandas with id " + id + " no longer exists.");
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
            Comandas comandas;
            try {
                comandas = em.getReference(Comandas.class, id);
                comandas.getComandaId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The comandas with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<ComandaItens> comandaItensCollectionOrphanCheck = comandas.getComandaItensCollection();
            for (ComandaItens comandaItensCollectionOrphanCheckComandaItens : comandaItensCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Comandas (" + comandas + ") cannot be destroyed since the ComandaItens " + comandaItensCollectionOrphanCheckComandaItens + " in its comandaItensCollection field has a non-nullable comandaId field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Clientes clienteId = comandas.getClienteId();
            if (clienteId != null) {
                clienteId.getComandasCollection().remove(comandas);
                clienteId = em.merge(clienteId);
            }
            em.remove(comandas);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Comandas> findComandasEntities() {
        return findComandasEntities(true, -1, -1);
    }

    public List<Comandas> findComandasEntities(int maxResults, int firstResult) {
        return findComandasEntities(false, maxResults, firstResult);
    }

    private List<Comandas> findComandasEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Comandas.class));
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

    public Comandas findComandas(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Comandas.class, id);
        } finally {
            em.close();
        }
    }

    public int getComandasCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Comandas> rt = cq.from(Comandas.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
