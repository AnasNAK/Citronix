package org.NAK.Citronix.Repository;

import org.NAK.Citronix.Entity.Field;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface FieldRepository extends JpaRepository<Field, Long>, DeleteRepository<Field, Long> {

    List<Field> findAllByFarmId(Long farmId);
}
