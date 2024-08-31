package com.mybank.credit.usecases.ports.in;

import com.mybank.credit.usecases.exception.UseCaseException;
import com.mybank.credit.usecases.model.web.GenericResponseModel;
import com.mybank.credit.usecases.model.web.SolicitudeRequestModel;

@FunctionalInterface
public interface SolicitudeSaveUseCase {
    GenericResponseModel save(SolicitudeRequestModel request) throws UseCaseException;
}
