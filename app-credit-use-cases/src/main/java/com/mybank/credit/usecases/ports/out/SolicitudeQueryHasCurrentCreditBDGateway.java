package com.mybank.credit.usecases.ports.out;

import com.mybank.credit.usecases.exception.UseCaseException;

import java.time.LocalDate;

@FunctionalInterface
public interface SolicitudeQueryHasCurrentCreditBDGateway {
    Integer hasCurrentCredit(
            String typeDocument
            , String documentNumber
            , LocalDate now) throws UseCaseException;
}
