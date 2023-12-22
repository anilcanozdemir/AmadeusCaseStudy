package com.amadeus.amadeuscasestudy.DTO.Flight;

import lombok.Value;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.util.Date;

/**
 * DTO for {@link com.amadeus.amadeuscasestudy.Entity.Flight}
 */
@Value
public class FlightSaveRequestDTO implements Serializable {
    @NotNull(message = "arrivalAirport must be not null.")
    Long arrivalAirportId;
    @NotNull(message = "departureAirport must be not null.")
    Long departureAirportId;
    @NotNull(message = "arrivalDate must be not null.")
    @FutureOrPresent(message = "arrivalDate must be in future or present.")
    Date arrivalDate;
    @NotNull(message = "departureDate must be not null.")
    @FutureOrPresent(message = "departureDate must be in future or present.")
    Date departureDate;
    @NotNull(message = "price must be not null.")
    @Positive(message = "price must be positive.")
    Double price;
}