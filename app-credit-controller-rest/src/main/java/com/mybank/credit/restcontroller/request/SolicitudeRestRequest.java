package com.mybank.credit.restcontroller.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class SolicitudeRestRequest {
    private String name;
    private String lastName;
    private String typeDocument;
    private String documentNumber;
    private String email;
    private String phone;
    private Integer amount;
    private Integer terms;
    private LocalDate disbursementDate;
}
