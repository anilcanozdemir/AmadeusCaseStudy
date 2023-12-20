package com.amadeus.amadeuscasestudy.Controller;

import com.amadeus.amadeuscasestudy.Core.Result.DataResult;
import com.amadeus.amadeuscasestudy.Core.Result.Result;
import com.amadeus.amadeuscasestudy.DTO.Flight.FlightDTO;
import com.amadeus.amadeuscasestudy.DTO.Flight.FlightSaveRequestDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flight")
public class FlightController implements CRUDController<FlightDTO, FlightSaveRequestDTO> {
    @PostMapping("/add")
    @Override
    public ResponseEntity<Result> add(@RequestBody FlightSaveRequestDTO flightSaveRequestDTO) {
        return null;
    }
    @GetMapping("/getAll")
    @Override
    public ResponseEntity<DataResult<List<FlightDTO>>> getAll() {
        return null;
    }
    @GetMapping("/getById")
    @Override
    public ResponseEntity<DataResult<FlightDTO>> getById(@RequestParam Long id) {
        return null;
    }

    @PostMapping("/updateById")
    @Override
    public ResponseEntity<Result> updateById(@RequestBody FlightDTO entityResponseDto) {
        return null;
    }
    @DeleteMapping("/deleteById")
    @Override
    public ResponseEntity<DataResult<FlightDTO>> deleteById(@RequestParam Long id) {
        return null;
    }
}
