package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import principal.model.Cliente;

public class ClienteTest {

	@Test
	public void testaClasseCliente() throws Exception{
		Cliente cliente = new Cliente(1, "email", "nome", "sobrenome", "senha", "cpf", "cidade",
				"estado", "bairro", "rua", "numero", null);
		Cliente c = new Cliente();
		c.setCodigo(1);
		c.setEmail("email");
		c.setNome("nome");
		c.setSobrenome("sobrenome");
		c.setSenha("senha");
		c.setCpf("cpf");
		c.setCidade("cidade");
		c.setEstado("estado");
		c.setBairro("bairro");
		c.setRua("rua");
		c.setNumero("numero");
		c.setCarrinho(null);
		
		assertEquals(cliente, c);
		
		assertEquals(Integer.valueOf(1), c.getCodigo());
		assertEquals("nome", c.getNome());
		assertEquals("email", c.getEmail());
		assertEquals("sobrenome", c.getSobrenome());
		assertEquals("cpf", c.getCpf());
		assertEquals("senha", c.getSenha());
		assertEquals("cidade", c.getCidade());
		assertEquals("estado", c.getEstado());
		assertEquals("bairro", c.getBairro());
		assertEquals("rua", c.getRua());
		assertEquals("numero", c.getNumero());
		assertEquals(null, c.getCarrinho());

	}

}
