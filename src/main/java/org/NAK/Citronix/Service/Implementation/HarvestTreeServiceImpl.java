package org.NAK.Citronix.Service.Implementation;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.NAK.Citronix.DTO.HarvestTree.CreateHarvestTreeDTO;
import org.NAK.Citronix.DTO.HarvestTree.ResponseHarvestTreeDTO;
import org.NAK.Citronix.DTO.HarvestTree.ResponseHarvestTreeSharedDTO;
import org.NAK.Citronix.DTO.HarvestTree.UpdateHarvestTreeDTO;
import org.NAK.Citronix.Entity.Embedded.EmbeddedIds;
import org.NAK.Citronix.Entity.Harvest;
import org.NAK.Citronix.Entity.HarvestTree;
import org.NAK.Citronix.Entity.Tree;
import org.NAK.Citronix.Mapper.HarvestTreeMapper;
import org.NAK.Citronix.Repository.HarvestRepository;
import org.NAK.Citronix.Repository.HarvestTreeRepository;
import org.NAK.Citronix.Repository.TreeRepository;
import org.NAK.Citronix.Service.Contract.HarvestTreeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class HarvestTreeServiceImpl implements HarvestTreeService {

    private final HarvestRepository harvestRepository;
    private final HarvestTreeMapper harvestTreeMapper;
    private final HarvestTreeRepository harvestTreeRepository;
    private final TreeRepository treeRepository;

    @Override
    public ResponseHarvestTreeSharedDTO createHarvestTree(CreateHarvestTreeDTO createHarvestTreeDTO) {

        Harvest harvest = harvestRepository.findById(createHarvestTreeDTO.getHarvestId()).orElseThrow(()-> new EntityNotFoundException("Harvest with Id: "+createHarvestTreeDTO.getHarvestId() +"not found"));

        Tree tree = treeRepository.findById(createHarvestTreeDTO.getTreeId()).orElseThrow(() -> new EntityNotFoundException("Tree with Id: "+createHarvestTreeDTO.getTreeId() +"not found"));

        System.out.println(createHarvestTreeDTO);
        HarvestTree harvestTree = harvestTreeMapper.toHarvestTree(createHarvestTreeDTO);

        System.out.println(harvestTree);
        harvestTree.setTree(tree);
        harvestTree.setHarvest(harvest);
        harvestTreeRepository.save(harvestTree);


        return harvestTreeMapper.toResponseHarvestTreeSharedDTO(harvestTree);

    }

    @Override
    public ResponseHarvestTreeDTO updateHarvestTree(UpdateHarvestTreeDTO updateHarvestTreeDTO) {

        EmbeddedIds embeddedIds = new EmbeddedIds(
                updateHarvestTreeDTO.getTreeId(),
                updateHarvestTreeDTO.getHarvestId()
        );

        HarvestTree harvestTree = harvestTreeRepository.findByHarvestIdAndTreeId(embeddedIds.getHarvestId(),embeddedIds.getTreeId())
                .orElseThrow(()-> new EntityNotFoundException("HarvestTree with HarvestId: "+embeddedIds.getHarvestId() +"and TreeId: "+embeddedIds.getTreeId() +"not found"));

        HarvestTree savedHarvestTree = harvestTreeMapper.toHarvestTree(updateHarvestTreeDTO);

        harvestTreeRepository.save(savedHarvestTree);

        return harvestTreeMapper.toResponseHarvestTreeDTO(savedHarvestTree);

    }

    @Override
    public ResponseHarvestTreeDTO getHarvestTree(EmbeddedIds embeddedIds) {

        return harvestTreeRepository.findByHarvestIdAndTreeId(embeddedIds.getHarvestId(),embeddedIds.getTreeId())
                .map(harvestTreeMapper::toResponseHarvestTreeDTO)
                .orElseThrow(() -> new EntityNotFoundException("HarvestTree with HarvestId: "+embeddedIds.getHarvestId() +"and TreeId: "+embeddedIds.getTreeId() +"not found"));
    }

    @Override
    public void deleteHarvestTree(EmbeddedIds embeddedIds) {

        HarvestTree harvestTree = harvestTreeRepository.findByHarvestIdAndTreeId(embeddedIds.getHarvestId(),embeddedIds.getTreeId())
            .orElseThrow(()-> new EntityNotFoundException("HarvestTree with HarvestId: "+embeddedIds.getHarvestId() +"and TreeId: "+embeddedIds.getTreeId() +"not found"));

        harvestTreeRepository.delete(harvestTree);
    }

    @Override
    public List<ResponseHarvestTreeDTO> getHarvestTrees() {
        return harvestTreeRepository.findAll()
                .stream()
                .map(harvestTreeMapper::toResponseHarvestTreeDTO)
                .collect(Collectors.toList());
    }
}
