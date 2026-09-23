package br.edu.unifio.ecommerce.repositorios;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

import br.edu.unifio.ecommerce.entidades.Cliente;
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
        assertNotNull(pedido.getData());
        assertNotNull(pedido.getCliente());
    }

    @Test
    @Order(2)
    public void deveListarTodosOsPedidos() {
        List<Pedido> pedidos = pedidoRepositorio.findAll(Sort.by("id"));

        assertEquals(5, pedidos.size());
    }

    @Test
    @Order(3)
    public void deveSalvarUmPedido() {
        Cliente cliente = clienteRepositorio.findById(1).orElseThrow();

        Pedido pedido = new Pedido();
        pedido.setData(LocalDate.now());
        pedido.setStatus("Pendente");
        pedido.setValorTotal(new BigDecimal("1.00"));
        pedido.setCliente(cliente);

        pedidoRepositorio.save(pedido);

        assertTrue(pedidoRepositorio.existsById(pedido.getId()));
        assertEquals("Pendente", pedidoRepositorio.findById(pedido.getId()).orElseThrow().getStatus());
    }

    @Test
    @Order(4)
    public void deveAlterarUmPedido() {
        Cliente cliente = clienteRepositorio.findById(1).orElseThrow();

        Pedido pedido = new Pedido();
        pedido.setDataPedido(LocalDate.now());
        pedido.setStatus("Aguardando Pagamento");
        pedido.setTotal(new BigDecimal("200.00"));
        pedido.setCliente(cliente);
        pedidoRepositorio.save(pedido);

        Integer id = pedido.getId();

        
        pedido.setStatus("Pago");
        pedidoRepositorio.save(pedido);

        Pedido pedidoAtualizado = pedidoRepositorio.findById(id).orElseThrow();
        assertEquals("Pago", pedidoAtualizado.getStatus());
    }

    // 5. Exclusão
    @Test
    @Order(5)
    public void deveExcluirUmPedidoPorId() {
        Cliente cliente = clienteRepositorio.findById(1).orElseThrow();

        Pedido pedido = new Pedido();
        pedido.setDataPedido(LocalDate.now());
        pedido.setStatus("Cancelado");
        pedido.setTotal(new BigDecimal("50.00"));
        pedido.setCliente(cliente);
        pedidoRepositorio.save(pedido);

        Integer id = pedido.getId();
        assertTrue(pedidoRepositorio.existsById(id));

        pedidoRepositorio.deleteById(id);

        assertFalse(pedidoRepositorio.existsById(id));
    }
}