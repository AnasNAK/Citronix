package org.NAK.Citronix.Service.Contract;

import org.NAK.Citronix.DTO.Tree.CreateTreeDTO;
import org.NAK.Citronix.DTO.Tree.ResponseTreeDTO;
import org.NAK.Citronix.DTO.Tree.ResponseTreeSharedDTO;
import org.NAK.Citronix.DTO.Tree.UpdateTreeDTO;

import java.util.List;

public interface TreeService {
    ResponseTreeSharedDTO createTree(CreateTreeDTO createTreeDTO);
    ResponseTreeDTO updateTree(Long id,UpdateTreeDTO updateTreeDTO);
    ResponseTreeDTO getTree(Long id);
    void deleteTree(Long id);
    List<ResponseTreeDTO> getTrees();
}
