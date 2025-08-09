package com.hexaware.fastx_busticketsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.fastx_busticketsystem.dto.BusDto;
import com.hexaware.fastx_busticketsystem.entities.Bus;
import com.hexaware.fastx_busticketsystem.exception.BusNotFoundException;
import com.hexaware.fastx_busticketsystem.repository.BusRepo;


@Service
public class BusServiceImpl implements IBusService {
	
	@Autowired
	BusRepo repo;

	@Override
	public Bus addBus(BusDto busDto) {
		Bus bus = new Bus();
		bus.setBusId(busDto.getBusId());
		bus.setBusName(busDto.getBusName());
		bus.setBusNumber(bus.getBusNumber());
		bus.setBusType(busDto.getBusType());
		bus.setCapacity(busDto.getCapacity());
		bus.setStatus(busDto.getStatus());
		return repo.save(bus);
	}

	@Override
	public Bus updateBus(BusDto busDto) throws BusNotFoundException {
		Bus existingBus = repo.findById(busDto.getBusId())
	            .orElseThrow(() -> new BusNotFoundException("Bus not found with id: " + busDto.getBusId()));

	        existingBus.setBusName(busDto.getBusName());
	        existingBus.setBusNumber(busDto.getBusNumber());
	        existingBus.setBusType(busDto.getBusType());
	        existingBus.setCapacity(busDto.getCapacity());
	        existingBus.setStatus(busDto.getStatus());

	        return repo.save(existingBus);
	}

	@Override
	public void deleteBus(int busId) throws BusNotFoundException {
		  Bus existingBus = repo.findById(busId)
		            .orElseThrow(() -> new BusNotFoundException("Bus not found with id: " + busId));
		        repo.delete(existingBus);
	}

	@Override
	public Bus getBusById(int busId) throws BusNotFoundException {
		return repo.findById(busId)
	            .orElseThrow(() -> new BusNotFoundException("Bus not found with id: " + busId));
	}

	@Override
	public List<Bus> getAllBuses() {
		
		return repo.findAll();
	}

	@Override
	public List<Bus> getBusesByOperatorId(int operatorId) {
		return repo.findByOperatorId(operatorId);
	}

	

}
