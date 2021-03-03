package edu.spring.exceptions;

public class ForbiddenExcepcion extends RuntimeException {
	
	private static final String DESCRIPTION = "Forbidden (403)";
	
	public ForbiddenExcepcion (String detail) {
		super(DESCRIPTION + ". " + detail);
	}

}
