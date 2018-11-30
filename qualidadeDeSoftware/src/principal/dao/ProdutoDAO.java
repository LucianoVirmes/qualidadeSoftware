package principal.dao;

import java.util.List;

import principal.model.Produto;

public interface ProdutoDAO extends GenericDAO<Produto> {
	
	List<Produto> produtosEmOferta();

}
