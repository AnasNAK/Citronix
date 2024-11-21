package org.NAK.Citronix.Mapper;

import org.NAK.Citronix.DTO.Harvest.CreateHarvestDTO;
import org.NAK.Citronix.DTO.Harvest.ResponseHarvestDTO;
import org.NAK.Citronix.DTO.Harvest.ResponseHarvestSharedDTO;
import org.NAK.Citronix.DTO.Harvest.UpdateHarvestDTO;
import org.NAK.Citronix.Entity.Harvest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HarvestMapper {

    ResponseHarvestSharedDTO toResponseHarvestSharedDTO(Harvest harvest);

    ResponseHarvestDTO toResponseHarvestDTO(Harvest harvest);

    Harvest toHarvest(CreateHarvestDTO createHarvestDTO);

    Harvest toHarvest(UpdateHarvestDTO updateHarvestDTO);
}
