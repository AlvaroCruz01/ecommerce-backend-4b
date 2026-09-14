package br.edu.unifio.ecommerce.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unifio.ecommerce.entidades.Item_Pedido;

public interface Item_PedidoRepositorio extends JpaRepository <Item_Pedido, Integer> {

}
