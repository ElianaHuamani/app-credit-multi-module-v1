package com.mybank.credit.repository;

import com.mybank.credit.document.DesgravamenDocument;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DesgravamenMongoSpringDataRespository extends
        GenericMongoSpringDataRespository<DesgravamenDocument, String> {
    @Query("{$and :[ {MinTerm: {$lte: ?0}}, {MaxTerm: {$gte: ?0}} ] }")
    DesgravamenDocument findByTermsBetween(Integer terms);
}
