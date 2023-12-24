package com.amadeus.amadeuscasestudy.ModelMapper;


import com.amadeus.amadeuscasestudy.DTO.Airport.AirportDTO;
import com.amadeus.amadeuscasestudy.DTO.Airport.AirportSaveRequestDTO;
import com.amadeus.amadeuscasestudy.Entity.Airport;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AirportMapper implements MapperProfile<AirportDTO, AirportSaveRequestDTO, Airport> {


    @Override
    public AirportDTO entityToDTO(Airport airport) {
        return new AirportDTO(airport.getId(), airport.getCityName());

    }

    @Override
    public Airport saveRequestDtoToEntity(AirportSaveRequestDTO airportSaveRequestDTO) {
        Airport airport = new Airport();
        airport.setCityName(airportSaveRequestDTO.getCityName());
        return airport;

    }

    @Override
    public Airport DTOtoEntity(AirportDTO updateRequestDto) {
        Airport airport = new Airport();
        airport.setCityName(updateRequestDto.getCityName());
        airport.setId(updateRequestDto.getId());
        return airport;
    }
}
