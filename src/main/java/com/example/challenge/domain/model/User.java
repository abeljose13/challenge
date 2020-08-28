package com.example.challenge.domain.model;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

/**
 * 
 * @author <a href="mailto:abeljose13@gmail.com">Avelardo Gavide</a>
 *
 */
@Entity
@Table(name = "users")
public class User implements Serializable 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3032507287983754285L;
	
	
	@Id
	@Column(name = "id", unique = true, length = 36, nullable = false)
	@Type(type="org.hibernate.type.UUIDCharType")
	private UUID id;
	
	@Column(name = "name", length = 50, nullable = false)
	private String name;
	
	@Column(name = "email", length = 100, nullable = false)
	private String email;
	
	@Column(name = "password", length = 100, nullable = false)
	private String password;
	
	
	public User() 
	{
	}

	public User(String name, String email, String password) 
	{
		super();
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
