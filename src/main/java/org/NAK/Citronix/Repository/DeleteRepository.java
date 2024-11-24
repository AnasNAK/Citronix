package org.NAK.Citronix.Repository;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@NoRepositoryBean
public interface DeleteRepository<T,ID> {
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM #{#entityName} e WHERE e.id = :id")
    void deleteByIdWithQuery(@Param("id") ID id);
}
