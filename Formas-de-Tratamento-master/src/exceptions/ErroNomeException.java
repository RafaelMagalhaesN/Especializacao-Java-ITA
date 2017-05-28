package exceptions;

public class ErroNomeException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7334208850454803281L;
	
	public ErroNomeException(String erro){
		super(erro);
	}

}
