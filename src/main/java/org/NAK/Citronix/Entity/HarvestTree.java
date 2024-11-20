package org.NAK.Citronix.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.NAK.Citronix.Entity.Embedded.EmbeddedIds;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "hervestTree")
public class HarvestTree {

    @EmbeddedId
    private EmbeddedIds embeddedIds;

    @Column(name = "quantity")
    private Double quantity;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @MapsId("harvestId")
    private Harvest harvest;

    @ManyToOne(cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    @MapsId("treeId")
    private Tree tree;
}
