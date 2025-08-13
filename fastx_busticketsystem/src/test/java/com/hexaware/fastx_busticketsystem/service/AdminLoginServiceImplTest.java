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

	
	@Test
	void testRegisterAdmin() throws AdminAlreadyExistsException {
		AdminLoginDto adminDto = new AdminLoginDto();
	    adminDto.setUsername("adminUser1");
	    adminDto.setPassword("adminPass1234");
	    
	    boolean registered = service.registerAdmin(adminDto);
	    assertTrue(registered);
	}

}
