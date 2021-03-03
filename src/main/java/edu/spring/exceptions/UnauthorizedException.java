package edu.spring.exceptions;

public class UnauthorizedException extends RuntimeException {
	
	private static final String DESCRIPTION = "Not Authorized (401)";

	public UnauthorizedException(String detail)
	{
		super(DESCRIPTION + ". " + detail);
	}
	
}