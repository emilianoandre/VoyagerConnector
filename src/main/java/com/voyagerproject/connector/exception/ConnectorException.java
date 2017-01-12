package com.voyagerproject.connector.exception;

/**
 * Basic exception used to cover connection issues
 * 
 * @author eandre
 *
 */
public class ConnectorException extends Exception {

	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Basic constructor for the class
	 * 
	 * @param message
	 */
	public ConnectorException(String message) {
		super(message);
	}
}
