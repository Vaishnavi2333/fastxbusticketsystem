package com.hexaware.fastx_busticketsystem.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.fastx_busticketsystem.dto.RouteDto;
import com.hexaware.fastx_busticketsystem.entities.Route;
import com.hexaware.fastx_busticketsystem.exception.RouteNotFoundException;

@SpringBootTest
class RouteServiceImplTest {
	
	@Autowired
    RouteServiceImpl routeService;
	
	private Route savedRoute;
	
	@BeforeEach
	void setup() {
	    RouteDto dto = new RouteDto();
	    dto.setRouteId(103);
	    dto.setRouteName("Delhi-Pune");
	    dto.setOrigin("Delhi");
	    dto.setDestination("Pune");
	    dto.setDistanceKm(120.5);
	    dto.setEstimatedTime(LocalTime.of(1, 0));

	    savedRoute = routeService.addRoute(dto);
	}

	@Test
	void testAddRoute() {
		 RouteDto dto = new RouteDto();
	        dto.setRouteId(103); 
	        dto.setRouteName("Delhi-Pune");
	        dto.setOrigin("Delhi");
	        dto.setDestination("Pune");
	        dto.setDistanceKm(120.5);
	        dto.setEstimatedTime(LocalTime.of(1, 0));
	        savedRoute = routeService.addRoute(dto);

	        Route saved = routeService.addRoute(dto);
	        assertEquals("Pune", saved.getDestination());
	        assertEquals(120.5, saved.getDistanceKm());
	}

	@Test
	void testGetRouteById() throws RouteNotFoundException {
		 Route fetchedRoute = routeService.getRouteById(savedRoute.getRouteId());
		    assertNotNull(fetchedRoute);
		    assertEquals("Pune", fetchedRoute.getDestination());
	}

}
