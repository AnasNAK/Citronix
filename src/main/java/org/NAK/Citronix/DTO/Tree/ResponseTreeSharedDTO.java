package org.NAK.Citronix.DTO.Tree;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTreeSharedDTO {

    private Long id;

    private LocalDate planingDate;
}
