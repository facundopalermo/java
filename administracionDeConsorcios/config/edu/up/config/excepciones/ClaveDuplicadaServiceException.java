package edu.up.config.excepciones;

public class ClaveDuplicadaServiceException extends Exception {

	public ClaveDuplicadaServiceException() {
		super();
	}

	public ClaveDuplicadaServiceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ClaveDuplicadaServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public ClaveDuplicadaServiceException(String message) {
		super(message);
	}

	public ClaveDuplicadaServiceException(Throwable cause) {
		super(cause);
	}

}
