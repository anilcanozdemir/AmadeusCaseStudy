package com.amadeus.amadeuscasestudy.Service.Implementation;

import com.amadeus.amadeuscasestudy.Core.Exception.AirportListEmptyException;
import com.amadeus.amadeuscasestudy.Core.Exception.AirportNotFoundException;
import com.amadeus.amadeuscasestudy.Core.Result.DataResult;
import com.amadeus.amadeuscasestudy.Core.Result.Result;
import com.amadeus.amadeuscasestudy.Core.Result.SuccessDataResult;
import com.amadeus.amadeuscasestudy.Core.Result.SuccessResult;
import com.amadeus.amadeuscasestudy.DTO.Airport.AirportDTO;
import com.amadeus.amadeuscasestudy.DTO.Airport.AirportSaveRequestDTO;
import com.amadeus.amadeuscasestudy.Entity.Airport;
import com.amadeus.amadeuscasestudy.ModelMapper.AirportMapper;
import com.amadeus.amadeuscasestudy.Repository.AirportRepository;
import com.amadeus.amadeuscasestudy.Service.Contract.AirportService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AirportManager implements AirportService {
    @Autowired
    private AirportMapper airportMapper;
    @Autowired

    private AirportRepository airportRepository;

    @Override
    public Result add(AirportSaveRequestDTO airportSaveRequestDTO) {
        Airport savedAirport = this.airportRepository.save(airportMapper.saveRequestDtoToEntity(airportSaveRequestDTO));
        return new SuccessResult("To city   :" + savedAirport.getCityName() +
                " with id  : " + savedAirport.getId() +
                "  airport added.");
    }

    @Override
    public DataResult<AirportDTO> deleteById(Long id) {
        Optional<Airport> airport = airportRepository.findById(id);
        airport.ifPresent(airportRepository::delete);
        return new SuccessDataResult<>("Company with id  " + id + "  deleted successfully.",
                airport.map(airportMapper::entityToDTO)
                        .orElseThrow(() -> new AirportNotFoundException(id)));

    }

    @Override
    public DataResult<List<AirportDTO>> getAll() {
        List<Airport> airportList = this.airportRepository.findAll();
        if (airportList.isEmpty()) {
            throw new AirportListEmptyException();
        }
        return new SuccessDataResult<>("CompanyList successfully called.",
                airportList.stream()
                        .map(airportMapper::entityToDTO)
                        .toList());
    }

    @Override
    public DataResult<AirportDTO> getById(Long id) {
        Optional<Airport> airport = this.airportRepository.findById(id);
        return new SuccessDataResult<>("Company with id " + id + "successfully called.",
                airport.map(airportMapper::entityToDTO)
                        .orElseThrow(() -> new AirportNotFoundException(id)));

    }

    @Override
    public Result updateById(AirportDTO entityUpdateRequestDto) {
        Optional<Airport> airportOld = this.airportRepository.findById(entityUpdateRequestDto.getId());
        if (airportOld.isPresent()) {
            if (!airportOld.get().getCityName().equals(entityUpdateRequestDto.getCityName())) {
                this.airportRepository.save(airportMapper.DTOtoEntity(entityUpdateRequestDto));
            }
            return new SuccessResult("To city   :" + entityUpdateRequestDto.getCityName() +
                    "with id  :" + entityUpdateRequestDto.getId() +
                    " airport updated.");
        }
        throw new AirportNotFoundException(entityUpdateRequestDto.getId());
    }
}
