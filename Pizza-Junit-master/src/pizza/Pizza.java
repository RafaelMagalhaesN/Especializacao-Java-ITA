package pizza;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Pizza {

	private String ingrediente;
	private int quantidade;
	public static HashMap<String, Integer> ingredientes = new HashMap<String, Integer>();
	private static double valor;
	private static double valorTotal;
	CarrinhoDeCompras carrinhoDeCompras;

	// adiciona os ingredientes
	public String adicionaIngrediente(String ingrediente, int quantidade) {
		this.ingrediente = ingrediente;
		this.quantidade = quantidade + this.quantidade;
		contabilizaIngrediente(ingrediente, quantidade);
		return ingrediente;
	}

	public String getingrediente() {
		return ingrediente;
	}

	public int getQuantidade() {
		return quantidade;
	}

	// faz a verificação do valor
	public double getPreco() {
		if (quantidade <= 2) {

			return valor = 15.00 + valor;
		} else if (quantidade >= 3 && quantidade <= 4) {

			return valor = 20.00 + valor;
		} else {

			return valor = 23.00 + valor;
		}

	}

	// contabiliza o ingrediente
	private static void contabilizaIngrediente(String ingrediente, int quantidade) {
		if (ingredientes.containsKey(ingrediente)) {
			int a = quantidade;
			ingredientes.put(ingrediente, quantidade + a);

		} else {
			ingredientes.put(ingrediente, quantidade);

		}
	}

	// faz a verificação se nao é vazio
	public boolean possuiIngredientes() {
		return quantidade > 0;
	}

	public static void zerarOsIngredientes() {
		ingredientes.clear();
	}

}
