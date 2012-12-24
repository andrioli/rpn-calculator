package br.com.ooboo.calculator.operator;

public class NoSuchOperatorException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public NoSuchOperatorException(String message) {
		super(message);
	}

}
