package com.hexaware.fastx_busticketsystem.service;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.fastx_busticketsystem.dto.RouteDto;
import com.hexaware.fastx_busticketsystem.entities.Route;

@SpringBootTest
class RouteServiceImplTest {
	
	@Autowired
    RouteServiceImpl routeService;

	@Test
	void testAddRoute() {
		 RouteDto dto = new RouteDto();
	        dto.setRouteId(101); 
	        dto.setRouteName("Delhi-Pune");
	        dto.setOrigin("Delhi");
	        dto.setDestination("Pune");
	        dto.setDistanceKm(120.5);
	        dto.setEstimatedTime(LocalTime.of(1, 0));

	        Route saved = routeService.addRoute(dto);
	        assertEquals("Pune", saved.getDestination());
	        assertEquals(120.5, saved.getDistanceKm());
	}

	@Test
	void testGetRouteById() {
		fail("Not yet implemented");
	}

}
