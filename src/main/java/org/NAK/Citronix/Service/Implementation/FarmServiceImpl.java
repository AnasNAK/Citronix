package org.NAK.Citronix.Service.Implementation;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.NAK.Citronix.DTO.Farm.CreateFarmDTO;
import org.NAK.Citronix.DTO.Farm.ResponseFarmDTO;
import org.NAK.Citronix.DTO.Farm.ResponseFarmSharedDTO;
import org.NAK.Citronix.DTO.Farm.UpdateFarmDTO;
import org.NAK.Citronix.Entity.Farm;
import org.NAK.Citronix.Mapper.FarmMapper;
import org.NAK.Citronix.Repository.FarmRepository;
import org.NAK.Citronix.Service.Contract.FarmService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FarmServiceImpl implements FarmService {

    private final FarmRepository farmRepository;

    private final FarmMapper farmMapper;


    @Override
    public ResponseFarmSharedDTO createFarm(CreateFarmDTO createFarmDTO) {

        Farm farm = farmMapper.toFarm(createFarmDTO);

        farm.setCreationDate(LocalDate.now());

        Farm savedFarm = farmRepository.save(farm);

        return farmMapper.toResponseFarmSharedDTO(savedFarm);

    }

    @Override
    public ResponseFarmDTO UpdateFarm(Long id, UpdateFarmDTO updateFarmDTO) {

        Farm existedFarm = farmRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Farm with Id:" + id + " Not Found"));

        Farm updatedFarm = farmMapper.toFarm(updateFarmDTO);

        updatedFarm.setId(existedFarm.getId());
        updatedFarm.setCreationDate(existedFarm.getCreationDate());
        farmRepository.save(updatedFarm);

        return farmMapper.toResponseFarmDTO(updatedFarm);
    }

    @Override
    public ResponseFarmDTO getFarm(Long id) {

        return farmRepository.findById(id)
                .map(farmMapper::toResponseFarmDTO)
                .orElseThrow(() -> new EntityNotFoundException("Farm with Id:" + id + " Not Found"));
    }

    @Override
    public List<ResponseFarmDTO> getFarms() {

        return farmRepository.findAll()
                .stream()
                .map(farmMapper::toResponseFarmDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteFarm(Long id) {
        if (!farmRepository.existsById(id)) {
            throw new EntityNotFoundException("Farm with Id:" + id + " Not Found");
        }
        farmRepository.deleteById(id);
    }
}
