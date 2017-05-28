package fabricas;

import java.util.ArrayList;
import java.util.Random;

import embaralhadores.EmbaralhadorDificil;
import embaralhadores.EmbaralhadorFacil;
import embaralhadores.EmbaralhadorMedio;
import interfaces.Embaralhador;

public class FabricaEmbaralhadores {
	
	ArrayList<Embaralhador> embaralhador = new ArrayList<Embaralhador>();
	
	public FabricaEmbaralhadores(){
		embaralhador.add(new EmbaralhadorFacil());
		embaralhador.add(new EmbaralhadorMedio());
		embaralhador.add(new EmbaralhadorDificil());		
	}
	
	public Embaralhador retornaUmEmbaralhadorRandomico(){
		Integer i = new Random().nextInt(embaralhador.size());
		return embaralhador.get(i);
	}

}
