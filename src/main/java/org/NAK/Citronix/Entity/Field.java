package org.NAK.Citronix.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "field")
public class Field {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "area")
    private Double area;

    @Column(name = "creation_date")
    private LocalDate creationDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "farm_id")
    private Farm farm;

    @OneToMany(mappedBy = "field" , cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    private List<Tree> trees;
}
