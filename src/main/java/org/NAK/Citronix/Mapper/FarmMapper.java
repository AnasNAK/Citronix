package org.NAK.Citronix.Mapper;

import org.NAK.Citronix.DTO.Farm.CreateFarmDTO;
import org.NAK.Citronix.DTO.Farm.ResponseFarmDTO;
import org.NAK.Citronix.DTO.Farm.ResponseFarmSharedDTO;
import org.NAK.Citronix.DTO.Farm.UpdateFarmDTO;
import org.NAK.Citronix.Entity.Farm;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring" )
public interface FarmMapper {

    ResponseFarmSharedDTO toResponseFarmSharedDTO(Farm farm);

    ResponseFarmDTO toResponseFarmDTO(Farm farm);

    Farm toFarm(CreateFarmDTO createFarmDTO);

    Farm toFarm(UpdateFarmDTO updateFarmDTO);

}
