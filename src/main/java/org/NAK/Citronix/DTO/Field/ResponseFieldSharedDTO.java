package org.NAK.Citronix.DTO.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseFieldSharedDTO {

    private Long id;

    private String name;

    private Double area;

    private LocalDate creationDate;
}
