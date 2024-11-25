package org.NAK.Citronix.Repository;

import org.NAK.Citronix.Entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> , DeleteRepository<Sale, Long> {
    List<Sale> findByHarvestId(Long harvestId);
}
