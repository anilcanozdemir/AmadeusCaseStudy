package com.amadeus.amadeuscasestudy.DTO.Airport;

import lombok.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * DTO for {@link com.amadeus.amadeuscasestudy.Entity.Airport}
 */
@Value
public class AirportSaveRequestDTO implements Serializable {
    @NotNull(message = "CityName must be not null")
    @NotEmpty(message = "CityName must be not empty")
    @NotBlank(message = "CityName must be not blank")
    String cityName;
}