package com.hexaware.fastx_busticketsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.fastx_busticketsystem.dto.UserDataDto;
import com.hexaware.fastx_busticketsystem.entities.UserData;
import com.hexaware.fastx_busticketsystem.entities.UserLogin;
import com.hexaware.fastx_busticketsystem.exception.UserNotFoundException;
import com.hexaware.fastx_busticketsystem.repository.UserDataRepo;
import com.hexaware.fastx_busticketsystem.repository.UserLoginRepo;


@Service
public class UserDataServiceImpl implements IUserDataService{
	
	@Autowired
    private UserDataRepo userRepo;

    @Autowired
    private UserLoginRepo userLoginRepo;

    @Override
    public UserData createUser(UserDataDto userDto) {
        UserData user = new UserData();
        
        user.setName(userDto.getName());
        user.setGender(userDto.getGender());
        user.setEmail(userDto.getEmail());
        user.setDateOfBirth(userDto.getDateOfBirth());
        user.setContactNumber(userDto.getContactNumber());
        user.setAddress(userDto.getAddress());

        UserLogin userLogin = userLoginRepo.findById(userDto.getUserLoginId())
                .orElseThrow(() -> new RuntimeException("UserLogin not found with id: " + userDto.getUserLoginId()));

        user.setUserLogin(userLogin);

        return userRepo.save(user);
    }

    @Override
    public UserData updateUser(UserDataDto userDto) throws UserNotFoundException {
        UserData user = userRepo.findById(userDto.getUserdataId())
                .orElseThrow(() -> new UserNotFoundException("UserData with ID " + userDto.getUserdataId() + " not found"));

        user.setName(userDto.getName());
        user.setGender(userDto.getGender());
        user.setEmail(userDto.getEmail());
        user.setDateOfBirth(userDto.getDateOfBirth());
        user.setContactNumber(userDto.getContactNumber());
        user.setAddress(userDto.getAddress());

        return userRepo.save(user);
    }

    @Override
    public String deleteUser(int userLoginId) throws UserNotFoundException {
       
        UserData userData = userRepo.findByUserLogin_UserId(userLoginId)
                .orElseThrow(() -> new UserNotFoundException("UserData for UserLogin id " + userLoginId + " not found"));

    
        userRepo.delete(userData);

        UserLogin userLogin = userLoginRepo.findById(userLoginId)
                .orElseThrow(() -> new UserNotFoundException("UserLogin with id " + userLoginId + " not found"));

        userLoginRepo.delete(userLogin);

        return "Deleted Successfully";
    }

    @Override
    public UserData getUserById(int userLoginId) throws UserNotFoundException {
        return userRepo.findByUserLogin_UserId(userLoginId)
                .orElseThrow(() -> new UserNotFoundException("UserData for UserLogin id " + userLoginId + " not found"));
    }

    @Override
    public List<UserData> getAllUsers() {
        return userRepo.findAll();
    }
}
	
