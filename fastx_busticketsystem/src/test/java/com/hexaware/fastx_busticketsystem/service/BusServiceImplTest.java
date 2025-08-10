package com.hexaware.fastx_busticketsystem.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.fastx_busticketsystem.dto.BusDto;
import com.hexaware.fastx_busticketsystem.entities.Bus;
import com.hexaware.fastx_busticketsystem.exception.BusNotFoundException;

@SpringBootTest
class BusServiceImplTest {

	@Autowired
    IBusService busService;
	
	@Test
	void testUpdateBus() throws BusNotFoundException {
		BusDto busDto = new BusDto();
        busDto.setBusId(1001);  
        busDto.setBusName("Express");
        busDto.setBusNumber("EXP123");
        busDto.setBusType("AC");
        busDto.setCapacity(40);
        busDto.setStatus("Active");

        busService.addBus(busDto);

       
        busDto.setBusName("Express Updated");
        busDto.setCapacity(45);
        Bus updatedBus = busService.updateBus(busDto);

        assertNotNull(updatedBus);
        assertEquals(45, updatedBus.getCapacity());
	}

	@Test
	void testGetBusById() throws BusNotFoundException {
		BusDto busDto = new BusDto();
        busDto.setBusId(1002);
        busDto.setBusName("Local");
        busDto.setBusNumber("LOC456");
        busDto.setBusType("Non-AC");
        busDto.setCapacity(30);
        busDto.setStatus("Active");

        busService.addBus(busDto);

        Bus bus = busService.getBusById(1002);
        assertNotNull(bus);
        assertEquals("Local", bus.getBusName());
		
	}

}
