package org.NAK.Citronix.Entity.Embedded;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmbeddedIds implements Serializable {

    @Column(name = "treeId")
    private Long treeId;

    @Column(name = "harvestId")
    private Long harvestId;
}
