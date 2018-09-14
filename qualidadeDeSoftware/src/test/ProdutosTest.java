package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import principal.model.Produto;

class ProdutosTest {

	@Test
	void testaClasseProdutos() throws Exception{
		Produto p = new Produto(1, "nome", 100.0, true, "modelo", 20.0, null);
		
		Produto p1 = new Produto();
		
		p1.setCodigo(1);
		p1.setNome("nome");
		p1.setValor(100.0);
		p1.setDisponibilidade(true);
		p1.setModelo("modelo");
		p1.setPorcentagemDesconto(20.0);
		p1.setCategoria(null);
		
		assertEquals(p, p1);
		
		
	}

}
