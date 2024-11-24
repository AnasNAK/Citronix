package org.NAK.Citronix.Service.Implementation;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.NAK.Citronix.DTO.Harvest.CreateHarvestDTO;
import org.NAK.Citronix.DTO.Harvest.ResponseHarvestDTO;
import org.NAK.Citronix.DTO.Harvest.ResponseHarvestSharedDTO;
import org.NAK.Citronix.DTO.Harvest.UpdateHarvestDTO;
import org.NAK.Citronix.Entity.Field;
import org.NAK.Citronix.Entity.Harvest;
import org.NAK.Citronix.Mapper.HarvestMapper;
import org.NAK.Citronix.Repository.FieldRepository;
import org.NAK.Citronix.Repository.HarvestRepository;
import org.NAK.Citronix.Service.Contract.HarvestService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class HarvestServiceImpl implements HarvestService {

    private final HarvestRepository harvestRepository;

    private final FieldRepository fieldRepository;

    private final HarvestMapper harvestMapper;



    @Override
    public ResponseHarvestSharedDTO createHarvest(CreateHarvestDTO createHarvestDTO) {
        Field field = fieldRepository.findById(createHarvestDTO.getFieldId())
                .orElseThrow(() -> new EntityNotFoundException("field with id:"+createHarvestDTO.getFieldId() + "not found"));

        Harvest harvest = harvestMapper.toHarvest(createHarvestDTO);

        harvest.setField(field);
        harvest.setTotalQuantity(0.0);
        harvestRepository.save(harvest);
        return harvestMapper.toResponseHarvestSharedDTO(harvest);
    }

    @Override
    public ResponseHarvestDTO updateHarvest(Long id ,UpdateHarvestDTO updateHarvestDTO) {


        Harvest existedHarvest = harvestRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("harvest with id:"+id + "not found"));

        Field filed = fieldRepository.findById(existedHarvest.getField().getId()).orElseThrow(() -> new EntityNotFoundException("field with id:"+id + "not found"));

        Harvest harvest = harvestMapper.toHarvest(updateHarvestDTO);

        harvest.setField(filed);
        harvest.setId(existedHarvest.getId());
        harvest.setTotalQuantity(existedHarvest.getTotalQuantity());

        harvestRepository.save(harvest);

        return harvestMapper.toResponseHarvestDTO(harvest);
    }

    @Override
    public ResponseHarvestDTO getHarvest(Long id) {
        return harvestRepository.findById(id)
                .map(harvestMapper::toResponseHarvestDTO)
                .orElseThrow(() -> new EntityNotFoundException("harvest with id:"+id + "not found"));
    }

    @Override
    public void deleteHarvest(Long id) {
        if (!harvestRepository.existsById(id)) {
            throw new EntityNotFoundException("harvest with id:"+id + "not found");
        }
        harvestRepository.deleteByIdWithQuery(id);

    }

    @Override
    public List<ResponseHarvestDTO> getHarvests() {
        return harvestRepository.findAll()
                .stream()
                .map(harvestMapper::toResponseHarvestDTO)
                .collect(Collectors.toList());
    }
}
