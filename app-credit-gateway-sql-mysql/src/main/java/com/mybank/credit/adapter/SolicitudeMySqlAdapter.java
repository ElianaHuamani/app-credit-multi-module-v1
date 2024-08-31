package com.mybank.credit.adapter;

import com.mybank.credit.adapter.mapper.SolicitudeMySqlAdapterMapper;
import com.mybank.credit.entity.SolicitudeMySqlEntity;
import com.mybank.credit.repository.SolicitudeSpringDataRepository;
import com.mybank.credit.usecases.common.CustomPage;
import com.mybank.credit.usecases.exception.UseCaseException;
import com.mybank.credit.usecases.model.bd.SolicitudeBDRequestModel;
import com.mybank.credit.usecases.model.bd.SolicitudeBDResponseModel;
import com.mybank.credit.usecases.model.web.GenericResponseModel;
import com.mybank.credit.usecases.ports.out.SolicitudeQueryBySolicitudeIdBDGateway;
import com.mybank.credit.usecases.ports.out.SolicitudeQueryByTypeDocAndDocNumberBDGateway;
import com.mybank.credit.usecases.ports.out.SolicitudeQueryHasCurrentCreditBDGateway;
import com.mybank.credit.usecases.ports.out.SolicitudeSaveBDGateway;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class SolicitudeMySqlAdapter implements
        SolicitudeQueryBySolicitudeIdBDGateway
        , SolicitudeQueryByTypeDocAndDocNumberBDGateway
        , SolicitudeSaveBDGateway
        , SolicitudeQueryHasCurrentCreditBDGateway
{
    private final SolicitudeSpringDataRepository solicitudeSpringDataRepository;
    private final SolicitudeMySqlAdapterMapper solicitudeMySqlAdapterMapper;

    public SolicitudeMySqlAdapter(final SolicitudeSpringDataRepository solicitudeSpringDataRepository
                                  , final SolicitudeMySqlAdapterMapper solicitudeMySqlAdapterMapper)
    {
        this.solicitudeSpringDataRepository = solicitudeSpringDataRepository;
        this.solicitudeMySqlAdapterMapper = solicitudeMySqlAdapterMapper;
    }

    @Override
    public Optional<SolicitudeBDResponseModel> queryBySolicitudeId(Long solicitudeId) throws UseCaseException {
        return solicitudeMySqlAdapterMapper.toOptional(solicitudeSpringDataRepository.queryBySolicitudeId(solicitudeId));
    }

    @Override
    public List<SolicitudeBDResponseModel> queryByTypeDocAndDocNumber(CustomPage customPage, String typeDocument
            , String documentNumber) throws UseCaseException {

        Pageable pageable = PageRequest.of(customPage.getPage(), customPage.getSize());

        List<SolicitudeMySqlEntity> solicitudes = solicitudeSpringDataRepository
                .queryByTypeDocAndDocNumber(pageable, typeDocument, documentNumber)
                .getContent();

        return solicitudeMySqlAdapterMapper.toList(solicitudes);
    }

    @Override
    public GenericResponseModel save(SolicitudeBDRequestModel request) throws UseCaseException {
        GenericResponseModel responseModel = new GenericResponseModel();
        SolicitudeMySqlEntity entity = solicitudeSpringDataRepository.save(solicitudeMySqlAdapterMapper.toEntity(request));
        responseModel.setSolicitudeId(entity.getSolicitudeId());
        return responseModel;
    }

    @Override
    public Integer hasCurrentCredit(String typeDocument, String documentNumber, LocalDate now)
            throws UseCaseException {
        return solicitudeSpringDataRepository.hasCurrentCredit(typeDocument, documentNumber, now);
    }
}
