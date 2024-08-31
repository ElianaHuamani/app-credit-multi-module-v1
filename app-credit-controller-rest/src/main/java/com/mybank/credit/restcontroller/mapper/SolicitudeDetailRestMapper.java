package com.mybank.credit.restcontroller.mapper;

import com.mybank.credit.restcontroller.response.SolicitudeDetailRestResponse;
import com.mybank.credit.usecases.model.web.SolicitudeDetailResponseModel;

import java.util.List;

public interface SolicitudeDetailRestMapper {
    List<SolicitudeDetailRestResponse> toList(List<SolicitudeDetailResponseModel> lstSolicitudeDetailResponseModel);
}
