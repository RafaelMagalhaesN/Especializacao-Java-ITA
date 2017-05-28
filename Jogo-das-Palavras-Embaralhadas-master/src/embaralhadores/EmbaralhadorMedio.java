package embaralhadores;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import interfaces.Embaralhador;

public class EmbaralhadorMedio implements Embaralhador {

	List<String> cadaLetra;
	StringBuilder palavraEmbaralhada;
	
	@Override
	public String retornaEmbaralhado(String palavra) {
		cadaLetra = Arrays.asList(palavra.trim().split(""));
		Collections.rotate(cadaLetra, cadaLetra.size() - 3);
		palavraEmbaralhada = new StringBuilder();
		for(String p : cadaLetra){
			palavraEmbaralhada.append(p);
		}
		return palavraEmbaralhada.toString();
	}

	@Override
	public int dificuldade() {
		return 5;
	}

}
