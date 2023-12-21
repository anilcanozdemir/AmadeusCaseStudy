package com.amadeus.amadeuscasestudy.ModelMapper;


import com.amadeus.amadeuscasestudy.Core.Exception.AirportNotFoundException;
import com.amadeus.amadeuscasestudy.DTO.Flight.FlightDTO;
import com.amadeus.amadeuscasestudy.DTO.Flight.FlightSaveRequestDTO;
import com.amadeus.amadeuscasestudy.Entity.Flight;
import com.amadeus.amadeuscasestudy.Repository.AirportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FlightMapper implements MapperProfile<FlightDTO, FlightSaveRequestDTO, Flight> {
    private AirportMapper airportMapper;
    private AirportRepository airportRepository;

    @Override
    public FlightDTO EntityToDTO(Flight flight) {

        return new FlightDTO(flight.getId(),
                airportMapper.EntityToDTO(flight.getArrivalAirport()),
                airportMapper.EntityToDTO(flight.getDepartureAirport()),
                flight.getArrivalDate(),flight.getDepartureDate(),flight.getPrice());
    }

    @Override
    public Flight saveRequestDtoToEntity(FlightSaveRequestDTO flightSaveRequestDTO) {
        Flight flight = new Flight();
        flight.setPrice(flightSaveRequestDTO.getPrice());
        flight.setArrivalDate(flightSaveRequestDTO.getArrivalDate());
        flight.setDepartureDate(flightSaveRequestDTO.getDepartureDate());
        flight.setArrivalAirport(airportRepository.findById(flightSaveRequestDTO.getArrivalAirport().getId()).
                orElseThrow(() -> new AirportNotFoundException(flightSaveRequestDTO.getArrivalAirport().getId())));
        flight.setDepartureAirport(airportRepository.findById(flightSaveRequestDTO.getDepartureAirport().getId()).
                orElseThrow(() -> new AirportNotFoundException(flightSaveRequestDTO.getDepartureAirport().getId())));

        return flight;
    }

    @Override
    public Flight DTOtoEntity(FlightDTO updateRequestDto) {
        Flight flight = new Flight();
        flight.setId(updateRequestDto.getId());
        flight.setPrice(updateRequestDto.getPrice());
        flight.setArrivalDate(updateRequestDto.getArrivalDate());
        flight.setDepartureDate(updateRequestDto.getDepartureDate());
        flight.setArrivalAirport(airportRepository.findById(updateRequestDto.getArrivalAirport().getId()).
                orElseThrow(() -> new AirportNotFoundException(updateRequestDto.getArrivalAirport().getId())));
        flight.setDepartureAirport(airportRepository.findById(updateRequestDto.getDepartureAirport().getId()).
                orElseThrow(() -> new AirportNotFoundException(updateRequestDto.getDepartureAirport().getId())));


        return flight;
    }
}
