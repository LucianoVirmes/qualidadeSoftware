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
	
	/**
	 * informa o login e senha do cliente para a validação
	 * @param login
	 * @param senha
	 * @return booleano informando se o login é valido ou não
	 */
	public boolean verificalogin(String login, String senha) {
		return (login.equals(this.email) && senha.equals(this.senha));
	}

	/**
	 * verifica se o cpf do cliente é valido ou não
	 * @return verdadeiro em caso de cpf ser verdadeiro
	 */
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
	
	public Cliente(String email, String nome, String sobrenome, String senha, String cpf, String cidade,
			String estado, String bairro, String rua, String numero, Carrinho carrinho) {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bairro == null) ? 0 : bairro.hashCode());
		result = prime * result + ((carrinho == null) ? 0 : carrinho.hashCode());
		result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		result = prime * result + ((rua == null) ? 0 : rua.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		result = prime * result + ((sobrenome == null) ? 0 : sobrenome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (bairro == null) {
			if (other.bairro != null)
				return false;
		} else if (!bairro.equals(other.bairro))
			return false;
		if (carrinho == null) {
			if (other.carrinho != null)
				return false;
		} else if (!carrinho.equals(other.carrinho))
			return false;
		if (cidade == null) {
			if (other.cidade != null)
				return false;
		} else if (!cidade.equals(other.cidade))
			return false;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		if (rua == null) {
			if (other.rua != null)
				return false;
		} else if (!rua.equals(other.rua))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		if (sobrenome == null) {
			if (other.sobrenome != null)
				return false;
		} else if (!sobrenome.equals(other.sobrenome))
			return false;
		return true;
	}

	
}
