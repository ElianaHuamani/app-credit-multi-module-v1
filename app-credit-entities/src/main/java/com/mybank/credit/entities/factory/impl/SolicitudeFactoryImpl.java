package com.mybank.credit.entities.factory.impl;

import com.mybank.credit.entities.Solicitude;
import com.mybank.credit.entities.exceptions.SolicitudeException;
import com.mybank.credit.entities.factory.SolicitudeFactory;
import com.mybank.credit.entities.impl.SolicitudeImpl;

import java.time.LocalDate;

public class SolicitudeFactoryImpl implements SolicitudeFactory {
    @Override
    public Solicitude create(String name
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
    ) throws SolicitudeException {
        return new SolicitudeImpl(name
                , lastName
                , typeDocument
                , documentNumber
                , amount
                , disbursementDate
                , terms
                , tea
                , termAmount
                , totalAmount
                , endDate);
    }

    @Override
    public Solicitude create(String name
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
    ) throws SolicitudeException {
        return new SolicitudeImpl(name
                , lastName
                , typeDocument
                , documentNumber
                , email
                , phone
                , amount
                , disbursementDate
                , terms
                , tea
                , termAmount
                , totalAmount
                , endDate);
    }
}
