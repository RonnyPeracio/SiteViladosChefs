/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sala308b
 */
@Entity
@Table(name = "comanda_itens", catalog = "restaurante", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ComandaItens.findAll", query = "SELECT c FROM ComandaItens c")
    , @NamedQuery(name = "ComandaItens.findByItemId", query = "SELECT c FROM ComandaItens c WHERE c.itemId = :itemId")
    , @NamedQuery(name = "ComandaItens.findByDataHora", query = "SELECT c FROM ComandaItens c WHERE c.dataHora = :dataHora")
    , @NamedQuery(name = "ComandaItens.findByItemQuantidade", query = "SELECT c FROM ComandaItens c WHERE c.itemQuantidade = :itemQuantidade")})
public class ComandaItens implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "item_id", nullable = false)
    private Integer itemId;
    @Column(name = "data_hora")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHora;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "item_quantidade", precision = 8, scale = 2)
    private BigDecimal itemQuantidade;
    @JoinColumn(name = "comanda_id", referencedColumnName = "comanda_id", nullable = false)
    @ManyToOne(optional = false)
    private Comandas comandaId;
    @JoinColumn(name = "produto_id", referencedColumnName = "produto_id", nullable = false)
    @ManyToOne(optional = false)
    private Produtos produtoId;

    public ComandaItens() {
    }

    public ComandaItens(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public BigDecimal getItemQuantidade() {
        return itemQuantidade;
    }

    public void setItemQuantidade(BigDecimal itemQuantidade) {
        this.itemQuantidade = itemQuantidade;
    }

    public Comandas getComandaId() {
        return comandaId;
    }

    public void setComandaId(Comandas comandaId) {
        this.comandaId = comandaId;
    }

    public Produtos getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Produtos produtoId) {
        this.produtoId = produtoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemId != null ? itemId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComandaItens)) {
            return false;
        }
        ComandaItens other = (ComandaItens) object;
        if ((this.itemId == null && other.itemId != null) || (this.itemId != null && !this.itemId.equals(other.itemId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.ComandaItens[ itemId=" + itemId + " ]";
    }
    
}
