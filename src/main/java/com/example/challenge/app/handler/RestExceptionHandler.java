package com.example.challenge.app.handler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.challenge.exception.ListingException;
import com.example.challenge.exception.SpecialPriceException;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler 
{
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request)
	{
		String error = "Malformed JSON request";
		return buildResponseEntity(new ApiError(HttpStatus.BAD_REQUEST, "", error));
	}

	@ExceptionHandler(Exception.class)
	protected ResponseEntity<Object> handleInternalError(Exception ex)
	{
		return buildResponseEntity(new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, "", ex.getMessage()));
	}
	
	@ExceptionHandler(ListingException.class)
	protected ResponseEntity<Object> handleListingException(ListingException ex)
	{
		if("NOT_FOUND".equals(ex.getErrorCode())) 
		{
			return buildResponseEntity(new ApiError(HttpStatus.NOT_FOUND, "NOT_FOUND", ex.getMessage()));
		}
		
		if("ALREADY_EXIST".equals(ex.getErrorCode())) 
		{
			return buildResponseEntity(new ApiError(HttpStatus.CONFLICT, "ALREADY_EXIST", ex.getMessage()));
		}
		
		if("INVALID_DATE".equals(ex.getErrorCode()) || "INVALID_DAYS".equals(ex.getErrorCode())) 
		{
			return buildResponseEntity(new ApiError(HttpStatus.BAD_REQUEST, "INVALID", ex.getMessage()));
		}
		
		return buildResponseEntity(new ApiError(HttpStatus.FORBIDDEN, ex.getErrorCode(), ex.getMessage()));
	}
	
	@ExceptionHandler(SpecialPriceException.class)
	protected ResponseEntity<Object> handleSpecialPriceException(SpecialPriceException ex)
	{
		if("NOT_FOUND".equals(ex.getErrorCode())) 
		{
			return buildResponseEntity(new ApiError(HttpStatus.NOT_FOUND, "NOT_FOUND", ex.getMessage()));
		}
				
		return buildResponseEntity(new ApiError(HttpStatus.FORBIDDEN, ex.getErrorCode(), ex.getMessage()));
	}
	
	private ResponseEntity<Object> buildResponseEntity(ApiError apiError)
	{
		return new ResponseEntity<>(apiError, apiError.getStatus());
	}
}
