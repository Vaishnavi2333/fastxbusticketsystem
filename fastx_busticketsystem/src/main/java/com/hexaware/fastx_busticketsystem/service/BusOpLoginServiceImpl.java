package com.hexaware.fastx_busticketsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.fastx_busticketsystem.dto.BusOpLoginDto;
import com.hexaware.fastx_busticketsystem.entities.BusOpLogin;
import com.hexaware.fastx_busticketsystem.exception.BusOperatorAlreadyExistsException;
import com.hexaware.fastx_busticketsystem.exception.BusOperatorNotFoundException;
import com.hexaware.fastx_busticketsystem.repository.BusOpLoginRepo;


@Service
public class BusOpLoginServiceImpl implements IBusOpLoginService {
	
	@Autowired
	BusOpLoginRepo repo;

	@Override
    public boolean registerBusOp(BusOpLoginDto loginDto) throws BusOperatorAlreadyExistsException {
        if (repo.existsByUsername(loginDto.getUsername())) {
            throw new BusOperatorAlreadyExistsException("Username already exists: " + loginDto.getUsername());
        }
        BusOpLogin busop = new BusOpLogin();
       // busop.setBusOpId(loginDto.getBusOpId());
        busop.setUsername(loginDto.getUsername());
        busop.setPassword(loginDto.getPassword());
        repo.save(busop);
        return true;
    }

    @Override
    public boolean loginBusOp(String username, String password) throws BusOperatorNotFoundException {
        BusOpLogin busop = repo.findByUsername(username)
                .orElseThrow(() -> new BusOperatorNotFoundException("Operator not found with username: " + username));
        return busop.getPassword().equals(password);
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
