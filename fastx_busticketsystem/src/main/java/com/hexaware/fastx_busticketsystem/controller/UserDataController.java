package com.hexaware.fastx_busticketsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.fastx_busticketsystem.dto.UserDataDto;
import com.hexaware.fastx_busticketsystem.entities.UserData;
import com.hexaware.fastx_busticketsystem.exception.UserNotFoundException;
import com.hexaware.fastx_busticketsystem.repository.UserDataRepo;
import com.hexaware.fastx_busticketsystem.service.IUserDataService;

/*Autor:Vaishnavi Suresh Vaidyanath
Modified Date:10-Aug-2025
Description:Controller Class for User data*/
@RestController
@RequestMapping("/userdata")
public class UserDataController {
	
	@Autowired
	IUserDataService service;
	
	@PostMapping("/createuser")
	public UserData createUser(@RequestBody UserDataDto userDto) {
        return service.createUser(userDto);
    }
	
	@PutMapping("/updateuser")
    public UserData updateUser(@RequestBody UserDataDto userDto) throws UserNotFoundException {
        return service.updateUser(userDto);
    }
	
	 @DeleteMapping("/deleteuser/{userId}")
	    public String deleteUser(@PathVariable int userId) throws UserNotFoundException {
	        service.deleteUser(userId);
	        return "User with ID " + userId + " deleted successfully";
	    }
	 
	 @GetMapping("/getuser/{userId}")
	    public UserData getUserById(@PathVariable int userId) throws UserNotFoundException {
	        return service.getUserById(userId);
	    }
	 
	 @GetMapping("/allusers")
	    public List<UserData> getAllUsers() {
	        return service.getAllUsers();
	    }


}
