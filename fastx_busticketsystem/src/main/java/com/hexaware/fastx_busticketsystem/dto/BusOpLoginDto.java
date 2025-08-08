package com.hexaware.fastx_busticketsystem.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class BusOpLoginDto {
	
	@Positive(message="ID should be positive value")
	private int busOpId;
	
	@NotNull
	@Size(min = 5, max = 14)
	private String username;
	
	@NotNull
	 @Size(min = 8 , max = 14,message="Password should not be less than 8 characters ")
	private String password;

}
