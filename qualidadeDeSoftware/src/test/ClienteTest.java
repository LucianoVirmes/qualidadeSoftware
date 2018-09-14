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
		
		

	}

}
