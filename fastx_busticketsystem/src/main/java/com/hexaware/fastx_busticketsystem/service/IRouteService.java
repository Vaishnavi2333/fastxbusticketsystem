package com.hexaware.fastx_busticketsystem.service;

import java.util.List;

import com.hexaware.fastx_busticketsystem.entities.Route;

public interface IRouteService {
	
	
    Route addRoute(Route route);

   
    Route updateRoute(int routeId, Route updatedRoute);
    

   
    void deleteRoute(int routeId);

    
    List<Route> getAllRoutes();

  
    Route getRouteById(int routeId);

}
