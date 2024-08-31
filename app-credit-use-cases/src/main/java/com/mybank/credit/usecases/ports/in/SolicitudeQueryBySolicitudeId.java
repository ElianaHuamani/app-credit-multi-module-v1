package com.mybank.credit.usecases.ports.in;

import com.mybank.credit.usecases.exception.UseCaseException;
import com.mybank.credit.usecases.model.web.SolicitudeResponseModel;

import java.util.Optional;

@FunctionalInterface
public interface SolicitudeQueryBySolicitudeId {
    Optional<SolicitudeResponseModel> queryBySolicitudeId(Long solicitudeId) throws UseCaseException;
}
