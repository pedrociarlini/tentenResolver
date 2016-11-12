package br.com.pedrociarlini.games.tentenresolver;

import br.com.pedrociarlini.games.tentenresolver.exception.TentenReolverException;

public class JogadaInvalidaException extends TentenReolverException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JogadaInvalidaException() {
		super();

	}

	public JogadaInvalidaException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public JogadaInvalidaException(String message, Throwable cause) {
		super(message, cause);
	}

	public JogadaInvalidaException(String message) {
		super(message);
	}

	public JogadaInvalidaException(Throwable cause) {
		super(cause);
	}

}
