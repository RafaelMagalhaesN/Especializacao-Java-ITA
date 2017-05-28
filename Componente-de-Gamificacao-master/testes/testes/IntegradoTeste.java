package testes;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import Exceptions.PontoInvalidoException;
import armazenamento.Armazenamento;
import mocks.ArmazenamentoMock;
import placar.Placar;

public class IntegradoTeste {

	Placar placar;
	ArrayList<String> rankingEstrelaVerificador;
	ArrayList<String> tiposPontos;

	@Before
	public void setUp() {
		placar = new Placar(new Armazenamento());

	}

	@Test
	public void testeCriarArquivo() {
		placar.registrarUmTipoDePontoParaUmUsuario("Rafael", "estrela", 5);
		placar.registrarUmTipoDePontoParaUmUsuario("Arthur", "like", 25);
		placar.registrarUmTipoDePontoParaUmUsuario("Arthur", "estrela", 235);
		placar.registrarUmTipoDePontoParaUmUsuario("Iaco", "like", 125);
		placar.registrarUmTipoDePontoParaUmUsuario("Luan", "comentarios", 0);
		placar.registrarUmTipoDePontoParaUmUsuario("Ana", "like", 325);
		placar.registrarUmTipoDePontoParaUmUsuario("Ana", "comentarios", 225);

	}

	@Test
	public void testeQuantosPontosDeUmTipoTemUmUsuario() {
		tiposPontos = new ArrayList<>();
		tiposPontos.add("like: 25");
		tiposPontos.add("estrela: 235");
		assertEquals(tiposPontos, placar.retornarTodosOsPontosDeUmUsuario("Arthur"));
	}

	@Test
	public void testeRetornarRanking() {
		rankingEstrelaVerificador = new ArrayList<>();
		rankingEstrelaVerificador.add("Arthur: 235");
		rankingEstrelaVerificador.add("Rafael: 5");		
		assertEquals(rankingEstrelaVerificador, placar.retornarRanking("estrela"));
		
		rankingEstrelaVerificador = new ArrayList<>();
		rankingEstrelaVerificador.add("Ana: 325");
		rankingEstrelaVerificador.add("Iaco: 125");
		rankingEstrelaVerificador.add("Arthur: 25");		
		assertEquals(rankingEstrelaVerificador, placar.retornarRanking("like"));
	}

	@Test(expected=PontoInvalidoException.class)
	public void testePontoZerado(){		
		assertEquals("0", placar.retornarTodosOsPontosDeUmUsuario("Luan"));
	}
	
}
