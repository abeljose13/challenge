package com.example.challenge.app.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.challenge.app.api.SpecialPriceApi;
import com.example.challenge.domain.service.SpecialPriceService;
import com.example.challenge.exception.SpecialPriceException;

@RestController
@RequestMapping(path = "/api/listings")
public class SpecialPriceController 
{
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SpecialPriceService specialPriceService;
	
	
	@PostMapping(path = "/{uuid}/special-prices", produces = {
			MediaType.APPLICATION_JSON_VALUE }, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> create(@PathVariable String listingUUID,
			@RequestBody SpecialPriceApi specialPriceApi) throws SpecialPriceException
	{
		log.info("Creating a new Special Price");
		
		specialPriceApi = specialPriceService.create(listingUUID, specialPriceApi);
		
		return new ResponseEntity<SpecialPriceApi>(specialPriceApi, HttpStatus.OK);
	}
	
	@DeleteMapping(path = "/special-prices/{uuid}")
	public ResponseEntity<?> delete(@PathVariable String uuid) throws SpecialPriceException
	{
		log.info("Delete a special price");
		
		specialPriceService.delete(uuid);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
