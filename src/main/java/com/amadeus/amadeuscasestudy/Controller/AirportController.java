package com.amadeus.amadeuscasestudy.Controller;

import com.amadeus.amadeuscasestudy.Core.Result.DataResult;
import com.amadeus.amadeuscasestudy.Core.Result.Result;
import com.amadeus.amadeuscasestudy.DTO.Airport.AirportDTO;
import com.amadeus.amadeuscasestudy.DTO.Airport.AirportSaveRequestDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airport")
public class AirportController implements CRUDController<AirportDTO, AirportSaveRequestDTO>{
    @Override
    @PostMapping("/add")
    public ResponseEntity<Result> add(@RequestBody AirportSaveRequestDTO airportSaveRequestDTO) {
        return null;
    }
    @GetMapping("/getAll")
    @Override
    public ResponseEntity<DataResult<List<AirportDTO>>> getAll() {
        return null;
    }
    @GetMapping("/getById")
    @Override
    public ResponseEntity<DataResult<AirportDTO>> getById(@RequestParam Long id) {
        return null;
    }
    @PostMapping("/updateById")
    @Override
    public ResponseEntity<Result> updateById(@RequestBody AirportDTO entityResponseDto) {
        return null;
    }
    @DeleteMapping("/deleteById")
    @Override
    public ResponseEntity<DataResult<AirportDTO>> deleteById(@RequestParam Long id) {
        return null;
    }
}
