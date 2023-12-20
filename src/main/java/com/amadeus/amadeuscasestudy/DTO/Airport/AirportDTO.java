package com.amadeus.amadeuscasestudy.DTO.Airport;

import lombok.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.io.Serializable;

/**
 * DTO for {@link com.amadeus.amadeuscasestudy.Entity.Airport}
 */
@Value
public class AirportDTO implements Serializable {
    @NotNull(message = "id must be not null")
    @Positive(message = "id must be positive")
    Long id;
    @NotNull(message = "CityName must be not null")
    @NotEmpty(message = "CityName must be not empty")
    @NotBlank(message = "CityName must be not blank")
    String cityName;
}