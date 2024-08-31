package com.mybank.credit.adapter;

import com.mybank.credit.document.CampaignDocument;
import com.mybank.credit.mapper.CampaignMongoAdapterMapper;
import com.mybank.credit.repository.CampaignMongoSpringDataRespository;
import com.mybank.credit.usecases.exception.UseCaseException;
import com.mybank.credit.usecases.model.bd.CampaignBDResponseModel;
import com.mybank.credit.usecases.ports.out.CampaignQueryByTypeDocAndDocNumberBDGateway;

import java.util.List;
import java.util.Optional;

public class CampaignMongoAdapter implements CampaignQueryByTypeDocAndDocNumberBDGateway {
    private final CampaignMongoSpringDataRespository campaignMongoSpringDataRespository;
    private final CampaignMongoAdapterMapper campaignMongoAdapterMapper;

    public CampaignMongoAdapter(
            final CampaignMongoSpringDataRespository campaignMongoSpringDataRespository
            , final CampaignMongoAdapterMapper campaignMongoAdapterMapper) {
        this.campaignMongoSpringDataRespository = campaignMongoSpringDataRespository;
        this.campaignMongoAdapterMapper = campaignMongoAdapterMapper;
    }

    @Override
    public Optional<CampaignBDResponseModel> queryByTypeDocAndDocNumber(String typeDocument, String documentNumber) throws UseCaseException {
        List<CampaignDocument> campaignDocuments = campaignMongoSpringDataRespository
                .findByTypeDocumentAndDocumentNumber(typeDocument, documentNumber);
        return campaignMongoAdapterMapper.toOptional(campaignDocuments.stream().findFirst());
    }
}
