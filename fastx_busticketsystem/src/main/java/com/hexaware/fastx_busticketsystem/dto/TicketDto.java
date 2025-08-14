package com.hexaware.fastx_busticketsystem.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

/*Author:Vaishnavi Suresh Vaidyanath
Modified Date:08-Aug-2025
Description:Dto Class for Ticket*/
@NoArgsConstructor
@Data
public class TicketDto {
	
	@Positive(message="ID should be positive value")
	private int ticketId;
	
	@Positive(message="ID should be positive value")
    private int bookingId;
	
	@Size(min=1,max=50,message="Mention correct seat number within the range")
    private int seatNumber;
	
	@NotNull
	@Positive
	@DecimalMin(value = "0.01", message = "Fare must be greater than 0")
    private double fare;
    

}