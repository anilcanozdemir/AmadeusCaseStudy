package com.amadeus.amadeuscasestudy.DTO.Flight;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
@ApiModel(description = "Flight Data Transfer Object to be used in various CRUD methods except for saving")
public class FlightDTO implements Serializable {
    @NotNull(message = "id must be not null")
    @Positive(message = "id must be positive")
    @ApiModelProperty(
            value = "id of the Flight",
            name = "id",
            example = "2")
    Long id;
    @NotNull(message = "arrivalAirportId must be not null.")
    @Positive(message = "arrivalAirportId must be positive")
    @ApiModelProperty(
            value = "id of the arrivalAirport",
            name = "arrivalAirportId",
            example = "5")
    Long arrivalAirportId;
    @NotNull(message = "departureAirportId must be not null.")
    @Positive(message = "departureAirportId must be positive")
    @ApiModelProperty(
            value = "id of the departureAirport",
            name = "departureAirportId",
            example = "2")
    Long departureAirportId;
    @NotNull(message = "arrivalDate must be not null")
    @FutureOrPresent(message = "arrivalDate must be in future or present.")
    @ApiModelProperty(
            value = "arrival Date of the Flight",
            name = "arrivalDate",
            example = "2016-08-19T00:00Z")
    Date arrivalDate;
    @NotNull(message = "departureDate must be not null.")
    @FutureOrPresent(message = "departureDate must be in future or present.")
    @ApiModelProperty(
            value = "departure Date of the Flight",
            name = "departureDate",
            example = "2016-08-19T00:00Z")
    Date departureDate;
    @NotNull(message = "price must be not null.")
    @Positive(message = "price must be positive.")
    @ApiModelProperty(
            value = "price of the Flight",
            name = "price",
            example = "3.45")
    Double price;
}