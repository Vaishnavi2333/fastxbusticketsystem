package com.hexaware.fastx_busticketsystem.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hexaware.fastx_busticketsystem.config.CustomUserDetails;
import com.hexaware.fastx_busticketsystem.entities.AdminLogin;
import com.hexaware.fastx_busticketsystem.entities.BusOpLogin;
import com.hexaware.fastx_busticketsystem.entities.UserLogin;
import com.hexaware.fastx_busticketsystem.repository.AdminLoginRepo;
import com.hexaware.fastx_busticketsystem.repository.BusOpLoginRepo;
import com.hexaware.fastx_busticketsystem.repository.UserLoginRepo;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserLoginRepo userLoginRepo;

    @Autowired
    private AdminLoginRepo adminLoginRepo;

    @Autowired
    private BusOpLoginRepo busOpLoginRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       
        Optional<UserLogin> userOpt = userLoginRepo.findByUsername(username);
        if (userOpt.isPresent()) {
            return new CustomUserDetails(userOpt.get(), "ROLE_USER");
        }

       
        Optional<AdminLogin> adminOpt = adminLoginRepo.findByUsername(username);
        if (adminOpt.isPresent()) {
            return new CustomUserDetails(adminOpt.get(), "ROLE_ADMIN");
        }

       
        Optional<BusOpLogin> busOpOpt = busOpLoginRepo.findByUsername(username);
        if (busOpOpt.isPresent()) {
            return new CustomUserDetails(busOpOpt.get(), "ROLE_BUS_OPERATOR");
        }

        throw new UsernameNotFoundException("User not found with username: " + username);
    }
}
