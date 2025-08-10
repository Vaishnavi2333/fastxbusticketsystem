package com.hexaware.fastx_busticketsystem.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.fastx_busticketsystem.dto.BusAmenityDto;
import com.hexaware.fastx_busticketsystem.entities.Bus;
import com.hexaware.fastx_busticketsystem.entities.BusAmenity;
import com.hexaware.fastx_busticketsystem.exception.BusNotFoundException;
import com.hexaware.fastx_busticketsystem.repository.BusRepo;

@SpringBootTest
class BusAmenityServiceImplTest {
	
	@Autowired
	BusRepo busRepo;
	
	@Autowired
	IBusAmenityService service;

	@Test
	void testAddBusAmenity() throws BusNotFoundException {
		Bus bus = new Bus();
        bus.setBusName("Travelbus");
        bus = busRepo.save(bus);

        BusAmenityDto dto = new BusAmenityDto();
        dto.setBusId(bus.getBusId());
        dto.setAmenityName("WiFi");

        BusAmenity result = service.addBusAmenity(dto);
        assertEquals("WiFi", result.getAmenityName());
	}

	@Test
	void testUpdateBusAmenity() {
		fail("Not yet implemented");
	}


}
