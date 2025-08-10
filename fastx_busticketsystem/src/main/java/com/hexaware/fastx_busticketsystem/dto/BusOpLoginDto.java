package com.hexaware.fastx_busticketsystem.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class BusOpLoginDto {

   // @Positive(message = "ID should be a positive value")
	/* private int busOpId; */

   @NotNull(message = "Username cannot be null")
   @Size(min = 5, max = 14, message = "Username must be between 5 and 14 characters")
    private String username;

    @NotNull(message = "Password cannot be null")
    @Size(min = 8, max = 14, message = "Password should be between 8 and 14 characters")
    private String password;
}
