/*Rules: There are some rules that each bi-directional relationship must follow:

    You must use its owing side simply using the mappedBy element of the @OneToOne, @OneToMany, or @ManyToMany annotation of the inverse side of a bi-directional relationship. mappedBy element is used to designate the field or property in an entity.
    In a one-to-one bi-directional relationship, owing side is the side that contains the corresponding foreign key.
    In a many-to-one bi-directional relationships the many side is always the owing side of the relationship and must not define the mappedBy element.
    In case of many-to-many bi-directional relationships either side may be the owing side.
*/

package com.alexnogueira.cursomc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private Double preco;

    @JsonBackReference
    @ManyToMany
    @JoinTable(name = "Produto_Categoria", 
    joinColumns = @JoinColumn(name = "produto_id"), 
    inverseJoinColumns = @JoinColumn(name = "categoria_id")
    )
    private List<Categoria> categorias = new ArrayList<>();

    @OneToMany(mappedBy = "id.produto")
    private Set<ItemPedido> itens = new HashSet<>();

    public Produto() {
    }

    public Produto(Integer id, String nome, Double preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    public List<Pedido> getPedidos(){
        List<Pedido> lista = new ArrayList<>();
        for(ItemPedido x : itens) {
            lista.add(x.getPedido());
        }
        return lista;
    }
    
    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    
    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public void setItens(Set<ItemPedido> itens) {
        this.itens = itens;
    }
    public Set<ItemPedido> getItens() {
        return itens;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((preco == null) ? 0 : preco.hashCode());
        result = prime * result + ((categorias == null) ? 0 : categorias.hashCode());
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
        Produto other = (Produto) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (preco == null) {
            if (other.preco != null)
                return false;
        } else if (!preco.equals(other.preco))
            return false;
        if (categorias == null) {
            if (other.categorias != null)
                return false;
        } else if (!categorias.equals(other.categorias))
            return false;
        return true;
    }

}
