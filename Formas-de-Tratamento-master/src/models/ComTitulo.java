package models;

import exceptions.ErroNomeException;
import interfaces.FormatadorNome;

public class ComTitulo implements FormatadorNome {

	String titulo;
	public ComTitulo(String titulo){
		this.titulo = titulo;
	}
	@Override
	public String formatarNome(String nome, String sobrenome) {		
	
		return titulo+" "+nome+" "+sobrenome;
	}

}
