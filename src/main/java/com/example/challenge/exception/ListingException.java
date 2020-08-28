package com.example.challenge.exception;

public class ListingException extends GenericException 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6785029316784739096L;
	
	
	public ListingException(String message, String errorCode) 
	{
		super(message, errorCode);
	}
	
	public ListingException(String message, String errorCode, Throwable ex) 
	{
		super(message, errorCode, ex);
	}
}
