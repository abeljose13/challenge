package com.example.challenge.domain.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.challenge.domain.model.User;

/**
 * 
 * @author <a href="mailto:abeljose13@gmail.com">Avelardo Gavide</a>
 *
 */
public interface UserRepository extends JpaRepository<User, UUID> 
{
}
