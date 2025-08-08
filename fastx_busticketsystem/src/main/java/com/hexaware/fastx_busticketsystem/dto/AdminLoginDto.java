package com.hexaware.fastx_busticketsystem.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class AdminLoginDto {
	
	@NotNull
	@NotEmpty
	@Min(value = 1)
	@Max(value = 9)
	private int adminId;
	
	@NotNull
	@NotEmpty(message="Admin name is cannot be empty")
	private String username;
	 
	 @NotEmpty
	 @Size(min = 8 , max = 14,message="Password should not be less than 8 characters ")
	 private String password;

}
