package org.NAK.Citronix.Repository;

import org.NAK.Citronix.Entity.Tree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TreeRepository extends JpaRepository<Tree, Long> , DeleteRepository<Tree, Long> {

        List<Tree> findByFieldId(Long fieldId);
}
