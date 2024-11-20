package org.NAK.Citronix.DTO.Farm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseFarmSharedDTO {

    private Long id;

    private String name;

    private String location;

    private Double totalArea;

    private LocalDate creationDate;
}
