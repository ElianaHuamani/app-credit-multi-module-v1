package com.mybank.credit.adapter.mapper.impl;

import com.mybank.credit.adapter.mapper.SolicitudeDetailMySqlAdapterMapper;
import com.mybank.credit.entity.SolicitudeDetailMySqlEntity;
import com.mybank.credit.usecases.model.bd.SolicitudeDetailBDRequestModel;
import com.mybank.credit.usecases.model.bd.SolicitudeDetailBDResponseModel;

import java.util.List;
import java.util.stream.Collectors;

public class SolicitudeDetailMySqlAdapterMapperImpl implements SolicitudeDetailMySqlAdapterMapper {
    @Override
    public List<SolicitudeDetailMySqlEntity> toListEntity(List<SolicitudeDetailBDRequestModel> lstRequest) {
        return lstRequest.stream().map(e -> toEntity(e)).collect(Collectors.toList());
    }

    @Override
    public List<SolicitudeDetailBDResponseModel> toList(List<SolicitudeDetailMySqlEntity> lstRequest) {
        return lstRequest.stream().map(e -> to(e)).collect(Collectors.toList());
    }

    private SolicitudeDetailMySqlEntity toEntity(SolicitudeDetailBDRequestModel requestBDModel) {
        SolicitudeDetailMySqlEntity entity = new SolicitudeDetailMySqlEntity();
        entity.setSolicitudeId(requestBDModel.getSolicitudeId());
        entity.setTermNumber(requestBDModel.getTermNumber());
        entity.setPaymentDate(requestBDModel.getPaymentDate());
        entity.setPrincipal(requestBDModel.getPrincipal());
        entity.setAmortization(requestBDModel.getAmortization());
        entity.setInterest(requestBDModel.getInterest());
        entity.setTermAmount(requestBDModel.getTermAmount());
        entity.setItf(requestBDModel.getItf());
        entity.setTermAmountTotal(requestBDModel.getTermAmountTotal());
        return entity;
    }

    private SolicitudeDetailBDResponseModel to(SolicitudeDetailMySqlEntity entity) {
        SolicitudeDetailBDResponseModel responseBDModel = new SolicitudeDetailBDResponseModel();
        responseBDModel.setTermNumber(entity.getTermNumber());
        responseBDModel.setPaymentDate(entity.getPaymentDate());
        responseBDModel.setPrincipal(entity.getPrincipal());
        responseBDModel.setAmortization(entity.getAmortization());
        responseBDModel.setInterest(entity.getInterest());
        responseBDModel.setTermAmount(entity.getTermAmount());
        responseBDModel.setItf(entity.getItf());
        responseBDModel.setTermAmountTotal(entity.getTermAmountTotal());
        return responseBDModel;
    }


}
