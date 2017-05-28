package exceptions;

public class HardwareLerEnvelopesException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5760971182224727321L;

	public HardwareLerEnvelopesException() {
		super("Falha ao ler o envelope");
	}
}
