package fabricas;

import java.util.ArrayList;
import java.util.Random;

import interfaces.Embaralhador;
import interfaces.MecanicaDoJogo;
import mecanicas.MecanicaDoJogoPontos;
import mecanicas.MecanicaDoJogoVidas;

public class FabricaMecanicaDoJogo {
	ArrayList<MecanicaDoJogo> mecanicaDoJogo = new ArrayList<MecanicaDoJogo>();
	
	public FabricaMecanicaDoJogo(){
		mecanicaDoJogo.add(new MecanicaDoJogoPontos());
		mecanicaDoJogo.add(new MecanicaDoJogoVidas());		
	}
	
	public MecanicaDoJogo retornaUmaMecanicaRandomica(){
		Integer i = new Random().nextInt(mecanicaDoJogo.size());
		return mecanicaDoJogo.get(i);
	}
}

