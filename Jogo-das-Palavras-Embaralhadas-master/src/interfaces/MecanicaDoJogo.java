package interfaces;

public interface MecanicaDoJogo {
	
	public String tipoDeJogo();
	public int quantosPontos();
	public int quantasChancesVidas();
	public boolean acertou();
	public boolean errou();
	public boolean venceu();
	public boolean perdeu();
	public String palavra();
	public boolean tentativa(String palavra);
	public boolean fimDeJogo();
	public void reiniciar();
	public String palavraCerta();
	 
	
}
