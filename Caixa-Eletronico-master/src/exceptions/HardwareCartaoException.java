package exceptions;

public class HardwareCartaoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3894143229052102664L;
	public HardwareCartaoException(){
		super("Falha no hardware de leitura de cartões");
	}
	
}
