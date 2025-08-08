package com.hexaware.fastx_busticketsystem.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
public class BusOpDataDto {
	
	@Positive(message="ID should be positive value")
	private int busOpdataId;
	
	@Positive(message="ID should be positive value")
    private int busOpId;
	
	@NotNull
    private String name;
	
	@NotNull
	@NotEmpty
    private String companyName;
	
	@Pattern(regexp = "[A-Z]{2}[0-9]{2}\s[0-9]{7}")
	@NotNull
	@NotEmpty
    private String licenceNumber;
	
	@Pattern(regexp="Male|Female|Other")
    private String gender;
	
	@Past(message = "Date of birth must be in the past")
    private LocalDate dateOfBirth;
	
	@Email
    private String email;
	
	@Pattern(regexp = "[1-9][0-9]{9}")
    private String contactNumber;
	
	@NotBlank
	@Size(min = 5, max = 255, message = "Address must be between 5 and 255 characters")
    private String address;

}
