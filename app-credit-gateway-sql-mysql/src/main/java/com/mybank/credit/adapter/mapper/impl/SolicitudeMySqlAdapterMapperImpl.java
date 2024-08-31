package com.mybank.credit.adapter.mapper.impl;

import com.mybank.credit.adapter.mapper.SolicitudeMySqlAdapterMapper;
import com.mybank.credit.entity.SolicitudeMySqlEntity;
import com.mybank.credit.usecases.model.bd.SolicitudeBDRequestModel;
import com.mybank.credit.usecases.model.bd.SolicitudeBDResponseModel;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class SolicitudeMySqlAdapterMapperImpl implements SolicitudeMySqlAdapterMapper {
    @Override
    public Optional<SolicitudeBDResponseModel> toOptional(Optional<SolicitudeMySqlEntity> optSolicitudeMySqlEntity) {
        if (optSolicitudeMySqlEntity.isPresent()) {
            return Optional.ofNullable(this.to(optSolicitudeMySqlEntity.get()));
        }
        return Optional.empty();
    }

    @Override
    public List<SolicitudeBDResponseModel> toList(List<SolicitudeMySqlEntity> solicitudes) {
        return solicitudes.stream().map(e -> to(e)).collect(Collectors.toList());
    }

    @Override
    public SolicitudeMySqlEntity toEntity(SolicitudeBDRequestModel requestBDModel) {
        SolicitudeMySqlEntity entity = new SolicitudeMySqlEntity();
        entity.setTypeDocument(requestBDModel.getTypeDocument());
        entity.setDocumentNumber(requestBDModel.getDocumentNumber());
        entity.setName(requestBDModel.getName());
        entity.setLastName(requestBDModel.getLastName());
        entity.setEmail(requestBDModel.getEmail());
        entity.setPhone(requestBDModel.getPhone());
        entity.setAmount(requestBDModel.getAmount());
        entity.setEndDate(requestBDModel.getEndDate());
        entity.setStatus(requestBDModel.getStatus());
        entity.setDisbursementDate(requestBDModel.getDisbursementDate());
        entity.setTerms(requestBDModel.getTerms());
        entity.setTea(requestBDModel.getTea());
        entity.setTermAmount(requestBDModel.getTermAmount());
        entity.setTotalAmount(requestBDModel.getTotalAmount());
        return entity;
    }

    private SolicitudeBDResponseModel to(SolicitudeMySqlEntity solicitudeMySqlEntity) {
        SolicitudeBDResponseModel responseModel = new SolicitudeBDResponseModel();
        responseModel.setSolicitudeId(solicitudeMySqlEntity.getSolicitudeId());
        responseModel.setName(solicitudeMySqlEntity.getName());
        responseModel.setLastName(solicitudeMySqlEntity.getLastName());
        responseModel.setEmail(solicitudeMySqlEntity.getEmail());
        responseModel.setPhone(solicitudeMySqlEntity.getPhone());
        responseModel.setAmount(solicitudeMySqlEntity.getAmount());
        responseModel.setDisbursementDate(solicitudeMySqlEntity.getDisbursementDate());
        responseModel.setTerms(solicitudeMySqlEntity.getTerms());
        responseModel.setTea(solicitudeMySqlEntity.getTea());
        responseModel.setTermAmount(solicitudeMySqlEntity.getTermAmount());
        responseModel.setTotalAmount(solicitudeMySqlEntity.getTotalAmount());
        return responseModel;
    }
}
