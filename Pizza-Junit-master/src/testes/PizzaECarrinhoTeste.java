package testes;

import static org.junit.Assert.*;

import java.security.Principal;

import org.junit.Before;
import org.junit.Test;

import pizza.CarrinhoDeCompras;
import pizza.Pizza;

public class PizzaECarrinhoTeste {

	Pizza pizza;
	CarrinhoDeCompras carrinhoDeCompras;

	@Before
	public void setUp() {
		pizza = new Pizza();
		carrinhoDeCompras = new CarrinhoDeCompras();

		// Zera os ingredientes;
		Pizza.zerarOsIngredientes();
	}

	@Test
	public void verificaQuantidaDeDePizzas() {
		pizza.adicionaIngrediente("cebolas", 1);
		pizza.adicionaIngrediente("queijo", 2);
		pizza.adicionaIngrediente("tomates", 3);
		pizza.adicionaIngrediente("parmesao", 4);

		// Verifica a quantidade
		assertEquals("1", carrinhoDeCompras.adicionar(pizza));

		pizza.adicionaIngrediente("oregano", 1);
		pizza.adicionaIngrediente("cebolinhas", 2);
		pizza.adicionaIngrediente("tomatinhos", 3);
		pizza.adicionaIngrediente("parmesao", 4);

		// Verifica a quantidade quando for adicionado 2 pizzas
		assertEquals("2", carrinhoDeCompras.adicionar(pizza));
	}

	@Test
	public void verificaQuantidaDeIngredientes() {
		pizza.adicionaIngrediente("parmesao", 4);

		// Verifica a quantidade de ingredientes
		assertEquals("4", String.valueOf(Pizza.ingredientes.get("parmesao")));
	}

	@Test
	public void verificaPizzaVazia() {		
		pizza = new Pizza();

		// Quantidade de pizzas vazia
		assertEquals("Pizza sem ingredientes", carrinhoDeCompras.adicionar(pizza));

	}

	@Test
	public void verificaValor() {		
		pizza.adicionaIngrediente("cebolas", 1);
		pizza.adicionaIngrediente("queijo", 2);

		carrinhoDeCompras.adicionar(pizza);

		// Verifica o valor
		assertEquals("20.0", String.valueOf(pizza.getPreco()));

	}

	@Test
	public void verificaRegistroDeIngredientes() {
		pizza = new Pizza();

		// Verifica o ingrediente
		assertEquals("cebolas", pizza.adicionaIngrediente("cebolas", 1));

	}

}
