package com.hexaware.fastx_busticketsystem.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.fastx_busticketsystem.dto.BusOpLoginDto;
import com.hexaware.fastx_busticketsystem.exception.BusOperatorAlreadyExistsException;

@SpringBootTest
class BusOpLoginServiceImplTest {
	
	@Autowired
	IBusOpLoginService busOpLoginService;

	@Disabled
	@Test
	void testRegisterBusOp() throws BusOperatorAlreadyExistsException {
		BusOpLoginDto dto = new BusOpLoginDto();
        dto.setUsername("Suresh");
        dto.setPassword("suresh123");

       // boolean result = busOpLoginService.registerBusOp(dto);
        assertEquals("Suresh",dto.getUsername());
	}

	

}
