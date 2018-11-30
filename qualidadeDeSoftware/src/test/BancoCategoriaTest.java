package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import principal.dao.CategoriaJDBC;
import principal.model.Categoria;
import principal.model.Produto;

class BancoCategoriaTest {

	@Test
	void testaCategoria() {
		Categoria c = new Categoria();
		c.setNome("categoria");
		c.setProdutos(null);
		CategoriaJDBC catDao = new CategoriaJDBC(); 
		
		catDao.inserir(c);
		c.setNome("nome1");
		catDao.alterar(c);
		
		Categoria cat = catDao.buscar(c.getCodigo());
		c = catDao.buscar(c.getCodigo());
		assertEquals(cat, c);
		
		
	}

}
