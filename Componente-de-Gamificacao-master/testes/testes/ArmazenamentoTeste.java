package testes;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import Exceptions.PontoInvalidoException;
import armazenamento.Armazenamento;

public class ArmazenamentoTeste {
	Armazenamento armazenamento;
	ArrayList<String> nomes;
	ArrayList<String> tiposDePontos;

	@Before
	public void setUp() {
		armazenamento = new Armazenamento();
		nomes = new ArrayList<>();			
		nomes.add("Rafael");
		nomes.add("Arthur");
		nomes.add("Ana");
		nomes.add("Iaco");	
	}

	@Test
	public void testeCriarArquivo() {
		armazenamento.ArmazenamentoDePontos("Rafael", "estrela", 5);		
		armazenamento.ArmazenamentoDePontos("Arthur", "like", 25);
		armazenamento.ArmazenamentoDePontos("Arthur", "estrela", 235);
		armazenamento.ArmazenamentoDePontos("Iaco", "like", 125);
		armazenamento.ArmazenamentoDePontos("Luan", "comentarios", 0);	
		armazenamento.ArmazenamentoDePontos("Ana", "like", 325);
		armazenamento.ArmazenamentoDePontos("Ana", "comentarios", 25);	
		
	}
	
	@Test
	public void testeQuantosPontosDeUmTipoTemUmUsuario(){
		assertEquals("25", armazenamento.quantosPontosDeUmTipoTemUmUsuario("Arthur", "like"));	
		assertEquals("25", armazenamento.quantosPontosDeUmTipoTemUmUsuario("Ana", "comentarios"));	
		
	}
	
	@Test
	public void testeTodosOsUsuariosComPontos(){		
		assertEquals(nomes, armazenamento.todosOsUsuariosComPontos());	
	}

	@Test
	public void testeTodosOsTiposDePontosRegistrados(){
		tiposDePontos = new ArrayList<>();
		tiposDePontos.add("like");
		tiposDePontos.add("comentarios");
		assertEquals(tiposDePontos, armazenamento.todosOsTiposDePontosRegistrados("Ana"));
	}
	
	
	@Test(expected=PontoInvalidoException.class)
	public void testePontoZerado(){		
		assertEquals("0", armazenamento.quantosPontosDeUmTipoTemUmUsuario("Luan", "comentarios"));
	}


}
