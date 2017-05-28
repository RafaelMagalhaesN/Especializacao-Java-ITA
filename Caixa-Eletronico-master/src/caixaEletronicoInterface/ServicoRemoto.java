package caixaEletronicoInterface;

import java.util.ArrayList;

import caixaEletronico.ContaCorrente;

public interface ServicoRemoto {
	public void recuperarConta(String nConta);
	public void persistirConta(String nConta, double valor);

}
