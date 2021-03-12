/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sala308b
 */
@Entity
@Table(catalog = "restaurante", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clientes.findAll", query = "SELECT c FROM Clientes c")
    , @NamedQuery(name = "Clientes.findByClienteId", query = "SELECT c FROM Clientes c WHERE c.clienteId = :clienteId")
    , @NamedQuery(name = "Clientes.findByClienteNome", query = "SELECT c FROM Clientes c WHERE c.clienteNome = :clienteNome")
    , @NamedQuery(name = "Clientes.findByClienteEmail", query = "SELECT c FROM Clientes c WHERE c.clienteEmail = :clienteEmail")
    , @NamedQuery(name = "Clientes.findByClienteCelular", query = "SELECT c FROM Clientes c WHERE c.clienteCelular = :clienteCelular")
    , @NamedQuery(name = "Clientes.findByEnderecoId", query = "SELECT c FROM Clientes c WHERE c.enderecoId = :enderecoId")})
public class Clientes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cliente_id", nullable = false)
    private Integer clienteId;
    @Basic(optional = false)
    @Column(name = "cliente_nome", nullable = false, length = 45)
    private String clienteNome;
    @Column(name = "cliente_email", length = 60)
    private String clienteEmail;
    @Basic(optional = false)
    @Column(name = "cliente_celular", nullable = false, length = 11)
    private String clienteCelular;
    @Column(name = "endereco_id")
    private Integer enderecoId;
    @JoinTable(name = "clientes_enderecos", joinColumns = {
        @JoinColumn(name = "cliente_id", referencedColumnName = "cliente_id", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "endereco_id", referencedColumnName = "endereco_id", nullable = false)})
    @ManyToMany
    private Collection<Enderecos> enderecosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clienteId")
    private Collection<Comandas> comandasCollection;

    public Clientes() {
    }

    public Clientes(Integer clienteId) {
        this.clienteId = clienteId;
    }

    public Clientes(Integer clienteId, String clienteNome, String clienteCelular) {
        this.clienteId = clienteId;
        this.clienteNome = clienteNome;
        this.clienteCelular = clienteCelular;
    }

    public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }

    public String getClienteNome() {
        return clienteNome;
    }

    public void setClienteNome(String clienteNome) {
        this.clienteNome = clienteNome;
    }

    public String getClienteEmail() {
        return clienteEmail;
    }

    public void setClienteEmail(String clienteEmail) {
        this.clienteEmail = clienteEmail;
    }

    public String getClienteCelular() {
        return clienteCelular;
    }

    public void setClienteCelular(String clienteCelular) {
        this.clienteCelular = clienteCelular;
    }

    public Integer getEnderecoId() {
        return enderecoId;
    }

    public void setEnderecoId(Integer enderecoId) {
        this.enderecoId = enderecoId;
    }

    @XmlTransient
    public Collection<Enderecos> getEnderecosCollection() {
        return enderecosCollection;
    }

    public void setEnderecosCollection(Collection<Enderecos> enderecosCollection) {
        this.enderecosCollection = enderecosCollection;
    }

    @XmlTransient
    public Collection<Comandas> getComandasCollection() {
        return comandasCollection;
    }

    public void setComandasCollection(Collection<Comandas> comandasCollection) {
        this.comandasCollection = comandasCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clienteId != null ? clienteId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clientes)) {
            return false;
        }
        Clientes other = (Clientes) object;
        if ((this.clienteId == null && other.clienteId != null) || (this.clienteId != null && !this.clienteId.equals(other.clienteId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.Clientes[ clienteId=" + clienteId + " ]";
    }
    
}
