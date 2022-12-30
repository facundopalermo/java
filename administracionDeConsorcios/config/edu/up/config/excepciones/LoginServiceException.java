package edu.up.config.excepciones;

public class LoginServiceException extends Exception {

	public LoginServiceException() {
		super();
	}

	public LoginServiceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public LoginServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public LoginServiceException(String message) {
		super(message);
	}

	public LoginServiceException(Throwable cause) {
		super(cause);
	}

}
