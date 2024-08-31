package com.mybank.credit.adapter.mapper;

import com.mybank.credit.entity.SolicitudeMySqlEntity;
import com.mybank.credit.usecases.model.bd.SolicitudeBDRequestModel;
import com.mybank.credit.usecases.model.bd.SolicitudeBDResponseModel;

import java.util.List;
import java.util.Optional;

public interface SolicitudeMySqlAdapterMapper {
    Optional<SolicitudeBDResponseModel> toOptional(Optional<SolicitudeMySqlEntity> optSolicitudeMySqlEntity);
    List<SolicitudeBDResponseModel> toList(List<SolicitudeMySqlEntity> solicitudes);
    SolicitudeMySqlEntity toEntity(SolicitudeBDRequestModel requestBDModel);
}
