package com.example.challenge.app.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value="checkoutApiResponse")
@JsonIgnoreProperties(ignoreUnknown = true)
public class CheckoutApiResponse 
{
	@JsonProperty
	private Long nightsCount;
	
	@JsonProperty
	private Double nightsCost;
	
	@JsonProperty
	private Double discount;
	
	@JsonProperty
	private Double cleaningFee;
	
	@JsonProperty
	private Double total;

	public CheckoutApiResponse() 
	{
	}

	public CheckoutApiResponse(Long nightsCount, Double nightsCost, Double discount, Double cleaningFee,
			Double total) 
	{
		super();
		this.nightsCount = nightsCount;
		this.nightsCost = nightsCost;
		this.discount = discount;
		this.cleaningFee = cleaningFee;
		this.total = total;
	}

	public Long getNightsCount() 
	{
		return nightsCount;
	}

	public void setNightsCount(Long nightsCount) 
	{
		this.nightsCount = nightsCount;
	}

	public Double getNightsCost() 
	{
		return nightsCost;
	}

	public void setNightsCost(Double nightsCost) 
	{
		this.nightsCost = nightsCost;
	}

	public Double getDiscount() 
	{
		return discount;
	}

	public void setDiscount(Double discount) 
	{
		this.discount = discount;
	}

	public Double getCleaningFee() 
	{
		return cleaningFee;
	}

	public void setCleaningFee(Double cleaningFee) 
	{
		this.cleaningFee = cleaningFee;
	}

	public Double getTotal() 
	{
		return total;
	}

	public void setTotal(Double total) 
	{
		this.total = total;
	}
	
}
