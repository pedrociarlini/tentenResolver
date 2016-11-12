package br.com.pedrociarlini.games.tentenresolver.ui.exception;

import br.com.pedrociarlini.games.tentenresolver.exception.TentenReolverException;

public class ComponenteInvalidoException extends TentenReolverException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ComponenteInvalidoException() {
		super();
	}

	public ComponenteInvalidoException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

	public ComponenteInvalidoException(String message, Throwable cause) {
		super(message, cause);

	}

	public ComponenteInvalidoException(String message) {
		super(message);

	}

	public ComponenteInvalidoException(Throwable cause) {
		super(cause);

	}
}
