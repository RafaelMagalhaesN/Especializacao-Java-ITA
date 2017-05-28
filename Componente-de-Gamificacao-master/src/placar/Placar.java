package placar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import Exceptions.PontoInvalidoException;
import armazenamento.Armazenamento;
import interfaces.ArmazenamentoInterface;
import mocks.ArmazenamentoMock;
import pontos.Pontos;

public class Placar {

	ArmazenamentoInterface armazenamento;

	public Placar(ArmazenamentoInterface armazenamento) {
		super();
		this.armazenamento = armazenamento;
	}

	public void registrarUmTipoDePontoParaUmUsuario(String nome, String tipoPontuacao, int pontos) {
		armazenamento.ArmazenamentoDePontos(nome, tipoPontuacao, pontos);

	}

	public ArrayList<String> retornarTodosOsPontosDeUmUsuario(String nome) throws PontoInvalidoException {
		ArrayList<String> totalPontos = new ArrayList<>();
		String stringTotal;
		for (String tipoPonto : armazenamento.todosOsTiposDePontosRegistrados(nome)) {
			for (int a = 0; a < 1; a++) {
				stringTotal = tipoPonto + ": " + armazenamento.quantosPontosDeUmTipoTemUmUsuario(nome, tipoPonto);
				totalPontos.add(stringTotal);
			}
		}

		return totalPontos;
	}

	public ArrayList<String> retornarRanking(String tipoPontuacao) {

		ArrayList<String> ranking = new ArrayList<>();
		List<Integer> pontos = new ArrayList<Integer>();
		String nomeComPonto;
		HashMap<Integer, String> salvarPosicoes = new HashMap<Integer, String>();

		int a = 0;
		for (String nome : armazenamento.todosOsUsuariosComPontos()) {

			if (armazenamento.quantosPontosDeUmTipoTemUmUsuario(nome, tipoPontuacao) != "") {
				pontos.add(Integer.parseInt(armazenamento.quantosPontosDeUmTipoTemUmUsuario(nome, tipoPontuacao)));
				System.out.println(armazenamento.quantosPontosDeUmTipoTemUmUsuario(nome, tipoPontuacao));
				salvarPosicoes.put(pontos.get(a), nome);
				a++;
			}
		}

		Collections.sort(pontos);
		Collections.reverse(pontos);
		for (Integer b : pontos) {
			if (salvarPosicoes.containsKey(b)) {
				nomeComPonto = salvarPosicoes.get(b) + ": " + b;
				ranking.add(nomeComPonto);

			}
		}

		return ranking;
	}

}
