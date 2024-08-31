package com.mybank.credit.mapper;

import com.mybank.credit.document.CampaignDocument;
import com.mybank.credit.usecases.model.bd.CampaignBDResponseModel;

import java.util.Optional;

public interface CampaignMongoAdapterMapper {
    Optional<CampaignBDResponseModel> toOptional(Optional<CampaignDocument> optCampaignDocument);
}
