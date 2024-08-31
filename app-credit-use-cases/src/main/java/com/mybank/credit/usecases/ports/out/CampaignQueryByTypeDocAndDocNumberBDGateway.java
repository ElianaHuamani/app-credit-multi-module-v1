package com.mybank.credit.usecases.ports.out;

import com.mybank.credit.usecases.exception.UseCaseException;
import com.mybank.credit.usecases.model.bd.CampaignBDResponseModel;

import java.util.Optional;

@FunctionalInterface
public interface CampaignQueryByTypeDocAndDocNumberBDGateway {
    Optional<CampaignBDResponseModel> queryByTypeDocAndDocNumber(String typeDocument
            , String documentNumber) throws UseCaseException;
}
