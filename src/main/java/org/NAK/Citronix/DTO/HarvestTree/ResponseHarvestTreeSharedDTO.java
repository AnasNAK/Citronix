package org.NAK.Citronix.DTO.HarvestTree;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.NAK.Citronix.DTO.Harvest.ResponseHarvestSharedDTO;
import org.NAK.Citronix.DTO.Tree.ResponseTreeSharedDTO;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseHarvestTreeSharedDTO {

    private ResponseTreeSharedDTO Tree;

    private ResponseHarvestSharedDTO Harvest;

    private Double quantity;
}
