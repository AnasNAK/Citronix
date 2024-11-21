package org.NAK.Citronix.Mapper;

import org.NAK.Citronix.DTO.HarvestTree.CreateHarvestTreeDTO;
import org.NAK.Citronix.DTO.HarvestTree.ResponseHarvestTreeDTO;
import org.NAK.Citronix.DTO.HarvestTree.ResponseHarvestTreeSharedDTO;
import org.NAK.Citronix.DTO.HarvestTree.UpdateHarvestTreeDTO;
import org.NAK.Citronix.Entity.HarvestTree;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {TreeMapper.class, HarvestMapper.class})
public interface HarvestTreeMapper {


    ResponseHarvestTreeDTO toResponseHarvestTreeDTO(HarvestTree harvestTree);

    ResponseHarvestTreeSharedDTO toResponseHarvestTreeSharedDTO(HarvestTree harvestTree);

    HarvestTree toHarvestTree(CreateHarvestTreeDTO createHarvestTreeDTO);

    HarvestTree toHarvestTree(UpdateHarvestTreeDTO updateHarvestTreeDTO);
}
