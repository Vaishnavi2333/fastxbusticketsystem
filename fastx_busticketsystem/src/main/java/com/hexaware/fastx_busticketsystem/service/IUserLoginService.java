package com.hexaware.fastx_busticketsystem.service;

import com.hexaware.fastx_busticketsystem.entities.UserLogin;

public interface IUserLoginService {
	
	public boolean register(UserLogin login);          

	public boolean login(String username, String password); 

	public boolean existsByUsername(String username);   

	public UserLogin getByUsername(String username);

}
