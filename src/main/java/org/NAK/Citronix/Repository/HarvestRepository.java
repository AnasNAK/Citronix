package org.NAK.Citronix.Repository;

import org.NAK.Citronix.Entity.Field;
import org.NAK.Citronix.Entity.Harvest;
import org.NAK.Citronix.Enum.Season;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HarvestRepository extends JpaRepository<Harvest, Long> ,DeleteRepository<Harvest,Long> {

    List<Harvest> findBySeason(Season season);
}
