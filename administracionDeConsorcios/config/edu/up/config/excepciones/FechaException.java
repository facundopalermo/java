package edu.up.config.excepciones;

public class FechaException extends Exception {

	public FechaException() {
		super();
	}

	public FechaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public FechaException(String message, Throwable cause) {
		super(message, cause);
	}

	public FechaException(String message) {
		super(message);
	}

	public FechaException(Throwable cause) {
		super(cause);
	}

}
