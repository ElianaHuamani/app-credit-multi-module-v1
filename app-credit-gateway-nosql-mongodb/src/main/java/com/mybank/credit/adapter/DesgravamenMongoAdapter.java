package com.mybank.credit.adapter;

import com.mybank.credit.document.DesgravamenDocument;
import com.mybank.credit.mapper.DesgravamenMongoAdapterMapper;
import com.mybank.credit.repository.DesgravamenMongoSpringDataRespository;
import com.mybank.credit.usecases.exception.UseCaseException;
import com.mybank.credit.usecases.model.bd.DesgravamenBDResponse;
import com.mybank.credit.usecases.ports.out.DesgravamenQueryByTermsBDGateway;

public class DesgravamenMongoAdapter implements DesgravamenQueryByTermsBDGateway {

    private final DesgravamenMongoAdapterMapper desgravamenMongoAdapterMapper;

    private final DesgravamenMongoSpringDataRespository desgravamenMongoSpringDataRespository;

    public DesgravamenMongoAdapter(DesgravamenMongoAdapterMapper desgravamenMongoAdapterMapper
            , DesgravamenMongoSpringDataRespository desgravamenMongoSpringDataRespository) {
        this.desgravamenMongoAdapterMapper = desgravamenMongoAdapterMapper;
        this.desgravamenMongoSpringDataRespository = desgravamenMongoSpringDataRespository;
    }

    @Override
    public DesgravamenBDResponse queryByTerms(Integer terms) throws UseCaseException {
        DesgravamenDocument desgravamenDocument = desgravamenMongoSpringDataRespository.findByTermsBetween(terms);
        return desgravamenMongoAdapterMapper.to(desgravamenDocument);
    }
}
