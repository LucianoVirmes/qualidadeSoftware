package test;

import org.junit.jupiter.api.Test;

import principal.dao.ProdutoJDBC;
import principal.model.Produto;

class BancoProdutoTest {

	@Test
	void test() {
		Produto p = new Produto("nome", 100.0, true, "modelo", 20.0, null);
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
		
		

	}

}
