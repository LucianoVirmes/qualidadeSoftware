package principal.model;

public class Produto {

	private String nome;
	private Double valor;
	private Boolean disponibilidade;
	private String modelo;

	private Categoria categoria;

	public Produto() {

	}

	public Produto(String nome, Double valor, Boolean disponibilidade, String modelo, Categoria categoria) {
		super();
		this.nome = nome;
		this.valor = valor;
		this.disponibilidade = disponibilidade;
		this.modelo = modelo;
		this.categoria = categoria;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Boolean getDisponibilidade() {
		return disponibilidade;
	}

	public void setDisponibilidade(Boolean disponibilidade) {
		this.disponibilidade = disponibilidade;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Produto [nome=" + nome + ", valor=" + valor + ", disponibilidade=" + disponibilidade + ", modelo="
				+ modelo + "]";
	}

}
