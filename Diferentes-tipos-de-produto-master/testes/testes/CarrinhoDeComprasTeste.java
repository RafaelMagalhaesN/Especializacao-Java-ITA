package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import models.CarrinhoDeCompras;
import models.Produto;

public class CarrinhoDeComprasTeste {

	Produto produto, produto2;
	CarrinhoDeCompras carrinhoDeCompras;
	
	@Before
	public void setUp(){
		produto = new Produto("Camiseta RasgaRapido", 15884, 18);
		produto2 = new Produto("Cueca Calvin", 19884, 100);
		carrinhoDeCompras = new CarrinhoDeCompras();
	}
	
	
	@Test
	public void testeValorTotal(){		
		assertEquals(1, carrinhoDeCompras.adicionaProduto(produto2, 1));
		assertEquals(100, carrinhoDeCompras.calculaOValorTotalDaCompra());
	}
	
	@Test
	public void testeQuantidade(){		
		assertEquals(3, carrinhoDeCompras.adicionaProduto(produto, 2));
	}
	


}
