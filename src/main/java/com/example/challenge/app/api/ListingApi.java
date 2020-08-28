package com.example.challenge.app.api;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value="listingApi")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ListingApi 
{
	@JsonProperty
	private UUID id;
	
	@JsonProperty
	private UserApi user;
	
	@JsonProperty(required=true)
	private String name;
	
	@JsonProperty
	private String slug;
	
	@JsonProperty(required=true)
	private String description;
	
	@JsonProperty(required=true)
	private Integer adults;
	
	@JsonProperty(required=true)
	private Integer children;
	
	@JsonProperty(required=true)
	private Boolean isPetsAllowed;
	
	@JsonProperty(required=true)
	private Double basePrice;
	
	@JsonProperty(required=true)
	private Double cleaningFee;
	
	@JsonProperty(required=true)
	private String imageUrl;
	
	@JsonProperty(required=true)
	private Double weeklyDiscount;
	
	@JsonProperty(required=true)
	private Double monthlyDiscount;
	
	
	public ListingApi() 
	{
	}
	
	public ListingApi(UserApi user, String name, String slug, String description, Integer adults, Integer children,
			Boolean isPetsAllowed, Double basePrice, Double cleaningFee, String imageUrl, Double weeklyDiscount,
			Double monthlyDiscount) 
	{
		super();
		this.user = user;
		this.name = name;
		this.slug = slug;
		this.description = description;
		this.adults = adults;
		this.children = children;
		this.isPetsAllowed = isPetsAllowed;
		this.basePrice = basePrice;
		this.cleaningFee = cleaningFee;
		this.imageUrl = imageUrl;
		this.weeklyDiscount = weeklyDiscount;
		this.monthlyDiscount = monthlyDiscount;
	}
	
	public UUID getId() 
	{
		return id;
	}

	public void setId(UUID id) 
	{
		this.id = id;
	}

	public UserApi getUser() 
	{
		return user;
	}

	public void setUser(UserApi user) 
	{
		this.user = user;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public String getSlug() 
	{
		return slug;
	}

	public void setSlug(String slug) 
	{
		this.slug = slug;
	}

	public String getDescription() 
	{
		return description;
	}

	public void setDescription(String description) 
	{
		this.description = description;
	}

	public Integer getAdults() 
	{
		return adults;
	}

	public void setAdults(Integer adults) 
	{
		this.adults = adults;
	}

	public Integer getChildren() 
	{
		return children;
	}

	public void setChildren(Integer children) 
	{
		this.children = children;
	}

	public Boolean getIsPetsAllowed() 
	{
		return isPetsAllowed;
	}

	public void setIsPetsAllowed(Boolean isPetsAllowed) 
	{
		this.isPetsAllowed = isPetsAllowed;
	}

	public Double getBasePrice() 
	{
		return basePrice;
	}

	public void setBasePrice(Double basePrice) 
	{
		this.basePrice = basePrice;
	}

	public Double getCleaningFee() 
	{
		return cleaningFee;
	}

	public void setCleaningFee(Double cleaningFee) 
	{
		this.cleaningFee = cleaningFee;
	}

	public String getImageUrl() 
	{
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) 
	{
		this.imageUrl = imageUrl;
	}

	public Double getWeeklyDiscount() 
	{
		return weeklyDiscount;
	}

	public void setWeeklyDiscount(Double weeklyDiscount) 
	{
		this.weeklyDiscount = weeklyDiscount;
	}

	public Double getMonthlyDiscount() 
	{
		return monthlyDiscount;
	}

	public void setMonthlyDiscount(Double monthlyDiscount) 
	{
		this.monthlyDiscount = monthlyDiscount;
	}
	
}
