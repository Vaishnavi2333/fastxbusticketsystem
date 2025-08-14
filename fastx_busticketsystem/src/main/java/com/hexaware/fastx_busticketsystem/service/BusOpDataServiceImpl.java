package com.hexaware.fastx_busticketsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.fastx_busticketsystem.dto.BusOpDataDto;
import com.hexaware.fastx_busticketsystem.entities.BusOpData;
import com.hexaware.fastx_busticketsystem.entities.BusOpLogin;
import com.hexaware.fastx_busticketsystem.exception.BusOperatorNotFoundException;
import com.hexaware.fastx_busticketsystem.repository.BusOpDataRepo;
import com.hexaware.fastx_busticketsystem.repository.BusOpLoginRepo;


/*Author:Vaishnavi Suresh Vaidyanath
Modified Date:09-Aug-2025
Description:  Bus Operator Data Implementation Class*/
@Service
public class BusOpDataServiceImpl implements IBusOpDataService{
	
	@Autowired
	BusOpDataRepo repo;
	
	@Autowired
	BusOpLoginRepo busOpLoginRepo;

	@Override
	public BusOpData addOperatorData(BusOpDataDto dto) throws BusOperatorNotFoundException {
		
        BusOpLogin login = busOpLoginRepo.findById(dto.getBusOpLoginId())
                .orElseThrow(() -> new BusOperatorNotFoundException("BusOpLogin not found with id: " + dto.getBusOpLoginId()));

       
        BusOpData busOpData = new BusOpData();
        busOpData.setBusOpLogin(login);
        busOpData.setName(dto.getName());
        busOpData.setGender(dto.getGender());
        busOpData.setCompanyName(dto.getCompanyName());
        busOpData.setLicenceNumber(dto.getLicenceNumber());
        busOpData.setEmail(dto.getEmail());
        busOpData.setContactNumber(dto.getContactNumber());
        busOpData.setDateOfBirth(dto.getDateOfBirth());
        busOpData.setAddress(dto.getAddress());

        return repo.save(busOpData);
	}
	 @Override
	    public BusOpData updateOperatorData(BusOpDataDto dto) throws BusOperatorNotFoundException {
	        BusOpData existing = repo.findById(dto.getBusOpdataId())
	            .orElseThrow(() -> new BusOperatorNotFoundException("Operator not found with id: " + dto.getBusOpdataId()));

	        existing.setName(dto.getName());
	        existing.setGender(dto.getGender());
	        existing.setCompanyName(dto.getCompanyName());
	        existing.setLicenceNumber(dto.getLicenceNumber());
	        existing.setEmail(dto.getEmail());
	        existing.setContactNumber(dto.getContactNumber());
	        existing.setDateOfBirth(dto.getDateOfBirth());
	        existing.setAddress(dto.getAddress());

	        return repo.save(existing);
	    }

	    @Override
	    public BusOpData getOperatorDataById(int operatorId) throws BusOperatorNotFoundException {
	        return repo.findById(operatorId)
	            .orElseThrow(() -> new BusOperatorNotFoundException("Operator not found with id: " + operatorId));
	    }

	    @Override
	    public List<BusOpData> getAllOperators() {
	        return repo.findAll();
	    }

	    @Override
	    public String deleteOperatorData(int operatorId) throws BusOperatorNotFoundException {
	        BusOpData existing = repo.findById(operatorId)
	            .orElseThrow(() -> new BusOperatorNotFoundException("Operator not found with id: " + operatorId));
	        repo.delete(existing);
	        return "Operator with id " + operatorId + " deleted successfully.";
	    }


}
