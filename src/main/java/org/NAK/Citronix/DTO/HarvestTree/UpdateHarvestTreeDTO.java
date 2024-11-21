package org.NAK.Citronix.DTO.HarvestTree;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateHarvestTreeDTO {

    @NotNull(message = "harvestId should not be null ")
    private Long harvestId;

    @NotNull(message = "TreeId should not be null ")
    private Long TreeId;

    @NotNull(message = "quantity should not be null ")
    private Double quantity;
}
