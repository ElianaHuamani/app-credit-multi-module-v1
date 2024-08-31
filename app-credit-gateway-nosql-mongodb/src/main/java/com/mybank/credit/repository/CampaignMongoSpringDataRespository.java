package com.mybank.credit.repository;

import com.mybank.credit.document.CampaignDocument;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampaignMongoSpringDataRespository extends
        GenericMongoSpringDataRespository<CampaignDocument, String> {
    @Query("{typeDocument:'?0', documentNumber:'?1'}")
    List<CampaignDocument> findByTypeDocumentAndDocumentNumber(String typeDocument, String documentNumber);

    long count();
}
