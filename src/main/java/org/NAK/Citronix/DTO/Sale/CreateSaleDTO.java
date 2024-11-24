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
public class CreateSaleDTO {

    @NotNull(message = "you need to add a harvest Id ")
    private Long harvestId;

    @NotNull(message = "unitPrice should not be null")
    private Double unitPrice;

    @NotNull(message = "you need to add a saleDate")
    private LocalDate saleDate;

    @NotNull(message = "quantity should not be null")
    private Double quantity;

    @NotBlank(message = "you need to add a client name")
    @NotNull(message = "client cannot be null")
    private String client;

}
