package caixaEletronico;

import java.util.ArrayList;

import caixaEletronicoInterface.Hardware;
import caixaEletronicoInterface.ServicoRemoto;
import exceptions.LoginException;
import mocks.HardwareMock;
import mocks.ServicoRemotoMock;

public class CaixaEletronico {

	private HardwareMock hardwareMock;
	private ServicoRemotoMock servicoRemotoMock;
	private ContaCorrente contaCorrente;
	private String nConta;


	public String logar(String nConta) {

		servicoRemotoMock = new ServicoRemotoMock();
		servicoRemotoMock.recuperarConta(nConta);
		contaCorrente = new ContaCorrente(servicoRemotoMock.getnConta(), servicoRemotoMock.getSaldo());
		
		if (contaCorrente.getnConta() != null) {
			this.nConta = nConta;
			return "Usuário Autenticado";
		} else {
			throw new LoginException();
		}

	}

	public String sacar(double valor) {
		if (contaCorrente.getSaldo() > valor) {
			contaCorrente.setSaldo(contaCorrente.getSaldo() - valor);
			servicoRemotoMock.persistirConta(nConta, contaCorrente.getSaldo());
			return "Retire seu dinheiro";
			
		} else {
			return "Saldo insuficiente";
		}

	}

	public String depositar(double valor) {
		hardwareMock = new HardwareMock();
		hardwareMock.setSaldo(contaCorrente.getSaldo());
		hardwareMock.lerEnvelope(valor);
		contaCorrente.adicionarNaConta(hardwareMock.getValorAlterado());
		hardwareMock.entregarDinheiro(nConta);
		servicoRemotoMock.persistirConta(nConta, contaCorrente.getSaldo());
		
		return "Depósito recebido com sucesso";

	}

	public String saldo() {		
		return "O saldo é R$ " + String.valueOf(contaCorrente.getSaldo());
	}

	
}
