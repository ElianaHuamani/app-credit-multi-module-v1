package com.mybank.credit.repository;

import com.mybank.credit.document.HolidayDocument;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface HolidayMongoSpringDataRespository extends
        GenericMongoSpringDataRespository<HolidayDocument, String> {
    @Query("{HolidayDate : ?0}")
    Optional<HolidayDocument> findHolidayByDate(String date);
}
