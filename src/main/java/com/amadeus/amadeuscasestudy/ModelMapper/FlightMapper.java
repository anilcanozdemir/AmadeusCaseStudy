package com.amadeus.amadeuscasestudy.ModelMapper;


import com.amadeus.amadeuscasestudy.Core.Exception.AirportNotFoundException;
import com.amadeus.amadeuscasestudy.DTO.Flight.FlightDTO;
import com.amadeus.amadeuscasestudy.DTO.Flight.FlightSaveRequestDTO;
import com.amadeus.amadeuscasestudy.Entity.Flight;
import com.amadeus.amadeuscasestudy.Repository.AirportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class FlightMapper implements MapperProfile<FlightDTO, FlightSaveRequestDTO, Flight> {
    @Autowired
    private AirportRepository airportRepository;

    @Override
    public FlightDTO entityToDTO(Flight flight) {

        return new FlightDTO(flight.getId(), flight.getArrivalAirport().getId(),
                flight.getDepartureAirport().getId(),
                flight.getArrivalDate(), flight.getDepartureDate(), flight.getPrice());
    }


    @Override
    public Flight saveRequestDtoToEntity(FlightSaveRequestDTO flightSaveRequestDTO) {
        Flight flight = new Flight();
        return getFlight(flight, flightSaveRequestDTO.getPrice(), flightSaveRequestDTO.getArrivalDate(),
                flightSaveRequestDTO.getDepartureDate(), flightSaveRequestDTO.getArrivalAirportId(),
                flightSaveRequestDTO.getDepartureAirportId());
    }

    private Flight getFlight(Flight flight, Double price, Date arrivalDate, Date departureDate, Long arrivalAirportId, Long departureAirportId) {
        flight.setPrice(price);
        flight.setArrivalDate(arrivalDate);
        flight.setDepartureDate(departureDate);
        flight.setArrivalAirport(airportRepository.findById(arrivalAirportId).
                orElseThrow(() -> new AirportNotFoundException(arrivalAirportId)));
        flight.setDepartureAirport(airportRepository.findById(departureAirportId).
                orElseThrow(() -> new AirportNotFoundException(departureAirportId)));

        return flight;
    }

    @Override
    public Flight DTOtoEntity(FlightDTO updateRequestDto) {
        Flight flight = new Flight();
        flight.setId(updateRequestDto.getId());
        return getFlight(flight, updateRequestDto.getPrice(), updateRequestDto.getArrivalDate(),
                updateRequestDto.getDepartureDate(),
                updateRequestDto.getArrivalAirportId(), updateRequestDto.getDepartureAirportId());
    }
}
