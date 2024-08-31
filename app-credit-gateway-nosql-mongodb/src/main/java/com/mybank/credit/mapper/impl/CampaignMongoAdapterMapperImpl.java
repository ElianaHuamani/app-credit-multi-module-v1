package com.mybank.credit.mapper.impl;

import com.mybank.credit.document.CampaignDocument;
import com.mybank.credit.mapper.CampaignMongoAdapterMapper;
import com.mybank.credit.usecases.model.bd.CampaignBDResponseModel;

import java.util.Optional;

public class CampaignMongoAdapterMapperImpl implements CampaignMongoAdapterMapper {
    @Override
    public Optional<CampaignBDResponseModel> toOptional(Optional<CampaignDocument> optCampaignDocument) {
        if (optCampaignDocument.isPresent()) {
            return Optional.ofNullable(this.to(optCampaignDocument.get()));
        }
        return Optional.empty();
    }

    private CampaignBDResponseModel to(CampaignDocument campaignDocument) {
        CampaignBDResponseModel responseModel = new CampaignBDResponseModel();
        responseModel.setTypeDocument(campaignDocument.getTypeDocument());
        responseModel.setDocumentNumber(campaignDocument.getDocumentNumber());
        responseModel.setRisk(campaignDocument.isRisk());
        responseModel.setTea(campaignDocument.getTea());
        return responseModel;
    }
}
