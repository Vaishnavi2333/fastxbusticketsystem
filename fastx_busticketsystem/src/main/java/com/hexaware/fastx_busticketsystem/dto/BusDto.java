package com.hexaware.fastx_busticketsystem.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.NoArgsConstructor;



/*Autor:Vaishnavi Suresh Vaidyanath
Modified Date:08-Aug-2025
Description:Dto Class for Bus
*/
@NoArgsConstructor
@Data
public class BusDto {
	
	@Positive(message="ID should be positive value")
	 private int busId;

	@Pattern(regexp="[1-9][0-9]{2}")
	 private String busNumber;
	
	@NotNull(message = "Bus name cannot be null")
	 private String busName;
	
	@NotNull(message = "Bus type cannot be null")
	 private String busType;
	
	@Positive(message = "Capacity must be a positive number")
     private int capacity;
	 
     @Pattern(regexp = "Available|Unavailable",message="Status should be either available or unavailable")
     private String status;

}
