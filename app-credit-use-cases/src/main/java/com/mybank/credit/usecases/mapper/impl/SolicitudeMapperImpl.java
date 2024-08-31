package com.mybank.credit.usecases.mapper.impl;

import com.mybank.credit.usecases.mapper.SolicitudeMapper;
import com.mybank.credit.usecases.model.bd.SolicitudeBDResponseModel;
import com.mybank.credit.usecases.model.web.SolicitudeResponseModel;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class SolicitudeMapperImpl implements SolicitudeMapper {

    @Override
    public Optional<SolicitudeResponseModel> toOptional(Optional<SolicitudeBDResponseModel> solicitudeBDResponseModel) {
        if (solicitudeBDResponseModel.isPresent()) {
            return Optional.ofNullable(this.to(solicitudeBDResponseModel.get()));
        }
        return Optional.empty();
    }

    @Override
    public List<SolicitudeResponseModel> toList(List<SolicitudeBDResponseModel> solicitudes) {
        return solicitudes.stream().map(e -> to(e)).collect(Collectors.toList());
    }

    private SolicitudeResponseModel to(SolicitudeBDResponseModel solicitudeBDResponseModel) {
        SolicitudeResponseModel solicitudeResponseModel = new SolicitudeResponseModel();
        solicitudeResponseModel.setSolicitudeId(solicitudeBDResponseModel.getSolicitudeId());
        solicitudeResponseModel.setName(solicitudeBDResponseModel.getName());
        solicitudeResponseModel.setLastName(solicitudeBDResponseModel.getLastName());
        solicitudeResponseModel.setEmail(solicitudeBDResponseModel.getEmail());
        solicitudeResponseModel.setPhone(solicitudeBDResponseModel.getPhone());
        solicitudeResponseModel.setAmount(solicitudeBDResponseModel.getAmount());
        solicitudeResponseModel.setDisbursementDate(solicitudeBDResponseModel.getDisbursementDate());
        solicitudeResponseModel.setTerms(solicitudeBDResponseModel.getTerms());
        solicitudeResponseModel.setTea(solicitudeBDResponseModel.getTea());
        solicitudeResponseModel.setTermAmount(solicitudeBDResponseModel.getTermAmount());
        solicitudeResponseModel.setTotalAmount(solicitudeBDResponseModel.getTotalAmount());
        return solicitudeResponseModel;
    }
}
