
package com.mobilize.core.exception;

public class MethodNotSupportedException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public MethodNotSupportedException() {
		super();
	}
	
	public MethodNotSupportedException ( String message ) {
		super( message );
	}
	
	public MethodNotSupportedException ( String message, Throwable cause ) {
		super( message, cause );
	}

}
