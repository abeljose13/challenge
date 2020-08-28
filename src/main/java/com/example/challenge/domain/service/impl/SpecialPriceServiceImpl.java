package com.example.challenge.domain.service.impl;

import java.util.Optional;
import java.util.UUID;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.challenge.app.api.SpecialPriceApi;
import com.example.challenge.domain.model.Listing;
import com.example.challenge.domain.model.SpecialPrice;
import com.example.challenge.domain.repository.ListingRepository;
import com.example.challenge.domain.repository.SpecialPriceRepository;
import com.example.challenge.domain.service.SpecialPriceService;
import com.example.challenge.exception.SpecialPriceException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * 
 * @author <a href="mailto:abeljose13@gmail.com">Avelardo Gavide</a>
 *
 */
@Service
public class SpecialPriceServiceImpl implements SpecialPriceService 
{
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SpecialPriceRepository specialPriceRepository;
	
	@Autowired
	private ListingRepository listingRepository;
	
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
	public SpecialPriceApi create(String listingUUID, SpecialPriceApi specialPriceApi) throws SpecialPriceException
	{
		Listing listing = null;
		
		Optional<Listing> listingDb = listingRepository.findById(UUID.fromString(listingUUID));
		
		if (!listingDb.isPresent())
		{
			throw new SpecialPriceException("Listing don't exist", "NOT_FOUND");
		}
		else
		{
			listing = listingDb.get();
		}
		
		SpecialPrice specialPrice = mapper.convertValue(specialPriceApi, SpecialPrice.class);
		specialPrice.setId(UUID.randomUUID());
		specialPrice.setListing(listing);
		
		specialPrice = specialPriceRepository.saveAndFlush(specialPrice);
		log.info("New Listing created witd ID: "+specialPrice.getId());
		
		return mapper.convertValue(specialPrice, SpecialPriceApi.class);
	}

	@Override
	public void delete(String uuid) throws SpecialPriceException 
	{
		Optional<SpecialPrice> specialPriceDb = specialPriceRepository.findById(UUID.fromString(uuid));
		
		if (!specialPriceDb.isPresent())
		{
			throw new SpecialPriceException("Special Price don't exist", "NOT_FOUND");
		}
		
		specialPriceRepository.deleteById(UUID.fromString(uuid));
	}

}
