package com.mybank.credit.restcontroller.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@JsonPropertyOrder({"termNumber", "paymentDate", "principal", "amortization", "interest", "termAmount", "itf", "termAmountTotal"})
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class SolicitudeDetailRestResponse {
    private Integer termNumber;
    private LocalDate paymentDate;
    private Double principal;
    private Double amortization;
    private Double interest;
    private Double termAmount;
    private Double itf;
    private Double termAmountTotal;
}
