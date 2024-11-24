package org.NAK.Citronix.Service.Contract;

import org.NAK.Citronix.DTO.Harvest.CreateHarvestDTO;
import org.NAK.Citronix.DTO.Harvest.ResponseHarvestDTO;
import org.NAK.Citronix.DTO.Harvest.ResponseHarvestSharedDTO;
import org.NAK.Citronix.DTO.Harvest.UpdateHarvestDTO;

import java.util.List;

public interface HarvestService {

    ResponseHarvestSharedDTO createHarvest(CreateHarvestDTO createHarvestDTO);
    ResponseHarvestDTO updateHarvest(Long id ,UpdateHarvestDTO updateHarvestDTO);
    ResponseHarvestDTO getHarvest(Long id);
    void deleteHarvest(Long id);
    List<ResponseHarvestDTO> getHarvests();
}
