package org.NAK.Citronix.DTO.Tree;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateTreeDTO {
    @NotBlank(message = "tree should have a planing date")
    @NotNull(message = "tree should not be null")
    private LocalDate planingDate;
}
