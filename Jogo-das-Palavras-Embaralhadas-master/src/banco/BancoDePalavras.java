package banco;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class BancoDePalavras {

	private static ArrayList<Palavras> palavras = new ArrayList<Palavras>();
	private static final String nomeDoArquivo = "listadepalavras.txt";
	private static boolean iniciaLeitura = true;
	private BufferedReader buffer;

	private void lerArquivo() throws IOException {
		String dado;
		File file = new File(nomeDoArquivo);
		if (file.exists()) {
			FileReader fileReader;
			fileReader = new FileReader(nomeDoArquivo);
			buffer = new BufferedReader(fileReader);
			while (true) {
				dado = buffer.readLine();
				if (dado == null) {
					break;
				}
				Palavras palavras = new Palavras(dado);
				this.palavras.add(palavras);
			}
		}
	}

	private void iniciaLeitura() throws IOException {
		if (iniciaLeitura) {
			lerArquivo();
			iniciaLeitura = false;
		}
	}

	public String obterPalavra() throws IOException {
		iniciaLeitura();	
		Integer i = new Random().nextInt(palavras.size());
		String palavra = this.palavras.get(i).getPalavra();				
		palavras.remove(i);
		return palavra;
	}
}
