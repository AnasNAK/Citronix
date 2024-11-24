package org.NAK.Citronix.Controller;

import jakarta.validation.Valid;
import org.NAK.Citronix.DTO.HarvestTree.CreateHarvestTreeDTO;
import org.NAK.Citronix.DTO.HarvestTree.ResponseHarvestTreeDTO;
import org.NAK.Citronix.DTO.HarvestTree.ResponseHarvestTreeSharedDTO;
import org.NAK.Citronix.DTO.HarvestTree.UpdateHarvestTreeDTO;
import org.NAK.Citronix.Entity.Embedded.EmbeddedIds;

import org.NAK.Citronix.Service.Contract.HarvestTreeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/harvestTrees")
public class HarvestTreeController {

    private final HarvestTreeService harvestTreeService;
    public HarvestTreeController(HarvestTreeService harvestTreeService) {
        this.harvestTreeService = harvestTreeService;
    }

    @GetMapping("/{harvestId}/{treeId}")
    public ResponseEntity<ResponseHarvestTreeDTO> getHarvestTree(@PathVariable Long harvestId ,@PathVariable Long treeId) {

        EmbeddedIds embeddedIds = new EmbeddedIds(harvestId, treeId);
        ResponseHarvestTreeDTO responseHarvestTreeDTO = harvestTreeService.getHarvestTree(embeddedIds);
        if (responseHarvestTreeDTO != null) {
            return new ResponseEntity<>(responseHarvestTreeDTO, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<ResponseHarvestTreeDTO>> getHarvestTrees() {

        List<ResponseHarvestTreeDTO> harvestTrees = harvestTreeService.getHarvestTrees();
        return new ResponseEntity<>(harvestTrees, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ResponseHarvestTreeSharedDTO> createHarvestTree(@Valid @RequestBody CreateHarvestTreeDTO createHarvestTreeDTO) {

        ResponseHarvestTreeSharedDTO harvestTree = harvestTreeService.createHarvestTree(createHarvestTreeDTO);
        return new ResponseEntity<>(harvestTree, HttpStatus.CREATED);
    }

    @PatchMapping("/{harvestId}/{treeId}")
    public ResponseEntity<ResponseHarvestTreeDTO> updateHarvestTree(@PathVariable Long harvestId ,
                                                                    @PathVariable Long treeId,
                                                                    @Valid @RequestBody UpdateHarvestTreeDTO updateHarvestTreeDTO) {


        updateHarvestTreeDTO.setHarvestId(harvestId);
        updateHarvestTreeDTO.setTreeId(treeId);

        ResponseHarvestTreeDTO HarvestTree = harvestTreeService.updateHarvestTree(updateHarvestTreeDTO);
        return new ResponseEntity<>(HarvestTree, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{harvestId}/{treeId}")
    public ResponseEntity<Void> deleteHarvestTree(@PathVariable Long harvestId ,@PathVariable Long treeId) {

        EmbeddedIds embeddedIds = new EmbeddedIds(harvestId, treeId);
        harvestTreeService.deleteHarvestTree(embeddedIds);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
