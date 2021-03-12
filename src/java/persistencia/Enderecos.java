/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
    @NamedQuery(name = "Enderecos.findAll", query = "SELECT e FROM Enderecos e")
    , @NamedQuery(name = "Enderecos.findByEnderecoId", query = "SELECT e FROM Enderecos e WHERE e.enderecoId = :enderecoId")
    , @NamedQuery(name = "Enderecos.findByEnderecoCep", query = "SELECT e FROM Enderecos e WHERE e.enderecoCep = :enderecoCep")
    , @NamedQuery(name = "Enderecos.findByEnderecoRua", query = "SELECT e FROM Enderecos e WHERE e.enderecoRua = :enderecoRua")
    , @NamedQuery(name = "Enderecos.findByEnderecoNumero", query = "SELECT e FROM Enderecos e WHERE e.enderecoNumero = :enderecoNumero")
    , @NamedQuery(name = "Enderecos.findByEnderecoComplemento", query = "SELECT e FROM Enderecos e WHERE e.enderecoComplemento = :enderecoComplemento")
    , @NamedQuery(name = "Enderecos.findByEnderecoBairro", query = "SELECT e FROM Enderecos e WHERE e.enderecoBairro = :enderecoBairro")
    , @NamedQuery(name = "Enderecos.findByEndercoCidade", query = "SELECT e FROM Enderecos e WHERE e.endercoCidade = :endercoCidade")
    , @NamedQuery(name = "Enderecos.findByEnderecoUf", query = "SELECT e FROM Enderecos e WHERE e.enderecoUf = :enderecoUf")})
public class Enderecos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "endereco_id", nullable = false)
    private Integer enderecoId;
    @Column(name = "endereco_cep", length = 8)
    private String enderecoCep;
    @Basic(optional = false)
    @Column(name = "endereco_rua", nullable = false, length = 50)
    private String enderecoRua;
    @Column(name = "endereco_numero", length = 10)
    private String enderecoNumero;
    @Column(name = "endereco_complemento", length = 25)
    private String enderecoComplemento;
    @Basic(optional = false)
    @Column(name = "endereco_bairro", nullable = false, length = 50)
    private String enderecoBairro;
    @Basic(optional = false)
    @Column(name = "enderco_cidade", nullable = false, length = 45)
    private String endercoCidade;
    @Basic(optional = false)
    @Column(name = "endereco_uf", nullable = false, length = 2)
    private String enderecoUf;
    @ManyToMany(mappedBy = "enderecosCollection")
    private Collection<Clientes> clientesCollection;

    public Enderecos() {
    }

    public Enderecos(Integer enderecoId) {
        this.enderecoId = enderecoId;
    }

    public Enderecos(Integer enderecoId, String enderecoRua, String enderecoBairro, String endercoCidade, String enderecoUf) {
        this.enderecoId = enderecoId;
        this.enderecoRua = enderecoRua;
        this.enderecoBairro = enderecoBairro;
        this.endercoCidade = endercoCidade;
        this.enderecoUf = enderecoUf;
    }

    public Integer getEnderecoId() {
        return enderecoId;
    }

    public void setEnderecoId(Integer enderecoId) {
        this.enderecoId = enderecoId;
    }

    public String getEnderecoCep() {
        return enderecoCep;
    }

    public void setEnderecoCep(String enderecoCep) {
        this.enderecoCep = enderecoCep;
    }

    public String getEnderecoRua() {
        return enderecoRua;
    }

    public void setEnderecoRua(String enderecoRua) {
        this.enderecoRua = enderecoRua;
    }

    public String getEnderecoNumero() {
        return enderecoNumero;
    }

    public void setEnderecoNumero(String enderecoNumero) {
        this.enderecoNumero = enderecoNumero;
    }

    public String getEnderecoComplemento() {
        return enderecoComplemento;
    }

    public void setEnderecoComplemento(String enderecoComplemento) {
        this.enderecoComplemento = enderecoComplemento;
    }

    public String getEnderecoBairro() {
        return enderecoBairro;
    }

    public void setEnderecoBairro(String enderecoBairro) {
        this.enderecoBairro = enderecoBairro;
    }

    public String getEndercoCidade() {
        return endercoCidade;
    }

    public void setEndercoCidade(String endercoCidade) {
        this.endercoCidade = endercoCidade;
    }

    public String getEnderecoUf() {
        return enderecoUf;
    }

    public void setEnderecoUf(String enderecoUf) {
        this.enderecoUf = enderecoUf;
    }

    @XmlTransient
    public Collection<Clientes> getClientesCollection() {
        return clientesCollection;
    }

    public void setClientesCollection(Collection<Clientes> clientesCollection) {
        this.clientesCollection = clientesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (enderecoId != null ? enderecoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Enderecos)) {
            return false;
        }
        Enderecos other = (Enderecos) object;
        if ((this.enderecoId == null && other.enderecoId != null) || (this.enderecoId != null && !this.enderecoId.equals(other.enderecoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.Enderecos[ enderecoId=" + enderecoId + " ]";
    }
    
}
