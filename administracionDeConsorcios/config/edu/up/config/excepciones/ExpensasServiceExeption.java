package edu.up.config.excepciones;

public class ExpensasServiceExeption extends Exception {

	public ExpensasServiceExeption() {
		super();
	}

	public ExpensasServiceExeption(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ExpensasServiceExeption(String message, Throwable cause) {
		super(message, cause);
	}

	public ExpensasServiceExeption(String message) {
		super(message);
	}

	public ExpensasServiceExeption(Throwable cause) {
		super(cause);
	}

}
