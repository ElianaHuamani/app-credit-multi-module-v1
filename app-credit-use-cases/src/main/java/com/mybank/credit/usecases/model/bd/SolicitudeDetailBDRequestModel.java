package com.mybank.credit.usecases.model.bd;

import java.time.LocalDate;

public class SolicitudeDetailBDRequestModel {
    private Long solicitudeId;
    private Integer termNumber;
    private Long passedPeriodDays;
    private LocalDate paymentDate;
    private Double principal;
    private Double amortization;
    private Double interest;
    private Double termAmount;
    private Double itf;
    private Double termAmountTotal;

    public Long getSolicitudeId() {
        return solicitudeId;
    }

    public void setSolicitudeId(Long solicitudeId) {
        this.solicitudeId = solicitudeId;
    }

    public Integer getTermNumber() {
        return termNumber;
    }

    public void setTermNumber(Integer termNumber) {
        this.termNumber = termNumber;
    }

    public Long getPassedPeriodDays() {
        return passedPeriodDays;
    }

    public void setPassedPeriodDays(Long passedPeriodDays) {
        this.passedPeriodDays = passedPeriodDays;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Double getPrincipal() {
        return principal;
    }

    public void setPrincipal(Double principal) {
        this.principal = principal;
    }

    public Double getAmortization() {
        return amortization;
    }

    public void setAmortization(Double amortization) {
        this.amortization = amortization;
    }

    public Double getInterest() {
        return interest;
    }

    public void setInterest(Double interest) {
        this.interest = interest;
    }

    public Double getTermAmount() {
        return termAmount;
    }

    public void setTermAmount(Double termAmount) {
        this.termAmount = termAmount;
    }

    public Double getItf() {
        return itf;
    }

    public void setItf(Double itf) {
        this.itf = itf;
    }

    public Double getTermAmountTotal() {
        return termAmountTotal;
    }

    public void setTermAmountTotal(Double termAmountTotal) {
        this.termAmountTotal = termAmountTotal;
    }
}
