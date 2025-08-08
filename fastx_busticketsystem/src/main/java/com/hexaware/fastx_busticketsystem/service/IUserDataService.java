package com.hexaware.fastx_busticketsystem.service;

import java.util.List;

import com.hexaware.fastx_busticketsystem.entities.UserData;

public interface IUserDataService {
	
	public UserData createUser(UserData user);
	
    public UserData updateUser(UserData user);
    
    public boolean deleteUser(int userId);
    
    public UserData getUserById(int userId);
    
    public List<UserData> getAllUsers();
    

}
