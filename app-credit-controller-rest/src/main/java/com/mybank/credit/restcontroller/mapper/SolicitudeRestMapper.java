package com.mybank.credit.restcontroller.mapper;

import com.mybank.credit.restcontroller.request.SolicitudeRestRequest;
import com.mybank.credit.restcontroller.response.SolicitudeRestResponse;
import com.mybank.credit.usecases.model.web.SolicitudeRequestModel;
import com.mybank.credit.usecases.model.web.SolicitudeResponseModel;

import java.util.List;
import java.util.Optional;

public interface SolicitudeRestMapper {
    List<SolicitudeRestResponse> toList(List<SolicitudeResponseModel> solicitudes);
    Optional<SolicitudeRestResponse> toOptional(Optional<SolicitudeResponseModel> solicitudeResponseModel);
    SolicitudeRequestModel to(SolicitudeRestRequest solicitudeRestRequest);
    SolicitudeRestResponse to(SolicitudeResponseModel solicitude);
}
