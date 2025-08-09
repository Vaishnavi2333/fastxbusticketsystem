package com.hexaware.fastx_busticketsystem.service;

import com.hexaware.fastx_busticketsystem.dto.UserLoginDto;
import com.hexaware.fastx_busticketsystem.entities.UserLogin;
import com.hexaware.fastx_busticketsystem.exception.UserAlreadyExistsException;
import com.hexaware.fastx_busticketsystem.exception.UserNotFoundException;

public interface IUserLoginService {
	
	public boolean register(UserLoginDto loginDto) throws UserAlreadyExistsException;          

	public boolean login(String username, String password) throws UserNotFoundException; 

	public boolean existsByUsername(String username);   

	public UserLogin getByUsername(String username);

}
