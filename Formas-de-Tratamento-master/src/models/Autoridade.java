package models;

import exceptions.ErroNomeException;
import interfaces.FormatadorNome;

public class Autoridade {

	FormatadorNome formatadorNome;
	String nome, sobrenome;

	public Autoridade(String nome, String sobrenome, FormatadorNome formatadorNome) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.formatadorNome = formatadorNome;

	}

	public String getTratamento() {
		return formatadorNome.formatarNome(nome, sobrenome);

	}

}
