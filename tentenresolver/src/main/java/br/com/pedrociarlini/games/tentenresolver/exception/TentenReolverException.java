package br.com.pedrociarlini.games.tentenresolver.exception;

public class TentenReolverException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TentenReolverException() {
		super();
	}

	public TentenReolverException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public TentenReolverException(String message, Throwable cause) {
		super(message, cause);
	}

	public TentenReolverException(String message) {
		super(message);
	}

	public TentenReolverException(Throwable cause) {
		super(cause);
	}

}
