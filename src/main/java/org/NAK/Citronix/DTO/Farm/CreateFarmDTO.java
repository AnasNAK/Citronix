package org.NAK.Citronix.DTO.Farm;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateFarmDTO {

    @NotBlank(message = "farm should have a name ")
    private String name;

    @NotBlank(message = "farm should have a location ")
    private String location;

    @NotBlank(message = "farm should have a totalArea ")
    @Min(value = 2000, message = "farm should have over than 2000 m")
    private Double totalArea;

    @NotBlank(message = "farm should have a creationDate")
    private LocalDate creationDate;

}
