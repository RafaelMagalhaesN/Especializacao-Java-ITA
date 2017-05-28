package caixaEletronicoTeste;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import caixaEletronico.CaixaEletronico;
import caixaEletronico.ContaCorrente;
import exceptions.HardwareCartaoException;
import exceptions.HardwareDinheiroException;
import exceptions.HardwareLerEnvelopesException;
import exceptions.LoginException;
import mocks.HardwareMock;
import mocks.ServicoRemotoMock;

public class CaixaEletronicoTeste {

	private CaixaEletronico caixaEletronico;
	private CaixaEletronico caixaEletronico2;
	private ServicoRemotoMock servicoRemotoMock;
	private HardwareMock hardwareMock;

	@Before
	public void init() {
		caixaEletronico = new CaixaEletronico();
		caixaEletronico2 = new CaixaEletronico();
		servicoRemotoMock = new ServicoRemotoMock();
		hardwareMock = new HardwareMock();

		servicoRemotoMock.ServicoRemotoMock("aaac1", 100.0);
		servicoRemotoMock.ServicoRemotoMock("aaac2", 500.0);

	}

	@Test
	public void verificaSaldo() {
		caixaEletronico.logar("aaac2");
		// Conta 2 com saldo de 500 Reais
		assertEquals("O saldo é R$ 500.0", caixaEletronico.saldo());
	}

	@Test
	public void verificaSaque() {
		caixaEletronico.logar("aaac1");
		// Conta 1 com saldo de 100 Reais
		assertEquals("Retire seu dinheiro", caixaEletronico.sacar(30.0));
	}

	@Test
	public void verificaSaqueII() {
		caixaEletronico.logar("aaac1");
		// Conta 1 com saldo de 200
		assertEquals("Saldo insuficiente", caixaEletronico.sacar(300.0));
	}

	@Test
	public void verificaDeposito() {
		caixaEletronico.logar("aaac1");
		// Conta 1 com saldo de 100 Reais e acrescido 10 Reais
		assertEquals("Depósito recebido com sucesso", caixaEletronico.depositar(10.0));
		assertEquals("O saldo é R$ 110.0", caixaEletronico.saldo());
	}

	@Test
	public void verificaLoginI() {
		// Logado com sucesso
		assertEquals("Usuário Autenticado", caixaEletronico.logar("aaac1"));
	}

	@Test(expected = LoginException.class)
	public void verificaLoginII() {
		// Login sem sucesso - conta não existe
		assertEquals("Não foi possível autenticar o usuário", caixaEletronico2.logar("aaac3"));
	}

	@Test(expected = HardwareCartaoException.class)
	public void falhasDeCartao() {
		// Falha na leitura do cartao
		assertEquals("Falha no hardware de leitura de cartões", hardwareMock.pegarNumeroDaContaCartao(null));
	}

	@Test(expected = HardwareDinheiroException.class)
	public void falhasDeDinheiro() {
		// Falha no dispositivo de dinheiro
		hardwareMock.entregarDinheiro(null);
	}
	
	@Test(expected = HardwareLerEnvelopesException.class)
	public void falhasDeHardwareLerEnvelopes() {
		// Falha no hardware de ler envelopes sem notas de dinheiro
		hardwareMock.lerEnvelope(0);
	}
	
	

}
