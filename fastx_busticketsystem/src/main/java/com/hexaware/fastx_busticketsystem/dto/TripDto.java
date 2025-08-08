package com.hexaware.fastx_busticketsystem.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
public class TripDto {
	@Positive(message="ID should be positive value")
	private int tripId;
	
	@Positive(message="ID should be positive value")
    private int busId;
	
	@Positive(message="ID should be positive value")
    private int routeId;
	
	@Future
    private LocalDate date;
	
	@NotNull(message = "Departure time is required")
	private LocalTime departureTime;

	@NotNull(message = "Arrival time is required")
	private LocalTime arrivalTime;
	
	@NotNull
	@Positive
	@DecimalMin(value = "0.01", message = "Fare must be greater than 0")
    private double fare;
    
    @Pattern(regexp = "Confirmed|Unconfirmed")
    private String status;

}
