package principal.model;

public class Cliente {

	private Integer codigo;
	private String email;
	private String nome;
	private String sobrenome;
	private String senha;
	private String cpf;
	private String cidade;
	private String estado;
	private String bairro;
	private String rua;
	private String numero;

	private Carrinho carrinho;

	public boolean verificalogin(String login, String senha) {
		return (login.equals(this.email) && senha.equals(this.senha));
	}

	public Boolean validaCpf() {
		boolean cpfValido = false;
		int decimaPosicao = 10;
		int total = 0;
		char[] chars = this.cpf.toCharArray();

		for (int i = 0; i < 9; i++) {
			int valorCaracterEmPosicao = Integer.valueOf(String.valueOf(chars[i]));
			total = total + (valorCaracterEmPosicao * decimaPosicao);
			decimaPosicao--;
		}

		int validacao1 = total % 11;
		validacao1 = 11 - validacao1;
		if (validacao1 > 9) {
			validacao1 = 0;
		}

		int valorCaracterEmPosicao9 = Integer.valueOf(String.valueOf(chars[9]));

		if (validacao1 == valorCaracterEmPosicao9) {
			cpfValido = true;
		}

		int decimaPrimeiraPosicao = 11;
		total = 0;
		for (int i = 0; i < 10; i++) {
			int valorCaracterEmPosicao = Integer.valueOf(String.valueOf(chars[i]));
			total = total + (valorCaracterEmPosicao * decimaPrimeiraPosicao);
			decimaPrimeiraPosicao--;
		}

		int validacao2 = total % 11;
		validacao2 = 11 - validacao2;

		if (validacao2 > 9) {
			validacao2 = 0;
		}

		int valorCaracterEmPosicao10 = Integer.valueOf(String.valueOf(chars[10]));

		if (validacao2 == valorCaracterEmPosicao10) {
			cpfValido = true;
		}

		if (!cpfValido) {
			return false;
		} else {
			return true;
		}

	}

	public Cliente() {
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Cliente(Integer codigo, String email, String nome, String sobrenome, String senha, String cpf, String cidade,
			String estado, String bairro, String rua, String numero, Carrinho carrinho) {
		super();
		this.codigo = codigo;
		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.senha = senha;
		this.cpf = cpf;
		this.cidade = cidade;
		this.estado = estado;
		this.bairro = bairro;
		this.rua = rua;
		this.numero = numero;
		this.carrinho = carrinho;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Carrinho getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(Carrinho carrinho) {
		this.carrinho = carrinho;
	}

}
