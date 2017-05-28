package models;

public class ProdutoComTamanho extends Produto {

	private int tam;

	public ProdutoComTamanho(String nome, int codigo, int preco, int tam) {
		super(nome, codigo, preco);
		this.tam = tam;
	}

	@Override
	public int hashCode() {
		int hash = super.hashCode();
		return (hash * 31 + tam);
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof ProdutoComTamanho)) {
			return false;
		}
		ProdutoComTamanho pct = (ProdutoComTamanho) o;
		if (this.hashCode() == pct.hashCode()) {
			return true;
		} 
		return false;
	}
}
