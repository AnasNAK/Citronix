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
public class UpdateSaleDTO {
    @NotNull(message = "unitPrice should not be null")
    @NotBlank(message = "you need to add a unitPrice")
    private Double unitPrice;

    @NotBlank(message = "you need to add a saleDate")
    private LocalDate saleDate;

    @NotBlank(message = "you need to add a quantity")
    @NotNull(message = "quantity should not be null")
    private Double quantity;

    @NotBlank(message = "you need to add a client name")
    @NotNull(message = "client cannot be null")
    private String client;
}
