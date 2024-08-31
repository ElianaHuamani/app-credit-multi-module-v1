package com.mybank.credit.usecases.ports.out;

import com.mybank.credit.usecases.exception.UseCaseException;
import com.mybank.credit.usecases.model.bd.SolicitudeDetailBDRequestModel;

import java.util.List;

public interface SolicitudeDetailSaveBDGateway {
    void saveAll(List<SolicitudeDetailBDRequestModel> lstRequest) throws UseCaseException;
}
