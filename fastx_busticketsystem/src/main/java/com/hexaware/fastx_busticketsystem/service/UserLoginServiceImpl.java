package com.hexaware.fastx_busticketsystem.service;

import com.hexaware.fastx_busticketsystem.entities.UserLogin;

public class UserLoginServiceImpl implements IUserLoginService {

	@Override
	public boolean register(UserLogin login) {
	
		return false;
	}

	@Override
	public boolean login(String username, String password) {
	
		return false;
	}

	@Override
	public boolean existsByUsername(String username) {
		
		return false;
	}

	@Override
	public UserLogin getByUsername(String username) {
		
		return null;
	}

}
