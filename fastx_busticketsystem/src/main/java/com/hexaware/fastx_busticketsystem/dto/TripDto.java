package com.hexaware.fastx_busticketsystem.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.NoArgsConstructor;

/*Autor:Vaishnavi Suresh Vaidyanath
Modified Date:08-Aug-2025
Description:Dto Class for Trip
*/
@NoArgsConstructor
@Data
public class TripDto {

    @Positive(message = "Trip ID should be positive")
    private int tripId;

    @NotNull(message = "Trip date is required")
    private LocalDate date;

    @NotNull(message = "Departure time is required")
    private LocalTime departureTime;

    @NotNull(message = "Arrival time is required")
    private LocalTime arrivalTime;

    @Positive(message = "Fare must be greater than zero")
    private double fare;

    @NotBlank(message = "Status is required")
    private String status;

    @Positive(message = "Bus ID must be positive")
    private int busId;

    @Positive(message = "Route ID must be positive")
    private int routeId;
}