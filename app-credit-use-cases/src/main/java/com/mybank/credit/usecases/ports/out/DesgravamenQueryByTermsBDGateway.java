package com.mybank.credit.usecases.ports.out;

import com.mybank.credit.usecases.exception.UseCaseException;
import com.mybank.credit.usecases.model.bd.DesgravamenBDResponse;

@FunctionalInterface
public interface DesgravamenQueryByTermsBDGateway {
    DesgravamenBDResponse queryByTerms(Integer terms)  throws UseCaseException;
}
