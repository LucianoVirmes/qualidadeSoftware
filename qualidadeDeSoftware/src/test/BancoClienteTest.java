package test;
import org.junit.jupiter.api.Test;
import principal.dao.ClienteJDBC;
import principal.model.Cliente;

class BancoClienteTest {

	@Test
	void testaBanco() {
		Cliente cliente = new Cliente("email", "nome", "sobrenome", "senha", "cpf", "cidade",
				"estado", "bairro", "rua", "numero", null);
		ClienteJDBC clienteDao = new ClienteJDBC();  
		
		clienteDao.inserir(cliente);
		
		cliente.setBairro("bairro2");
		
		for(Cliente achou : clienteDao.listar()) {
			if(achou.equals(cliente)) {
				cliente.setCodigo(achou.getCodigo());
			}
		}
		
		clienteDao.alterar(cliente);
		//Cliente cl = clienteDao.buscarPorNome(cliente.getNome());
		clienteDao.excluir(cliente.getCodigo());
		
	}

}
