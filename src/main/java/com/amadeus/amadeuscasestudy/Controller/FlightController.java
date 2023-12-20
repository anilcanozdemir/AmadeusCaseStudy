package com.amadeus.amadeuscasestudy.Controller;

import com.amadeus.amadeuscasestudy.Core.Result.DataResult;
import com.amadeus.amadeuscasestudy.Core.Result.Result;
import com.amadeus.amadeuscasestudy.DTO.Flight.FlightDTO;
import com.amadeus.amadeuscasestudy.DTO.Flight.FlightSaveRequestDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/flight")
public class FlightController implements CRUDController<FlightDTO, FlightSaveRequestDTO>{
    @Override
    public ResponseEntity<Result> add(FlightSaveRequestDTO flightSaveRequestDTO) {
        return null;
    }

    @Override
    public ResponseEntity<DataResult<List<FlightDTO>>> getAll() {
        return null;
    }

    @Override
    public ResponseEntity<DataResult<FlightDTO>> getById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<Result> updateById(FlightDTO entityResponseDto) {
        return null;
    }

    @Override
    public ResponseEntity<DataResult<FlightDTO>> deleteById(Long id) {
        return null;
    }
}
