package com.example.challenge.app.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.challenge.app.api.CheckoutApi;
import com.example.challenge.app.api.CheckoutApiResponse;
import com.example.challenge.app.api.ListingApi;
import com.example.challenge.domain.service.ListingService;
import com.example.challenge.exception.ListingException;

@RestController
@RequestMapping(path = "/api/listings")
public class ListingController 
{
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ListingService listingService;
	
	
	@PostMapping(produces = {
			MediaType.APPLICATION_JSON_VALUE }, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> create(@RequestBody ListingApi listingApi) throws ListingException
	{
		log.info("Creating a new Listing");
		
		listingApi = listingService.create(listingApi);
		
		return new ResponseEntity<ListingApi>(listingApi, HttpStatus.OK);
	}
	
	@PutMapping(path = "/{uuid}", produces = {
			MediaType.APPLICATION_JSON_VALUE }, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@PathVariable String uuid,
			@RequestBody ListingApi listingApi) throws ListingException
	{
		log.info("Updating a Listing");
		
		listingApi = listingService.update(uuid, listingApi);
		
		return new ResponseEntity<ListingApi>(listingApi, HttpStatus.OK);
	}
	
	@GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> showAll() throws ListingException
	{
		log.info("Get all listings");
		
		List<ListingApi> listings = listingService.getAll();
		
		return new ResponseEntity<List<ListingApi>>(listings, HttpStatus.OK);
	}
	
	@GetMapping(path = "/{uuid}", produces = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> show(@PathVariable String uuid) throws ListingException
	{
		log.info("Get a listing by uuid");
		
		ListingApi listingApi = listingService.get(uuid);
		
		return new ResponseEntity<ListingApi>(listingApi, HttpStatus.OK);
	}
	
	@DeleteMapping(path = "/{uuid}")
	public ResponseEntity<?> delete(@PathVariable String uuid) throws ListingException
	{
		log.info("Delete a listing");
		
		listingService.delete(uuid);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping(path = "/{uuid}/checkout", produces = {
			MediaType.APPLICATION_JSON_VALUE }, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> checkout(@PathVariable String uuid,
			@RequestBody CheckoutApi checkoutApi) throws ListingException
	{
		log.info("Calculating a reservation cost");
		
		CheckoutApiResponse response = listingService.checkout(uuid, checkoutApi);
		
		return new ResponseEntity<CheckoutApiResponse>(response, HttpStatus.OK);
	}
}
