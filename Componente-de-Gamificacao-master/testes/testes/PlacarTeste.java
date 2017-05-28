package testes;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import armazenamento.Armazenamento;
import mocks.ArmazenamentoMock;
import placar.Placar;

public class PlacarTeste {
	
	Placar placar;
	ArrayList<String> rankingEstrelaVerificador;
	
	ArrayList<String> tiposPontos;
	@Before
	public void setUp() {		
		placar = new Placar(new ArmazenamentoMock());	
		placar.registrarUmTipoDePontoParaUmUsuario("Iaco", "like", 5);
		placar.registrarUmTipoDePontoParaUmUsuario("Rafael", "like", 55);
		placar.registrarUmTipoDePontoParaUmUsuario("Gabriel", "like", 12);
		placar.registrarUmTipoDePontoParaUmUsuario("Cesar", "like", 28);
		placar.registrarUmTipoDePontoParaUmUsuario("Yago", "like", 1);
		placar.registrarUmTipoDePontoParaUmUsuario("Eidy", "like", 35);
		placar.registrarUmTipoDePontoParaUmUsuario("Rafael", "moedas", 18);
		placar.registrarUmTipoDePontoParaUmUsuario("Rafael", "dinheiros", 999);
		placar.registrarUmTipoDePontoParaUmUsuario("Rafael", "moneys", 850);
		
		placar.registrarUmTipoDePontoParaUmUsuario("Luan", "estrela", 19);
		placar.registrarUmTipoDePontoParaUmUsuario("Richard", "estrela", 55);
		placar.registrarUmTipoDePontoParaUmUsuario("Allan", "estrela", 15);
		placar.registrarUmTipoDePontoParaUmUsuario("Natan", "estrela", 18);
		
		rankingEstrelaVerificador = new ArrayList<>();
		rankingEstrelaVerificador.add("Richard: 55");
		rankingEstrelaVerificador.add("Luan: 19");
		rankingEstrelaVerificador.add("Natan: 18");
		rankingEstrelaVerificador.add("Allan: 15");
		
		tiposPontos = new ArrayList<>();
		tiposPontos.add("like: 55");
		tiposPontos.add("moedas: 18");
		tiposPontos.add("dinheiros: 999");
		tiposPontos.add("moneys: 850");
		
	}
	
	@Test
	public void testeRegistrarUmTipoDePontoParaUmUsuario() {		
		placar.registrarUmTipoDePontoParaUmUsuario("Rafael", "moedinhas", 850);
	}
	
	@Test
	public void testeRetornarTodosOsPontosDeUmUsuario() {		
		assertEquals(tiposPontos, placar.retornarTodosOsPontosDeUmUsuario("Rafael"));
	}
	
	@Test
	public void testeRetornarRanking() {		
		assertEquals(rankingEstrelaVerificador, placar.retornarRanking("estrela"));
	}
	
}
