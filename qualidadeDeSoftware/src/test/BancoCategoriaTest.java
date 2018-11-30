package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import principal.dao.CategoriaJDBC;
import principal.model.Categoria;

class BancoCategoriaTest {

	@Test
	void testaCategoria() {
		Categoria c = new Categoria();
		c.setNome("categoria");
		CategoriaJDBC catDao = new CategoriaJDBC();
		
		catDao.inserir(c);
		
		for(Categoria achou:catDao.listar()) {
			if(achou.equals(c)) {
				c.setCodigo(achou.getCodigo());
			}
		} 
		System.out.println(c.getCodigo());
		
		Categoria cat = catDao.buscar(c.getCodigo());
		c = catDao.buscar(c.getCodigo());
		assertEquals(cat, c);	
		c.setNome("nome1");
		catDao.alterar(c);
		assertFalse(catDao.buscar(c.getCodigo()) == cat);
		catDao.excluir(c.getCodigo());
		assertNull(catDao.buscar(c.getCodigo()));

	}

}
