package com.amadeus.amadeuscasestudy.Controller;

import com.amadeus.amadeuscasestudy.Core.Result.DataResult;
import com.amadeus.amadeuscasestudy.Core.Result.Result;
import com.amadeus.amadeuscasestudy.DTO.Flight.FlightDTO;
import com.amadeus.amadeuscasestudy.DTO.Flight.FlightSaveRequestDTO;
import com.amadeus.amadeuscasestudy.Service.Contract.FlightService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
@Api(value = "flightAPI", tags = "Flight CRUD and Search API.")
@RequiredArgsConstructor
public class FlightController implements CRUDController<FlightDTO, FlightSaveRequestDTO> {
    @Autowired
    private FlightService flightService;

    @PostMapping("/add")
    @ApiOperation(value = "Create a new Flight", response = ResponseEntity.class,
            notes = "This can only be done by an admin user.")
    @Override
    public ResponseEntity<Result> add(
            @ApiParam( value= "Flight Data Transfer Object to be added as Flight", required = true)
            @RequestBody FlightSaveRequestDTO flightSaveRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(flightService.add(flightSaveRequestDTO));
    }

    @GetMapping("/getAll")
    @ApiOperation(value = "Get all FlightList", response = ResponseEntity.class)
    @Override
    public ResponseEntity<DataResult<List<FlightDTO>>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(flightService.getAll());
    }

    @GetMapping("/getById")
    @ApiOperation(value = "Get a Flight by id.", response = ResponseEntity.class)
    @Override
    public ResponseEntity<DataResult<FlightDTO>> getById(
            @ApiParam( value= "Id of Flight to be called.", required = true,example = "15") @RequestParam Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(flightService.getById(id));
    }

    @PostMapping("/updateById")
    @ApiOperation(value = "Update a Flight by id.", response = ResponseEntity.class)
    @Override
    public ResponseEntity<Result> updateById(
            @ApiParam( value= "Flight Data Transfer Object with id of Flight to be updated.", required = true) @RequestBody FlightDTO entityResponseDto) {
        return ResponseEntity.status(HttpStatus.OK).body(flightService.updateById(entityResponseDto));
    }

    @DeleteMapping("/deleteById")
    @ApiOperation(value = "Delete a Flight by id.", response = ResponseEntity.class)
    @Override
    public ResponseEntity<DataResult<FlightDTO>> deleteById(
            @ApiParam( value= "Id of Flight to be deleted.", required = true,example = "15") @RequestParam Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(flightService.deleteById(id));
    }

    @GetMapping("/search")
    @ApiOperation(value = "Search for flights for spesific departure and arrival dates.(arrivalDate isn't required.)", response = ResponseEntity.class)
    public ResponseEntity<DataResult> search(
            @ApiParam( value= "Id of departure Airport  of Flight to be searched.", required = true,example = "15")  Long departureAirportId
            , @ApiParam( value= "Id of arrival Airport  of Flight to be searched.", required = true,example = "15") Long arrivalAirportId
            ,   @ApiParam( value= "departure date  of Flight to be searched.", required = true,example = "2016-08-19T00:00Z") @DateTimeFormat(pattern = "yyyy-MM-dd") Date departureDate
            ,  @ApiParam( value= "return date  of Flight to be searched.", required = false,example = "2016-08-19T00:00Z") @DateTimeFormat(pattern = "yyyy-MM-dd") Date returnDate) {
        if (returnDate == null) {
            return ResponseEntity.status(HttpStatus.OK).body(this.flightService.search(departureAirportId, arrivalAirportId, departureDate));
        }
        return ResponseEntity.status(HttpStatus.OK).body(this.flightService.search(departureAirportId, arrivalAirportId, departureDate, returnDate));
    }


}
