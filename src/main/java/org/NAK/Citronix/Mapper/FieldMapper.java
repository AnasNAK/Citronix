package org.NAK.Citronix.Mapper;

import org.NAK.Citronix.DTO.Field.CreateFieldDTO;
import org.NAK.Citronix.DTO.Field.ResponseFieldDTO;
import org.NAK.Citronix.DTO.Field.ResponseFieldSharedDTO;
import org.NAK.Citronix.DTO.Field.UpdateFieldDTO;
import org.NAK.Citronix.Entity.Field;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FieldMapper {

    ResponseFieldDTO toResponseFieldDTO(Field field);

    ResponseFieldSharedDTO toResponseFieldSharedDTO(Field field);

    Field toField(CreateFieldDTO createFieldDTO);

    Field toField(UpdateFieldDTO updateFieldDTO);

}
