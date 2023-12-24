package com.amadeus.amadeuscasestudy.Controller;

import com.amadeus.amadeuscasestudy.Core.Result.DataResult;
import com.amadeus.amadeuscasestudy.Core.Result.Result;
import com.amadeus.amadeuscasestudy.DTO.Airport.AirportDTO;
import com.amadeus.amadeuscasestudy.DTO.Airport.AirportSaveRequestDTO;
import com.amadeus.amadeuscasestudy.Service.Contract.AirportService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airport")
@Api(value = "airportAPI", tags = "Airport CRUD API.")
@RequiredArgsConstructor
public class AirportController implements CRUDController<AirportDTO, AirportSaveRequestDTO> {
    @Autowired
    private AirportService airportService;

    @Override
    @ApiOperation(value = "Create a new Airport", response = ResponseEntity.class,
            notes = "This can only be done by an admin user.")
    @PostMapping("/add")
    public ResponseEntity<Result> add(
            @ApiParam( value= "Airport Data Transfer Object to be added as Airport", required = true)
            @RequestBody AirportSaveRequestDTO airportSaveRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(airportService.add(airportSaveRequestDTO));
    }

    @ApiOperation(value = "Get all AirportList", response = ResponseEntity.class)
    @GetMapping("/getAll")
    @Override

    public ResponseEntity<DataResult<List<AirportDTO>>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(airportService.getAll());
    }

    @ApiOperation(value = "Get a Airport by id.", response = ResponseEntity.class)
    @GetMapping("/getById")
    @Override
    public ResponseEntity<DataResult<AirportDTO>> getById(
            @ApiParam( value= "Id of Airport to be called.", required = true,example = "15") @RequestParam Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(airportService.getById(id));

    }

    @ApiOperation(value = "Update a Airport by id.", response = ResponseEntity.class,
            notes = "This can only be done by an admin user.")
    @PostMapping("/updateById")
    @Override
    public ResponseEntity<Result> updateById(
            @ApiParam( value= "Airport Data Transfer Object with id of Airport to be updated.", required = true) @RequestBody AirportDTO entityResponseDto) {
        return ResponseEntity.status(HttpStatus.OK).body(airportService.updateById(entityResponseDto));
    }

    @ApiOperation(value = "Delete a Airport by id.", response = ResponseEntity.class,
            notes = "This can only be done by an admin user."
    )
    @DeleteMapping("/deleteById")
    @Override
    public ResponseEntity<DataResult<AirportDTO>> deleteById(
            @ApiParam( value= "Id of Airport to be deleted.", required = true,example = "15")  @RequestParam Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(airportService.deleteById(id));
    }

}
