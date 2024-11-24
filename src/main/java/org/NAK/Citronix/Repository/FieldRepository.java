package org.NAK.Citronix.Repository;

import org.NAK.Citronix.Entity.Field;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FieldRepository extends JpaRepository<Field, Long>, DeleteRepository<Field, Long> {

}
