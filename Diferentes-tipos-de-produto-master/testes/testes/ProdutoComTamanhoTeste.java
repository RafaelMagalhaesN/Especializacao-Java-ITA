package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import models.Produto;
import models.ProdutoComTamanho;

public class ProdutoComTamanhoTeste {

	Produto produto1, produto2;
	
	@Before
	public void setUp() throws Exception {
		produto1 = new ProdutoComTamanho("Tenis  Nike", 999, 180, 42);
		produto2 = new ProdutoComTamanho("Tenis Adidas", 999, 190, 42);
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
