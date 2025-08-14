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


/*Author:Vaishnavi Suresh Vaidyanath
Modified Date:09-Aug-2025
Description:  Bus Service Implementation Class*/

@Service
public class BusServiceImpl implements IBusService {

    @Autowired
    private BusRepo repo;

    @Autowired
    private TripRepo tripRepo;

   
    private BusDto mapToDto(Bus bus, Trip trip) {
        BusDto dto = new BusDto();
        dto.setBusId(bus.getBusId());
        dto.setBusNumber(bus.getBusNumber());
        dto.setBusName(bus.getBusName());
        dto.setBusType(bus.getBusType());
        dto.setCapacity(bus.getCapacity());
        dto.setStatus(bus.getStatus());

        if (trip != null) {
            dto.setFare(trip.getFare());
            dto.setDepartureTime(trip.getDepartureTime());
            dto.setArrivalTime(trip.getArrivalTime());
        }

        dto.setAmenities(
            bus.getAmenities() != null ?
            bus.getAmenities().stream().map(a -> {
                BusAmenityDto adto = new BusAmenityDto();
                adto.setBusamenityId(a.getBusamenityId());
                adto.setAmenityName(a.getAmenityName());
                return adto;
            }).collect(Collectors.toList())
            : new ArrayList<>()
        );

        return dto;
    }

    @Override
    public BusDto addBus(BusDto busDto) {
        Bus bus = new Bus();
        bus.setBusId(busDto.getBusId());
        bus.setBusName(busDto.getBusName());
        bus.setBusNumber(busDto.getBusNumber());
        bus.setBusType(busDto.getBusType());
        bus.setCapacity(busDto.getCapacity());
        bus.setStatus(busDto.getStatus());

        bus.setAmenities(
            busDto.getAmenities().stream().map(a -> {
                BusAmenity amenity = new BusAmenity();
                amenity.setAmenityName(a.getAmenityName());
                amenity.setBus(bus);
                return amenity;
            }).collect(Collectors.toList())
        );

        Bus savedBus = repo.save(bus);
        return mapToDto(savedBus, null);
    }

    @Override
    public BusDto updateBus(BusDto busDto) throws BusNotFoundException {
        Bus existingBus = repo.findById(busDto.getBusId())
                .orElseThrow(() -> new BusNotFoundException("Bus not found with id: " + busDto.getBusId()));

        existingBus.setBusName(busDto.getBusName());
        existingBus.setBusNumber(busDto.getBusNumber());
        existingBus.setBusType(busDto.getBusType());
        existingBus.setCapacity(busDto.getCapacity());
        existingBus.setStatus(busDto.getStatus());

        existingBus.setAmenities(
            busDto.getAmenities().stream().map(a -> {
                BusAmenity amenity = new BusAmenity();
                amenity.setAmenityName(a.getAmenityName());
                amenity.setBus(existingBus);
                return amenity;
            }).collect(Collectors.toList())
        );

        Bus savedBus = repo.save(existingBus);
        return mapToDto(savedBus, null);
    }

    @Override
    public void deleteBus(int busId) throws BusNotFoundException {
        Bus existingBus = repo.findById(busId)
                .orElseThrow(() -> new BusNotFoundException("Bus not found with id: " + busId));
        repo.delete(existingBus);
    }

    @Override
    public BusDto getBusById(int busId) throws BusNotFoundException {
        Bus bus = repo.findById(busId)
                .orElseThrow(() -> new BusNotFoundException("Bus not found with id: " + busId));
        return mapToDto(bus, null);
    }

    @Override
    public List<BusDto> getAllBuses() {
        return repo.findAll().stream()
                .map(bus -> mapToDto(bus, null))
                .collect(Collectors.toList());
    }

    @Override
    public List<BusDto> getBusesByOperatorId(int operatorId) {
        return repo.findByBusOpData_BusOpdataId(operatorId).stream()
                .map(bus -> mapToDto(bus, null))
                .collect(Collectors.toList());
    }

    @Override
    public List<BusDto> searchBusesByOriginDestinationAndDate(String origin, String destination, LocalDate date) {
        List<Trip> trips = tripRepo.findTripsByOriginDestinationAndDate(origin, destination, date);

        return trips.stream().map(trip -> mapToDto(trip.getBus(), trip)).collect(Collectors.toList());
    }
}
