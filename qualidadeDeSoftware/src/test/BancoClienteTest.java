package test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
		 
		Cliente cl = clienteDao.buscarPorNome(cliente.getNome());
		assertEquals(cl, cliente);
				
		Cliente clienteCod = clienteDao.buscar(cliente.getCodigo());
		assertEquals(clienteCod, cliente);
		
		clienteDao.alterar(cliente);
		assertFalse(clienteDao.buscar(cliente.getCodigo()) == clienteCod);
		clienteDao.excluir(cliente.getCodigo());
		
		assertNull(clienteDao.buscar(cliente.getCodigo()));
		
	}

}
