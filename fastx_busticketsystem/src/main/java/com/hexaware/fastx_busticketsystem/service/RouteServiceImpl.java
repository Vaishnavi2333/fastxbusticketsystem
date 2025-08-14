package com.hexaware.fastx_busticketsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.fastx_busticketsystem.dto.RouteDto;
import com.hexaware.fastx_busticketsystem.entities.Route;
import com.hexaware.fastx_busticketsystem.exception.RouteNotFoundException;
import com.hexaware.fastx_busticketsystem.repository.RouteRepo;


/*Author:Vaishnavi Suresh Vaidyanath
Modified Date:09-Aug-2025
Description:  Route Service Implementation Class*/
@Service
public class RouteServiceImpl implements IRouteService {
	
	@Autowired
	RouteRepo repo;

	@Override
	public Route addRoute(RouteDto routeDto) {
		Route route = new Route();
		route.setRouteId(routeDto.getRouteId());
		route.setRouteName(routeDto.getRouteName());
		route.setOrigin(routeDto.getOrigin());
		route.setDestination(routeDto.getDestination());
		route.setDistanceKm(routeDto.getDistanceKm());
		route.setEstimatedTime(routeDto.getEstimatedTime());
		return repo.save(route);
	}

	@Override
	public Route updateRoute(RouteDto routeDto) throws RouteNotFoundException {
		 Route existing = repo.findById(routeDto.getRouteId())
		            .orElseThrow(() -> new RouteNotFoundException("Route not found with id: " + routeDto.getRouteId()));

		        existing.setRouteName(routeDto.getRouteName());
		        existing.setOrigin(routeDto.getOrigin());
		        existing.setDestination(routeDto.getDestination());
		        existing.setDistanceKm(routeDto.getDistanceKm());
		        existing.setEstimatedTime(routeDto.getEstimatedTime());

		        return repo.save(existing);
	}

	@Override
	public void deleteRoute(int routeId) throws RouteNotFoundException {
		 Route existing = repo.findById(routeId)
		            .orElseThrow(() -> new RouteNotFoundException("Route not found with id: " + routeId));
		        repo.delete(existing);
		
	}

	@Override
	public List<Route> getAllRoutes() {
		return repo.findAll();
	}

	@Override
	public Route getRouteById(int routeId) throws RouteNotFoundException {
		 return repo.findById(routeId)
		            .orElseThrow(() -> new RouteNotFoundException("Route not found with id: " + routeId));
		    }

	
}
