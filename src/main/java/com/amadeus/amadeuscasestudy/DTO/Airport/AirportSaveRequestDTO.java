package com.amadeus.amadeuscasestudy.DTO.Airport;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * DTO for {@link com.amadeus.amadeuscasestudy.Entity.Airport}
 */
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true)
@ApiModel(description = "Airport Data Transfer Object to be used in  saving method. ('/airport/add/')")
public class AirportSaveRequestDTO implements Serializable {
    @NotNull(message = "CityName must be not null")
    @NotEmpty(message = "CityName must be not empty")
    @NotBlank(message = "CityName must be not blank")
    @ApiModelProperty(
            value = "cityName of the Airport",
            name = "cityName",
            example = "ANKARA")
    String cityName;
}