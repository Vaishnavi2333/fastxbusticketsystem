package com.hexaware.fastx_busticketsystem.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.fastx_busticketsystem.dto.BusDto;
import com.hexaware.fastx_busticketsystem.entities.Bus;
import com.hexaware.fastx_busticketsystem.exception.BusNotFoundException;
import com.hexaware.fastx_busticketsystem.service.IBusService;
/*
Autor:Vaishnavi Suresh Vaidyanath
Modified Date:12-Aug-2025
Description:Controller Class for Bus*/

import jakarta.validation.Valid;

@RestController
@RequestMapping("/bus")
public class BusController {
    
    @Autowired
    private IBusService service;

    
    @PreAuthorize("hasRole('BUS_OPERATOR')")
    @PostMapping("/add")
    public Bus addBus(@Valid @RequestBody BusDto busDto) {
        return service.addBus(busDto);
    }

    @PreAuthorize("hasRole('BUS_OPERATOR')")
    @PutMapping("/update")
    public Bus updateBus(@Valid @RequestBody BusDto busDto) throws BusNotFoundException {
        return service.updateBus(busDto);
    }

    @PreAuthorize("hasRole('BUS_OPERATOR')")
    @DeleteMapping("/delete/{id}")
    public String deleteBus(@PathVariable("id") int id) throws BusNotFoundException {
        service.deleteBus(id);
        return "Bus with id " + id + " deleted successfully";
    }

   
    @GetMapping("/getbusbyid/{id}")
    public Bus getBusById(@PathVariable("id") int id) throws BusNotFoundException {
        return service.getBusById(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/getallbus")
    public List<Bus> getAllBuses() {
        return service.getAllBuses();
    }

    @GetMapping("/getbusbyoperator/{operatorId}")
    @PreAuthorize("hasRole('BUS_OPERATOR')")
    public List<Bus> getBusesByOperatorId(@PathVariable("operatorId") int operatorId) {
        return service.getBusesByOperatorId(operatorId);
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/search")
    public List<BusDto> searchBuses(@RequestParam String origin,
                                    @RequestParam String destination,
                                    @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return service.searchBusesByOriginDestinationAndDate(origin, destination, date);
    }
}
