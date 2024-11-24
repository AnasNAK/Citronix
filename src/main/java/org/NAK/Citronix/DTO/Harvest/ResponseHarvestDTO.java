package org.NAK.Citronix.DTO.Harvest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.NAK.Citronix.DTO.HarvestTree.ResponseHarvestTreeSharedDTO;
import org.NAK.Citronix.DTO.Sale.ResponseSaleSharedDTO;
import org.NAK.Citronix.Enum.Season;
import org.NAK.Citronix.Enum.Status;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseHarvestDTO {

    private Long id;

    private LocalDate harvestDate;

    private Double TotalQuantity;

    private Status status;

    private Season season;

    private List<ResponseSaleSharedDTO> sales ;

    private List<ResponseHarvestTreeSharedDTO> harvestTrees;
}
