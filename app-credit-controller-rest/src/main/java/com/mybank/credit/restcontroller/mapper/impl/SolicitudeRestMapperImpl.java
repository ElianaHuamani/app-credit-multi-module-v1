package com.mybank.credit.restcontroller.mapper.impl;

import com.mybank.credit.restcontroller.mapper.SolicitudeRestMapper;
import com.mybank.credit.restcontroller.request.SolicitudeRestRequest;
import com.mybank.credit.restcontroller.response.SolicitudeRestResponse;
import com.mybank.credit.usecases.model.web.SolicitudeRequestModel;
import com.mybank.credit.usecases.model.web.SolicitudeResponseModel;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

public class SolicitudeRestMapperImpl implements SolicitudeRestMapper {
    @Override
    public List<SolicitudeRestResponse> toList(List<SolicitudeResponseModel> solicitudes) {
        return solicitudes.stream().map(e -> to(e)).collect(Collectors.toList());
    }

    @Override
    public Optional<SolicitudeRestResponse> toOptional(Optional<SolicitudeResponseModel> solicitudeResponseModel) {
        if (solicitudeResponseModel.isPresent()) {
            return Optional.ofNullable(this.to(solicitudeResponseModel.get()));
        }
        return Optional.empty();
    }

    @Override
    public SolicitudeRequestModel to(SolicitudeRestRequest solicitudeRestRequest) {
        SolicitudeRequestModel solicitudeRequestModel = new SolicitudeRequestModel();
        solicitudeRequestModel.setName(solicitudeRestRequest.getName());
        solicitudeRequestModel.setLastName(solicitudeRestRequest.getLastName());
        solicitudeRequestModel.setTypeDocument(solicitudeRestRequest.getTypeDocument());
        solicitudeRequestModel.setDocumentNumber(solicitudeRestRequest.getDocumentNumber());
        solicitudeRequestModel.setPhone(solicitudeRestRequest.getPhone());
        solicitudeRequestModel.setEmail(solicitudeRestRequest.getEmail());
        solicitudeRequestModel.setAmount(solicitudeRestRequest.getAmount());
        solicitudeRequestModel.setTerms(solicitudeRestRequest.getTerms());
        solicitudeRequestModel.setDisbursementDate(solicitudeRestRequest.getDisbursementDate());
        return solicitudeRequestModel;
    }

    @Override
    public SolicitudeRestResponse to(SolicitudeResponseModel solicitude) {
        if (isNull(solicitude)) {
            SolicitudeRestResponse.builder().build();
        }
        return SolicitudeRestResponse.builder()
                .solicitudeId(solicitude.getSolicitudeId())
                .name(solicitude.getName())
                .lastName(solicitude.getLastName())
                .amount(solicitude.getAmount())
                .email(solicitude.getEmail())
                .disbursementDate(solicitude.getDisbursementDate())
                .terms(solicitude.getTerms())
                .tea(solicitude.getTea())
                .termAmount(solicitude.getTermAmount())
                .totalAmount(solicitude.getTotalAmount())
                .build();
    }
}
