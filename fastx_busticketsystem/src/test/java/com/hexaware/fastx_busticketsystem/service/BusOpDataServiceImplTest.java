package com.hexaware.fastx_busticketsystem.service;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.fastx_busticketsystem.dto.BusOpDataDto;
import com.hexaware.fastx_busticketsystem.entities.BusOpData;
import com.hexaware.fastx_busticketsystem.exception.BusOperatorNotFoundException;
import com.hexaware.fastx_busticketsystem.repository.BusOpDataRepo;
@SpringBootTest
class BusOpDataServiceImplTest {
	
	@Autowired
	BusOpDataRepo repo;

	@Autowired
	IBusOpDataService service;

	@Test
	void testAddOperatorData() {
		
		BusOpDataDto dto = new BusOpDataDto();
		dto.setBusOpdataId(1);
	    dto.setName("Shruti");
	    dto.setGender("Female");
	    dto.setCompanyName("Best Bus Co");
	    dto.setLicenceNumber("LIC12345");
	    dto.setEmail("shru59@gmail.com");
	    dto.setContactNumber("9876543210");
	    dto.setDateOfBirth(LocalDate.of(1989, 3, 25));
	    dto.setAddress("16, Nesapakkam");

	    BusOpData saved = service.addOperatorData(dto);
	    
	    assertTrue(saved.getBusOpdataId() > 0);


	}

	@Test
	void testGetOperatorDataById() throws BusOperatorNotFoundException {
		BusOpDataDto dto = new BusOpDataDto();
		
	    BusOpData saved = service.addOperatorData(dto);
	    BusOpData fetched = service.getOperatorDataById(1);
	    assertEquals("LIC123456", fetched.getLicenceNumber());
	}

}
