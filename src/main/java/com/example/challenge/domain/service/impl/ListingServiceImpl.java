package com.example.challenge.domain.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.challenge.app.api.CheckoutApi;
import com.example.challenge.app.api.CheckoutApiResponse;
import com.example.challenge.app.api.ListingApi;
import com.example.challenge.domain.model.Listing;
import com.example.challenge.domain.model.User;
import com.example.challenge.domain.repository.ListingRepository;
import com.example.challenge.domain.repository.UserRepository;
import com.example.challenge.domain.service.ListingService;
import com.example.challenge.exception.ListingException;
import com.example.challenge.util.ChallengeUtil;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.sun.xml.bind.v2.TODO;

/**
 * 
 * @author <a href="mailto:abeljose13@gmail.com">Avelardo Gavide</a>
 *
 */
@Service
public class ListingServiceImpl implements ListingService 
{
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	public static final long VALID_DAYS = 28;
	
	public static final long QUANTITY_DAYS_FOR_DISCOUNT = 15;
	
	@Autowired
	private ListingRepository listingRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	private ObjectMapper mapper;
	
	
	@PostConstruct
	protected void init()
	{
		mapper = new ObjectMapper();
		mapper.findAndRegisterModules();
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		mapper.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, false);
		mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
	}
	
	
	@Override
	public ListingApi create(ListingApi listingApi) throws ListingException 
	{
		
		User user = null;
		Listing listing = listingRepository.findByName(listingApi.getName());
		
		if (null != listing)
		{
			throw new ListingException("Listing already exist", "ALREADY_EXIST");
		}
		
		Optional<User> userDb = userRepository.findById(listingApi.getUser().getId());
		
		if (!userDb.isPresent())
		{
			throw new ListingException("User Owner don't exist", "NOT_FOUND");
		}
		else
		{
			user = userDb.get();
		}
		
		listing = mapper.convertValue(listingApi, Listing.class);
		listing.setId(UUID.randomUUID());
		listing.setUser(user);
		
		listing = listingRepository.saveAndFlush(listing);
		log.info("New Listing created witd ID: "+listing.getId());
		
		return mapper.convertValue(listing, ListingApi.class);
	}
	
	@Override
	public ListingApi update(String uuid, ListingApi listingApi) throws ListingException 
	{
		
		Optional<Listing> listingDb = listingRepository.findById(UUID.fromString(uuid));
		
		Listing listing = null;
		User user = null;
		
		if (!listingDb.isPresent())
		{
			throw new ListingException("Listing don't exist", "NOT_FOUND");
		}
		else
		{
			listing = listingDb.get();
		}
		
		user = listing.getUser();
		
		listing = mapper.convertValue(listingApi, Listing.class);
		listing.setId(UUID.fromString(uuid));
		listing.setUser(user);
		
		listing = listingRepository.saveAndFlush(listing);
		
		log.info("Updated Listing witd ID: "+listing.getId());
			
		return mapper.convertValue(listing, ListingApi.class);
	}
	
	@Override
	public void delete(String uuid) throws ListingException
	{
		Optional<Listing> listingDb = listingRepository.findById(UUID.fromString(uuid));
		
		if (!listingDb.isPresent())
		{
			throw new ListingException("Listing don't exist", "NOT_FOUND");
		}
		
		listingRepository.deleteById(UUID.fromString(uuid));
	}

	@Override
	public ListingApi get(String uuid) throws ListingException
	{
		Optional<Listing> listingDb = listingRepository.findById(UUID.fromString(uuid));
		
		if (!listingDb.isPresent())
		{
			throw new ListingException("Listing don't exist", "NOT_FOUND");
		}
		
		return mapper.convertValue(listingDb, ListingApi.class);
	}

	@Override
	public List<ListingApi> getAll() throws ListingException 
	{
		List<Listing> listings = listingRepository.findAll();
		
		List<ListingApi> listingsApi = mapper.convertValue(listings, new TypeReference<List<ListingApi>>() {});
		
		return listingsApi;
	}

	@Override
	public CheckoutApiResponse checkout(String uuid, CheckoutApi checkoutApi) throws ListingException 
	{
		if (ChallengeUtil.isPastDate(checkoutApi.getCheckin()))
		{
			throw new ListingException("The checkin date is invalid", "INVALID_DATE");
		}
		
		if (ChallengeUtil.isPastDate(checkoutApi.getCheckout()))
		{
			throw new ListingException("The checkout date is invalid", "INVALID_DATE");
		}
		
		if (!ChallengeUtil.isValidCheckinDate(checkoutApi.getCheckin(), checkoutApi.getCheckout()))
		{
			throw new ListingException("The checkin date must be before to checkout date", "INVALID_DATE");
		}
		
		long days = ChallengeUtil.isValidCheckoutDays(checkoutApi.getCheckin(), checkoutApi.getCheckout());
		
		if (days > VALID_DAYS)
		{
			throw new ListingException("The numbers of days of reservation is invalid", "INVALID_DAYS");
		}
		
		Optional<Listing> optListing = listingRepository.findById(UUID.fromString(uuid));
		
		if (!optListing.isPresent())
		{
			throw new ListingException("Listing don't exist", "NOT_FOUND");
		}
		
		Listing listing = optListing.get();
		
		CheckoutApiResponse response = getCalculate(listing, days);
		
		return response;
	}
	
	/**
	 * The reservation calculations are made
	 * 
	 * @param listing
	 * @param days
	 * @return CheckoutApiResponse object
	 */
	private CheckoutApiResponse getCalculate(Listing listing, long days)
	{
		/*
		 * TODO LA IMPLEMENTACION ACTUAL TOMA POR DEFECTO EL "PRICE" DE "LISTING" PARA
		 * HACER LOS CALCULOS.
		 * SE PODRIA APLICAR UNA MEJORA OBTENIENDO LA LISTA DE "SPECIAL PRICES" ASOCIADOS AL "LISTING"
		 * Y ORDENADOS DE FORMA DESCENDENTE POR FECHA, TOMAR EL "PRICE" RECIENTE PARA EL CALCULO.
		 */
		
		CheckoutApiResponse response = new CheckoutApiResponse();
		
		Double price = listing.getBasePrice();
		Double fee = listing.getCleaningFee();
		
		Double discountP = 0.0;
		
		// If numbers of Days is grather than QUANTITY_DAYS_FOR_DISCOUNT, applys monthlyDiscount, 
		// else applys weeklyDiscount 
		if (days > QUANTITY_DAYS_FOR_DISCOUNT)
		{
			discountP = listing.getMonthlyDiscount();
		}
		else
		{
			discountP = listing.getWeeklyDiscount();
		}
		
		Double discountAmount = 0.0;
		Double total = 0.0;
		Double subTotal = ((price * days) + fee);
		
		if (discountP > 0)
		{
			discountAmount = subTotal * discountP;
			total = subTotal - discountAmount;
		}
		else
		{
			total = subTotal;
		}
		
		// Response
		response.setNightsCount(days);
		response.setNightsCost(price);
		response.setDiscount(discountAmount);
		response.setCleaningFee(fee);
		response.setTotal(total);
		
		return response;
	}

}
