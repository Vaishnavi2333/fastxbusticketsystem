package com.hexaware.fastx_busticketsystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.fastx_busticketsystem.entities.BusOpLogin;

public interface BusOpLoginRepo extends JpaRepository<BusOpLogin,Integer>{
	
	
	boolean existsByUsername(String username);
	

	Optional<BusOpLogin> findByUsername(String username);


}
