package exceptions;

public class LoginException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public LoginException(){
		super("N�o foi poss�vel autenticar o usu�rio");
	}

}
