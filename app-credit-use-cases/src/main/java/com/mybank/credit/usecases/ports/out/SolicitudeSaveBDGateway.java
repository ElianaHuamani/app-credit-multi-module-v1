package com.mybank.credit.usecases.ports.out;

import com.mybank.credit.usecases.exception.UseCaseException;
import com.mybank.credit.usecases.model.bd.SolicitudeBDRequestModel;
import com.mybank.credit.usecases.model.web.GenericResponseModel;

@FunctionalInterface
public interface SolicitudeSaveBDGateway {
    GenericResponseModel save(SolicitudeBDRequestModel request) throws UseCaseException;
}
