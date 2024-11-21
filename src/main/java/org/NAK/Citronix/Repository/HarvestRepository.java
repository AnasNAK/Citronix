package org.NAK.Citronix.Repository;

import org.NAK.Citronix.Entity.Harvest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HarvestRepository extends JpaRepository<Harvest, Long> {
}
