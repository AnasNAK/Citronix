package org.NAK.Citronix.Repository;

import org.NAK.Citronix.Entity.Farm;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FarmRepository extends JpaRepository<Farm, Long> {
    List<Farm> findAll(Specification<Farm> spec);
}
