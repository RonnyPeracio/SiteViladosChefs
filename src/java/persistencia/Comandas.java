/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
    @NamedQuery(name = "Comandas.findAll", query = "SELECT c FROM Comandas c")
    , @NamedQuery(name = "Comandas.findByComandaId", query = "SELECT c FROM Comandas c WHERE c.comandaId = :comandaId")
    , @NamedQuery(name = "Comandas.findByDataHora", query = "SELECT c FROM Comandas c WHERE c.dataHora = :dataHora")})
public class Comandas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "comanda_id", nullable = false)
    private Integer comandaId;
    @Column(name = "data_hora")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHora;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "comandaId")
    private Collection<ComandaItens> comandaItensCollection;
    @JoinColumn(name = "cliente_id", referencedColumnName = "cliente_id", nullable = false)
    @ManyToOne(optional = false)
    private Clientes clienteId;

    public Comandas() {
    }

    public Comandas(Integer comandaId) {
        this.comandaId = comandaId;
    }

    public Integer getComandaId() {
        return comandaId;
    }

    public void setComandaId(Integer comandaId) {
        this.comandaId = comandaId;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    @XmlTransient
    public Collection<ComandaItens> getComandaItensCollection() {
        return comandaItensCollection;
    }

    public void setComandaItensCollection(Collection<ComandaItens> comandaItensCollection) {
        this.comandaItensCollection = comandaItensCollection;
    }

    public Clientes getClienteId() {
        return clienteId;
    }

    public void setClienteId(Clientes clienteId) {
        this.clienteId = clienteId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (comandaId != null ? comandaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comandas)) {
            return false;
        }
        Comandas other = (Comandas) object;
        if ((this.comandaId == null && other.comandaId != null) || (this.comandaId != null && !this.comandaId.equals(other.comandaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.Comandas[ comandaId=" + comandaId + " ]";
    }
    
}
