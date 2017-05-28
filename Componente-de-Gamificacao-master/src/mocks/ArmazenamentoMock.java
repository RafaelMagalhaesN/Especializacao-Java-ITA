package mocks;

import java.util.ArrayList;
import java.util.List;

import interfaces.ArmazenamentoInterface;
import pontos.Pontos;

public class ArmazenamentoMock implements ArmazenamentoInterface {

	private String nome, tipoPontuacao, pontos;
	private ArrayList<Pontos> pontosArray = new ArrayList<>();
	
	

	@Override
	public String quantosPontosDeUmTipoTemUmUsuario(String usuario, String tipoPontuacao) {
		String ponto = "";
		for (Pontos pontos : pontosArray) {
			if (pontos.getTipoPonto().equals(tipoPontuacao) && pontos.getNome().equals(usuario)) {
				ponto = pontos.getPontos();
				break;
			}
		}
		return ponto;
	}

	@Override
	public ArrayList<String> todosOsUsuariosComPontos() {
		ArrayList<String> usuarios = new ArrayList<>();
		for (Pontos pontos : pontosArray) {
			usuarios.add(pontos.getNome());
		}
		return usuarios;
	}

	@Override
	public ArrayList<String> todosOsTiposDePontosRegistrados(String usuario) {
		ArrayList<String> tiposDePonto = new ArrayList<>();
		for (Pontos pontos : pontosArray) {			
			if (pontos.getNome().equals(usuario)) {
				tiposDePonto.add(pontos.getTipoPonto());
		
			}
		}
		return tiposDePonto;
	}

	@Override
	public void ArmazenamentoDePontos(String nome, String tipoPontuacao, int pontos) {
		Pontos ponto = new Pontos();
		ponto.Pontos(nome, tipoPontuacao, String.valueOf(pontos));
		pontosArray.add(ponto);
	}

}
