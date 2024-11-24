package org.NAK.Citronix.Service.Contract;

import org.NAK.Citronix.DTO.HarvestTree.CreateHarvestTreeDTO;
import org.NAK.Citronix.DTO.HarvestTree.ResponseHarvestTreeDTO;
import org.NAK.Citronix.DTO.HarvestTree.ResponseHarvestTreeSharedDTO;
import org.NAK.Citronix.DTO.HarvestTree.UpdateHarvestTreeDTO;
import org.NAK.Citronix.Entity.Embedded.EmbeddedIds;

import java.util.List;

public interface HarvestTreeService {

    ResponseHarvestTreeSharedDTO createHarvestTree(CreateHarvestTreeDTO createHarvestTreeDTO);
    ResponseHarvestTreeDTO updateHarvestTree(UpdateHarvestTreeDTO updateHarvestTreeDTO);
    ResponseHarvestTreeDTO getHarvestTree(EmbeddedIds embeddedIds);
    void deleteHarvestTree(EmbeddedIds embeddedIds);
    List<ResponseHarvestTreeDTO> getHarvestTrees(EmbeddedIds embeddedIds);

}
