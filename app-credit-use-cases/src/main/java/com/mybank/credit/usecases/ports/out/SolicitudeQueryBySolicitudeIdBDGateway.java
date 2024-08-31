package com.mybank.credit.usecases.ports.out;

import com.mybank.credit.usecases.exception.UseCaseException;
import com.mybank.credit.usecases.model.bd.SolicitudeBDResponseModel;

import java.util.Optional;

@FunctionalInterface
public interface SolicitudeQueryBySolicitudeIdBDGateway {
    Optional<SolicitudeBDResponseModel> queryBySolicitudeId(Long solicitudeId) throws UseCaseException;
}
