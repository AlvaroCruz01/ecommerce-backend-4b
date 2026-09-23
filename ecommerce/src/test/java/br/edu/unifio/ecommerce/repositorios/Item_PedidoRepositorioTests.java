package br.edu.unifio.ecommerce.repositorios;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

import br.edu.unifio.ecommerce.entidades.Item_Pedido;

@SpringBootTest 
@TestMethodOrder (MethodOrderer.OrderAnnotation.class)
public class Item_PedidoRepositorioTests {
    @Autowired 
    private Item_PedidoRepositorio item_PedidoRepositorio;
    
    @Autowired
    private PedidoRepositorio pedidoRepositorio;

    @Autowired
    private ProdutoRepositorio produtoRepositorio;

    @Test
    @Order (1)
    public void deveBuscarUmItemPedidoPorId (){
        Item_Pedido item_Pedido = item_PedidoRepositorio.findById(1).orElseThrow();

        assertNotNull(item_Pedido);
        assertEquals(Short.parseShort("2"), item_Pedido.getQuantidade());
        assertEquals(new BigDecimal("75.25"), item_Pedido.getValorUnitario());
    }

    @Test
    @Order (2)
    public void deveListarTodosOsItensPedido () {
        List<Item_Pedido> itens = item_PedidoRepositorio.findAll(Sort.by("id"));

        assertEquals(5, itens.size());
        assertEquals(Short.parseShort("2"), itens.get(0).getQuantidade());
        assertEquals(Short.parseShort("1"), itens.get(1).getQuantidade());
    }

    @Test
    @Order (3)
    public void deveExcluirUmItemPedidoPorId (){
        Item_Pedido item_Pedido = new Item_Pedido();
        item_Pedido.setQuantidade(1);
        item_Pedido.setValorUnitario(new BigDecimal("10.00"));
        item_Pedido.setPedido(pedidoRepositorio.findById(1).orElseThrow());
        item_Pedido.setProduto(produtoRepositorio.findById(1).orElseThrow());
        item_PedidoRepositorio.save(item_Pedido);

        assertTrue(item_PedidoRepositorio.existsById(item_Pedido.getId()));
        item_PedidoRepositorio.deleteById(item_Pedido.getId());
        assertFalse(item_PedidoRepositorio.existsById(item_Pedido.getId()));
    }

    @Test 
    @Order (4)
    public void deveSalvarUmItemPedido (){
        Item_Pedido item_Pedido = new Item_Pedido();
        item_Pedido.setQuantidade(1);
        item_Pedido.setValorUnitario(new BigDecimal("15.00"));
        item_Pedido.setPedido(pedidoRepositorio.findById(1).orElseThrow());
        item_Pedido.setProduto(produtoRepositorio.findById(1).orElseThrow());
        item_PedidoRepositorio.save(item_Pedido);

        assertTrue(item_PedidoRepositorio.existsById(item_Pedido.getId()));
        assertEquals(1, item_PedidoRepositorio.findById(item_Pedido.getId()).orElseThrow().getQuantidade());
    }

    @Test
    @Order (5)
    public void deveAlterarUmItemPedido(){
        Item_Pedido item_Pedido = item_PedidoRepositorio.findById(1).orElseThrow();

        item_Pedido.setQuantidade(5);
        item_Pedido.setValorUnitario(new BigDecimal("75.00"));
        item_PedidoRepositorio.save(item_Pedido);
        Item_Pedido item_PedidoAlterado = item_PedidoRepositorio.findById(1).orElseThrow();
        assertEquals(5, item_PedidoAlterado.getQuantidade());
        assertEquals(new BigDecimal("75.00"), item_PedidoAlterado.getValorUnitario());
    }
}
