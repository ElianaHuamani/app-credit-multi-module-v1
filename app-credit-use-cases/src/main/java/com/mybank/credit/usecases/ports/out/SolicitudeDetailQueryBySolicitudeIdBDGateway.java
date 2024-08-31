package com.mybank.credit.usecases.ports.out;

import com.mybank.credit.usecases.exception.UseCaseException;
import com.mybank.credit.usecases.model.bd.SolicitudeDetailBDResponseModel;

import java.util.List;

@FunctionalInterface
public interface SolicitudeDetailQueryBySolicitudeIdBDGateway {
    List<SolicitudeDetailBDResponseModel> queryBySolicitudeId(Long solicitudeId) throws UseCaseException;
}
