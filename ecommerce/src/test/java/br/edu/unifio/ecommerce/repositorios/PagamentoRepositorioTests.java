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

import br.edu.unifio.ecommerce.entidades.Pagamento;
import br.edu.unifio.ecommerce.entidades.Pedido;

@SpringBootTest 
@TestMethodOrder (MethodOrderer.OrderAnnotation.class)
public class PagamentoRepositorioTests {

    @Autowired 
    private PagamentoRepositorio pagamentoRepositorio;

    @Autowired
    private PedidoRepositorio pedidoRepositorio;

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    @Test
    @Order (1)
    public void deveBuscarUmPagamentoPorId(){
        Pagamento pagamento = pagamentoRepositorio.findById(1).orElseThrow();

        assertNotNull(pagamento);
        assertEquals(new BigDecimal("150.50"), pagamento.getValor());
        assertEquals("Concluído", pagamento.getStatus());
        assertEquals("Cartão de Crédito", pagamento.getTipo());
    }

    @Test
    @Order (2)
    public void deveListarTodosOsPagamentos () {
        List<Pagamento> pagamentos = pagamentoRepositorio.findAll(Sort.by("id"));

        assertEquals(5, pagamentos.size());
        assertEquals("Concluído", pagamentos.get(0).getStatus());
        assertEquals("Pendente", pagamentos.get(1).getStatus());
    }

    @Test
    @Order (3)
    public void deveExcluirUmPagamentoPorId (){
        Pagamento pagamento = pagamentoRepositorio.findById(5).orElseThrow();

        assertTrue(pagamentoRepositorio.existsById(pagamento.getId()));
        pagamentoRepositorio.deleteById(pagamento.getId());
        assertFalse(pagamentoRepositorio.existsById(pagamento.getId()));
    }

    @Test 
    @Order (4)
    public void deveSalvarUmPagamento (){
        Pedido novoPedido = new Pedido();
        novoPedido.setData(java.time.LocalDateTime.now());
        novoPedido.setStatus("Pendente");
        novoPedido.setValorTotal(new BigDecimal("20.00"));
        novoPedido.setCliente(clienteRepositorio.findById(1).orElseThrow());
        pedidoRepositorio.save(novoPedido);

        Pagamento pagamento = new Pagamento();
        pagamento.setData(java.time.LocalDateTime.now());
        pagamento.setValor(new BigDecimal("20.00"));
        pagamento.setStatus("Concluído");
        pagamento.setTipo("Pix");
        pagamento.setPedido(novoPedido);

        pagamentoRepositorio.save(pagamento);

        assertTrue(pagamentoRepositorio.existsById(pagamento.getId()));
        assertEquals(new BigDecimal("20.00"), pagamentoRepositorio.findById(pagamento.getId()).orElseThrow().getValor());
    }

    @Test
    @Order (5)
    public void deveAlterarUmPagamento(){
        Pagamento pagamento = pagamentoRepositorio.findById(1).orElseThrow();
        pagamento.setStatus("Concluído");
        pagamento.setValor(new BigDecimal("75.00"));
        pagamento.setTipo("Boleto");
        pagamentoRepositorio.save(pagamento);

        Pagamento pagamentoAlterado = pagamentoRepositorio.findById(1).orElseThrow();
        assertEquals("Concluído", pagamentoAlterado.getStatus());
        assertEquals(new BigDecimal("75.00"), pagamentoAlterado.getValor());
        assertEquals("Boleto", pagamentoAlterado.getTipo());
    }

}
