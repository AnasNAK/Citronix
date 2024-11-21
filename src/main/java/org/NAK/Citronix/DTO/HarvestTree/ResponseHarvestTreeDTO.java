package org.NAK.Citronix.DTO.HarvestTree;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.NAK.Citronix.DTO.Harvest.ResponseHarvestSharedDTO;
import org.NAK.Citronix.DTO.Tree.ResponseTreeSharedDTO;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseHarvestTreeDTO {

    private ResponseTreeSharedDTO Tree;

    private ResponseHarvestSharedDTO Harvest;

    private Double quantity;
}
