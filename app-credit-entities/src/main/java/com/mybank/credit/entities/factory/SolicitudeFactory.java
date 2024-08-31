package com.mybank.credit.entities.factory;

import com.mybank.credit.entities.Solicitude;
import com.mybank.credit.entities.exceptions.SolicitudeException;

import java.time.LocalDate;

public interface SolicitudeFactory {
    Solicitude create(String name
            , String lastName
            , String typeDocument
            , String documentNumber
            , Integer amount
            , LocalDate disbursementDate
            , Integer terms
            , Double tea
            , Double termAmount
            , Double totalAmount
            , LocalDate endDate
    ) throws SolicitudeException;
    Solicitude create(String name
            , String lastName
            , String typeDocument
            , String documentNumber
            , String email
            , String phone
            , Integer amount
            , LocalDate disbursementDate
            , Integer terms
            , Double tea
            , Double termAmount
            , Double totalAmount
            , LocalDate endDate
    ) throws SolicitudeException;
}
