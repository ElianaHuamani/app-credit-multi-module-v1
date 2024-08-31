package com.mybank.credit.entities;

import com.mybank.credit.entities.enums.SolicitudeStatusEnum;

import java.time.LocalDate;

public interface Solicitude {
    String getName();
    String getLastName();
    String getTypeDocument();
    String getDocumentNumber();
    String getEmail();
    String getPhone();
    Integer getAmount();
    LocalDate getDisbursementDate();
    Integer getTerms();
    Double getTea();
    Double getTermAmount();
    Double getTotalAmount();
    SolicitudeStatusEnum getStatus();
    LocalDate getEndDate();
}
