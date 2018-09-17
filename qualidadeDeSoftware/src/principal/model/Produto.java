package principal.model;

public class Produto {

	private Integer codigo;
	private String nome;
	private Double valor;
	private Boolean disponibilidade;
	private String modelo;
	private Double porcentagemDesconto;

	private Categoria categoria;
	
	/**
	 * calcula valor do produto com desconto
	 */
	public Double valorProduto() {
		return this.valor - (this.porcentagemDesconto / 100);
	}

	public Produto() {

	}

	public Produto(Integer codigo, String nome, Double valor, Boolean disponibilidade, String modelo,
			Double porcentagemDesconto, Categoria categoria) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.valor = valor;
		this.disponibilidade = disponibilidade;
		this.modelo = modelo;
		this.porcentagemDesconto = porcentagemDesconto;
		this.categoria = categoria;
	}
	
	public Produto(String nome, Double valor, Boolean disponibilidade, String modelo,
			Double porcentagemDesconto, Categoria categoria) {
		this.nome = nome;
		this.valor = valor;
		this.disponibilidade = disponibilidade;
		this.modelo = modelo;
		this.porcentagemDesconto = porcentagemDesconto;
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

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Double getPorcentagemDesconto() {
		return porcentagemDesconto;
	}

	public void setPorcentagemDesconto(Double porcentagemDesconto) {
		this.porcentagemDesconto = porcentagemDesconto;
	}

	@Override
	public String toString() {
		return "Produto [codigo=" + codigo + ", nome=" + nome + ", valor=" + valor + ", disponibilidade="
				+ disponibilidade + ", modelo=" + modelo + ", porcentagemDesconto=" + porcentagemDesconto
				+ ", categoria=" + categoria + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((modelo == null) ? 0 : modelo.hashCode());
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
		Produto other = (Produto) obj;
		if (modelo == null) {
			if (other.modelo != null)
				return false;
		} else if (!modelo.equals(other.modelo))
			return false;
		return true;
	}

	
}
