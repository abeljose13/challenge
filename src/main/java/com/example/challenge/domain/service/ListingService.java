package com.example.challenge.domain.service;

import java.util.List;

import com.example.challenge.app.api.CheckoutApi;
import com.example.challenge.app.api.CheckoutApiResponse;
import com.example.challenge.app.api.ListingApi;
import com.example.challenge.exception.ListingException;



/**
 * 
 * @author <a href="mailto:abeljose13@gmail.com">Avelardo Gavide</a>
 *
 */
public interface ListingService 
{
	/**
	 * Create a new Listing
	 * 
	 * @param listing
	 * @return New Listing object
	 * @throws ListingException
	 */
	public ListingApi create(ListingApi listingApi) throws ListingException;
	
	/**
	 * Update a Listing
	 * 
	 * @param listing
	 * @return Updated Listing object
	 * @throws ListingException
	 */
	public ListingApi update(String uuid, ListingApi listingApi) throws ListingException;
	
	/**
	 * Delete a listing by UUID
	 * 
	 * @param uuid
	 * @throws ListingException
	 */
	public void delete(String uuid) throws ListingException;
	
	/**
	 * Return a Listing by UUID
	 * 
	 * @param uuid
	 * @return Listing object
	 * @throws ListingException
	 */
	public ListingApi get(String uuid) throws ListingException;
	
	/**
	 * Return a list with all Listings
	 * 
	 * @return Listing list
	 */
	public List<ListingApi> getAll() throws ListingException;
	
	/**
	 * Calculate a reservation cost
	 * 
	 * @param uuid
	 * @param checkoutApi
	 * @return A CheckoutApiResponse object
	 * @throws ListingException
	 */
	public CheckoutApiResponse checkout(String uuid, CheckoutApi checkoutApi) throws ListingException;
}
