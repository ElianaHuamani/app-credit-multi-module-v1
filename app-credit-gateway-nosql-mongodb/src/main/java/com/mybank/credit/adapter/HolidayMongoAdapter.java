package com.mybank.credit.adapter;

import com.mybank.credit.document.HolidayDocument;
import com.mybank.credit.mapper.HolidayMongoAdapterMapper;
import com.mybank.credit.repository.HolidayMongoSpringDataRespository;
import com.mybank.credit.usecases.model.bd.HolidayBDResponse;
import com.mybank.credit.usecases.ports.out.HolidayQueryByDateBDGateway;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class HolidayMongoAdapter implements HolidayQueryByDateBDGateway {

    private final HolidayMongoAdapterMapper holidayMongoAdapterMapper;

    private final HolidayMongoSpringDataRespository holidayMongoSpringDataRespository;

    public HolidayMongoAdapter(HolidayMongoAdapterMapper holidayMongoAdapterMapper
            , HolidayMongoSpringDataRespository holidayMongoSpringDataRespository) {
        this.holidayMongoAdapterMapper = holidayMongoAdapterMapper;
        this.holidayMongoSpringDataRespository = holidayMongoSpringDataRespository;
    }

    @Override
    public HolidayBDResponse queryByDate(LocalDate date) {
        String localDateString = date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        Optional<HolidayDocument> optHolidayDocument = holidayMongoSpringDataRespository.findHolidayByDate(localDateString);
        return holidayMongoAdapterMapper.to(optHolidayDocument);
    }
}
