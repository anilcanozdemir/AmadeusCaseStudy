package com.amadeus.amadeuscasestudy.Service.Implementation;

import com.amadeus.amadeuscasestudy.Core.Result.DataResult;
import com.amadeus.amadeuscasestudy.Core.Result.Result;
import com.amadeus.amadeuscasestudy.DTO.Airport.AirportDTO;
import com.amadeus.amadeuscasestudy.DTO.Airport.AirportSaveRequestDTO;
import com.amadeus.amadeuscasestudy.Service.Contract.AirportService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirportManager implements AirportService {
    @Override
    public Result add(AirportSaveRequestDTO airportSaveRequestDTO) {
        return null;
    }

    @Override
    public DataResult<AirportDTO> deleteById(Long id) {
        return null;
    }

    @Override
    public DataResult<List<AirportDTO>> getAll() {
        return null;
    }

    @Override
    public DataResult<AirportDTO> getById(Long id) {
        return null;
    }

    @Override
    public Result updateById(AirportDTO entityUpdateRequestDto) {
        return null;
    }
}
