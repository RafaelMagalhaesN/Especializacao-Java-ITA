package interfaces;

import java.util.ArrayList;
import java.util.HashMap;

public interface ArmazenamentoInterface {
	
	public String quantosPontosDeUmTipoTemUmUsuario(String usuario, String tipoPontuacao);
	public ArrayList<String> todosOsUsuariosComPontos();
	public ArrayList<String> todosOsTiposDePontosRegistrados(String usuario);
	public void ArmazenamentoDePontos(String nome, String tipoPontuacao, int pontos);

}
