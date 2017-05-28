package mocks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import caixaEletronico.ContaCorrente;
import caixaEletronicoInterface.ServicoRemoto;
import exceptions.LoginException;

public class ServicoRemotoMock implements ServicoRemoto {
	
	private static ArrayList<ContaCorrente> arrayContaCorrente = new ArrayList<>();
	private String nConta;

	public String getnConta() {
		return nConta;
	}

	public void setnConta(String nConta) {
		this.nConta = nConta;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	private double saldo;

	public void ServicoRemotoMock(String nConta, double saldo) {
		arrayContaCorrente.add(new ContaCorrente(nConta, saldo));
	}

	@Override
	public void recuperarConta(String nConta) {

		for (int a = 0; a < arrayContaCorrente.size(); a++) {
			if (arrayContaCorrente.get(a).getnConta().equals(nConta)) {
				setnConta(arrayContaCorrente.get(a).getnConta());
				setSaldo(arrayContaCorrente.get(a).getSaldo());
				break;
			} 
		}
	}

	@Override
	public void persistirConta(String nConta, double valor) {
		for (int a = 0; a < arrayContaCorrente.size(); a++) {
			if (arrayContaCorrente.get(a).getnConta().equals(nConta)) {
				arrayContaCorrente.remove(a);
				arrayContaCorrente.add(a, new ContaCorrente(nConta, valor));			
				break;
			}
		}
	}
}
