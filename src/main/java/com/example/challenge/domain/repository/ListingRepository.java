package com.example.challenge.domain.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.challenge.domain.model.Listing;

/**
 * 
 * @author <a href="mailto:abeljose13@gmail.com">Avelardo Gavide</a>
 *
 */
public interface ListingRepository extends JpaRepository<Listing, UUID> 
{
	public Listing findByName(String name);
}
