package caixaEletronicoInterface;

public interface Hardware {
	public String pegarNumeroDaContaCartao(String nContaCartao);
	public void entregarDinheiro(String nContaCartao);
	public void lerEnvelope(double valor);
}
