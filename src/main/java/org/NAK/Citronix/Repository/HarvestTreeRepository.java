package org.NAK.Citronix.Repository;

import org.NAK.Citronix.Entity.Embedded.EmbeddedIds;
import org.NAK.Citronix.Entity.HarvestTree;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HarvestTreeRepository extends JpaRepository<HarvestTree, EmbeddedIds>{
    Optional<HarvestTree> findByHarvestIdAndTreeId(Long harvestId, Long treeId);

    List<HarvestTree> findByTreeId(Long id);
}
