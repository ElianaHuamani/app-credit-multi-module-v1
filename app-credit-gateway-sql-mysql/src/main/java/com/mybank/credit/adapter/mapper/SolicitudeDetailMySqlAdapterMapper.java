package com.mybank.credit.adapter.mapper;

import com.mybank.credit.entity.SolicitudeDetailMySqlEntity;
import com.mybank.credit.usecases.model.bd.SolicitudeDetailBDRequestModel;
import com.mybank.credit.usecases.model.bd.SolicitudeDetailBDResponseModel;

import java.util.List;

public interface SolicitudeDetailMySqlAdapterMapper {
    List<SolicitudeDetailMySqlEntity> toListEntity(List<SolicitudeDetailBDRequestModel> lstRequest);
    List<SolicitudeDetailBDResponseModel> toList(List<SolicitudeDetailMySqlEntity> lstRequest);
}

