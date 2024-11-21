package org.NAK.Citronix.Service.Contract;

import org.NAK.Citronix.DTO.Farm.CreateFarmDTO;
import org.NAK.Citronix.DTO.Farm.ResponseFarmDTO;
import org.NAK.Citronix.DTO.Farm.ResponseFarmSharedDTO;
import org.NAK.Citronix.DTO.Farm.UpdateFarmDTO;

import java.util.List;

public interface FarmService {
    ResponseFarmSharedDTO createFarm(CreateFarmDTO createFarmDTO);
    ResponseFarmDTO UpdateFarm(Long id ,UpdateFarmDTO updateFarmDTO);
    ResponseFarmDTO getFarm(Long id);
    List<ResponseFarmDTO> getFarms();
    void deleteFarm(Long id);
}
