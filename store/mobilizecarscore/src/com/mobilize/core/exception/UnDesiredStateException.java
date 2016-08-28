
package com.mobilize.core.exception;

public class UnDesiredStateException extends Exception {

	private static final long serialVersionUID = 1L;

	public UnDesiredStateException() {
		super();
	}
	
	public UnDesiredStateException ( String message ) {
		super( message );
	}
	
	public UnDesiredStateException ( String message, Throwable cause ) {
		super( message, cause );
	}
}
