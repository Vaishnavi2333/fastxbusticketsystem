package com.hexaware.fastx_busticketsystem.service;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.fastx_busticketsystem.dto.AdminLoginDto;
import com.hexaware.fastx_busticketsystem.dto.RouteDto;
import com.hexaware.fastx_busticketsystem.entities.Route;
import com.hexaware.fastx_busticketsystem.exception.AdminAlreadyExistsException;

@SpringBootTest
class AdminLoginServiceImplTest {
	
	@Autowired
	IAdminLoginService service;

	@Disabled
	@Test
	void testAddRoute() {
		RouteDto routeDto = new RouteDto();
	    routeDto.setRouteName("Chennai-Mumbai");
	    routeDto.setOrigin("Chennai");
	    routeDto.setDestination("Mumbai");
	    routeDto.setDistanceKm(120);
	    routeDto.setEstimatedTime(LocalTime.of(1, 0));
	    
	    Route savedRoute = service.addRoute(routeDto);
	}

	@Disabled
	@Test
	void testDeleteBooking() {
		int bookingId = 1; 
	    
	    assertDoesNotThrow(() -> {
	        service.deleteBooking(bookingId);
	    });
	}

	
	@Test
	void testRegisterAdmin() throws AdminAlreadyExistsException {
		AdminLoginDto adminDto = new AdminLoginDto();
	    adminDto.setUsername("adminUser");
	    adminDto.setPassword("adminPass123");
	    
	    boolean registered = service.registerAdmin(adminDto);
	    assertTrue(registered);
	}

}
