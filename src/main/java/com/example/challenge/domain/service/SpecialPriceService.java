package com.example.challenge.domain.service;

import com.example.challenge.app.api.SpecialPriceApi;
import com.example.challenge.exception.SpecialPriceException;

/**
 * 
 * @author <a href="mailto:abeljose13@gmail.com">Avelardo Gavide</a>
 *
 */
public interface SpecialPriceService 
{
	/**
	 * Create a new Special Price
	 * 
	 * @param uuid
	 * @param specialPriceApi
	 * @return  New Special Price object
	 * @throws SpecialPriceException
	 */
	public SpecialPriceApi create(String listingUUID, SpecialPriceApi specialPriceApi) throws SpecialPriceException;
	
	/**
	 * Delete a Special Price by UUID
	 * 
	 * @param uuid
	 * @throws SpecialPriceException
	 */
	public void delete(String uuid) throws SpecialPriceException;
}
