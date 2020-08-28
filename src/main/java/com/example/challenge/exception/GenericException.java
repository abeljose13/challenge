package com.example.challenge.exception;

public abstract class GenericException extends Exception 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1840535288769258848L;
	
	private String errorCode;

    public GenericException(String message, String errorCode)
    {
        super(message);
        this.errorCode = errorCode;
    }

    public GenericException(String message, String errorCode, Throwable ex)
    {
        super(message, ex);
        this.errorCode = errorCode;
    }

    public String getErrorCode()
    {
        return errorCode;
    }
}
