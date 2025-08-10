package com.hexaware.fastx_busticketsystem.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.fastx_busticketsystem.dto.UserLoginDto;
import com.hexaware.fastx_busticketsystem.entities.UserLogin;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@SpringBootTest
class UserLoginServiceImplTest {
	
	@Autowired
	IUserLoginService service;

	@Disabled
	@Test
	void testRegister() throws Exception {
        UserLoginDto user = new UserLoginDto();
        boolean result = service.register(user);
        assertTrue(result);
    }

	@Disabled
	@Test
	void testLogin() {
		
		/*
		 * UserLoginDto user = new UserLoginDto(); UserLogin dto =
		 * service.login("Vaishnavi","vaish23");
		 */
		
	}

}
