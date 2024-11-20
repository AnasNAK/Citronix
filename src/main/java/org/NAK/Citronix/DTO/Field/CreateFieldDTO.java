package org.NAK.Citronix.DTO.Field;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.NAK.Citronix.DTO.Farm.ResponseFarmSharedDTO;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateFieldDTO {

    @NotBlank(message = "field should have a name")
    private String name;

    @NotBlank(message = "field should have an area")
    @NotNull(message = "this field should have an area not null")
    @Min(value =1000 ,message ="this field should have over than 1000 m" )
    private Double area;

    @NotBlank(message = "field should have an creationDate")
    private LocalDate createDate;

}
