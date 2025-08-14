package com.hexaware.fastx_busticketsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.fastx_busticketsystem.dto.AdminLoginDto;
import com.hexaware.fastx_busticketsystem.exception.AdminAlreadyExistsException;
import com.hexaware.fastx_busticketsystem.exception.AdminNotFoundException;
import com.hexaware.fastx_busticketsystem.service.IAdminLoginService;

import lombok.extern.slf4j.Slf4j;

/*Author:Vaishnavi Suresh Vaidyanath
Modified Date:10-Aug-2025
Description:Controller Class for AdminLogin*/

@Slf4j
@RestController
@RequestMapping("/admin")
public class AdminController {
	
	
	  @Autowired 
	  IAdminLoginService service;
	  
	  @PostMapping("/register")
	  public String registerAdmin(@RequestBody AdminLoginDto adminDto) throws AdminAlreadyExistsException {
	      boolean registered = service.registerAdmin(adminDto);
	      if (registered) {
	          return "Admin registered successfully";
	      } else {
	          return "Admin registration failed";
	      }
	  }

	  @PostMapping("/login")
	  public String loginAdmin(@RequestParam String username, @RequestParam String password) throws AdminNotFoundException {
	      return service.loginAdmin(username, password);  
	      
	  }
	
}
