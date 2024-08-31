package com.mybank.credit.usecases.ports.in;

import com.mybank.credit.usecases.common.CustomPage;
import com.mybank.credit.usecases.exception.UseCaseException;
import com.mybank.credit.usecases.model.web.SolicitudeResponseModel;

import java.util.List;

@FunctionalInterface
public interface SolicitudeQueryByTypeDocAndDocNumber {
    List<SolicitudeResponseModel> queryByTypeDocAndDocNumber(CustomPage customPage, String typeDocument
            , String documentNumber) throws UseCaseException;
}
