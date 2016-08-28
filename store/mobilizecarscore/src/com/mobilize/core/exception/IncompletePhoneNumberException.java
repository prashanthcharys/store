
package com.mobilize.core.exception;

public class IncompletePhoneNumberException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public IncompletePhoneNumberException() {
		super();
	}
	
	public IncompletePhoneNumberException ( String message ) {
		super( message );
	}
	
	public IncompletePhoneNumberException ( String message, Throwable cause ) {
		super( message, cause );
	}
}
