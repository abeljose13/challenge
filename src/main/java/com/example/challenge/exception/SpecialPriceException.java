package com.example.challenge.exception;

public class SpecialPriceException extends GenericException 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1241990830997347566L;
	
	
	public SpecialPriceException(String message, String errorCode) 
	{
		super(message, errorCode);
	}
	
	public SpecialPriceException(String message, String errorCode, Throwable ex) 
	{
		super(message, errorCode, ex);
	}
}
