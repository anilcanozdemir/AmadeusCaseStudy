package com.amadeus.amadeuscasestudy.Service.Implementation;

import com.amadeus.amadeuscasestudy.Core.Result.DataResult;
import com.amadeus.amadeuscasestudy.Core.Result.Result;
import com.amadeus.amadeuscasestudy.DTO.Flight.FlightDTO;
import com.amadeus.amadeuscasestudy.DTO.Flight.FlightSaveRequestDTO;
import com.amadeus.amadeuscasestudy.Service.Contract.FlightService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightManager  implements FlightService {
    @Override
    public Result add(FlightSaveRequestDTO flightSaveRequestDTO) {
        return null;
    }

    @Override
    public DataResult<FlightDTO> deleteById(Long id) {
        return null;
    }

    @Override
    public DataResult<List<FlightDTO>> getAll() {
        return null;
    }

    @Override
    public DataResult<FlightDTO> getById(Long id) {
        return null;
    }

    @Override
    public Result updateById(FlightDTO entityUpdateRequestDto) {
        return null;
    }
}
