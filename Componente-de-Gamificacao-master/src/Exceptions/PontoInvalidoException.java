package Exceptions;

public class PontoInvalidoException extends RuntimeException {


		private static final long serialVersionUID = 3894143229052102664L;
		public PontoInvalidoException(){
			super("Tipo de pontuação invalida/inexistente");
		}
		
	
}
