package edu.up.config.excepciones;

public class PisoMaxServiceException extends Exception {

	public PisoMaxServiceException() {
		super();
	}

	public PisoMaxServiceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public PisoMaxServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public PisoMaxServiceException(String message) {
		super(message);
	}

	public PisoMaxServiceException(Throwable cause) {
		super(cause);
	}

}
