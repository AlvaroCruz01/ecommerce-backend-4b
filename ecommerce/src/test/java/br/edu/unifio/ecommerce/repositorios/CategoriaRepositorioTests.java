package br.edu.unifio.ecommerce.repositorios;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.unifio.ecommerce.entidades.Categoria;

@SpringBootTest 
public class CategoriaRepositorioTests {
    @Autowired /* NEW */
    private CategoriaRepositorio categoriaRepositorio;

    @Test 
    public void deveBuscarUmaCategoriaPorId () {
        Categoria categoria = categoriaRepositorio.findById (Short.parseShort("1")).orElseThrow();

        assertNotNull(categoria);
        assertEquals("Informática", categoria.getNome());
    }

}
