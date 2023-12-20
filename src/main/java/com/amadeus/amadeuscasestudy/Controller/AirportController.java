package com.amadeus.amadeuscasestudy.Controller;

import com.amadeus.amadeuscasestudy.Core.Result.DataResult;
import com.amadeus.amadeuscasestudy.Core.Result.Result;
import com.amadeus.amadeuscasestudy.DTO.Airport.AirportDTO;
import com.amadeus.amadeuscasestudy.DTO.Airport.AirportSaveRequestDTO;
import com.amadeus.amadeuscasestudy.Service.Contract.AirportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airport")
@RequiredArgsConstructor
public class AirportController implements CRUDController<AirportDTO, AirportSaveRequestDTO> {
    private AirportService airportService;

    @Override
    @PostMapping("/add")
    public ResponseEntity<Result> add(@RequestBody AirportSaveRequestDTO airportSaveRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(airportService.add(airportSaveRequestDTO));
    }

    @GetMapping("/getAll")
    @Override
    public ResponseEntity<DataResult<List<AirportDTO>>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(airportService.getAll());
    }

    @GetMapping("/getById")
    @Override
    public ResponseEntity<DataResult<AirportDTO>> getById(@RequestParam Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(airportService.getById(id));

    }

    @PostMapping("/updateById")
    @Override
    public ResponseEntity<Result> updateById(@RequestBody AirportDTO entityResponseDto) {
        return ResponseEntity.status(HttpStatus.OK).body(airportService.updateById(entityResponseDto));
    }

    @DeleteMapping("/deleteById")
    @Override
    public ResponseEntity<DataResult<AirportDTO>> deleteById(@RequestParam Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(airportService.deleteById(id));
    }
}
