package com.hexaware.fastx_busticketsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.fastx_busticketsystem.dto.UserLoginDto;
import com.hexaware.fastx_busticketsystem.entities.UserLogin;
import com.hexaware.fastx_busticketsystem.exception.UserAlreadyExistsException;
import com.hexaware.fastx_busticketsystem.exception.UserNotFoundException;
import com.hexaware.fastx_busticketsystem.repository.UserLoginRepo;
import com.hexaware.fastx_busticketsystem.service.IUserLoginService;

/*Autor:Vaishnavi Suresh Vaidyanath
Modified Date:10-Aug-2025
Description:Controller Class for User login*/

@RestController
@RequestMapping("/userlogin")
public class UserLoginController {
	
	@Autowired
	IUserLoginService service;
	
	@PostMapping("/register")
    public String register(@RequestBody UserLoginDto loginDto) throws UserAlreadyExistsException {
        service.register(loginDto);
        return "User registered successfully";
    }
	
	@PostMapping("/login")
	public String login(@RequestParam String username, @RequestParam String password) throws UserNotFoundException {
	    return service.login(username, password);
	}
	
	
	

	
	
	

}
