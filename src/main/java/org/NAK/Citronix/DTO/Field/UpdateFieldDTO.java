package org.NAK.Citronix.DTO.Field;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateFieldDTO {
    @NotBlank(message = "field should have a name")
    private String name;

    @NotNull(message = "this field should have an area not null")
    @Min(value =1000 ,message ="this field should have over than 1000 m" )
    private Double area;

}
