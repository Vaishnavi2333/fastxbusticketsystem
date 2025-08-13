package com.hexaware.fastx_busticketsystem.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.fastx_busticketsystem.dto.BusAmenityDto;
import com.hexaware.fastx_busticketsystem.dto.BusDto;
import com.hexaware.fastx_busticketsystem.entities.Bus;
import com.hexaware.fastx_busticketsystem.entities.BusAmenity;
import com.hexaware.fastx_busticketsystem.entities.Trip;
import com.hexaware.fastx_busticketsystem.exception.BusNotFoundException;
import com.hexaware.fastx_busticketsystem.repository.BusRepo;
import com.hexaware.fastx_busticketsystem.repository.TripRepo;


@Service
public class BusServiceImpl implements IBusService {
	
	@Autowired
	BusRepo repo;
	
	@Autowired 
	TripRepo tripRepo;

	@Override
	public Bus addBus(BusDto busDto) {
		Bus bus = new Bus();
		bus.setBusId(busDto.getBusId());
		bus.setBusName(busDto.getBusName());
		bus.setBusNumber(bus.getBusNumber());
		bus.setBusType(busDto.getBusType());
		bus.setCapacity(busDto.getCapacity());
		bus.setStatus(busDto.getStatus());
		
		bus.setAmenities(busDto.getAmenities().stream().map(a -> {
		    BusAmenity amenity = new BusAmenity();
		    amenity.setAmenityName(a.getAmenityName());
		    amenity.setBus(bus);
		    return amenity;
		}).collect(Collectors.toList()));
		
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
	        
	        existingBus.setAmenities(busDto.getAmenities().stream().map(a -> {
	            BusAmenity amenity = new BusAmenity();
	            amenity.setAmenityName(a.getAmenityName());
	            amenity.setBus(existingBus);  
	            return amenity;
	        }).collect(Collectors.toList()));
	       
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
		return repo.findByBusOpData_BusOpdataId(operatorId);
		
		

	}
	@Override
	public List<BusDto> searchBusesByOriginDestinationAndDate(String origin, String destination, LocalDate date) {
	    List<Trip> trips = tripRepo.findTripsByOriginDestinationAndDate(origin, destination, date);

	    return trips.stream().map(trip -> {
	        Bus bus = trip.getBus();
	        BusDto dto = new BusDto();
	        dto.setBusId(bus.getBusId());
	        dto.setBusName(bus.getBusName());
	        dto.setBusType(bus.getBusType());
	        dto.setCapacity(bus.getCapacity());
	        dto.setFare(trip.getFare());
	        dto.setDepartureTime(trip.getDepartureTime());
	        dto.setArrivalTime(trip.getArrivalTime());

	        List<BusAmenity> amenities = bus.getAmenities() != null ? bus.getAmenities() : new ArrayList<>();
	        dto.setAmenities(
	            amenities.stream()
	                .map((BusAmenity a) -> {
	                    BusAmenityDto amenityDto = new BusAmenityDto();
	                    amenityDto.setBusamenityId(a.getBusamenityId());
	                    amenityDto.setAmenityName(a.getAmenityName());
	                    return amenityDto;
	                })
	                .collect(Collectors.toList())
	        );

	        return dto;
	    }).collect(Collectors.toList());
	}
	
	

}
