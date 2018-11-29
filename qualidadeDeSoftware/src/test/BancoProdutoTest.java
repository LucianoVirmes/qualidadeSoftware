package test;

import org.junit.jupiter.api.Test;

import principal.dao.CategoriaJDBC;
import principal.dao.ProdutoJDBC;
import principal.model.Categoria;
import principal.model.Produto;

class BancoProdutoTest {

	@Test
	void test() {
		CategoriaJDBC categoriaDao = new CategoriaJDBC();
		Categoria c = categoriaDao.buscar(1);
		Produto p = new Produto("nome", 100.0, true, "modelo", 20.0, c);
		ProdutoJDBC produtoDao = new ProdutoJDBC();
		
		produtoDao.inserir(p);
		
		for(Produto achou:produtoDao.listar()) {
			if(achou.equals(p)) {
				p.setCodigo(achou.getCodigo());
			}
		} 
		
		p.setNome("nome02");
		produtoDao.alterar(p);
		produtoDao.excluir(p.getCodigo());
		
		produtoDao.buscar(p.getCodigo());

	}

}
