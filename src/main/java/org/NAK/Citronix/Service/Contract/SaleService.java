package org.NAK.Citronix.Service.Contract;

import org.NAK.Citronix.DTO.Sale.CreateSaleDTO;
import org.NAK.Citronix.DTO.Sale.ResponseSaleDTO;
import org.NAK.Citronix.DTO.Sale.ResponseSaleSharedDTO;
import org.NAK.Citronix.DTO.Sale.UpdateSaleDTO;

import java.util.List;

public interface SaleService {
    ResponseSaleSharedDTO createSale(CreateSaleDTO createSaleDTO);
    ResponseSaleDTO updateSale(Long id,UpdateSaleDTO updateSaleDTO);
    ResponseSaleDTO getSale(Long id);
    void deleteSale(Long id);
    List<ResponseSaleDTO> getSales();
}
