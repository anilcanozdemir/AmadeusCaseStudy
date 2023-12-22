package com.amadeus.amadeuscasestudy.Service.Implementation;

import com.amadeus.amadeuscasestudy.Core.Exception.FlightListEmptyException;
import com.amadeus.amadeuscasestudy.Core.Exception.FlightNotFoundException;
import com.amadeus.amadeuscasestudy.Core.Result.DataResult;
import com.amadeus.amadeuscasestudy.Core.Result.Result;
import com.amadeus.amadeuscasestudy.Core.Result.SuccessDataResult;
import com.amadeus.amadeuscasestudy.Core.Result.SuccessResult;
import com.amadeus.amadeuscasestudy.DTO.Flight.FlightDTO;
import com.amadeus.amadeuscasestudy.DTO.Flight.FlightSaveRequestDTO;
import com.amadeus.amadeuscasestudy.Entity.Flight;
import com.amadeus.amadeuscasestudy.ModelMapper.FlightMapper;
import com.amadeus.amadeuscasestudy.Repository.FlightRepository;
import com.amadeus.amadeuscasestudy.Service.Contract.FlightService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.WireMockServer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

@Service
@RequiredArgsConstructor
public class FlightManager implements FlightService {
    private FlightMapper flightMapper;
    private FlightRepository flightRepository;
    @Override
    public Result add(FlightSaveRequestDTO flightSaveRequestDTO) {
        Flight savedFlight = this.flightRepository.save(flightMapper.saveRequestDtoToEntity(flightSaveRequestDTO));
        return new SuccessResult("Flight created with the id" + savedFlight.getId());
    }

    @Override
    public DataResult<FlightDTO> deleteById(Long id) {
        Optional<Flight> flight = flightRepository.findById(id);
        flight.ifPresent(flightRepository::delete);
        return new SuccessDataResult<>("Flight with id  " + id + "  deleted successfully.",
                flight.map(flightMapper::entityToDTO)
                        .orElseThrow(() -> new FlightNotFoundException(id)));
    }

    @Override
    public DataResult<List<FlightDTO>> getAll() {
        List<Flight> flightList = this.flightRepository.findAll();
        if (flightList.isEmpty()) {
            throw new FlightListEmptyException();
        }
        return new SuccessDataResult<>("FlightList successfully called.",
                flightList.stream()
                        .map(flightMapper::entityToDTO)
                        .toList());
    }

    @Override
    public DataResult<FlightDTO> getById(Long id) {
        Optional<Flight> flight = this.flightRepository.findById(id);
        return new SuccessDataResult<>("Flight with id " + id + "successfully called.",
                flight.map(flightMapper::entityToDTO)
                        .orElseThrow(() -> new FlightNotFoundException(id)));
    }

    @Override
    public Result updateById(FlightDTO entityUpdateRequestDto) {
        Optional<Flight> flightOld = this.flightRepository.findById(entityUpdateRequestDto.getId());
        if (flightOld.isEmpty()) {
            throw new FlightNotFoundException(entityUpdateRequestDto.getId());
        }
        Flight flight = flightMapper.DTOtoEntity(entityUpdateRequestDto);
        this.flightRepository.save(flight);
        return new SuccessResult("Successfully updated flight by id" + flight.getId());
    }

    @Override
    public void getFlightListFromExternalServiceByDaily() throws Exception {
        System.out.print("called external api call." + new Date());
        WireMockServer wireMockServer = new WireMockServer();
        wireMockServer.start();

        // Mock API endpoint ve cevabını tanımlama
        configureFor("localhost", 8080);
        stubFor(get(urlEqualTo("/api/flight"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"data\" :[\n" +
                                "        {\n" +
                                "            \"arrivalAirportId\": 2,\n" +
                                "            \"departureAirportId\": 1,\n" +
                                "            \"arrivalDate\": \"2016-08-19T00:00:00.000+00:00\",\n" +
                                "            \"departureDate\": \"2016-08-19T00:00:00.000+00:00\",\n" +
                                "            \"price\": 15.0\n" +
                                "        },\n" +
                                "        {\n" +
                                "            \"arrivalAirportId\": 1,\n" +
                                "            \"departureAirportId\": 2,\n" +
                                "            \"arrivalDate\": \"2016-08-19T00:00:00.000+00:00\",\n" +
                                "            \"departureDate\": \"2016-08-19T00:00:00.000+00:00\",\n" +
                                "            \"price\": 15.0\n" +
                                "        },\n" +
                                "        {\n" +
                                "            \"arrivalAirportId\": 1,\n" +
                                "            \"departureAirportId\": 2,\n" +
                                "            \"arrivalDate\": \"2016-08-19T00:00:00.000+00:00\",\n" +
                                "            \"departureDate\": \"2016-08-19T00:00:00.000+00:00\",\n" +
                                "            \"price\": 15.0\n" +
                                "        }\n" +
                                "    ]}")));

        // Mock API isteği yapma
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(new URI("http://localhost:8080/api/flight"))
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode jsonResponse = objectMapper.readTree(response.body());
            JsonNode dataArray = jsonResponse.get("data"); // Dizi olan "data" alanını al

            if (dataArray.isArray()) {
                for (JsonNode element : dataArray) {
                    FlightSaveRequestDTO object = objectMapper.treeToValue(element, FlightSaveRequestDTO.class);
                    this.flightRepository.save(flightMapper.saveRequestDtoToEntity(object));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        System.out.println("Mock API Response:\n" + response.body());

        wireMockServer.stop();
    }
}
