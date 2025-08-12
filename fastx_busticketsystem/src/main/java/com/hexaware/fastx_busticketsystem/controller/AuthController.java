package com.hexaware.fastx_busticketsystem.controller;



import com.hexaware.fastx_busticketsystem.service.JwtService;
import com.hexaware.fastx_busticketsystem.dto.AdminLoginDto;
import com.hexaware.fastx_busticketsystem.dto.BusOpLoginDto;
import com.hexaware.fastx_busticketsystem.dto.JwtRequest;
import com.hexaware.fastx_busticketsystem.dto.JwtResponse;
import com.hexaware.fastx_busticketsystem.dto.UserLoginDto;
import com.hexaware.fastx_busticketsystem.dto.UserRegistrationDto;
import com.hexaware.fastx_busticketsystem.exception.AdminAlreadyExistsException;
import com.hexaware.fastx_busticketsystem.exception.AdminNotFoundException;
import com.hexaware.fastx_busticketsystem.exception.BusOperatorAlreadyExistsException;
import com.hexaware.fastx_busticketsystem.exception.BusOperatorNotFoundException;
import com.hexaware.fastx_busticketsystem.exception.UserAlreadyExistsException;
import com.hexaware.fastx_busticketsystem.exception.UserNotFoundException;
import com.hexaware.fastx_busticketsystem.service.AppUserDetailsService;
import com.hexaware.fastx_busticketsystem.service.IAdminLoginService;
import com.hexaware.fastx_busticketsystem.service.IBusOpLoginService;
import com.hexaware.fastx_busticketsystem.service.IUserLoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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
        userLoginService.register(dto);
        return ResponseEntity.ok("User registered");
    }

    @PostMapping("/register/busoperator")
    public ResponseEntity<?> registerBusOperator(@RequestBody BusOpLoginDto dto) throws BusOperatorAlreadyExistsException {
        busOpLoginService.registerBusOp(dto);
        return ResponseEntity.ok("Bus Operator registered");
    }
    @PostMapping("/register/admin")
    public ResponseEntity<?> registerAdmin(@RequestBody AdminLoginDto dto) throws AdminAlreadyExistsException {
        adminLoginService.registerAdmin(dto);
        return ResponseEntity.ok("Admin registered");
    }

    @PostMapping("/login/user")
    public ResponseEntity<JwtResponse> loginUser(@RequestBody JwtRequest request) throws UserNotFoundException {
        String token = userLoginService.login(request.getUsername(), request.getPassword());
        return ResponseEntity.ok(new JwtResponse(token));
    }

    @PostMapping("/login/busoperator")
    public ResponseEntity<JwtResponse> loginBusOperator(@RequestBody JwtRequest request) throws BusOperatorNotFoundException {
        String token = busOpLoginService.loginBusOp(request.getUsername(), request.getPassword());
        return ResponseEntity.ok(new JwtResponse(token));
    }

    @PostMapping("/login/admin")
    public ResponseEntity<JwtResponse> loginAdmin(@RequestBody JwtRequest request) throws AdminNotFoundException {
        String token = adminLoginService.loginAdmin(request.getUsername(), request.getPassword());
        return ResponseEntity.ok(new JwtResponse(token));
    }

}
