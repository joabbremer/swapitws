package com.swapit.ws.dao.exception;

public class ConnectException extends Exception{
	
	
	private static final long serialVersionUID = 1L;

	public ConnectException(){
		super();
	}
	
	public ConnectException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public ConnectException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ConnectException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ConnectException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
