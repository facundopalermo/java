package edu.up.config.excepciones;

public class ClaveDuplicadaDAOException extends Exception {
	
	private int error;
	
    public ClaveDuplicadaDAOException() {
    }

    public ClaveDuplicadaDAOException(String message) {
        super(message);
    }

    public ClaveDuplicadaDAOException(String message, Throwable cause) {
        super(message, cause);
    }

    public ClaveDuplicadaDAOException(Throwable cause) {
        super(cause);
    }
}

