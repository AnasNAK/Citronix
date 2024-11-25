package org.NAK.Citronix.Service.Implementation;

import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.criteria.CriteriaQuery;
import lombok.AllArgsConstructor;
import org.NAK.Citronix.DTO.Farm.CreateFarmDTO;
import org.NAK.Citronix.DTO.Farm.ResponseFarmDTO;
import org.NAK.Citronix.DTO.Farm.ResponseFarmSharedDTO;
import org.NAK.Citronix.DTO.Farm.UpdateFarmDTO;
import org.NAK.Citronix.Entity.Farm;
import org.NAK.Citronix.Mapper.FarmMapper;
import org.NAK.Citronix.Repository.FarmRepository;
import org.NAK.Citronix.SearchCriteria.FarmSearch;
import org.NAK.Citronix.Service.Contract.FarmService;
import org.NAK.Citronix.Validation.FarmValidation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FarmServiceImpl implements FarmService {

    private final FarmRepository farmRepository;

    private final FarmMapper farmMapper;

    private final FarmValidation farmValidation;


    @Override
    public ResponseFarmSharedDTO createFarm(CreateFarmDTO createFarmDTO) {

        Farm farm = farmMapper.toFarm(createFarmDTO);

        farmValidation.validateFarm(farm);

        farm.setCreationDate(LocalDate.now());

        Farm savedFarm = farmRepository.save(farm);

        return farmMapper.toResponseFarmSharedDTO(savedFarm);

    }

    @Override
    public ResponseFarmDTO UpdateFarm(Long id, UpdateFarmDTO updateFarmDTO) {

        Farm existedFarm = farmRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Farm with Id:" + id + " Not Found"));

        Farm updatedFarm = farmMapper.toFarm(updateFarmDTO);

        farmValidation.validateFarm(updatedFarm);

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
    public Page<ResponseFarmDTO> getFarms(Pageable pageable) {

        return farmRepository.findAll(pageable)
                .map(farmMapper::toResponseFarmDTO);
    }


    @Override
    public void deleteFarm(Long id) {
        if (!farmRepository.existsById(id)) {
            throw new EntityNotFoundException("Farm with Id:" + id + " Not Found");
        }
        farmRepository.deleteById(id);
    }

    @Override
    public List<ResponseFarmDTO> searchFarms(String name, String location, Double minArea, Double maxArea , LocalDate creationDate) {
        Specification<Farm> spec = FarmSearch.createSearchSpecification(name, location, minArea, maxArea ,creationDate);

        List<Farm> farms = farmRepository.findAll(spec);

        return farms.stream()
                .map(farmMapper::toResponseFarmDTO)
                .collect(Collectors.toList());
    }
}
