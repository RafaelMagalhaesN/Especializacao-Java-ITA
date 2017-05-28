package models;

import java.util.HashMap;

public class CarrinhoDeCompras {

	private HashMap<Produto, Integer> cadaProduto = new HashMap<Produto, Integer>();
	private static int totalCompra;
	private static int quantidade;
	
	public int adicionaProduto(Produto produto, int quantidade) {
		if (cadaProduto.containsKey(produto)) {
			cadaProduto.put(produto, quantidade += quantidade);
		} else {
			cadaProduto.put(produto, quantidade);
		}
		this.quantidade += quantidade;
		return this.quantidade;
	}
	
	public void removeProduto(Produto produto, int quantidade){
		if(cadaProduto.containsKey(produto)){
			cadaProduto.remove(produto);
			this.quantidade -= quantidade;
		}
	}
	
	public int calculaOValorTotalDaCompra(){
		for(Produto produto : cadaProduto.keySet()){
			totalCompra = produto.getPreco()*quantidade;
			
		}
		return totalCompra;
	}
	
}
