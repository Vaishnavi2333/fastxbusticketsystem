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

    @Test
    void testRegister() throws Exception {
        log.info("Starting testRegister...");

       
        UserLoginDto user = new UserLoginDto();
        user.setUsername("Rani");
        user.setPassword("rani12345");
       

        log.info("Registering user with username", user.getUsername());

        boolean result = service.register(user);

        log.info("Registration result", result);

        assertTrue(result, "User registration should return true");
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
