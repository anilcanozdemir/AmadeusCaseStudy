package com.amadeus.amadeuscasestudy.Service.Contract;

import com.amadeus.amadeuscasestudy.Core.Result.DataResult;
import com.amadeus.amadeuscasestudy.DTO.Flight.FlightDTO;
import com.amadeus.amadeuscasestudy.DTO.Flight.FlightSaveRequestDTO;
import com.amadeus.amadeuscasestudy.DTO.Flight.FlightSearchResponseListDto;

import java.util.Date;
import java.util.List;


public interface FlightService extends CRUDService<FlightDTO, FlightSaveRequestDTO> {
    void getFlightListFromExternalServiceByDaily() throws Exception;

    DataResult<FlightSearchResponseListDto> search(Long departureAirportId, Long arrivalAirportId, Date departureDate, Date returnDate);

    DataResult<List<FlightDTO>> search(Long departureAirportId, Long arrivalAirportId, Date departureDate);

}
