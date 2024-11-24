package org.NAK.Citronix.DTO.Harvest;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.NAK.Citronix.Enum.Season;
import org.NAK.Citronix.Enum.Status;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateHarvestDTO {

    @NotNull(message = "harvest should have a harvest date")
    private LocalDate harvestDate;

    @NotNull(message = "you need to add a field Id")
    private Long fieldId;

    @NotNull(message = "harvest should have a season PENDING or INPROGRESS or FINISHED")
    private Status status;

    @NotNull(message = "harvest should have a season SPRING or SUMMER or AUTUMN or WINTER")
    private Season season;

}
