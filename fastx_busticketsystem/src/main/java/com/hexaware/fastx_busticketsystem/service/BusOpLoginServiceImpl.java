package com.hexaware.fastx_busticketsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.fastx_busticketsystem.dto.BusOpLoginDto;
import com.hexaware.fastx_busticketsystem.entities.BusOpLogin;
import com.hexaware.fastx_busticketsystem.repository.BusOpLoginRepo;


@Service
public class BusOpLoginServiceImpl implements IBusOpLoginService {
	
	@Autowired
	BusOpLoginRepo repo;
	/*
	 * @Override public BusOpLogin registerOperator(BusOpLoginDto dto) { BusOpLogin
	 * busop = new BusOpLogin(); busop.setBusOpId(dto.getBusOpId());
	 * busop.setUsername(dto.getUsername()); busop.setPassword(dto.getPassword());
	 * 
	 * return repo.save(busop); }
	 * 
	 * @Override public BusOpLogin authenticateOperator(String username, String
	 * password) { // TODO Auto-generated method stub return null; }
	 * 
	 * @Override public boolean logoutOperator(int operatorId) { // TODO
	 * Auto-generated method stub return false; }
	 * 
	 * @Override public BusOpLogin getOperatorLoginById(int id) { return
	 * repo.findById(id) .orElseThrow(() -> new
	 * RuntimeException("Operator login not found with id: " + id)); }
	 */

	@Override
	public BusOpLogin registerOperator(BusOpLoginDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BusOpLogin authenticateOperator(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean logoutOperator(int operatorId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public BusOpLogin getOperatorLoginById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	


}
