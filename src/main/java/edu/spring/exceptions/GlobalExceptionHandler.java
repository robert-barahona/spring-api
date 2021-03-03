package edu.spring.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
public class GlobalExceptionHandler {

	ErrorMessage result;
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler({NotFoundException.class})
	@ResponseBody
	public ErrorMessage notFoundRequest(HttpServletRequest request, Exception exception) {
		
		return new ErrorMessage(exception, request.getRequestURI());
		
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler({BadRequestException.class})
	@ResponseBody
	public ErrorMessage wrongRequest(HttpServletRequest request, Exception exception) {
		
		return new ErrorMessage(exception, request.getRequestURI());
		
	}
	
	@ResponseStatus(HttpStatus.FORBIDDEN)
	@ExceptionHandler({ForbiddenExcepcion.class})
	@ResponseBody
	public ErrorMessage forbiddenRequest(HttpServletRequest request, Exception exception) {
		
		return new ErrorMessage(exception, request.getRequestURI());
		
	}
	
	@ResponseStatus(HttpStatus.CONFLICT)
	@ExceptionHandler({ConflictException.class})
	@ResponseBody
	public ErrorMessage conflictRequest(HttpServletRequest request, Exception exception) {
		
		return new ErrorMessage(exception, request.getRequestURI());
		
	}
	
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	@ExceptionHandler({UnauthorizedException.class})
	@ResponseBody
	public ErrorMessage unauthorizedRequest(HttpServletRequest request, Exception exception) {
		
		return new ErrorMessage(exception, request.getRequestURI());
		
	}
	
}
