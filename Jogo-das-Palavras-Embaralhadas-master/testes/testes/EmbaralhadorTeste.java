package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import embaralhadores.EmbaralhadorDificil;
import embaralhadores.EmbaralhadorFacil;
import embaralhadores.EmbaralhadorMedio;

public class EmbaralhadorTeste {

	EmbaralhadorFacil embaralhadorFacil;
	EmbaralhadorMedio embaralhadorMedio;
	EmbaralhadorDificil embaralhadorDificil;
	
	@Before
	public void setUp() throws Exception {
		embaralhadorFacil = new EmbaralhadorFacil();
		embaralhadorMedio = new EmbaralhadorMedio();
		embaralhadorDificil = new EmbaralhadorDificil();
	}

	@Test
	public void embaralhadorFacil() {
		assertEquals("leafaR", embaralhadorFacil.retornaEmbaralhado("Rafael"));
		assertEquals(2, embaralhadorFacil.dificuldade());
	}
	
	@Test
	public void embaralhadorMedio() {
		assertEquals("aelRaf", embaralhadorMedio.retornaEmbaralhado("Rafael"));
		assertEquals(5, embaralhadorMedio.dificuldade());
	}
	
	@Test
	public void embaralhadorDificil() {
		/**
		 * Foi usando somente 2 letras pois o metodo 
		 * de embaralhamento nessa dificuldade 
		 * é randomico e sem logica para o embaralhamento.
		 */
		assertEquals("Ra", embaralhadorDificil.retornaEmbaralhado("Ra"));
		assertEquals(10, embaralhadorDificil.dificuldade());
	}

}
