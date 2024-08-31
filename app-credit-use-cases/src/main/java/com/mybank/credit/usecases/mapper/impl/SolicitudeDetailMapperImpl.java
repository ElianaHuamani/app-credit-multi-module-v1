package com.mybank.credit.usecases.mapper.impl;

import com.mybank.credit.usecases.mapper.SolicitudeDetailMapper;
import com.mybank.credit.usecases.model.bd.SolicitudeDetailBDResponseModel;
import com.mybank.credit.usecases.model.web.SolicitudeDetailResponseModel;

import java.util.List;
import java.util.stream.Collectors;

public class SolicitudeDetailMapperImpl implements SolicitudeDetailMapper {

    @Override
    public List<SolicitudeDetailResponseModel> toList(List<SolicitudeDetailBDResponseModel> lstSolicitudeDetailBDResponseModel) {
        return lstSolicitudeDetailBDResponseModel.stream().map(e -> to(e)).collect(Collectors.toList());
    }

    private SolicitudeDetailResponseModel to(SolicitudeDetailBDResponseModel solicitudeDetailBDResponseModel) {
        SolicitudeDetailResponseModel solicitudeDetailResponseModel = new SolicitudeDetailResponseModel();
        solicitudeDetailResponseModel.setTermNumber(solicitudeDetailBDResponseModel.getTermNumber());
        solicitudeDetailResponseModel.setPaymentDate(solicitudeDetailBDResponseModel.getPaymentDate());
        solicitudeDetailResponseModel.setPrincipal(solicitudeDetailBDResponseModel.getPrincipal());
        solicitudeDetailResponseModel.setAmortization(solicitudeDetailBDResponseModel.getAmortization());
        solicitudeDetailResponseModel.setInterest(solicitudeDetailBDResponseModel.getInterest());
        solicitudeDetailResponseModel.setTermAmount(solicitudeDetailBDResponseModel.getTermAmount());
        solicitudeDetailResponseModel.setItf(solicitudeDetailBDResponseModel.getItf());
        solicitudeDetailResponseModel.setTermAmountTotal(solicitudeDetailBDResponseModel.getTermAmountTotal());
        return solicitudeDetailResponseModel;
    }
}
