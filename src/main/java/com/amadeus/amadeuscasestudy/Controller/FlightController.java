package com.amadeus.amadeuscasestudy.Controller;

import com.amadeus.amadeuscasestudy.Core.Result.DataResult;
import com.amadeus.amadeuscasestudy.Core.Result.Result;
import com.amadeus.amadeuscasestudy.DTO.Flight.FlightDTO;
import com.amadeus.amadeuscasestudy.DTO.Flight.FlightSaveRequestDTO;
import com.amadeus.amadeuscasestudy.Service.Contract.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/flight")
@RequiredArgsConstructor
public class FlightController implements CRUDController<FlightDTO, FlightSaveRequestDTO> {
    @Autowired
    private FlightService flightService;

    @PostMapping("/add")
    @Override
    public ResponseEntity<Result> add(@RequestBody FlightSaveRequestDTO flightSaveRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(flightService.add(flightSaveRequestDTO));
    }

    @GetMapping("/getAll")
    @Override
    public ResponseEntity<DataResult<List<FlightDTO>>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(flightService.getAll());
    }

    @GetMapping("/getById")
    @Override
    public ResponseEntity<DataResult<FlightDTO>> getById(@RequestParam Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(flightService.getById(id));
    }

    @PostMapping("/updateById")
    @Override
    public ResponseEntity<Result> updateById(@RequestBody FlightDTO entityResponseDto) {
        return ResponseEntity.status(HttpStatus.OK).body(flightService.updateById(entityResponseDto));
    }

    @DeleteMapping("/deleteById")
    @Override
    public ResponseEntity<DataResult<FlightDTO>> deleteById(@RequestParam Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(flightService.deleteById(id));
    }
    public ResponseEntity<DataResult> search(
            Long departureAirportId
            , Long arrivalAirportId
            , Date departureDate
            , Date returnDate) {
        if (returnDate == null) {
            return ResponseEntity.status(HttpStatus.OK).body(this.flightService.search(departureAirportId, arrivalAirportId, departureDate));
        }
        return ResponseEntity.status(HttpStatus.OK).body(this.flightService.search(departureAirportId, arrivalAirportId, departureDate, returnDate));
    }
}
