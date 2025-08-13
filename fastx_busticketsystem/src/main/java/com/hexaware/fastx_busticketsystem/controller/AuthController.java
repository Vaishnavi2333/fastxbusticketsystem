package com.hexaware.fastx_busticketsystem.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.fastx_busticketsystem.dto.AdminLoginDto;
import com.hexaware.fastx_busticketsystem.dto.BusOpLoginDto;
import com.hexaware.fastx_busticketsystem.dto.JwtRequest;
import com.hexaware.fastx_busticketsystem.dto.UserLoginDto;
import com.hexaware.fastx_busticketsystem.exception.AdminAlreadyExistsException;
import com.hexaware.fastx_busticketsystem.exception.AdminNotFoundException;
import com.hexaware.fastx_busticketsystem.exception.BusOperatorAlreadyExistsException;
import com.hexaware.fastx_busticketsystem.exception.BusOperatorNotFoundException;
import com.hexaware.fastx_busticketsystem.exception.UserAlreadyExistsException;
import com.hexaware.fastx_busticketsystem.exception.UserNotFoundException;
import com.hexaware.fastx_busticketsystem.service.IAdminLoginService;
import com.hexaware.fastx_busticketsystem.service.IBusOpLoginService;
import com.hexaware.fastx_busticketsystem.service.IUserLoginService;

import lombok.extern.slf4j.Slf4j;


/*Autor:Vaishnavi Suresh Vaidyanath
Modified Date:12-Aug-2025
Description:AuthController Class*/



@Slf4j
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private IUserLoginService userLoginService;

    @Autowired
    private IBusOpLoginService busOpLoginService;

    @Autowired
    private IAdminLoginService adminLoginService;

    @PostMapping("/register/user")
    public ResponseEntity<?> registerUser(@RequestBody UserLoginDto dto) throws UserAlreadyExistsException {
        log.info("Received user registration request for username: {}", dto.getUsername());
        userLoginService.register(dto);
        log.info("User registered successfully: {}", dto.getUsername());
        return ResponseEntity.ok("User registered");
    }

    @PostMapping("/register/busoperator")
    public ResponseEntity<?> registerBusOperator(@RequestBody BusOpLoginDto dto) throws BusOperatorAlreadyExistsException {
        log.info("Received bus operator registration request for username: {}", dto.getUsername());
        busOpLoginService.registerBusOp(dto);
        log.info("Bus Operator registered successfully: {}", dto.getUsername());
        return ResponseEntity.ok("Bus Operator registered");
    }

    @PostMapping("/register/admin")
    public ResponseEntity<?> registerAdmin(@RequestBody AdminLoginDto dto) throws AdminAlreadyExistsException {
        log.info("Received admin registration request for username: {}", dto.getUsername());
        adminLoginService.registerAdmin(dto);
        log.info("Admin registered successfully: {}", dto.getUsername());
        return ResponseEntity.ok("Admin registered");
    }

    @PostMapping("/login/user")
    public ResponseEntity<String> loginUser(@RequestBody JwtRequest request) throws UserNotFoundException {
        log.info("User login attempt for username: {}", request.getUsername());
        String token = userLoginService.login(request.getUsername(), request.getPassword());
        log.info("User login successful: {}", request.getUsername());
        return ResponseEntity.ok(token);
    }

    @PostMapping("/login/busoperator")
    public ResponseEntity<String> loginBusOperator(@RequestBody JwtRequest request) throws BusOperatorNotFoundException {
        log.info("Bus Operator login attempt for username: {}", request.getUsername());
        String token = busOpLoginService.loginBusOp(request.getUsername(), request.getPassword());
        log.info("Bus Operator login successful: {}", request.getUsername());
        return ResponseEntity.ok(token);
    }

    @PostMapping("/login/admin")
    public ResponseEntity<String> loginAdmin(@RequestBody JwtRequest request) throws AdminNotFoundException {
        log.info("Admin login attempt for username: {}", request.getUsername());
        String token = adminLoginService.loginAdmin(request.getUsername(), request.getPassword());
        log.info("Admin login successful: {}", request.getUsername());
        return ResponseEntity.ok(token);
    }
}
