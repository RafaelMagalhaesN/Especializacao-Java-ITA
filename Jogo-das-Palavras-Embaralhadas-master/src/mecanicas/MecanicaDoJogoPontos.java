package mecanicas;

import java.io.IOException;

import banco.BancoDePalavras;
import fabricas.FabricaEmbaralhadores;
import interfaces.Embaralhador;
import interfaces.MecanicaDoJogo;

public class MecanicaDoJogoPontos implements MecanicaDoJogo {

	private Embaralhador embaralhador;
	private FabricaEmbaralhadores fabricaEmbaralhadores = new FabricaEmbaralhadores();
	private BancoDePalavras bancoDePalavras = new BancoDePalavras();
	private int pontos = 0;
	private int chances = 10;
	private String palavra;

	public MecanicaDoJogoPontos() {
		embaralhador = fabricaEmbaralhadores.retornaUmEmbaralhadorRandomico();
	}

	@Override
	public String tipoDeJogo() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("******** JOGO PALAVRAS EMBARALHADAS *******\n");
		stringBuilder.append("*******************************************\n");
		stringBuilder.append("**********R E G R A S**********************\n");
		stringBuilder.append("*******************************************\n");
		stringBuilder.append("********JOGO DE PONTOS*********************\n");
		stringBuilder.append("-----VOCÊ TEM 10 PALAVRAS------------------\n");
		stringBuilder.append("Tente acertar todas as palavras!***********\n");
		stringBuilder.append("Cada palavra certa vale 1 ponto! multiplicado pela dificuldade\n");
		stringBuilder.append("Cada palavra errada perde 1 ponto! multiplicado pela dificuldade\n");
		stringBuilder.append("*******************************************\n");
		stringBuilder.append("******DIFICULDADE: " + embaralhador.dificuldade() + "*******************\n");
		stringBuilder.append("********************************************\n");
		stringBuilder.append("********************************************\n");
		return stringBuilder.toString();
	}

	@Override
	public int quantosPontos() {
		return pontos * embaralhador.dificuldade();
	}

	@Override
	public boolean venceu() {
		return true;
	}

	@Override
	public boolean perdeu() {
		return false;
	}

	@Override
	public boolean acertou() {
		pontos++;
		chances--;
		return true;
	}

	@Override
	public boolean errou() {
		pontos--;
		chances--;
		return false;
	}

	@Override
	public String palavra() {
		try {
			palavra = bancoDePalavras.obterPalavra();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return embaralhador.retornaEmbaralhado(palavra);
	}

	@Override
	public boolean tentativa(String palavra) {
		if (palavra.equalsIgnoreCase(this.palavra)) {
			return acertou();
		} else {
			return errou();
		}
	}

	@Override
	public int quantasChancesVidas() {
		return chances;
	}

	@Override
	public boolean fimDeJogo() {
		if (quantasChancesVidas() < 0) {
			return perdeu();
		}
		return venceu();
	}

	@Override
	public void reiniciar() {
		chances = 10;
		pontos = 0;
	}

	@Override
	public String palavraCerta() {
		return palavra;
	}

}
