package org.NAK.Citronix.Service.Implementation;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.NAK.Citronix.DTO.Field.CreateFieldDTO;
import org.NAK.Citronix.DTO.Field.ResponseFieldDTO;
import org.NAK.Citronix.DTO.Field.ResponseFieldSharedDTO;
import org.NAK.Citronix.DTO.Field.UpdateFieldDTO;
import org.NAK.Citronix.Entity.Farm;
import org.NAK.Citronix.Entity.Field;
import org.NAK.Citronix.Mapper.FieldMapper;
import org.NAK.Citronix.Repository.FarmRepository;
import org.NAK.Citronix.Repository.FieldRepository;
import org.NAK.Citronix.Service.Contract.FieldService;
import org.NAK.Citronix.Validation.FieldValidation;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FieldServiceImpl implements FieldService {

    private final FieldRepository fieldRepository;
    private final FarmRepository farmRepository;
    private final FieldValidation fieldValidation;
    private final FieldMapper fieldMapper;

    @Override
    public ResponseFieldSharedDTO createField(CreateFieldDTO createFieldDTO) {

        Farm farm = farmRepository.findById(createFieldDTO.getFarmId()).orElseThrow(EntityNotFoundException::new);

        Field field = fieldMapper.toField(createFieldDTO);

        Long farmId = farm.getId();

        double currentFieldArea = fieldRepository.findAllByFarmId(farmId).stream()
                .mapToDouble(Field::getArea)
                .sum();

        fieldValidation.validateFieldCreation(field, farm, currentFieldArea);

        field.setCreationDate(LocalDate.now());
        field.setFarm(farm);

        Field savedField = fieldRepository.save(field);

        return fieldMapper.toResponseFieldSharedDTO(savedField);

    }

    @Override
    public ResponseFieldDTO updateField(Long id ,UpdateFieldDTO updateFieldDTO) {

        Field existedField = fieldRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Field with Id :" +id+ "not found" ));

        Farm farm = farmRepository.findById(existedField.getFarm().getId()).orElseThrow(() -> new EntityNotFoundException("farm with Id :" +existedField.getFarm().getId()+"does not found" ));

        Field updatedField = fieldMapper.toField(updateFieldDTO);

        double currentFieldArea = fieldRepository.findAllByFarmId(farm.getId()).stream()
                .filter(f -> !f.getId().equals(existedField.getId()))
                .mapToDouble(Field::getArea)
                .sum();

        fieldValidation.validateFieldUpdate(updatedField, farm, currentFieldArea);

        updatedField.setId(existedField.getId());
        updatedField.setFarm(farm);
        updatedField.setCreationDate(existedField.getCreationDate());

        fieldRepository.save(updatedField);

        return fieldMapper.toResponseFieldDTO(updatedField);

    }

    @Override
    public void deleteField(Long id) {
        if (!fieldRepository.existsById(id)) {
            throw new EntityNotFoundException("Field with Id :" + id + "not found");
        }
        fieldRepository.deleteByIdWithQuery(id);
    }

    @Override
    public ResponseFieldDTO getField(Long id) {
        return fieldRepository.findById(id)
                .map(fieldMapper::toResponseFieldDTO)
                .orElseThrow(()-> new EntityNotFoundException("Field with Id :" +id + "not found"));

    }

    @Override
    public List<ResponseFieldDTO> getFields() {
        return fieldRepository.findAll()
                .stream()
                .map(fieldMapper::toResponseFieldDTO)
                .collect(Collectors.toList());
    }
}
