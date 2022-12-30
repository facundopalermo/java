package edu.up.config.excepciones;

public class DAOException extends Exception {

	public DAOException() {
		super();
	}

	public DAOException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public DAOException(String message, Throwable cause) {
		super(message, cause);
	}

	public DAOException(String message) {
		super(message);
	}

	public DAOException(Throwable cause) {
		super(cause);
	}
	
	public DAOException(Throwable cause, int vendorCode) {
		super(cause);
		this.vendorCode=vendorCode;
	}
	
	public int getErrorCode() {
		return vendorCode;
	}
	
	private int vendorCode;
}
