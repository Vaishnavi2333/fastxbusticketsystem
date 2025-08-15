package com.hexaware.fastx_busticketsystem.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.fastx_busticketsystem.dto.BusOpLoginDto;
import com.hexaware.fastx_busticketsystem.exception.BusOperatorAlreadyExistsException;
import com.hexaware.fastx_busticketsystem.exception.BusOperatorNotFoundException;

import lombok.extern.slf4j.Slf4j;


/*Author:Vaishnavi Suresh Vaidyanath
Modified Date:14-Aug-2025
Description:  BusOperatorLogin Class test case*/

@SpringBootTest
@Slf4j
public class BusOpLoginServiceImpl {

    @Autowired
    private IBusOpLoginService service;

    @Test
    void testRegisterBusOperator() throws BusOperatorAlreadyExistsException {
        log.info("Starting testRegisterBusOperator...");

        BusOpLoginDto dto = new BusOpLoginDto();
        dto.setUsername("Hamza");
        dto.setPassword("hamza123");

        log.info("Registering bus operator: {}", dto.getUsername());

        String result = service.registerBusOp(dto);

        log.info("Registration result: {}", result);
       
        assertEquals("Bus Operator registered successfully", result);
    }

    @Test
    void testLoginBusOperator() throws BusOperatorNotFoundException {
        log.info("Starting testLoginBusOperator...");

        String username = "Hamza";
        String password = "hamza123";

        log.info("Logging in bus operator: {}", username);

        String result = service.loginBusOp(username, password);

        log.info("Login result: {}", result);
        assertNotNull(result);
        assertTrue(result.length() > 0); 
    }
}