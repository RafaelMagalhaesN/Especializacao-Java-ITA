package models;

import exceptions.ErroNomeException;
import interfaces.FormatadorNome;

public class Respeitoso implements FormatadorNome {

	private boolean masculino = false, feminino = false;
	private String genero;
	
	public Respeitoso(String genero){
		if(genero.equals("masculino")){ this.masculino = true; this.feminino=false;}
		if(genero.equals("feminino")){this.feminino = true; this.masculino=false;}
	}
	
	@Override
	public String formatarNome(String nome, String sobrenome){
		if(masculino){return "Sr. "+sobrenome;}
		if(feminino){return "Sra. "+sobrenome;}
		throw new ErroNomeException("Você não definiu um tipo de genero");
	}

}
