package com.hexaware.fastx_busticketsystem.config;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.hexaware.fastx_busticketsystem.entities.AdminLogin;
import com.hexaware.fastx_busticketsystem.entities.BusOpLogin;
import com.hexaware.fastx_busticketsystem.entities.UserLogin;

import java.util.Collection;
import java.util.Collections;


/*Author:Vaishnavi Suresh Vaidyanath
Modified Date:13-Aug-2025
Description:CustomUser details Class*/

public class CustomUserDetails implements UserDetails {

    private String username;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    
    public CustomUserDetails(Object userEntity, String role) {
        if (userEntity instanceof UserLogin) {
            this.username = ((UserLogin) userEntity).getUsername();
            this.password = ((UserLogin) userEntity).getPassword();
        } else if (userEntity instanceof AdminLogin) {
            this.username = ((AdminLogin) userEntity).getUsername();
            this.password = ((AdminLogin) userEntity).getPassword();
        } else if (userEntity instanceof BusOpLogin) {
            this.username = ((BusOpLogin) userEntity).getUsername();
            this.password = ((BusOpLogin) userEntity).getPassword();
        } else {
            throw new IllegalArgumentException("Unsupported user entity");
        }

        
        this.authorities = Collections.singletonList(new SimpleGrantedAuthority(role));
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; 
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; 
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; 
    }

    @Override
    public boolean isEnabled() {
        return true; 
    }
}