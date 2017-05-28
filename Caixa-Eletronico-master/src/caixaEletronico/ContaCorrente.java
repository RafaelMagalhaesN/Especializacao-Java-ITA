package caixaEletronico;

import caixaEletronicoInterface.ServicoRemoto;
import mocks.ServicoRemotoMock;

public class ContaCorrente {

	private double saldo;
	private String nConta;
	
	
	public ContaCorrente(String nConta, double saldo){
		this.nConta = nConta;
		this.saldo = saldo;
	}	

	
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}


	public void setnConta(String nConta) {
		this.nConta = nConta;
	}


	public double getSaldo() {
		return saldo;
	}

	public String getnConta() {
		return nConta;
	}

	
	public void adicionarNaConta(double valor) {
		setSaldo(this.saldo + valor);
		
	}

}
