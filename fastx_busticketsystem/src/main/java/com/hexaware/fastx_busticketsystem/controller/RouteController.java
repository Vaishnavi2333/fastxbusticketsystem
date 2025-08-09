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

import com.hexaware.fastx_busticketsystem.dto.RouteDto;
import com.hexaware.fastx_busticketsystem.entities.Route;
import com.hexaware.fastx_busticketsystem.exception.RouteNotFoundException;
import com.hexaware.fastx_busticketsystem.service.IRouteService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping
public class RouteController {
	
	@Autowired
	IRouteService service;
	
	@PostMapping("/add")
    public Route addRoute(@RequestBody RouteDto routeDto) {
        return service.addRoute(routeDto);
    }

    @PutMapping("/update")
    public Route updateRoute(@RequestBody RouteDto routeDto) throws RouteNotFoundException {
        return service.updateRoute(routeDto);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteRoute(@PathVariable("id") int routeId) throws RouteNotFoundException {
        service.deleteRoute(routeId);
        return "Route with ID " + routeId + " deleted successfully";
    }

    @GetMapping("/all")
    public List<Route> getAllRoutes() {
        return service.getAllRoutes();
    }

    @GetMapping("/{id}")
    public Route getRouteById(@PathVariable("id") int routeId) throws RouteNotFoundException {
        return service.getRouteById(routeId);
    }

}
