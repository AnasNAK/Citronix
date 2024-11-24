package org.NAK.Citronix.DTO.Harvest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.NAK.Citronix.Enum.Season;
import org.NAK.Citronix.Enum.Status;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseHarvestSharedDTO {

    private Long id;

    private LocalDate harvestDate;

    private Double TotalQuantity;

    private Status status;

    private Season season;
}
