package org.NAK.Citronix.Service.Implementation;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.NAK.Citronix.DTO.Sale.CreateSaleDTO;
import org.NAK.Citronix.DTO.Sale.ResponseSaleDTO;
import org.NAK.Citronix.DTO.Sale.ResponseSaleSharedDTO;
import org.NAK.Citronix.DTO.Sale.UpdateSaleDTO;
import org.NAK.Citronix.Entity.Harvest;
import org.NAK.Citronix.Entity.Sale;
import org.NAK.Citronix.Mapper.SaleMapper;
import org.NAK.Citronix.Repository.HarvestRepository;
import org.NAK.Citronix.Repository.SaleRepository;
import org.NAK.Citronix.Service.Contract.SaleService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SaleServiceImpl  implements SaleService {

    private final SaleRepository saleRepository;

    private final SaleMapper saleMapper;

    private final HarvestRepository harvestRepository;

    @Override
    public ResponseSaleSharedDTO createSale(CreateSaleDTO createSaleDTO) {

        Harvest harvest = harvestRepository.findById(createSaleDTO.getHarvestId())
                .orElseThrow(()-> new RuntimeException("Harvest with Id :"+ createSaleDTO.getHarvestId() +"not found"));

        validateHarvestReadyForSale(harvest);

        validateAvailableQuantity(harvest, createSaleDTO.getQuantity());

        Sale sale = saleMapper.toSale(createSaleDTO);
        sale.setHarvest(harvest);
        saleRepository.save(sale);

        return saleMapper.toResponseSaleSharedDTO(sale);

    }

    @Override
    public ResponseSaleDTO updateSale(Long id,UpdateSaleDTO updateSaleDTO) {
        Sale existedSale = saleRepository.findById(id).orElseThrow(()-> new RuntimeException("Sale with Id :"+ id +"not found"));

        Sale sale = saleMapper.toSale(updateSaleDTO);

        sale.setHarvest(existedSale.getHarvest());
        sale.setId(existedSale.getId());
        saleRepository.save(sale);

        return saleMapper.toResponseSaleDTO(sale);

    }

    @Override
    public ResponseSaleDTO getSale(Long id) {
        return saleRepository.findById(id)
                .map(saleMapper::toResponseSaleDTO)
                .orElseThrow(()-> new RuntimeException("Sale with Id :"+ id +"not found"));
    }

    @Override
    public void deleteSale(Long id) {
        if (!saleRepository.existsById(id)) {
            throw new EntityNotFoundException("Sale with Id :"+ id +"not found");
        }
        saleRepository.deleteByIdWithQuery(id);

    }

    @Override
    public List<ResponseSaleDTO> getSales() {
        return saleRepository.findAll()
                .stream()
                .map(saleMapper::toResponseSaleDTO)
                .collect(Collectors.toList());
    }

    @Override
    public double calculateTotalRevenue(Long harvestId) {
        List<Sale> sales = saleRepository.findByHarvestId(harvestId);

        return sales.stream()
                .mapToDouble(this::calculateRevenue)
                .sum();
    }

    private double calculateRevenue(Sale sale) {
        return sale.getQuantity() * sale.getUnitPrice();
    }

    private void validateAvailableQuantity(Harvest harvest, Double requestedQuantity) {
        double availableQuantity = harvest.getTotalQuantity();

        if (requestedQuantity > availableQuantity) {
            throw new IllegalArgumentException("Not enough quantity available for this harvest. Available: " + availableQuantity + ", Requested: " + requestedQuantity);
        }
    }

    private void validateHarvestReadyForSale(Harvest harvest) {
        LocalDate currentDate = LocalDate.now();

        if (currentDate.isBefore(harvest.getHarvestDate().plusMonths(3))) {
            throw new IllegalArgumentException("The harvest is not ready for sale yet. Please wait until " + harvest.getHarvestDate().plusMonths(3));
        }
    }
}
