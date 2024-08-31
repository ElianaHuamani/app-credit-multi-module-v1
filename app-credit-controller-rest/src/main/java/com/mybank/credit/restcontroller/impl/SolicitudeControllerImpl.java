package com.mybank.credit.restcontroller.impl;

import com.mybank.credit.presenter.SolicitudePresenter;
import com.mybank.credit.restcontroller.SolicitudeController;
import com.mybank.credit.restcontroller.commons.CustomResponse;
import com.mybank.credit.restcontroller.commons.GenericRestController;
import com.mybank.credit.restcontroller.mapper.SolicitudeDetailRestMapper;
import com.mybank.credit.restcontroller.mapper.SolicitudeRestMapper;
import com.mybank.credit.restcontroller.request.SolicitudeRestRequest;
import com.mybank.credit.restcontroller.response.SolicitudeDetailRestResponse;
import com.mybank.credit.restcontroller.response.SolicitudeRestResponse;
import com.mybank.credit.usecases.common.CustomPage;
import com.mybank.credit.usecases.exception.UseCaseException;
import com.mybank.credit.usecases.model.web.GenericResponseModel;
import com.mybank.credit.usecases.model.web.SolicitudeResponseModel;
import com.mybank.credit.usecases.service.SolicitudeInteractor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import static java.util.Objects.isNull;

@RestController
public class SolicitudeControllerImpl extends GenericRestController implements SolicitudeController {
    private final SolicitudeInteractor solicitudeInteractor;
    private final SolicitudeRestMapper solicitudeRestMapper;
    private final SolicitudePresenter solicitudePresenter;

    private final SolicitudeDetailRestMapper solicitudeDetailRestMapper;

    public SolicitudeControllerImpl(final SolicitudeInteractor solicitudeInteractor
                                    , final SolicitudeRestMapper solicitudeRestMapper
                                    , final SolicitudePresenter solicitudePresenter
                                    , final SolicitudeDetailRestMapper solicitudeDetailRestMapper
    ) {
        this.solicitudeInteractor = solicitudeInteractor;
        this.solicitudeRestMapper = solicitudeRestMapper;
        this.solicitudePresenter = solicitudePresenter;
        this.solicitudeDetailRestMapper = solicitudeDetailRestMapper;
    }

    @Override
    public ResponseEntity<CustomResponse> findBySolicitudeId(Long idSolicitude) {
        try {
            Optional<SolicitudeResponseModel>  optSolicitudeResponseModel = solicitudeInteractor
                    .queryBySolicitudeId(idSolicitude);

            if (optSolicitudeResponseModel.isPresent()) {
                SolicitudeResponseModel solicitudeResponseModel = optSolicitudeResponseModel.get();

                List<SolicitudeDetailRestResponse> lstSolicitudeDetailRestResponse = solicitudeDetailRestMapper
                        .toList(solicitudeResponseModel.getLstSolicitudeDetailResponseModel());

                SolicitudeRestResponse solicitudeRestResponse = solicitudeRestMapper.to(solicitudeResponseModel);
                solicitudeRestResponse.setSolicitudeDetail(lstSolicitudeDetailRestResponse);
                return super.setResponse(solicitudeRestResponse);
            }
            return super.setResponse(null);

        } catch (UseCaseException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Override
    public ResponseEntity<CustomResponse> findAll(String typeDocument, String documentNumber
            , Integer size, Integer page) {
        try {
            CustomPage customPage = new CustomPage();
            if (isNull(page) || page <= 0) {
                page = 1;
            }
            customPage.setPage(page - 1);
            customPage.setSize(size);


            List<SolicitudeRestResponse> solicitudes = solicitudeRestMapper.toList(solicitudeInteractor
                    .queryByTypeDocAndDocNumber(customPage, typeDocument, documentNumber));

            return super.setListResponse(solicitudes);

        } catch (UseCaseException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Override
    public ResponseEntity<CustomResponse> save(SolicitudeRestRequest request) {
        try {
            GenericResponseModel genericResponseModel = solicitudeInteractor.save(solicitudeRestMapper.to(request));
            return super.ok(solicitudePresenter.getSolicitudeSuccessMessage(genericResponseModel));
        } catch (UseCaseException e) {
            return super.badRequest(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
