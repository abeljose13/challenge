package com.example.challenge.domain.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

/**
 * 
 * @author <a href="mailto:abeljose13@gmail.com">Avelardo Gavide</a>
 *
 */
@Entity
@Table(name = "special_prices")
public class SpecialPrice implements Serializable 
{/**
	 * 
	 */
	private static final long serialVersionUID = -5692334646962398505L;
	
	
	@Id
	@Column(name = "id", unique = true, length = 36, nullable = false)
	@Type(type="org.hibernate.type.UUIDCharType")
	private UUID id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "listing_id")
	private Listing listing;
	
	@Column(name = "date")
	private LocalDate date;
	
	@Column(name = "price")
	private Double price;

	
	public SpecialPrice() 
	{
	}
	
	public SpecialPrice(Listing listing, LocalDate date, Double price) 
	{
		super();
		this.listing = listing;
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

	public Listing getListing()
	{
		return listing;
	}

	public void setListing(Listing listing) 
	{
		this.listing = listing;
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
