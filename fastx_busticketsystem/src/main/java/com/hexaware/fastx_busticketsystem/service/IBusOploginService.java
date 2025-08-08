package com.hexaware.fastx_busticketsystem.service;

import com.hexaware.fastx_busticketsystem.entities.BusOpLogin;

public interface IBusOploginService {
	
	public  BusOpLogin registerOperator(BusOpLogin operatorLogin);
	    
	public BusOpLogin authenticateOperator(String username, String password);
	  
	public   boolean logoutOperator(int operatorId);
	
	  public   BusOpLogin getOperatorLoginById(int id);

}
