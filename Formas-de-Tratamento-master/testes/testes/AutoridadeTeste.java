package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import exceptions.ErroNomeException;
import interfaces.FormatadorNome;
import models.Autoridade;
import models.ComTitulo;
import models.Informal;
import models.Respeitoso;

public class AutoridadeTeste {

	Autoridade autoridade;
	FormatadorNome formatadorNome;
	

	@Test
	public void testeComTitulo() {
		autoridade = new Autoridade("Rafael","Magalhaes",formatadorNome = new ComTitulo("Supremo Senhor do Universo"));
		assertEquals("Supremo Senhor do Universo Rafael Magalhaes",autoridade.getTratamento());	
		
	}

	@Test
	public void testeComTituloII() {
		autoridade = new Autoridade("Pedro","Cabral",formatadorNome = new ComTitulo("Magnífico"));
		assertEquals("Magnífico Pedro Cabral",autoridade.getTratamento());	
		
	}
	
	@Test
	public void testeInformal() {
		autoridade = new Autoridade("John","Tolkien",formatadorNome = new Informal());
		assertEquals("John",autoridade.getTratamento());			
	}
	
	@Test
	public void testeInformalII() {
		autoridade = new Autoridade("Rafael","Magalhães",formatadorNome = new Informal());
		assertEquals("Rafael",autoridade.getTratamento());			
	}
	
	@Test
	public void testeMasculino() {
		autoridade = new Autoridade("John","Smith",formatadorNome = new Respeitoso("masculino"));
		assertEquals("Sr. Smith",autoridade.getTratamento());			
	}
	
	@Test
	public void testeFeminino() {
		autoridade = new Autoridade("Jane","Smith",formatadorNome = new Respeitoso("feminino"));
		assertEquals("Sra. Smith",autoridade.getTratamento());			
	}
	
}
