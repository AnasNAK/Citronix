package org.NAK.Citronix.DTO.Tree;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.NAK.Citronix.DTO.Field.ResponseFieldSharedDTO;
import org.NAK.Citronix.DTO.HarvestTree.ResponseHarvestTreeSharedDTO;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTreeDTO {

    private Long id;

    private LocalDate planingDate;

    private List<ResponseHarvestTreeSharedDTO> harvestTrees;

    private ResponseFieldSharedDTO field;
}
