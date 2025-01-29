package com.alexnogueira.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alexnogueira.cursomc.domain.ItemPedido;
import com.alexnogueira.cursomc.domain.ItemPedidoPK;

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido,ItemPedidoPK>{

    


}
