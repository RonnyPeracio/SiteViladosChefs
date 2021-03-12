/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    @NamedQuery(name = "Produtos.findAll", query = "SELECT p FROM Produtos p")
    , @NamedQuery(name = "Produtos.findByProdutoId", query = "SELECT p FROM Produtos p WHERE p.produtoId = :produtoId")
    , @NamedQuery(name = "Produtos.findByProdutoNome", query = "SELECT p FROM Produtos p WHERE p.produtoNome = :produtoNome")
    , @NamedQuery(name = "Produtos.findByProdutoDescricao", query = "SELECT p FROM Produtos p WHERE p.produtoDescricao = :produtoDescricao")
    , @NamedQuery(name = "Produtos.findByProdutoUnidade", query = "SELECT p FROM Produtos p WHERE p.produtoUnidade = :produtoUnidade")
    , @NamedQuery(name = "Produtos.findByProdutoValor", query = "SELECT p FROM Produtos p WHERE p.produtoValor = :produtoValor")})
public class Produtos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "produto_id", nullable = false)
    private Integer produtoId;
    @Column(name = "produto_nome", length = 45)
    private String produtoNome;
    @Basic(optional = false)
    @Column(name = "produto_descricao", nullable = false, length = 45)
    private String produtoDescricao;
    @Column(name = "produto_unidade", length = 25)
    private String produtoUnidade;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "produto_valor", precision = 8, scale = 2)
    private BigDecimal produtoValor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produtoId")
    private Collection<ComandaItens> comandaItensCollection;

    public Produtos() {
    }

    public Produtos(Integer produtoId) {
        this.produtoId = produtoId;
    }

    public Produtos(Integer produtoId, String produtoDescricao) {
        this.produtoId = produtoId;
        this.produtoDescricao = produtoDescricao;
    }

    public Integer getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Integer produtoId) {
        this.produtoId = produtoId;
    }

    public String getProdutoNome() {
        return produtoNome;
    }

    public void setProdutoNome(String produtoNome) {
        this.produtoNome = produtoNome;
    }

    public String getProdutoDescricao() {
        return produtoDescricao;
    }

    public void setProdutoDescricao(String produtoDescricao) {
        this.produtoDescricao = produtoDescricao;
    }

    public String getProdutoUnidade() {
        return produtoUnidade;
    }

    public void setProdutoUnidade(String produtoUnidade) {
        this.produtoUnidade = produtoUnidade;
    }

    public BigDecimal getProdutoValor() {
        return produtoValor;
    }

    public void setProdutoValor(BigDecimal produtoValor) {
        this.produtoValor = produtoValor;
    }

    @XmlTransient
    public Collection<ComandaItens> getComandaItensCollection() {
        return comandaItensCollection;
    }

    public void setComandaItensCollection(Collection<ComandaItens> comandaItensCollection) {
        this.comandaItensCollection = comandaItensCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (produtoId != null ? produtoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produtos)) {
            return false;
        }
        Produtos other = (Produtos) object;
        if ((this.produtoId == null && other.produtoId != null) || (this.produtoId != null && !this.produtoId.equals(other.produtoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.Produtos[ produtoId=" + produtoId + " ]";
    }
    
}
