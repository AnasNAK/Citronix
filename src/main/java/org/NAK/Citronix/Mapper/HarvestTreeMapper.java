package org.NAK.Citronix.Mapper;

import org.NAK.Citronix.DTO.HarvestTree.CreateHarvestTreeDTO;
import org.NAK.Citronix.DTO.HarvestTree.ResponseHarvestTreeDTO;
import org.NAK.Citronix.DTO.HarvestTree.ResponseHarvestTreeSharedDTO;
import org.NAK.Citronix.DTO.HarvestTree.UpdateHarvestTreeDTO;
import org.NAK.Citronix.Entity.HarvestTree;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring" , uses = {TreeMapper.class, HarvestMapper.class})
public interface HarvestTreeMapper {

    @Mapping(target = "tree" ,source = "tree")
    @Mapping(target = "embeddedIds.harvestId" ,source = "harvestId")
    ResponseHarvestTreeDTO toResponseHarvestTreeDTO(HarvestTree harvestTree);

    @Mapping(target = "tree" ,source = "tree")
    @Mapping(target = "embeddedIds.harvestId" ,source = "harvestId")
    ResponseHarvestTreeSharedDTO toResponseHarvestTreeSharedDTO(HarvestTree harvestTree);

    @Mapping(target = "embeddedIds.treeId" ,source = "TreeId")
    @Mapping(target = "embeddedIds.harvestId" ,source = "harvestId")
    HarvestTree toHarvestTree(CreateHarvestTreeDTO createHarvestTreeDTO);

    @Mapping(target = "embeddedIds.treeId" ,source = "TreeId")
    @Mapping(target = "embeddedIds.harvestId" ,source = "harvestId")
    HarvestTree toHarvestTree(UpdateHarvestTreeDTO updateHarvestTreeDTO);


}
