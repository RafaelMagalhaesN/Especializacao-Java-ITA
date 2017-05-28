package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import models.Produto;

public class ProdutoTeste {

	Produto produto1, produto2;
	
	@Before
	public void setUp(){
		produto1 = new Produto("Calça SergioK", 1515, 50);
		produto2 = new Produto("Bermuda SergioK", 1515, 50);
	}
	
	@Test
	public void testeEquals(){
		assertEquals(produto1.equals(produto2), produto2.equals(produto1));
	}
	
	@Test
	public void testeHashCode(){
		assertEquals(produto1.hashCode(), produto2.hashCode());
	}
}
