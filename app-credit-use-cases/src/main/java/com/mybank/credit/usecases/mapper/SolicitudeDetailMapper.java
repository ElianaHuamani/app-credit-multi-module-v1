package com.mybank.credit.usecases.mapper;

import com.mybank.credit.usecases.model.bd.SolicitudeDetailBDResponseModel;
import com.mybank.credit.usecases.model.web.SolicitudeDetailResponseModel;

import java.util.List;

public interface SolicitudeDetailMapper {

    List<SolicitudeDetailResponseModel> toList(List<SolicitudeDetailBDResponseModel> lstSolicitudeDetailBDResponseModel);
}
