package com.hexaware.fastx_busticketsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.fastx_busticketsystem.dto.UserLoginDto;
import com.hexaware.fastx_busticketsystem.entities.UserLogin;
import com.hexaware.fastx_busticketsystem.exception.UserAlreadyExistsException;
import com.hexaware.fastx_busticketsystem.exception.UserNotFoundException;
import com.hexaware.fastx_busticketsystem.repository.UserLoginRepo;
import com.hexaware.fastx_busticketsystem.service.IUserLoginService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/user")
public class UserLoginController {
	
	@Autowired
	IUserLoginService service;
	
	@PostMapping("/register")
    public String register(@RequestBody UserLoginDto loginDto) throws UserAlreadyExistsException {
        service.register(loginDto);
        return "User registered successfully";
    }
	
	@PostMapping("/login")
	public String login(String username,String password) throws UserNotFoundException {
		
		service.login(username, password);
        return "Login successful";
		
	}
	
	@GetMapping("/exists/{username}")
    public boolean existsByUsername(@PathVariable String username) {
        return service.existsByUsername(username);
    }
	
	 @GetMapping("/{username}")
	    public UserLogin getUserByUsername(@PathVariable String username) {
	        return service.getByUsername(username);
	    }
	
	

}
