package com.hexaware.fastx_busticketsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.fastx_busticketsystem.entities.UserData;

public interface UserDataRepo extends JpaRepository<UserData,Integer> {

}
