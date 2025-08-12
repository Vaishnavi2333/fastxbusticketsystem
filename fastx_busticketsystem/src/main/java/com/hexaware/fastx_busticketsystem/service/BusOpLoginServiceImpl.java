package com.hexaware.fastx_busticketsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hexaware.fastx_busticketsystem.dto.BusOpLoginDto;
import com.hexaware.fastx_busticketsystem.entities.BusOpData;
import com.hexaware.fastx_busticketsystem.entities.BusOpLogin;
import com.hexaware.fastx_busticketsystem.exception.BusOperatorAlreadyExistsException;
import com.hexaware.fastx_busticketsystem.exception.BusOperatorNotFoundException;
import com.hexaware.fastx_busticketsystem.repository.BusOpDataRepo;
import com.hexaware.fastx_busticketsystem.repository.BusOpLoginRepo;

	
	@Service
	public class BusOpLoginServiceImpl implements IBusOpLoginService {

	    @Autowired
	    private BusOpLoginRepo repo;

	    @Autowired
	    private JwtService jwtService;

	    @Autowired
	    private PasswordEncoder passwordEncoder;
	    
	    @Autowired
	    BusOpDataRepo busOpDataRepo;

	    @Override
	    public String registerBusOp(BusOpLoginDto loginDto) throws BusOperatorAlreadyExistsException {
	        if (existsByUsername(loginDto.getUsername())) {
	            throw new BusOperatorAlreadyExistsException("Bus operator already exists");
	        }

	        
	        BusOpLogin busOp = new BusOpLogin();
	        busOp.setUsername(loginDto.getUsername());
	        busOp.setPassword(passwordEncoder.encode(loginDto.getPassword()));

	       
	        BusOpLogin savedLogin = repo.save(busOp);

	      
	        BusOpData busOpData = new BusOpData();
	        busOpData.setBusOpLogin(savedLogin);
	       

	       
	        busOpDataRepo.save(busOpData);

	      
	        savedLogin.setBusopdata(busOpData);
	        repo.save(savedLogin);

	        return "Bus Operator Registered Successfully";
	    }


	    @Override
	    public String loginBusOp(String username, String password) throws BusOperatorNotFoundException {
	        BusOpLogin busOp = repo.findByUsername(username)
	                .orElseThrow(() -> new BusOperatorNotFoundException("Operator not found with username: " + username));

	        if (!passwordEncoder.matches(password, busOp.getPassword())) {
	            throw new BusOperatorNotFoundException("Invalid password");
	        }

	        UserDetails userDetails = User.withUsername(busOp.getUsername())
	                                      .password(busOp.getPassword())
	                                      .roles("BUSOPERATOR")
	                                      .build();

	        return jwtService.generateToken(userDetails);
	    }

	    @Override
	    public boolean existsByUsername(String username) {
	        return repo.existsByUsername(username);
	    }

	    @Override
	    public BusOpLogin getByUsername(String username) {
	        return repo.findByUsername(username).orElse(null);
	    }
	}


	


