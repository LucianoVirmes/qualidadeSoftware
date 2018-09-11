package principal.dao;

public interface DaoFactory {

	ClienteDAO clienteDao();
	
	ProdutoDAO produtoDAO();
}
