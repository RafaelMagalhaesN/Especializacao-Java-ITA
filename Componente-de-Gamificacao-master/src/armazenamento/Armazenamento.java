package armazenamento;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.HashMap;
import java.util.List;

import Exceptions.PontoInvalidoException;
import interfaces.ArmazenamentoInterface;
import pontos.Pontos;

public class Armazenamento implements ArmazenamentoInterface {

	private HashMap<String, ArrayList<Pontos>> _cadastros = new HashMap<String, ArrayList<Pontos>>();
	private static final String _nomeArquivo = "pontosData.txt";
	private ArrayList<String> _nome = new ArrayList<>();
	private ArrayList<String> _tipoPontuacao = new ArrayList<>();
	private ArrayList<Integer> _pontos = new ArrayList<>();
	private String _textDoArquivo;

	private void criarArquivo() {
		try {
			Formatter formatter = new Formatter(_nomeArquivo);
			for (int a = 0; a < _tipoPontuacao.size(); a++) {
				_textDoArquivo = _nome.get(a) + "-" + _tipoPontuacao.get(a) + "-" + _pontos.get(a) + "%n";
				formatter.format(_textDoArquivo);
			}
			formatter.close();
		} catch (Exception erro) {
			System.err.println("Erro ao criar arquivo");
		}
	}

	private void lerArquivo() {
		String linhaDeDados;
		String[] dados = new String[3];
		ArrayList<Pontos> detalhes = new ArrayList<>();

		File file = new File(_nomeArquivo);
		if (file.exists()) {
			try {
				FileReader fileReader = new FileReader(_nomeArquivo);
				BufferedReader buffer = new BufferedReader(fileReader);
				while (true) {
					linhaDeDados = buffer.readLine();
					if (linhaDeDados == null) {
						break;
					}
					dados = linhaDeDados.split("-");
					Pontos pontos = new Pontos();
					pontos.Pontos(dados[0], dados[1], dados[2]);
					detalhes.add(pontos);
					_cadastros.put(dados[0], detalhes);

					dados = new String[0];
					dados = new String[3];
				}
			} catch (IOException e) {
				System.out.println("Arquivo não existe");
			}
		}
	}

	@Override
	public String quantosPontosDeUmTipoTemUmUsuario(String usuario, String tipoPontuacao) {
		lerArquivo();
		String pontos = "";
		ArrayList<Pontos> detalhes = new ArrayList<>();
		detalhes.addAll(_cadastros.get(usuario));
		for (int a = 0; a < detalhes.size(); a++) {
			if (detalhes.get(a).getTipoPonto().equals(tipoPontuacao) && detalhes.get(a).getNome().equals(usuario)) {
				pontos = detalhes.get(a).getPontos();
			}
		}
		if (pontos.equals("0")) {
			throw new PontoInvalidoException();
		}
		return pontos;

	}

	@Override
	public ArrayList<String> todosOsUsuariosComPontos() {
		lerArquivo();
		ArrayList<String> nomes = new ArrayList<>();
		ArrayList<Pontos> detalhes = new ArrayList<>();		
		
		for (String nome : _cadastros.keySet()) {
			detalhes.addAll(_cadastros.get(nome));		
			nomes.add(nome);			
		}
		for(int a=0; a<nomes.size();a++){			
			if(detalhes.get(a).getNome().equals(detalhes.get(a).getNome()) && detalhes.get(a).getPontos().equals("0")){				
				nomes.remove(detalhes.get(a).getNome());
			}			
		}
		return nomes;
	}

	@Override
	public ArrayList<String> todosOsTiposDePontosRegistrados(String usuario) {
		lerArquivo();
		ArrayList<String> tipoPontos = new ArrayList<>();
		ArrayList<Pontos> detalhes = new ArrayList<>();
		detalhes.addAll(_cadastros.get(usuario));
		for (int a = 0; a < detalhes.size(); a++) {
			if (detalhes.get(a).getNome().equals(usuario)) {
				tipoPontos.add(detalhes.get(a).getTipoPonto());
			}
		}
		return tipoPontos;

	}

	@Override
	public void ArmazenamentoDePontos(String nome, String tipoPontuacao, int pontos) {
		_nome.add(nome);
		_tipoPontuacao.add(tipoPontuacao);
		_pontos.add(pontos);
		criarArquivo();
	}

}
