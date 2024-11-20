package org.NAK.Citronix.DTO.Harvest;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.NAK.Citronix.Enum.Season;
import org.NAK.Citronix.Enum.Status;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateHarvestDTO {

    @NotBlank(message = "harvest should have a harvest date")
    private LocalDate harvestDate;

    @NotBlank(message = "harvest should have a season PENDING or INPROGRESS or FINISHED")
    private Status status;

    @NotBlank(message = "harvest should have a season SPRING or SUMMER or AUTUMN or WINTER")
    private Season season;
}
