package com.hexaware.fastx_busticketsystem.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class BusDto {
	
	@Positive(message="ID should be positive value")
	 private int busId;

	@Pattern(regexp="[1-9][0-9]{2}")
	 private String busNumber;
	
	@NotNull
	 private String busName;
	
	@NotNull
	 private String busType;
	
	
     private int capacity;
	 
     @Pattern(regexp = "Available|Unavailable")
     private String status;

}
