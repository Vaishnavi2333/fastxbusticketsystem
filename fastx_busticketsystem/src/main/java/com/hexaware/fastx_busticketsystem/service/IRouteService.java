package com.hexaware.fastx_busticketsystem.service;

import java.util.List;

import com.hexaware.fastx_busticketsystem.dto.RouteDto;
import com.hexaware.fastx_busticketsystem.entities.Route;
import com.hexaware.fastx_busticketsystem.exception.RouteNotFoundException;

public interface IRouteService {
	
	
    Route addRoute(RouteDto routeDto);

   
    Route updateRoute(RouteDto routeDto) throws RouteNotFoundException;
    

   
    void deleteRoute(int routeId) throws RouteNotFoundException;

    
    List<Route> getAllRoutes();

  
    Route getRouteById(int routeId) throws RouteNotFoundException;

}
