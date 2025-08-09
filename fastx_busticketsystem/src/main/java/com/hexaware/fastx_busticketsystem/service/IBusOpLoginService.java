package com.hexaware.fastx_busticketsystem.service;

import com.hexaware.fastx_busticketsystem.dto.BusOpLoginDto;
import com.hexaware.fastx_busticketsystem.entities.BusOpLogin;

public interface IBusOpLoginService {
	
	public BusOpLogin registerOperator(BusOpLoginDto dto);

	    
	public BusOpLogin authenticateOperator(String username, String password);
	  
	public   boolean logoutOperator(int operatorId);
	
	  public   BusOpLogin getOperatorLoginById(int id);

}
