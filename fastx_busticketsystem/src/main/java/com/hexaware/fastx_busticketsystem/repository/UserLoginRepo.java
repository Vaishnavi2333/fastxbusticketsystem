package com.hexaware.fastx_busticketsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.fastx_busticketsystem.entities.UserLogin;

public interface UserLoginRepo extends JpaRepository<UserLogin,Integer>{
	
	boolean existsByUsername(String username);
    UserLogin findByUsername(String username);

}
