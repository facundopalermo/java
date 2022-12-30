package edu.up.config.excepciones;

public class DAOServiceException extends Exception {

	public DAOServiceException() {
		super();
	}

	public DAOServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public DAOServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public DAOServiceException(String message) {
		super(message);
	}

	public DAOServiceException(Throwable cause) {
		super(cause);
	}
	

}
