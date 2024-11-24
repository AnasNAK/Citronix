package org.NAK.Citronix.Controller;

import jakarta.validation.Valid;
import org.NAK.Citronix.DTO.Harvest.CreateHarvestDTO;
import org.NAK.Citronix.DTO.Harvest.ResponseHarvestDTO;
import org.NAK.Citronix.DTO.Harvest.ResponseHarvestSharedDTO;
import org.NAK.Citronix.DTO.Harvest.UpdateHarvestDTO;
import org.NAK.Citronix.Service.Contract.HarvestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/harvests")
public class HarvestController {

    private final HarvestService harvestService;


    public HarvestController(HarvestService harvestService) {
        this.harvestService = harvestService;
    }

    @GetMapping
    public ResponseEntity<List<ResponseHarvestDTO>> getHarvests() {
        return ResponseEntity.ok(harvestService.getHarvests());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseHarvestDTO> getHarvestById(@PathVariable Long id) {
        ResponseHarvestDTO harvest = harvestService.getHarvest(id);
        return new ResponseEntity<>(harvest, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ResponseHarvestSharedDTO> createHarvest(@Valid @RequestBody CreateHarvestDTO createHarvestDTO) {
        ResponseHarvestSharedDTO harvest = harvestService.createHarvest(createHarvestDTO);
        return new ResponseEntity<>(harvest, HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ResponseHarvestDTO> UpdateHarvest(@PathVariable Long id, @Valid @RequestBody UpdateHarvestDTO updateHarvestDTO) {
        ResponseHarvestDTO harvest = harvestService.updateHarvest(id, updateHarvestDTO);
        return new ResponseEntity<>(harvest, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseHarvestDTO> deleteHarvest(@PathVariable Long id) {
        harvestService.deleteHarvest(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
