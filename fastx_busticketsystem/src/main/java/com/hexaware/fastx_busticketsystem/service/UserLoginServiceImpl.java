package com.hexaware.fastx_busticketsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.fastx_busticketsystem.dto.UserLoginDto;
import com.hexaware.fastx_busticketsystem.entities.UserLogin;
import com.hexaware.fastx_busticketsystem.exception.UserAlreadyExistsException;
import com.hexaware.fastx_busticketsystem.exception.UserNotFoundException;
import com.hexaware.fastx_busticketsystem.repository.UserLoginRepo;


@Service
public class UserLoginServiceImpl implements IUserLoginService {
	
	@Autowired
	UserLoginRepo repo;

	@Override
	public boolean register(UserLoginDto loginDto) throws UserAlreadyExistsException {
	

		if (repo.existsByUsername(loginDto.getUsername())) {
	        throw new UserAlreadyExistsException("User '" + loginDto.getUsername() + "' already exists");
	        
	    }
		
	
		
		  UserLogin login = new UserLogin();
		  
		  
		  login.setUsername(loginDto.getUsername());
		  login.setPassword(loginDto.getPassword());
		 
		  repo.save(login);
		 
			 return true; 
	}

	@Override
	public boolean login(String username, String password) throws UserNotFoundException {
		UserLogin user = repo.findByUsername(username);
	    if (user == null) {
	        throw new UserNotFoundException("User with username '" + username + "' not found");
	    }
		
		
		return true;
	}

	
	public boolean existsByUsername(String username) {
		
		
        return repo.existsByUsername(username);
    }

	


}
