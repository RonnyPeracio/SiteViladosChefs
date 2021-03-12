/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.exceptions.IllegalOrphanException;
import controller.exceptions.NonexistentEntityException;
import controller.exceptions.PreexistingEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import persistencia.Enderecos;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import persistencia.Clientes;
import persistencia.Comandas;

/**
 *
 * @author sala308b
 */
public class ClientesJpaController implements Serializable {

    public ClientesJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Clientes clientes) throws PreexistingEntityException, Exception {
        if (clientes.getEnderecosCollection() == null) {
            clientes.setEnderecosCollection(new ArrayList<Enderecos>());
        }
        if (clientes.getComandasCollection() == null) {
            clientes.setComandasCollection(new ArrayList<Comandas>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Enderecos> attachedEnderecosCollection = new ArrayList<Enderecos>();
            for (Enderecos enderecosCollectionEnderecosToAttach : clientes.getEnderecosCollection()) {
                enderecosCollectionEnderecosToAttach = em.getReference(enderecosCollectionEnderecosToAttach.getClass(), enderecosCollectionEnderecosToAttach.getEnderecoId());
                attachedEnderecosCollection.add(enderecosCollectionEnderecosToAttach);
            }
            clientes.setEnderecosCollection(attachedEnderecosCollection);
            Collection<Comandas> attachedComandasCollection = new ArrayList<Comandas>();
            for (Comandas comandasCollectionComandasToAttach : clientes.getComandasCollection()) {
                comandasCollectionComandasToAttach = em.getReference(comandasCollectionComandasToAttach.getClass(), comandasCollectionComandasToAttach.getComandaId());
                attachedComandasCollection.add(comandasCollectionComandasToAttach);
            }
            clientes.setComandasCollection(attachedComandasCollection);
            em.persist(clientes);
            for (Enderecos enderecosCollectionEnderecos : clientes.getEnderecosCollection()) {
                enderecosCollectionEnderecos.getClientesCollection().add(clientes);
                enderecosCollectionEnderecos = em.merge(enderecosCollectionEnderecos);
            }
            for (Comandas comandasCollectionComandas : clientes.getComandasCollection()) {
                Clientes oldClienteIdOfComandasCollectionComandas = comandasCollectionComandas.getClienteId();
                comandasCollectionComandas.setClienteId(clientes);
                comandasCollectionComandas = em.merge(comandasCollectionComandas);
                if (oldClienteIdOfComandasCollectionComandas != null) {
                    oldClienteIdOfComandasCollectionComandas.getComandasCollection().remove(comandasCollectionComandas);
                    oldClienteIdOfComandasCollectionComandas = em.merge(oldClienteIdOfComandasCollectionComandas);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findClientes(clientes.getClienteId()) != null) {
                throw new PreexistingEntityException("Clientes " + clientes + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Clientes clientes) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Clientes persistentClientes = em.find(Clientes.class, clientes.getClienteId());
            Collection<Enderecos> enderecosCollectionOld = persistentClientes.getEnderecosCollection();
            Collection<Enderecos> enderecosCollectionNew = clientes.getEnderecosCollection();
            Collection<Comandas> comandasCollectionOld = persistentClientes.getComandasCollection();
            Collection<Comandas> comandasCollectionNew = clientes.getComandasCollection();
            List<String> illegalOrphanMessages = null;
            for (Comandas comandasCollectionOldComandas : comandasCollectionOld) {
                if (!comandasCollectionNew.contains(comandasCollectionOldComandas)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Comandas " + comandasCollectionOldComandas + " since its clienteId field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Enderecos> attachedEnderecosCollectionNew = new ArrayList<Enderecos>();
            for (Enderecos enderecosCollectionNewEnderecosToAttach : enderecosCollectionNew) {
                enderecosCollectionNewEnderecosToAttach = em.getReference(enderecosCollectionNewEnderecosToAttach.getClass(), enderecosCollectionNewEnderecosToAttach.getEnderecoId());
                attachedEnderecosCollectionNew.add(enderecosCollectionNewEnderecosToAttach);
            }
            enderecosCollectionNew = attachedEnderecosCollectionNew;
            clientes.setEnderecosCollection(enderecosCollectionNew);
            Collection<Comandas> attachedComandasCollectionNew = new ArrayList<Comandas>();
            for (Comandas comandasCollectionNewComandasToAttach : comandasCollectionNew) {
                comandasCollectionNewComandasToAttach = em.getReference(comandasCollectionNewComandasToAttach.getClass(), comandasCollectionNewComandasToAttach.getComandaId());
                attachedComandasCollectionNew.add(comandasCollectionNewComandasToAttach);
            }
            comandasCollectionNew = attachedComandasCollectionNew;
            clientes.setComandasCollection(comandasCollectionNew);
            clientes = em.merge(clientes);
            for (Enderecos enderecosCollectionOldEnderecos : enderecosCollectionOld) {
                if (!enderecosCollectionNew.contains(enderecosCollectionOldEnderecos)) {
                    enderecosCollectionOldEnderecos.getClientesCollection().remove(clientes);
                    enderecosCollectionOldEnderecos = em.merge(enderecosCollectionOldEnderecos);
                }
            }
            for (Enderecos enderecosCollectionNewEnderecos : enderecosCollectionNew) {
                if (!enderecosCollectionOld.contains(enderecosCollectionNewEnderecos)) {
                    enderecosCollectionNewEnderecos.getClientesCollection().add(clientes);
                    enderecosCollectionNewEnderecos = em.merge(enderecosCollectionNewEnderecos);
                }
            }
            for (Comandas comandasCollectionNewComandas : comandasCollectionNew) {
                if (!comandasCollectionOld.contains(comandasCollectionNewComandas)) {
                    Clientes oldClienteIdOfComandasCollectionNewComandas = comandasCollectionNewComandas.getClienteId();
                    comandasCollectionNewComandas.setClienteId(clientes);
                    comandasCollectionNewComandas = em.merge(comandasCollectionNewComandas);
                    if (oldClienteIdOfComandasCollectionNewComandas != null && !oldClienteIdOfComandasCollectionNewComandas.equals(clientes)) {
                        oldClienteIdOfComandasCollectionNewComandas.getComandasCollection().remove(comandasCollectionNewComandas);
                        oldClienteIdOfComandasCollectionNewComandas = em.merge(oldClienteIdOfComandasCollectionNewComandas);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = clientes.getClienteId();
                if (findClientes(id) == null) {
                    throw new NonexistentEntityException("The clientes with id " + id + " no longer exists.");
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
            Clientes clientes;
            try {
                clientes = em.getReference(Clientes.class, id);
                clientes.getClienteId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The clientes with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Comandas> comandasCollectionOrphanCheck = clientes.getComandasCollection();
            for (Comandas comandasCollectionOrphanCheckComandas : comandasCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Clientes (" + clientes + ") cannot be destroyed since the Comandas " + comandasCollectionOrphanCheckComandas + " in its comandasCollection field has a non-nullable clienteId field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Enderecos> enderecosCollection = clientes.getEnderecosCollection();
            for (Enderecos enderecosCollectionEnderecos : enderecosCollection) {
                enderecosCollectionEnderecos.getClientesCollection().remove(clientes);
                enderecosCollectionEnderecos = em.merge(enderecosCollectionEnderecos);
            }
            em.remove(clientes);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Clientes> findClientesEntities() {
        return findClientesEntities(true, -1, -1);
    }

    public List<Clientes> findClientesEntities(int maxResults, int firstResult) {
        return findClientesEntities(false, maxResults, firstResult);
    }

    private List<Clientes> findClientesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Clientes.class));
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

    public Clientes findClientes(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Clientes.class, id);
        } finally {
            em.close();
        }
    }

    public int getClientesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Clientes> rt = cq.from(Clientes.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
