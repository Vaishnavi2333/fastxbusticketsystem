package com.hexaware.fastx_busticketsystem.service;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.fastx_busticketsystem.dto.UserDataDto;
import com.hexaware.fastx_busticketsystem.entities.UserData;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@SpringBootTest
class UserDataServiceImplTest {
	
	@Autowired
	IUserDataService userDataService;

	@Test
	void testCreateUser() {
		log.info("Create test started");
		UserDataDto dto = new UserDataDto();
	    dto.setUserdataId(3);  
	    dto.setName("Ria");
	    dto.setGender("Female");
	    dto.setDateOfBirth(LocalDate.of(2003, 02, 1));
	    dto.setEmail("ria23@example.com");
	    dto.setContactNumber("9876543210");
	    dto.setAddress("30,mulund");
	    dto.setUserLoginId(1);
		
	    UserData created = userDataService.createUser(dto);
	    assertEquals("Ria", created.getName());
	}

	@Disabled
	@Test
	void testDeleteUser() {
		fail("Not yet implemented");
	}

	@Disabled
	@Test
	void testGetUserById() {
		fail("Not yet implemented");
	}

}
