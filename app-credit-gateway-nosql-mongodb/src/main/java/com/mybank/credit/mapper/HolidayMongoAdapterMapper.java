package com.mybank.credit.mapper;

import com.mybank.credit.document.HolidayDocument;
import com.mybank.credit.usecases.model.bd.HolidayBDResponse;

import java.util.Optional;

public interface HolidayMongoAdapterMapper {
    HolidayBDResponse to(Optional<HolidayDocument> optHolidayDocument);
}
