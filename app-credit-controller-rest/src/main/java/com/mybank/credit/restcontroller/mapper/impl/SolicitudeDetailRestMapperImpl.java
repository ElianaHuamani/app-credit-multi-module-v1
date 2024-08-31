package com.mybank.credit.restcontroller.mapper.impl;

import com.mybank.credit.restcontroller.mapper.SolicitudeDetailRestMapper;
import com.mybank.credit.restcontroller.response.SolicitudeDetailRestResponse;
import com.mybank.credit.restcontroller.response.SolicitudeRestResponse;
import com.mybank.credit.usecases.model.web.SolicitudeDetailResponseModel;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

public class SolicitudeDetailRestMapperImpl implements SolicitudeDetailRestMapper {
    @Override
    public List<SolicitudeDetailRestResponse> toList(List<SolicitudeDetailResponseModel> lstSolicitudeDetailResponseModel) {
        return lstSolicitudeDetailResponseModel.stream().map(e -> to(e)).collect(Collectors.toList());
    }

    private SolicitudeDetailRestResponse to(SolicitudeDetailResponseModel solicitudeDetailResponseModel) {
        if (isNull(solicitudeDetailResponseModel)) {
            SolicitudeRestResponse.builder().build();
        }
        return SolicitudeDetailRestResponse.builder()
                .termNumber(solicitudeDetailResponseModel.getTermNumber())
                .paymentDate(solicitudeDetailResponseModel.getPaymentDate())
                .principal(solicitudeDetailResponseModel.getPrincipal())
                .amortization(solicitudeDetailResponseModel.getAmortization())
                .interest(solicitudeDetailResponseModel.getInterest())
                .termAmount(solicitudeDetailResponseModel.getTermAmount())
                .itf(solicitudeDetailResponseModel.getItf())
                .termAmountTotal(solicitudeDetailResponseModel.getTermAmountTotal())
                .build();
    }
}
