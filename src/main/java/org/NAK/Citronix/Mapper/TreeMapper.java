package org.NAK.Citronix.Mapper;

import org.NAK.Citronix.DTO.Tree.CreateTreeDTO;
import org.NAK.Citronix.DTO.Tree.ResponseTreeDTO;
import org.NAK.Citronix.DTO.Tree.ResponseTreeSharedDTO;
import org.NAK.Citronix.DTO.Tree.UpdateTreeDTO;
import org.NAK.Citronix.Entity.Tree;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TreeMapper {

    ResponseTreeSharedDTO toResponseTreeSharedDTO(Tree tree);

    ResponseTreeDTO toResponseTreeDTO(Tree tree);

    Tree toTree(CreateTreeDTO createTreeDTO);

    Tree toTree(UpdateTreeDTO updateTreeDTO);
}
