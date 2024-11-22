package org.NAK.Citronix.Repository;

import org.NAK.Citronix.Entity.HarvestTree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HarvestTreeRepository extends JpaRepository<HarvestTree, Long> {
}
