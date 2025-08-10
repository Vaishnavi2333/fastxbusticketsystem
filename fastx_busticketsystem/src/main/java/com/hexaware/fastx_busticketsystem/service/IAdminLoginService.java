package com.hexaware.fastx_busticketsystem.service;

import java.util.List;

import com.hexaware.fastx_busticketsystem.dto.AdminLoginDto;
import com.hexaware.fastx_busticketsystem.dto.BusDto;
import com.hexaware.fastx_busticketsystem.dto.RouteDto;
import com.hexaware.fastx_busticketsystem.entities.Booking;
import com.hexaware.fastx_busticketsystem.entities.Bus;
import com.hexaware.fastx_busticketsystem.entities.BusOpData;
import com.hexaware.fastx_busticketsystem.entities.Route;
import com.hexaware.fastx_busticketsystem.entities.UserData;
import com.hexaware.fastx_busticketsystem.exception.AdminAlreadyExistsException;
import com.hexaware.fastx_busticketsystem.exception.AdminNotFoundException;
import com.hexaware.fastx_busticketsystem.exception.BookingNotFoundException;
import com.hexaware.fastx_busticketsystem.exception.BusOperatorNotFoundException;
import com.hexaware.fastx_busticketsystem.exception.RouteNotFoundException;
import com.hexaware.fastx_busticketsystem.exception.UserNotFoundException;

public interface IAdminLoginService {
	
    public boolean registerAdmin(AdminLoginDto adminDto) throws AdminAlreadyExistsException;
    
    public boolean loginAdmin(String username, String password) throws AdminNotFoundException;
	
	void deleteUser(int userId) throws UserNotFoundException;
	
    List<UserData> getAllUsers();

    
    void deleteBusOperator(int operatorId) throws BusOperatorNotFoundException;
    
    List<BusOpData> getAllBusOperators();

    
    void deleteBooking(int bookingId) throws BookingNotFoundException;
    
    List<Booking> getAllBookings();

   
    Route addRoute(RouteDto routeDto);
    
    void deleteRoute(int routeId) throws RouteNotFoundException;
    
    List<Route> getAllRoutes();
}
