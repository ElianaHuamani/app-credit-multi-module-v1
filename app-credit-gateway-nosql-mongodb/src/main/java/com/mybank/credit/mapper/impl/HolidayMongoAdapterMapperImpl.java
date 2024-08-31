package com.mybank.credit.mapper.impl;

import com.mybank.credit.document.HolidayDocument;
import com.mybank.credit.mapper.HolidayMongoAdapterMapper;
import com.mybank.credit.usecases.model.bd.HolidayBDResponse;

import java.util.Optional;

public class HolidayMongoAdapterMapperImpl implements HolidayMongoAdapterMapper {
    @Override
    public HolidayBDResponse to(Optional<HolidayDocument> optHolidayDocument) {
        HolidayBDResponse responseModel = new HolidayBDResponse();
        responseModel.setHoliday(false);
        if (optHolidayDocument.isPresent()) {
            responseModel.setHoliday(true);
        }
        return responseModel;
    }
}
