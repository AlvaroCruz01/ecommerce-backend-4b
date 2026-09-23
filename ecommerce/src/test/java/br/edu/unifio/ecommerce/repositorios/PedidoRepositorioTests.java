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

import br.edu.unifio.ecommerce.entidades.Pedido;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PedidoRepositorioTests {

    @Autowired 
    private PedidoRepositorio pedidoRepositorio;

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    @Test
    @Order(1)
    public void deveBuscarUmPedidoPorId() {
        Pedido pedido = pedidoRepositorio.findById(1).orElseThrow();

        assertNotNull(pedido);
        assertEquals("Entregue", pedido.getStatus());
        assertEquals(new BigDecimal("150.50"), pedido.getValorTotal());
    }

    @Test
    @Order(2)
    public void deveListarTodosOsPedidos() {
        List<Pedido> pedidos = pedidoRepositorio.findAll(Sort.by("id"));

        assertEquals(5, pedidos.size());
        assertEquals("Entregue", pedidos.get(0).getStatus());
        assertEquals("Processando", pedidos.get(1).getStatus());
    }

    @Test
    @Order(3)
    public void deveExcluirUmPedidoPorId () {
        Pedido pedido = new Pedido();
        pedido.setData(java.time.LocalDateTime.now());
        pedido.setStatus("Teste");
        pedido.setValorTotal(new BigDecimal("100.00"));
        pedido.setCliente(clienteRepositorio.findById(1).orElseThrow());
        pedidoRepositorio.save(pedido);

        assertTrue(pedidoRepositorio.existsById(pedido.getId()));
        pedidoRepositorio.deleteById(pedido.getId());
        assertFalse(pedidoRepositorio.existsById(pedido.getId()));
    }

    @Test 
    @Order (4)
    public void deveSalvarUmPedido (){
        Pedido pedido = new Pedido();
        pedido.setData(java.time.LocalDateTime.now());
        pedido.setStatus("Pendente");
        pedido.setValorTotal(new BigDecimal("100.00"));
        pedido.setCliente(clienteRepositorio.findById(1).orElseThrow());
        pedidoRepositorio.save(pedido);

        assertTrue(pedidoRepositorio.existsById(pedido.getId()));
        assertEquals("Pendente", pedidoRepositorio.findById(pedido.getId()).orElseThrow().getStatus());
    }

    @Test
    @Order(5)
    public void deveAlterarUmPedido() {
        Pedido pedido = new Pedido(); 

        pedido.setData(java.time.LocalDateTime.now());
        pedido.setStatus("Em Análise");
        pedido.setValorTotal(new BigDecimal("50.00"));
        pedido.setCliente(clienteRepositorio.findById(1).orElseThrow());
        pedidoRepositorio.save(pedido);

        Integer id = pedido.getId();

        pedido.setStatus("Aprovado");
        pedido.setValorTotal(new BigDecimal("75.00"));
        pedidoRepositorio.save(pedido);

        Pedido pedidoAlterado = pedidoRepositorio.findById(id).orElseThrow();
        assertEquals("Aprovado", pedidoAlterado.getStatus());
        assertEquals(new BigDecimal("75.00"), pedidoAlterado.getValorTotal());
    }
}