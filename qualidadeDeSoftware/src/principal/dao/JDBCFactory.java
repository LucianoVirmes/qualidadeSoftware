package principal.dao;

public class JDBCFactory implements DaoFactory{

	@Override
	public ClienteDAO clienteDao() {
		return new ClienteJDBC();
	}

	@Override
	public ProdutoDAO produtoDAO() {
		return new ProdutoJDBC();
	}


}
