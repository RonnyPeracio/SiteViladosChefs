/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import persistencia.Clientes;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import persistencia.Enderecos;

/**
 *
 * @author sala308b
 */
public class EnderecosJpaController implements Serializable {

    public EnderecosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Enderecos enderecos) {
        if (enderecos.getClientesCollection() == null) {
            enderecos.setClientesCollection(new ArrayList<Clientes>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Clientes> attachedClientesCollection = new ArrayList<Clientes>();
            for (Clientes clientesCollectionClientesToAttach : enderecos.getClientesCollection()) {
                clientesCollectionClientesToAttach = em.getReference(clientesCollectionClientesToAttach.getClass(), clientesCollectionClientesToAttach.getClienteId());
                attachedClientesCollection.add(clientesCollectionClientesToAttach);
            }
            enderecos.setClientesCollection(attachedClientesCollection);
            em.persist(enderecos);
            for (Clientes clientesCollectionClientes : enderecos.getClientesCollection()) {
                clientesCollectionClientes.getEnderecosCollection().add(enderecos);
                clientesCollectionClientes = em.merge(clientesCollectionClientes);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Enderecos enderecos) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Enderecos persistentEnderecos = em.find(Enderecos.class, enderecos.getEnderecoId());
            Collection<Clientes> clientesCollectionOld = persistentEnderecos.getClientesCollection();
            Collection<Clientes> clientesCollectionNew = enderecos.getClientesCollection();
            Collection<Clientes> attachedClientesCollectionNew = new ArrayList<Clientes>();
            for (Clientes clientesCollectionNewClientesToAttach : clientesCollectionNew) {
                clientesCollectionNewClientesToAttach = em.getReference(clientesCollectionNewClientesToAttach.getClass(), clientesCollectionNewClientesToAttach.getClienteId());
                attachedClientesCollectionNew.add(clientesCollectionNewClientesToAttach);
            }
            clientesCollectionNew = attachedClientesCollectionNew;
            enderecos.setClientesCollection(clientesCollectionNew);
            enderecos = em.merge(enderecos);
            for (Clientes clientesCollectionOldClientes : clientesCollectionOld) {
                if (!clientesCollectionNew.contains(clientesCollectionOldClientes)) {
                    clientesCollectionOldClientes.getEnderecosCollection().remove(enderecos);
                    clientesCollectionOldClientes = em.merge(clientesCollectionOldClientes);
                }
            }
            for (Clientes clientesCollectionNewClientes : clientesCollectionNew) {
                if (!clientesCollectionOld.contains(clientesCollectionNewClientes)) {
                    clientesCollectionNewClientes.getEnderecosCollection().add(enderecos);
                    clientesCollectionNewClientes = em.merge(clientesCollectionNewClientes);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = enderecos.getEnderecoId();
                if (findEnderecos(id) == null) {
                    throw new NonexistentEntityException("The enderecos with id " + id + " no longer exists.");
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
            Enderecos enderecos;
            try {
                enderecos = em.getReference(Enderecos.class, id);
                enderecos.getEnderecoId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The enderecos with id " + id + " no longer exists.", enfe);
            }
            Collection<Clientes> clientesCollection = enderecos.getClientesCollection();
            for (Clientes clientesCollectionClientes : clientesCollection) {
                clientesCollectionClientes.getEnderecosCollection().remove(enderecos);
                clientesCollectionClientes = em.merge(clientesCollectionClientes);
            }
            em.remove(enderecos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Enderecos> findEnderecosEntities() {
        return findEnderecosEntities(true, -1, -1);
    }

    public List<Enderecos> findEnderecosEntities(int maxResults, int firstResult) {
        return findEnderecosEntities(false, maxResults, firstResult);
    }

    private List<Enderecos> findEnderecosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Enderecos.class));
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

    public Enderecos findEnderecos(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Enderecos.class, id);
        } finally {
            em.close();
        }
    }

    public int getEnderecosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Enderecos> rt = cq.from(Enderecos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
