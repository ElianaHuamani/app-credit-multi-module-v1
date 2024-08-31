package com.mybank.credit.repository;

import com.mybank.credit.entity.SolicitudeDetailMySqlEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SolicitudeDetailSpringDataRepository
        extends GenericSpringDataRepository<SolicitudeDetailMySqlEntity,Long> {

    @Query(value =  "select p from SolicitudeDetailMySqlEntity p " +
            "where p.solicitudeId=:solicitudeId ")
    List<SolicitudeDetailMySqlEntity> queryBySolicitudeId(@Param("solicitudeId") Long solicitudeId);
}
