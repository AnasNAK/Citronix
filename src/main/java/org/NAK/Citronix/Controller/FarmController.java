package org.NAK.Citronix.Controller;

import jakarta.validation.Valid;
import org.NAK.Citronix.DTO.Farm.CreateFarmDTO;
import org.NAK.Citronix.DTO.Farm.ResponseFarmDTO;
import org.NAK.Citronix.DTO.Farm.ResponseFarmSharedDTO;
import org.NAK.Citronix.DTO.Farm.UpdateFarmDTO;
import org.NAK.Citronix.Service.Contract.FarmService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/farms")
public class FarmController {

    private final FarmService farmService;

    public FarmController(FarmService farmService) {
        this.farmService = farmService;
    }
    @PostMapping
    public ResponseEntity<ResponseFarmSharedDTO> createFarm(@Valid @RequestBody CreateFarmDTO createFarmDTO){
        ResponseFarmSharedDTO response = farmService.createFarm(createFarmDTO);

        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }
    @GetMapping
    public ResponseEntity<List<ResponseFarmDTO>> getAllFarms(){

        List<ResponseFarmDTO> farms = farmService.getFarms();

        if (farms.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(farms, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseFarmDTO> getFarmById(@PathVariable Long id){
        ResponseFarmDTO farm = farmService.getFarm(id);
        return new ResponseEntity<>(farm, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ResponseFarmDTO> updateFarm( @Valid @RequestBody UpdateFarmDTO updateFarmDTO , @PathVariable("id") Long id){

        ResponseFarmDTO updatedFarm = farmService.UpdateFarm(id, updateFarmDTO);
        return new ResponseEntity<>(updatedFarm, HttpStatus.ACCEPTED);

    }

    @DeleteMapping("/{id}")

    public ResponseEntity<Void> deleteFarm(@PathVariable("id") Long id){
        farmService.deleteFarm(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
