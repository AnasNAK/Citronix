package org.NAK.Citronix.Service.Implementation;

import lombok.AllArgsConstructor;
import org.NAK.Citronix.DTO.Tree.CreateTreeDTO;
import org.NAK.Citronix.DTO.Tree.ResponseTreeDTO;
import org.NAK.Citronix.DTO.Tree.ResponseTreeSharedDTO;
import org.NAK.Citronix.DTO.Tree.UpdateTreeDTO;
import org.NAK.Citronix.Entity.Field;
import org.NAK.Citronix.Entity.Tree;
import org.NAK.Citronix.Mapper.TreeMapper;
import org.NAK.Citronix.Repository.FieldRepository;
import org.NAK.Citronix.Repository.TreeRepository;
import org.NAK.Citronix.Service.Contract.TreeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class TreeServiceImpl implements TreeService {

    private final TreeRepository treerepository;

    private final FieldRepository fieldrepository;

    private final TreeMapper treemapper;


    @Override
    public ResponseTreeSharedDTO createTree(CreateTreeDTO createTreeDTO) {

        Field field = fieldrepository.findById(createTreeDTO.getFieldId())
                .orElseThrow(() -> new IllegalArgumentException("Field with Id :" + createTreeDTO.getFieldId()+ " not found"));

        Tree tree = treemapper.toTree(createTreeDTO);

        tree.setField(field);
        Tree savedTree =treerepository.save(tree);
        return treemapper.toResponseTreeSharedDTO(savedTree);
    }

    @Override
    public ResponseTreeDTO updateTree(Long id,UpdateTreeDTO updateTreeDTO) {
        Tree existedTree = treerepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Tree with Id :" + id + " not found"));

        Field field = fieldrepository.findById(existedTree.getField().getId()).orElseThrow(()-> new IllegalArgumentException("Field with Id :" + id + " not found"));

        Tree tree = treemapper.toTree(updateTreeDTO);

        tree.setField(field);
        tree.setId(existedTree.getId());

        Tree savedTree =treerepository.save(tree);

        return treemapper.toResponseTreeDTO(savedTree);

    }

    @Override
    public ResponseTreeDTO getTree(Long id) {
        return treerepository.findById(id)
                .map(treemapper::toResponseTreeDTO)
                .orElseThrow(() -> new IllegalArgumentException("Tree with Id :" + id + " not found"));
    }

    @Override
    public void deleteTree(Long id) {
        if (!treerepository.existsById(id)) {
            throw new IllegalArgumentException("Tree with Id :" + id + " not found");
        }
        treerepository.deleteByIdWithQuery(id);

    }

    @Override
    public List<ResponseTreeDTO> getTrees() {
        return treerepository.findAll()
                .stream()
                .map(treemapper::toResponseTreeDTO)
                .collect(Collectors.toList());
    }
}
