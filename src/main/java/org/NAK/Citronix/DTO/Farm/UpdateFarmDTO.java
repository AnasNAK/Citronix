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
public class UpdateFarmDTO {
    @NotBlank(message = "farm should have a name ")
    private String name;

    @NotBlank(message = "farm should have a location ")
    private String location;

    @Min(value = 2000, message = "farm should have over than 2000 m")
    private Double totalArea;


}
