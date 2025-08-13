package com.hexaware.fastx_busticketsystem.dto;

import java.time.LocalDate;
import java.util.List;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.NoArgsConstructor;


/*Autor:Vaishnavi Suresh Vaidyanath
Modified Date:08-Aug-2025
Description:Dto Class for Booking*/

@NoArgsConstructor
@Data
public class BookingDto {
	private int bookingId;

    @NotNull(message = "Booking date cannot be null")
    private LocalDate bookingDate;

    @NotNull(message = "Booking status cannot be null")
    private String status;

    @NotNull(message = "User ID cannot be null")
    private int userId;

    @NotNull(message = "Trip ID cannot be null")
    private int tripId;

    @Positive(message = "Total price must be positive")
    private double totalPrice;

    private List<String> selectedSeats;

    private int paymentId;

}
