package com.hexaware.fastx_busticketsystem.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class UserLoginDto {
	
	/*
	 * @Positive(message="Userid should only be positive") private int userId;
	 */

    @NotNull
    private String username;

    @NotNull
	@Size(min = 8 , max = 14,message="Password should not be less than 8 characters ")
    private String password;
  
    
    
}
