package com.hexaware.fastx_busticketsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.fastx_busticketsystem.entities.Bus;

public interface BusRepo extends JpaRepository<Bus,Integer>{
	
	List<Bus> findByBusOpData_BusOpdataId(int busOpdataId);


}
