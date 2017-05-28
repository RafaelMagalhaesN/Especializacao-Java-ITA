package mocks;

import caixaEletronico.ContaCorrente;
import caixaEletronicoInterface.Hardware;
import caixaEletronicoInterface.ServicoRemoto;
import exceptions.HardwareCartaoException;
import exceptions.HardwareDinheiroException;
import exceptions.HardwareLerEnvelopesException;

public class HardwareMock implements Hardware {

	private double valor, valorAlterado = 0;
	private ServicoRemotoMock servicoRemotoMock;
	private ContaCorrente contaCorrente;
	private String nConta;

	public double getValorAlterado() {
		return valorAlterado;
	}

	public void setValorAlterado(double valorAlterado) {
		this.valorAlterado = valorAlterado;
	}
	
	public double getValor() {
		return valor;
	}

	public void setSaldo(double valor) {
		this.valor = valor;
	}

	@Override
	public String pegarNumeroDaContaCartao(String nContaCartao) {
		if (nContaCartao != null) {
			this.nConta = nContaCartao;
			return nConta;
		} else {
			throw new HardwareCartaoException();
		}
	}

	@Override
	public void entregarDinheiro(String nContaCartao) {
		if (nContaCartao != null) {
		} else {
			throw new HardwareDinheiroException();
		}
	}

	@Override
	public void lerEnvelope(double valor) {
		if (valor != 0) {
			setValorAlterado(this.valorAlterado + valor);
		} else{
			throw new HardwareLerEnvelopesException();
		}
	}



}
