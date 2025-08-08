package com.hexaware.fastx_busticketsystem.service;

import java.util.List;

import com.hexaware.fastx_busticketsystem.entities.BusOpData;

public interface IBusOpDataService {
	
	 BusOpData createOperatorData(BusOpData operatorData);
	 
	 BusOpData updateOperatorData(BusOpData operatorData);
	    
	 BusOpData getOperatorDataById(int operatorId);
	    
	 List<BusOpData> getAllOperators();
	    
	 boolean deleteOperatorData(int operatorId);

}
