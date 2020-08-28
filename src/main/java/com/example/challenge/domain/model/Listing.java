package com.example.challenge.domain.model;

import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

/**
 * 
 * @author <a href="mailto:abeljose13@gmail.com">Avelardo Gavide</a>
 *
 */
@Entity
@Table(name = "listings")
public class Listing implements Serializable 
{/**
	 * 
	 */
	private static final long serialVersionUID = -3003569312822170887L;
	
	
	@Id
	@Column(name = "id", unique = true, length = 36, nullable = false)
	@Type(type="org.hibernate.type.UUIDCharType")
	private UUID id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	
	@Column(name = "name", length = 50, nullable = false)
	private String name;
	
	@Column(name = "slug", length = 50)
	private String slug;
	
	@Column(name = "description", length = 255)
	private String description;
	
	@Column(name = "adults")
	private Integer adults;
	
	@Column(name = "children")
	private Integer children;
	
	@Column(name = "is_pets_allowed", nullable = false)
	private Boolean isPetsAllowed = false;
	
	@Column(name = "base_price")
	private Double basePrice;
	
	@Column(name = "cleaning_fee")
	private Double cleaningFee;
	
	@Column(name = "image_url")
	private String imageUrl;
	
	@Column(name = "weekly_discount")
	private Double weeklyDiscount;
	
	@Column(name = "monthly_discount")
	private Double monthlyDiscount;
	
//	@OneToMany(cascade = CascadeType.ALL,
//			fetch = FetchType.LAZY,
//			mappedBy = "listing")
//	private Set<SpecialPrice> specialPrices;

	
	public Listing() 
	{
	}

	public Listing(User user, String name, String slug, String description, Integer adults, Integer children,
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

	public User getUser() 
	{
		return user;
	}

	public void setUser(User user) 
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

//	public Set<SpecialPrice> getSpecialPrices() 
//	{
//		return specialPrices;
//	}
//
//	public void setSpecialPrices(Set<SpecialPrice> specialPrices) 
//	{
//		this.specialPrices = specialPrices;
//	}
	
}
