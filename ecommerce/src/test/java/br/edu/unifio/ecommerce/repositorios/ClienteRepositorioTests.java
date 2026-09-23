package br.edu.unifio.ecommerce.repositorios;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

import br.edu.unifio.ecommerce.entidades.Cliente;

@SpringBootTest
@TestMethodOrder (MethodOrderer.OrderAnnotation.class)
public class ClienteRepositorioTests {

    @Autowired /* NEW */
    private ClienteRepositorio clienteRepositorio;

    @Test
    @Order (1)
    public void deveBuscarUmClientePorId () {
        Cliente cliente = clienteRepositorio.findById (1).orElseThrow();

        assertNotNull(cliente);
        assertEquals("Murilo", cliente.getNome());
        assertEquals("murilogabriel321@gmail.com", cliente.getEmail());
    }

    @Test
    @Order(2)
    public void deveListarTodosOsClientes() {
        List<Cliente> clientes = clienteRepositorio.findAll(Sort.by("nome"));

        assertEquals(5, clientes.size());
        assertEquals("Beatriz Cruz", clientes.get(0).getNome());
        assertEquals("Carlos Oliveira", clientes.get(1).getNome());
    }

    @Test
    @Order (3)
    public void deveExcluirUmClientePorId (){
        Cliente cliente = new Cliente();
        cliente.setNome("Nome Teste");
        cliente.setEmail("teste@email.com");
        cliente.setTelefone("+55 14 999999999");
        clienteRepositorio.save(cliente);

        assertTrue(clienteRepositorio.existsById(cliente.getId()));
        clienteRepositorio.deleteById(cliente.getId());
        assertFalse(clienteRepositorio.existsById(cliente.getId()));
    }

    @Test 
    @Order (4)
    public void deveSalvarUmCliente (){
        Cliente cliente = new Cliente();
        cliente.setNome("Nome Teste");
        cliente.setEmail("teste@email.com");
        cliente.setTelefone("+55 14 999999999");
        clienteRepositorio.save(cliente);

        assertTrue(clienteRepositorio.existsById(cliente.getId()));
        assertEquals("Nome Teste", clienteRepositorio.findById(cliente.getId()).orElseThrow().getNome());
    }

    @Test
    @Order (5)
    public void deveAlterarUmCliente(){
        Cliente cliente = new Cliente(); 

        cliente.setNome("Cliente Para Alterar");
        cliente.setEmail("alterar@email.com");
        cliente.setTelefone("+55 14 999999999");
        clienteRepositorio.save(cliente);

        Integer id = cliente.getId();

        cliente.setNome("Cliente Alterado com Sucesso");
        cliente.setEmail("alterado@email.com");
        clienteRepositorio.save(cliente);

        Cliente clienteAlterado = clienteRepositorio.findById(id).orElseThrow();
        assertEquals("Cliente Alterado com Sucesso", clienteAlterado.getNome());
        assertEquals("alterado@email.com", clienteAlterado.getEmail());
    }
}
