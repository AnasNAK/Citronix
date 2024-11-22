package org.NAK.Citronix.Controller;

import jakarta.validation.Valid;
import org.NAK.Citronix.DTO.Field.CreateFieldDTO;
import org.NAK.Citronix.DTO.Field.ResponseFieldDTO;
import org.NAK.Citronix.DTO.Field.ResponseFieldSharedDTO;
import org.NAK.Citronix.DTO.Field.UpdateFieldDTO;
import org.NAK.Citronix.Service.Contract.FieldService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/fields")
public class FieldController {

    private final FieldService fieldService;

    public FieldController(FieldService fieldService) {
        this.fieldService = fieldService;
    }


    @GetMapping
    public ResponseEntity<List<ResponseFieldDTO>> getFields() {
        List<ResponseFieldDTO> fields = fieldService.getFields();

        if (fields.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(fields);
        }
    }


    @PostMapping
    public ResponseEntity<ResponseFieldSharedDTO> createField(@Valid @RequestBody CreateFieldDTO createFieldDTO) {
        ResponseFieldSharedDTO field = fieldService.createField(createFieldDTO);
        return new ResponseEntity<>(field, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseFieldDTO> getField(@PathVariable Long id) {
        ResponseFieldDTO field = fieldService.getField(id);
        return new ResponseEntity<>(field, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteField(@PathVariable Long id) {
        fieldService.deleteField(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ResponseFieldDTO> updateField(@PathVariable Long id, @Valid @RequestBody UpdateFieldDTO updateFieldDTO) {

        ResponseFieldDTO updatedField = fieldService.updateField(id, updateFieldDTO);
        return new ResponseEntity<>(updatedField, HttpStatus.ACCEPTED);
    }
}
