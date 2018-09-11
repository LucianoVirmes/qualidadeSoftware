package principal.model;

import java.util.ArrayList;

public class Categoria {

	private String nome;
	private ArrayList<Produto> produtos;

	public Categoria() {
	}

	public Categoria(String nome, ArrayList<Produto> produtos) {
		super();
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

	@Override
	public String toString() {
		return "Categoria [nome=" + nome + ", produtos=" + produtos + "]";
	}

}
