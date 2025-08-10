package com.hexaware.fastx_busticketsystem.service;

import com.hexaware.fastx_busticketsystem.dto.BusOpLoginDto;
import com.hexaware.fastx_busticketsystem.entities.BusOpLogin;
import com.hexaware.fastx_busticketsystem.exception.BusOperatorAlreadyExistsException;
import com.hexaware.fastx_busticketsystem.exception.BusOperatorNotFoundException;

public interface IBusOpLoginService {
	
	public  boolean registerBusOp(BusOpLoginDto loginDto) throws BusOperatorAlreadyExistsException;

	  public   boolean loginBusOp(String username, String password) throws BusOperatorNotFoundException;

	   public  boolean existsByUsername(String username);

	 public  BusOpLogin getByUsername(String username);

}
