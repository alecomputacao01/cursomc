/*Rules: There are some rules that each bi-directional relationship must follow:

    You must use its owing side simply using the mappedBy element of the @OneToOne, @OneToMany, or @ManyToMany annotation of the inverse side of a bi-directional relationship. mappedBy element is used to designate the field or property in an entity.
    In a one-to-one bi-directional relationship, owing side is the side that contains the corresponding foreign key.
    In a many-to-one bi-directional relationships the many side is always the owing side of the relationship and must not define the mappedBy element.
    In case of many-to-many bi-directional relationships either side may be the owing side.
*/

package com.alexnogueira.cursomc.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Pedido implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @JsonFormat(pattern="dd/MM/yyyy HH:mm")
    private Date instante;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "pedido")
    private Pagamento pagamento;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "endereco_de_entrega_id")
    private Endereco enderecoDeEntregas;

    @OneToMany(mappedBy = "id.pedido")
    private Set<ItemPedido> itens = new HashSet<>();
    
    public Pedido(){}

    public Pedido(Integer id, Date instante, Cliente cliente, Endereco enderecoDeEntregas) {
        this.id = id;
        this.instante = instante;
        this.cliente = cliente;
        this.enderecoDeEntregas = enderecoDeEntregas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getInstante() {
        return instante;
    }

    public void setInstante(Date instante) {
        this.instante = instante;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Endereco getEnderecoDeEntregas() {
        return enderecoDeEntregas;
    }

    public void setEnderecoDeEntregas(Endereco enderecoDeEntregas) {
        this.enderecoDeEntregas = enderecoDeEntregas;
    }

    public Set<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(Set<ItemPedido> itens) {
        this.itens = itens;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pedido other = (Pedido) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    

}
