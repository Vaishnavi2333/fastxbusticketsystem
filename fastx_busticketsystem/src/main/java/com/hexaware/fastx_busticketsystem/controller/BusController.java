package com.hexaware.fastx_busticketsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.fastx_busticketsystem.dto.BusDto;
import com.hexaware.fastx_busticketsystem.entities.Bus;
import com.hexaware.fastx_busticketsystem.exception.BusNotFoundException;
import com.hexaware.fastx_busticketsystem.service.IBusService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/bus")
public class BusController {
	
	@Autowired
	IBusService service;
	
	@PostMapping("/add")
    public Bus addBus(@RequestBody @Valid BusDto busDto) {
        return service.addBus(busDto);
    }

    @PutMapping("/update")
    public Bus updateBus(@RequestBody @Valid BusDto busDto) throws BusNotFoundException {
        return service.updateBus(busDto);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBus(@PathVariable("id") int id) throws BusNotFoundException {
        service.deleteBus(id);
        return "Bus with id " + id + " deleted successfully";
    }

    @GetMapping("/{id}")
    public Bus getBusById(@PathVariable("id") int id) throws BusNotFoundException {
        return service.getBusById(id);
    }

    @GetMapping("/all")
    public List<Bus> getAllBuses() {
        return service.getAllBuses();
    }

    @GetMapping("/operator/{operatorId}")
    public List<Bus> getBusesByOperatorId(@PathVariable("operatorId") int operatorId) {
        return service.getBusesByOperatorId(operatorId);
    }

}
