package com.mybank.credit.mapper.impl;

import com.mybank.credit.document.DesgravamenDocument;
import com.mybank.credit.mapper.DesgravamenMongoAdapterMapper;
import com.mybank.credit.usecases.model.bd.DesgravamenBDResponse;

public class DesgravamenMongoAdapterMapperImpl implements DesgravamenMongoAdapterMapper {
    @Override
    public DesgravamenBDResponse to(DesgravamenDocument desgravamenDocument) {
        DesgravamenBDResponse response = new DesgravamenBDResponse();
        response.setRate(desgravamenDocument.getRate());
        return response;
    }
}
