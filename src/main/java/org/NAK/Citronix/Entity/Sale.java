package org.NAK.Citronix.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "sale")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "unitPrice")
    private Double unitPrice;

    @Column(name = "saleDate")
    private LocalDate saleDate;

    @Column(name = "quantity")
    private Double quantity;

    @Column(name = "client")
    private String client;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "harvest_id")
    private Harvest harvest;
}
