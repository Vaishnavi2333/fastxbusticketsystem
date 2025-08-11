package com.hexaware.fastx_busticketsystem.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.NoArgsConstructor;


/*Autor:Vaishnavi Suresh Vaidyanath
Modified Date:08-Aug-2025
Description:Dto Class for Booking*/

@NoArgsConstructor
@Data
public class BookingDto {
	
	@Positive(message="ID should be positive value")
	private int bookingId;
	
	/*
	 * @Positive(message="ID should be positive value") private int userId;
	 */
	/*
	 * @Positive(message="ID should be positive value") private int tripId;
	 */
	
	@FutureOrPresent(message="Booking date cannot be past")
    private LocalDate bookingDate;
	
	@Pattern(regexp = "Confirmed|Unconfiremd")
    private String status;
	
	@Positive(message="ID should be positive value")
     private int userId;    
    
	@Positive(message="ID should be positive value") 
	private int tripId;    
    
	@Positive(message="ID should be positive value")
     private int paymentId; 
    
	@Positive(message="ID should be positive value")
      private int adminId;  

}
