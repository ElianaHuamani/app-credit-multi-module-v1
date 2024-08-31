package com.mybank.credit.usecases.mapper;

import com.mybank.credit.usecases.model.bd.SolicitudeBDResponseModel;
import com.mybank.credit.usecases.model.web.SolicitudeResponseModel;

import java.util.List;
import java.util.Optional;

public interface SolicitudeMapper {
    Optional<SolicitudeResponseModel> toOptional(Optional<SolicitudeBDResponseModel> solicitudeBDResponseModel);
    List<SolicitudeResponseModel> toList(List<SolicitudeBDResponseModel> solicitudes);
}
