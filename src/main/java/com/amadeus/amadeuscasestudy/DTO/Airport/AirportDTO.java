package com.amadeus.amadeuscasestudy.DTO.Airport;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
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
@AllArgsConstructor
@NoArgsConstructor(force = true)
@ApiModel(description = "Airport Data Transfer Object to be used in various CRUD methods except for saving")
public class AirportDTO implements Serializable {

    @NotNull(message = "id must be not null")
    @Positive(message = "id must be positive")
    @ApiModelProperty(
            value = "id of the Airport",
            name = "id",
            example = "3")
    Long id;
    @NotNull(message = "CityName must be not null")
    @NotEmpty(message = "CityName must be not empty")
    @NotBlank(message = "CityName must be not blank")
    @ApiModelProperty(
            value = "cityName of the Airport",
            name = "cityName",
            example = "ANKARA")
    String cityName;
}