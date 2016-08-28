
package com.mobilize.core.exception;

public class ReferenceDataException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public ReferenceDataException() {
		super();
	}
	
	public ReferenceDataException ( String message ) {
		super( message );
	}
	
	public ReferenceDataException ( String message, Throwable cause ) {
		super( message, cause );
	}

}
