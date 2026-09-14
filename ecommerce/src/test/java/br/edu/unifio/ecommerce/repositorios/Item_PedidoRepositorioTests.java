package br.edu.unifio.ecommerce.repositorios;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.unifio.ecommerce.entidades.Item_Pedido;

@SpringBootTest 
public class Item_PedidoRepositorioTests {
    @Autowired 
    private Item_PedidoRepositorio item_PedidoRepositorio;

    @Test
    public void deveBuscarUmItemPedidoPorId(){
        Item_Pedido item_pedido = item_PedidoRepositorio.findById(Integer.parseInt("1")).orElseThrow();

        assertNotNull(item_pedido);
        assertEquals(new BigDecimal("75.25"), item_pedido.getValorUnitario());
}
}
