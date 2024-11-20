package org.NAK.Citronix.DTO.Farm;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.NAK.Citronix.DTO.Field.ResponseFieldSharedDTO;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseFarmDTO {

    private Long id;

    private String name;

    private String location;

    private Double totalArea;

    private LocalDate creationDate;

    private List<ResponseFieldSharedDTO> Fields;
}
