package com.amadeus.amadeuscasestudy.DTO.Flight;

import lombok.AllArgsConstructor;
import lombok.Value;

import java.util.List;
@Value
@AllArgsConstructor
public class FlightSearchResponseListDto {

    List<FlightDTO> returningFlightDtoList;
    List<FlightDTO> departureFlightDtoList;
}
