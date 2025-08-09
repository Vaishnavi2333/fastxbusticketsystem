package com.hexaware.fastx_busticketsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.fastx_busticketsystem.dto.BusAmenityDto;
import com.hexaware.fastx_busticketsystem.entities.Bus;
import com.hexaware.fastx_busticketsystem.entities.BusAmenity;
import com.hexaware.fastx_busticketsystem.exception.BusAmenityNotFoundException;
import com.hexaware.fastx_busticketsystem.exception.BusNotFoundException;
import com.hexaware.fastx_busticketsystem.repository.BusAmenityRepo;
import com.hexaware.fastx_busticketsystem.repository.BusRepo;


@Service
public class BusAmenityServiceImpl implements IBusAmenityService {
	
	@Autowired
    BusAmenityRepo busAmenityRepo;

    @Autowired
    BusRepo busRepo;

	@Override
	public BusAmenity addBusAmenity(BusAmenityDto busamenityDto) throws BusNotFoundException {
		Bus bus = busRepo.findById(busamenityDto.getBusId())
	            .orElseThrow(() -> new BusNotFoundException("Bus not found with id: " + busamenityDto.getBusId()));

	        BusAmenity busAmenity = new BusAmenity();
	        busAmenity.setBus(bus);
	        busAmenity.setAmenityName(busamenityDto.getAmenityName());

	        return busAmenityRepo.save(busAmenity);
	}

	@Override
	public BusAmenity updateBusAmenity(BusAmenityDto busamenityDto) throws BusAmenityNotFoundException, BusNotFoundException {
		BusAmenity existing = busAmenityRepo.findById(busamenityDto.getBusId())
		        .orElseThrow(() -> new BusAmenityNotFoundException("BusAmenity not found with id: " + busamenityDto.getBusId()));

		  
		    if (busamenityDto.getBusId() != 0) {
		        Bus bus = busRepo.findById(busamenityDto.getBusId())
		            .orElseThrow(() -> new BusNotFoundException("Bus not found with id: " + busamenityDto.getBusId()));
		        existing.setBus(bus);
		    }

		    existing.setAmenityName(busamenityDto.getAmenityName());

		    return busAmenityRepo.save(existing);
	}

	@Override
	public void removeBusAmenity(int busAmenityId) {
		BusAmenity existing = busAmenityRepo.findById(busAmenityId)
	            .orElseThrow(() -> new RuntimeException("BusAmenity not found with id: " + busAmenityId));

	        busAmenityRepo.delete(existing);
		
	}

	@Override
	public List<BusAmenity> getAllBusAmenity() {
		return busAmenityRepo.findAll();
	}

	@Override
	public BusAmenity getBusAmenityById(int busAmenityId) {
		return busAmenityRepo.findById(busAmenityId)
	            .orElseThrow(() -> new RuntimeException("BusAmenity not found with id: " + busAmenityId));
	}


	
}
