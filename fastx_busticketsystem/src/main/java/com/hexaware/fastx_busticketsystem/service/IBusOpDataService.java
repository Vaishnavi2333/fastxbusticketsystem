package com.hexaware.fastx_busticketsystem.service;

import java.util.List;

import com.hexaware.fastx_busticketsystem.dto.BusOpDataDto;
import com.hexaware.fastx_busticketsystem.entities.BusOpData;
import com.hexaware.fastx_busticketsystem.exception.BusOperatorNotFoundException;

public interface IBusOpDataService {
	
	 BusOpData addOperatorData(BusOpDataDto dto );
	 
	 BusOpData updateOperatorData(BusOpDataDto dto) throws BusOperatorNotFoundException;
	    
	 BusOpData getOperatorDataById(int operatorId) throws BusOperatorNotFoundException;
	    
	 List<BusOpData> getAllOperators();
	    
	 public String deleteOperatorData(int operatorId) throws BusOperatorNotFoundException;

}
