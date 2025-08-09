package com.hexaware.fastx_busticketsystem.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class BusAmenityDto {
 
	 @Positive(message = "Busamenity ID should be positive value")
	private int busamenityId;
	
	
    @Positive(message = "Bus ID should be positive value")
    private int busId;  
    
    
    @NotNull(message = "Amenity name cannot be null")
    private String amenityName;
}

