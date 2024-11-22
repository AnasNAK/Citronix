package org.NAK.Citronix.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.NAK.Citronix.Enum.Season;
import org.NAK.Citronix.Enum.Status;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "harvest")
public class Harvest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "harvestDate")
    private LocalDate harvestDate;

    @Column(name = "season")
    private Season season;

    @Column(name = "status")
    private Status status;

    @OneToMany(mappedBy = "harvest", fetch = FetchType.EAGER)
    private List<HarvestTree> harvestTrees;

    @OneToMany(mappedBy = "harvest" ,fetch = FetchType.EAGER ,cascade = CascadeType.ALL)
    private List<Sale> sales;

    @ManyToOne(fetch = FetchType.EAGER)
    private Field field;

}
