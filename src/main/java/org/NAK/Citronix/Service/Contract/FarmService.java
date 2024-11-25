package org.NAK.Citronix.Service.Contract;

import jakarta.persistence.criteria.CriteriaQuery;
import org.NAK.Citronix.DTO.Farm.CreateFarmDTO;
import org.NAK.Citronix.DTO.Farm.ResponseFarmDTO;
import org.NAK.Citronix.DTO.Farm.ResponseFarmSharedDTO;
import org.NAK.Citronix.DTO.Farm.UpdateFarmDTO;
import org.NAK.Citronix.Entity.Farm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;

public interface FarmService {
    ResponseFarmSharedDTO createFarm(CreateFarmDTO createFarmDTO);
    ResponseFarmDTO UpdateFarm(Long id ,UpdateFarmDTO updateFarmDTO);
    ResponseFarmDTO getFarm(Long id);
    Page<ResponseFarmDTO> getFarms(Pageable pageable);
    void deleteFarm(Long id);
    List<ResponseFarmDTO> searchFarms(String name, String location, Double minArea, Double maxArea, LocalDate creationDate);
}
