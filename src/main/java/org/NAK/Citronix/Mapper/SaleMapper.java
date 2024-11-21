package org.NAK.Citronix.Mapper;

import org.NAK.Citronix.DTO.Sale.CreateSaleDTO;
import org.NAK.Citronix.DTO.Sale.ResponseSaleDTO;
import org.NAK.Citronix.DTO.Sale.ResponseSaleSharedDTO;
import org.NAK.Citronix.DTO.Sale.UpdateSaleDTO;
import org.NAK.Citronix.Entity.Sale;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SaleMapper {

    ResponseSaleDTO toResponseSaleDTO(Sale sale);

    ResponseSaleSharedDTO toResponseSaleSharedDTO(Sale sale);

    Sale toSale(CreateSaleDTO saleDTO);

    Sale toSale(UpdateSaleDTO updateSaleDTO);
}
