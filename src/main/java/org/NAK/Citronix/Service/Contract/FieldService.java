package org.NAK.Citronix.Service.Contract;

import org.NAK.Citronix.DTO.Field.CreateFieldDTO;
import org.NAK.Citronix.DTO.Field.ResponseFieldDTO;
import org.NAK.Citronix.DTO.Field.ResponseFieldSharedDTO;
import org.NAK.Citronix.DTO.Field.UpdateFieldDTO;

import java.util.List;

public interface FieldService {
    ResponseFieldSharedDTO createField(CreateFieldDTO createFieldDTO);
    ResponseFieldDTO updateField(Long id ,UpdateFieldDTO updateFieldDTO);
    void deleteField(Long id);
    ResponseFieldDTO getField(Long id);
    List<ResponseFieldDTO> getFields();
}
