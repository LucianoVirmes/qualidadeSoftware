package principal.conexao;

public enum TipoConexao {

	TESTES(new PropriedadesConexao("QualiTeste.properties")), 
	DESENVOLVIMENTO(new PropriedadesConexao("QualiDesenvolvimento.properties")), 
	CLIENTE(new PropriedadesConexao("QualiCliente.properties"));
	
	TipoConexao(PropriedadesConexao propriedadesConexao) {
		this.propriedadesConexao = propriedadesConexao;
	}
	
	private PropriedadesConexao propriedadesConexao;
	
	public String getUser() {
		return propriedadesConexao.getUser();
	}
	public String getPass() {
		return propriedadesConexao.getPass();
	}
	public String getUrl() {
		return propriedadesConexao.getUrl();
	}
	
	
}
