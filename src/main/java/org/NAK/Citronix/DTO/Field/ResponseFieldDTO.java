package org.NAK.Citronix.DTO.Field;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.NAK.Citronix.DTO.Farm.ResponseFarmSharedDTO;
import org.NAK.Citronix.DTO.Tree.ResponseTreeSharedDTO;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseFieldDTO {

    private Long id;

    private String name;

    private Double area;

    private LocalDate creationDate;

    private ResponseFarmSharedDTO farm;

    private List<ResponseTreeSharedDTO> trees;

}
