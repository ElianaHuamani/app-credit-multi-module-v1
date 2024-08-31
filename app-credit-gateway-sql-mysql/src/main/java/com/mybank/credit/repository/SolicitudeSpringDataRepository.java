package com.mybank.credit.repository;

import com.mybank.credit.entity.SolicitudeMySqlEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface SolicitudeSpringDataRepository
        extends GenericSpringDataRepository<SolicitudeMySqlEntity,Long> {
    @Query(value =  "select p from SolicitudeMySqlEntity p " +
            "where p.solicitudeId=:solicitudeId " +
            "and p.status='A'")
    Optional<SolicitudeMySqlEntity> queryBySolicitudeId(@Param("solicitudeId") Long solicitudeId);

    @Query(value =  "select p from SolicitudeMySqlEntity p " +
            "where p.typeDocument=:typeDocument " +
            "and p.documentNumber=:documentNumber " +
            "and p.status='A'")
    Page<SolicitudeMySqlEntity> queryByTypeDocAndDocNumber(Pageable pageable, @Param("typeDocument") String typeDocument
            , @Param("documentNumber") String documentNumber);

    @Query(value = "SELECT COUNT(s.SolicitudeId) " +
            "FROM credit.Solicitude s " +
            "WHERE s.TypeDocument = :typeDocument " +
            "AND s.DocumentNumber = :documentNumber " +
            "AND s.EndDate > :now " +
            "AND s.Status = 'A' ", nativeQuery = true)
    Integer hasCurrentCredit(@Param("typeDocument") String typeDocument,
                                   @Param("documentNumber") String documentNumber,
                                   @Param("now") LocalDate now);

}
