package com.example.challenge.app.api;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value="checkoutApi")
@JsonIgnoreProperties(ignoreUnknown = true)
public class CheckoutApi 
{
	@JsonProperty(required=true)
	private LocalDate checkin;
	
	@JsonProperty(required=true)
	private LocalDate checkout;

	public CheckoutApi() 
	{
	}

	public CheckoutApi(LocalDate checkin, LocalDate checkout) 
	{
		super();
		this.checkin = checkin;
		this.checkout = checkout;
	}

	public LocalDate getCheckin() 
	{
		return checkin;
	}

	public void setCheckin(LocalDate checkin) 
	{
		this.checkin = checkin;
	}

	public LocalDate getCheckout() 
	{
		return checkout;
	}

	public void setCheckout(LocalDate checkout) 
	{
		this.checkout = checkout;
	}
	
}
