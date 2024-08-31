package com.mybank.credit.adapter;

import com.mybank.credit.adapter.mapper.SolicitudeDetailMySqlAdapterMapper;
import com.mybank.credit.repository.SolicitudeDetailSpringDataRepository;
import com.mybank.credit.usecases.exception.UseCaseException;
import com.mybank.credit.usecases.model.bd.SolicitudeDetailBDRequestModel;
import com.mybank.credit.usecases.model.bd.SolicitudeDetailBDResponseModel;
import com.mybank.credit.usecases.ports.out.SolicitudeDetailQueryBySolicitudeIdBDGateway;
import com.mybank.credit.usecases.ports.out.SolicitudeDetailSaveBDGateway;

import java.util.List;

public class SolicitudeDetailMySqlAdapter implements SolicitudeDetailSaveBDGateway
, SolicitudeDetailQueryBySolicitudeIdBDGateway
{

    private final SolicitudeDetailSpringDataRepository solicitudeDetailSpringDataRepository;
    private final SolicitudeDetailMySqlAdapterMapper solicitudeDetailMySqlAdapterMapper;

    public SolicitudeDetailMySqlAdapter(
            SolicitudeDetailSpringDataRepository solicitudeDetailSpringDataRepository
            , SolicitudeDetailMySqlAdapterMapper solicitudeDetailMySqlAdapterMapper)
    {
        this.solicitudeDetailSpringDataRepository = solicitudeDetailSpringDataRepository;
        this.solicitudeDetailMySqlAdapterMapper = solicitudeDetailMySqlAdapterMapper;
    }

    @Override
    public void saveAll(List<SolicitudeDetailBDRequestModel> lstRequest) throws UseCaseException {
        solicitudeDetailSpringDataRepository.saveAll(solicitudeDetailMySqlAdapterMapper.toListEntity(lstRequest));
    }

    @Override
    public List<SolicitudeDetailBDResponseModel> queryBySolicitudeId(Long solicitudeId) throws UseCaseException {
        return solicitudeDetailMySqlAdapterMapper.toList(solicitudeDetailSpringDataRepository.queryBySolicitudeId(solicitudeId));
    }
}
