package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.jupiter.api.Test;

import principal.conexao.ConexaoUtil;
import principal.dao.ClienteJDBC;
import principal.model.Cliente;

class BancoClienteTest {

	@Test
	void testaBanco() {
		Cliente cliente = new Cliente("email", "nome", "sobrenome", "senha", "cpf", "cidade",
				"estado", "bairro", "rua", "numero", null);
		ClienteJDBC clienteDao = new ClienteJDBC();  
		
		clienteDao.inserir(cliente);
		
//		Integer i = null;
//		try {
//			Statement statement = ConexaoUtil.getConn().createStatement();
//			ResultSet rs = statement.executeQuery("select last_insert_id()");
//			i =  ((Number) rs.getObject(1)).intValue();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		cliente.setBairro("bairro2");
		
		clienteDao.alterar(clienteDao.buscarPorNome(cliente.getNome()));
		
		Cliente cl = clienteDao.buscarPorNome(cliente.getNome());
		clienteDao.excluir(cl.getCodigo());
		
	}

}
