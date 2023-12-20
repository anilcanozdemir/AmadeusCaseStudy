package com.amadeus.amadeuscasestudy.DTO.Flight;

import com.amadeus.amadeuscasestudy.DTO.Airport.AirportDTO;
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
    @NotNull(message = "arrivalAirport must be not null.")
    AirportDTO arrivalAirport;
    @NotNull(message = "departureAirport must be not null.")
    AirportDTO departureAirport;
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