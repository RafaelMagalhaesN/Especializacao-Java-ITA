package exceptions;

public class HardwareDinheiroException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HardwareDinheiroException() {
		super("Falha no hardware de entrega de dinheiro");
	}
}
