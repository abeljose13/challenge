package com.example.challenge.domain.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.challenge.domain.model.SpecialPrice;

/**
 * 
 * @author <a href="mailto:abeljose13@gmail.com">Avelardo Gavide</a>
 *
 */
@Repository
public interface SpecialPriceRepository extends JpaRepository<SpecialPrice, UUID> 
{

}
