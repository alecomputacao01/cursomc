/*Rules: There are some rules that each bi-directional relationship must follow:

    You must use its owing side simply using the mappedBy element of the @OneToOne, @OneToMany, or @ManyToMany annotation of the inverse side of a bi-directional relationship. mappedBy element is used to designate the field or property in an entity.
    In a one-to-one bi-directional relationship, owing side is the side that contains the corresponding foreign key.
    In a many-to-one bi-directional relationships the many side is always the owing side of the relationship and must not define the mappedBy element.
    In case of many-to-many bi-directional relationships either side may be the owing side.
*/

package com.alexnogueira.cursomc.domain;

import java.io.Serializable;

import com.alexnogueira.cursomc.domain.enuns.EstadoPagamento;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pagamento implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    private Integer id;
    private Integer estado;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name="pedido_id")
    @MapsId
    private Pedido pedido;

        
    public Pagamento() {
    }

    public Pagamento(Integer id, EstadoPagamento estado, Pedido pedido) {
        this.id = id;
        this.estado = estado.getCod();
        this.pedido = pedido;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EstadoPagamento getEstado() {
        return EstadoPagamento.toEnum(estado);
    }

    public void setEstado(EstadoPagamento estado) {
        this.estado = estado.getCod();
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
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
        Pagamento other = (Pagamento) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    
    
}
