package com.mybank.credit.usecases.ports.out;

import com.mybank.credit.usecases.common.CustomPage;
import com.mybank.credit.usecases.exception.UseCaseException;
import com.mybank.credit.usecases.model.bd.SolicitudeBDResponseModel;

import java.util.List;

@FunctionalInterface
public interface SolicitudeQueryByTypeDocAndDocNumberBDGateway {
    List<SolicitudeBDResponseModel> queryByTypeDocAndDocNumber(CustomPage customPage, String TypeDocument
            , String DocumentNumber) throws UseCaseException;
}
