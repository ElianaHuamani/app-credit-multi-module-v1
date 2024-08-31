package com.mybank.credit.usecases.model.web;

import java.time.LocalDate;
import java.util.List;

public class SolicitudeResponseModel {
    private Long  solicitudeId;
    private String name;
    private String lastName;
    private Integer amount;
    private String email;
    private String phone;
    private LocalDate disbursementDate;
    private Integer terms;
    private Double tea;
    private Double termAmount;
    private Double totalAmount;

    private List<SolicitudeDetailResponseModel> lstSolicitudeDetailResponseModel;


    public Long getSolicitudeId() {
        return solicitudeId;
    }

    public void setSolicitudeId(Long solicitudeId) {
        this.solicitudeId = solicitudeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getDisbursementDate() {
        return disbursementDate;
    }

    public void setDisbursementDate(LocalDate disbursementDate) {
        this.disbursementDate = disbursementDate;
    }

    public Integer getTerms() {
        return terms;
    }

    public void setTerms(Integer terms) {
        this.terms = terms;
    }

    public Double getTea() {
        return tea;
    }

    public void setTea(Double tea) {
        this.tea = tea;
    }

    public Double getTermAmount() {
        return termAmount;
    }

    public void setTermAmount(Double termAmount) {
        this.termAmount = termAmount;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<SolicitudeDetailResponseModel> getLstSolicitudeDetailResponseModel() {
        return lstSolicitudeDetailResponseModel;
    }

    public void setLstSolicitudeDetailResponseModel(List<SolicitudeDetailResponseModel> lstSolicitudeDetailResponseModel) {
        this.lstSolicitudeDetailResponseModel = lstSolicitudeDetailResponseModel;
    }
}
