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
public class FlightDTO implements Serializable {
    @NotNull(message = "id must be not null")
    @Positive(message = "id must be positive")
    Long id;
    @NotNull(message = "arrivalAirportId must be not null.")
    @Positive(message = "arrivalAirportId must be positive")
    Long arrivalAirportId;
    @NotNull(message = "departureAirportId must be not null.")
    @Positive(message = "departureAirportId must be positive")
    Long departureAirportId;
    @NotNull(message = "arrivalDate must be not null")
    @FutureOrPresent(message = "arrivalDate must be in future or present.")
    Date arrivalDate;
    @NotNull(message = "departureDate must be not null.")
    @FutureOrPresent(message = "departureDate must be in future or present.")
    Date departureDate;
    @NotNull(message = "price must be not null.")
    @Positive(message = "price must be positive.")
    Double price;
}