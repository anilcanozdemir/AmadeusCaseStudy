package com.amadeus.amadeuscasestudy.DTO.Flight;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.util.List;

@Value
@AllArgsConstructor
@NoArgsConstructor(force = true)
@ApiModel(description = "Flight Data Transfer Object for FlightLists which are the result of search api in method search in Flight Service. ('/flight/search/')")
public class FlightSearchResponseListDto {
    @ApiModelProperty(
            value = "List of the returning Flights",
            name = "returningFlightDtoList")
    List<FlightDTO> returningFlightDtoList;
    @ApiModelProperty(
            value = "List of the departure Flights",
            name = "returningFlightDtoList")
    List<FlightDTO> departureFlightDtoList;
}
