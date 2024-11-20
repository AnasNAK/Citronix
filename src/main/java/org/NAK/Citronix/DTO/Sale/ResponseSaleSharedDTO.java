package org.NAK.Citronix.DTO.Sale;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseSaleSharedDTO {

    private Long id;

    private Double unitPrice;

    private LocalDate saleDate;

    private Double quantity;

    private String client;
}
