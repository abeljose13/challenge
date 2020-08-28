package com.example.challenge.app.api;

import java.time.LocalDate;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value="specialPriceRequest")
@JsonIgnoreProperties(ignoreUnknown = true)
public class SpecialPriceApi 
{
	@JsonProperty
	private UUID id;
	
	@JsonProperty(required=true)
	private LocalDate date;
	
	@JsonProperty(required=true)
	private Double price;
	
	
	public SpecialPriceApi() 
	{
	}

	public SpecialPriceApi(LocalDate date, Double price) 
	{
		super();
		this.date = date;
		this.price = price;
	}
	
	public UUID getId() 
	{
		return id;
	}

	public void setId(UUID id) 
	{
		this.id = id;
	}

	public LocalDate getDate() 
	{
		return date;
	}

	public void setDate(LocalDate date) 
	{
		this.date = date;
	}

	public Double getPrice() 
	{
		return price;
	}

	public void setPrice(Double price) 
	{
		this.price = price;
	}
	
}
