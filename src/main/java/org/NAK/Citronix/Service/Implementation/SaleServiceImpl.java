package org.NAK.Citronix.Service.Implementation;

import lombok.AllArgsConstructor;
import org.NAK.Citronix.DTO.Sale.CreateSaleDTO;
import org.NAK.Citronix.DTO.Sale.ResponseSaleDTO;
import org.NAK.Citronix.DTO.Sale.ResponseSaleSharedDTO;
import org.NAK.Citronix.DTO.Sale.UpdateSaleDTO;
import org.NAK.Citronix.Mapper.SaleMapper;
import org.NAK.Citronix.Repository.HarvestRepository;
import org.NAK.Citronix.Repository.SaleRepository;
import org.NAK.Citronix.Service.Contract.SaleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SaleServiceImpl  implements SaleService {

    private final SaleRepository saleRepository;

    private final SaleMapper saleMapper;

    private final HarvestRepository harvestRepository;

    @Override
    public ResponseSaleSharedDTO createSale(CreateSaleDTO createSaleDTO) {


    }

    @Override
    public ResponseSaleDTO updateSale(UpdateSaleDTO updateSaleDTO) {
        return null;
    }

    @Override
    public ResponseSaleDTO getSale(Long id) {
        return null;
    }

    @Override
    public void deleteSale(Long id) {

    }

    @Override
    public List<ResponseSaleDTO> getSales() {
        return List.of();
    }
}
