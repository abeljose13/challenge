package com.example.challenge.app.handler;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ApiError 
{
	@JsonProperty
    private HttpStatus status;
	
	@JsonProperty
    private String code;

    @JsonProperty
    private String message;

	public ApiError() 
	{
	}

	public ApiError(HttpStatus status, String code, String message) 
	{
		super();
		this.status = status;
		this.code = code;
		this.message = message;
	}

	public HttpStatus getStatus() 
	{
		return status;
	}

	public void setStatus(HttpStatus status) 
	{
		this.status = status;
	}

	public String getCode() 
	{
		return code;
	}

	public void setCode(String code) 
	{
		this.code = code;
	}

	public String getMessage() 
	{
		return message;
	}

	public void setMessage(String message) 
	{
		this.message = message;
	}
	
}
