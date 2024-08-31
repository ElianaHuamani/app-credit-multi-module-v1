package com.mybank.credit.usecases.ports.out;

import com.mybank.credit.usecases.model.bd.HolidayBDResponse;

import java.time.LocalDate;

@FunctionalInterface
public interface HolidayQueryByDateBDGateway {
    HolidayBDResponse queryByDate(LocalDate date);
}
