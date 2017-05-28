package pontos;

import java.util.ArrayList;

public class Pontos {

	private String tipoPonto;
	private String pontos;
	private String nome;
	
	public void Pontos(String nome, String tipoPonto, String pontos) {
		this.nome = nome;
		this.tipoPonto = tipoPonto;
		this.pontos = pontos;
	}

	public String getNome() {
		return nome;
	}

	public String getTipoPonto() {
		return tipoPonto;
	}

	public String getPontos() {
		return String.valueOf(pontos);
	}


}
