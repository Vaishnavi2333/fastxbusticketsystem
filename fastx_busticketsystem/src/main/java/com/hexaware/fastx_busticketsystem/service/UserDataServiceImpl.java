package com.hexaware.fastx_busticketsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.fastx_busticketsystem.dto.UserDataDto;
import com.hexaware.fastx_busticketsystem.entities.UserData;
import com.hexaware.fastx_busticketsystem.exception.UserNotFoundException;
import com.hexaware.fastx_busticketsystem.repository.UserDataRepo;


@Service
public class UserDataServiceImpl implements IUserDataService{
	
	@Autowired
	UserDataRepo userRepo;

	@Override
	public UserData createUser(UserDataDto userDto) {
		UserData user = new UserData();
        user.setUserdataId(userDto.getUserdataId());
        user.setName(userDto.getName());
        user.setGender(userDto.getGender());
        user.setEmail(userDto.getEmail());
        user.setDateOfBirth(userDto.getDateOfBirth());
        user.setContactNumber(userDto.getContactNumber());
        user.setAddress(userDto.getAddress());
        
        return userRepo.save(user);
        
   


        
	}

	@Override
	public UserData updateUser(UserDataDto userDto) throws UserNotFoundException {
		UserData user =userRepo.findById(userDto.getUserdataId())
	            .orElseThrow(() -> new UserNotFoundException("User with ID " + userDto.getUserdataId() + " not found"));
		user.setName(userDto.getName());
        user.setGender(userDto.getGender());
        user.setEmail(userDto.getEmail());
        user.setDateOfBirth(userDto.getDateOfBirth());
        user.setContactNumber(userDto.getContactNumber());
        user.setAddress(userDto.getAddress());
        
		
		return userRepo.save(user);
	}

	@Override
	public String deleteUser(int userId) throws UserNotFoundException {
		UserData user =userRepo.findById(userId)
	            .orElseThrow(() -> new UserNotFoundException("User with ID " + userId + " not found"));
		userRepo.delete(user);
		return "Deleted Successfully";
	}

	@Override
	public UserData getUserById(int userId) throws UserNotFoundException {
		return userRepo.findById(userId)
	            .orElseThrow(() -> new UserNotFoundException("User with ID " + userId + " not found"));
	}

	@Override
	public List<UserData> getAllUsers() {
		
		return userRepo.findAll();
	}

	
}
