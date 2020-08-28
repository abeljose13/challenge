package com.example.challenge.app.api;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value="userApi")
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserApi 
{
	@JsonProperty(required=true)
	private UUID id;
	
	@JsonProperty(required=true)
	private String name;
	
	@JsonProperty(required=true)
	private String email;
	
	@JsonProperty(required=true)
	private String password;

	public UserApi() 
	{
	}

	public UserApi(UUID id, String name, String email, String password) 
	{
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public UUID getId() 
	{
		return id;
	}

	public void setId(UUID id) 
	{
		this.id = id;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public String getEmail() 
	{
		return email;
	}

	public void setEmail(String email) 
	{
		this.email = email;
	}

	public String getPassword() 
	{
		return password;
	}

	public void setPassword(String password) 
	{
		this.password = password;
	}
	
}
