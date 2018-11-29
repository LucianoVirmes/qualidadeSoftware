package principal.model;

import java.util.ArrayList;

public class Categoria {

	private Integer codigo;
	private String nome;
	private ArrayList<Produto> produtos;

	public Categoria() {
	}

	public Categoria(Integer codigo, String nome, ArrayList<Produto> produtos) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.produtos = produtos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(ArrayList<Produto> produtos) {
		this.produtos = produtos;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return this.nome;
	}

}
