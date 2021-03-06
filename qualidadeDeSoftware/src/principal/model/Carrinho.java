package principal.model;

import java.util.ArrayList;

public class Carrinho {

	private ArrayList<Produto> produtos;

	/**
	 * adiciona um produto no carrinho
	 * @param prod
	 */
	public void addCarrinho(Produto prod) {
		this.produtos.add(prod);
	}
	
	/**
	 * remove o produto informado por parametro do carrinho
	 * @param prod
	 */
	public void removerCarrinho(Produto prod) {
		for (Produto p : produtos) {
			if (p.equals(prod)) {
				produtos.remove(p);
			}
		}
	}

	public Carrinho() {
	}

	public Carrinho(ArrayList<Produto> produtos) {
		super();
		this.produtos = produtos;
	}

	public ArrayList<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(ArrayList<Produto> produtos) {
		this.produtos = produtos;
	}

	@Override
	public String toString() {
		return "Carrinho [produtos=" + produtos + "]";
	}

}
