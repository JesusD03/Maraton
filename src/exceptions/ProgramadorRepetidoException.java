package exceptions;

public class ProgramadorRepetidoException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public ProgramadorRepetidoException() {
		super("No pueden haber dos programadores con el mismo nombre");
	}
	
}
