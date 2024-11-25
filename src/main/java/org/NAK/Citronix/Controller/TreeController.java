package org.NAK.Citronix.Controller;

import jakarta.validation.Valid;
import org.NAK.Citronix.DTO.Tree.CreateTreeDTO;
import org.NAK.Citronix.DTO.Tree.ResponseTreeDTO;
import org.NAK.Citronix.DTO.Tree.ResponseTreeSharedDTO;
import org.NAK.Citronix.DTO.Tree.UpdateTreeDTO;
import org.NAK.Citronix.Service.Contract.TreeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trees")
public class TreeController {

    private final TreeService treeService;

    public TreeController(TreeService treeService) {
        this.treeService = treeService;
    }

    @PostMapping
    public ResponseEntity<ResponseTreeSharedDTO> createTree(@Valid @RequestBody CreateTreeDTO createTreeDTO) {
        ResponseTreeSharedDTO tree = treeService.createTree(createTreeDTO);

        return new ResponseEntity<>(tree , HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ResponseTreeDTO>> getTrees() {
        List<ResponseTreeDTO> trees = treeService.getTrees();

        if(trees.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(trees, HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseTreeDTO> getTree(@PathVariable Long id) {

        ResponseTreeDTO tree = treeService.getTree(id);

        return new ResponseEntity<>(tree, HttpStatus.OK);

    }

    @PatchMapping("/{id}")
    public ResponseEntity<ResponseTreeDTO> updateTree(@PathVariable Long id, @Valid @RequestBody UpdateTreeDTO updateTreeDTO) {
        ResponseTreeDTO tree = treeService.updateTree(id, updateTreeDTO);
        return new ResponseEntity<>(tree, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTree(@PathVariable Long id) {
        treeService.deleteTree(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/productivity/{fieldId}")
    public ResponseEntity<Double> getProductivity(@PathVariable Long fieldId) {
        Double fieldProductivity = treeService.calculateTotalProductivity(fieldId);
        return new ResponseEntity<>(fieldProductivity, HttpStatus.OK);
    }

    @GetMapping("/age/{id}")
    public ResponseEntity<String> calculateAge(@PathVariable Long id) {
        int age = (int) treeService.calculateAge(id);
        String message = String.format("The age of the tree is %d years.", age);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
