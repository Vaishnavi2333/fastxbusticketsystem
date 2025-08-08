package com.hexaware.fastx_busticketsystem.dto;

import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class BusAmenityDto {
	
	@Positive(message="ID should be positive value")
	 private int id;  

	 
	 private String amenityName;


}
