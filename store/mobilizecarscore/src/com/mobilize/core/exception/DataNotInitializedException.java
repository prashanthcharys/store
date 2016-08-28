
package com.mobilize.core.exception;

public class DataNotInitializedException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public DataNotInitializedException() {
		super();
	}
	
	public DataNotInitializedException ( String message ) {
		super( message );
	}
	
	public DataNotInitializedException ( String message, Throwable cause ) {
		super( message, cause );
	}
}
