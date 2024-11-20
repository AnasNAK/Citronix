package org.NAK.Citronix.DTO.Sale;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.NAK.Citronix.DTO.Harvest.ResponseHarvestSharedDTO;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseSaleDTO {

    private Long id;

    private Double unitPrice;

    private LocalDate saleDate;

    private Double quantity;

    private String client;

    private ResponseHarvestSharedDTO harvest;
}
