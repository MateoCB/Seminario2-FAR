package ar.edu.uccor.seminario1.far.exceptions;

public class ParameterException extends Exception {

	public ParameterException() {
		super();
	}

	public ParameterException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

	public ParameterException(String message, Throwable cause) {
		super(message, cause);

	}

	public ParameterException(String message) {
		super(message);

	}

	public ParameterException(Throwable cause) {
		super(cause);

	}

	private static final long serialVersionUID = -1112376011331330795L;

}
