package com.mybank.credit.configuration;

import com.mybank.credit.entities.factory.SolicitudeFactory;
import com.mybank.credit.entities.factory.impl.SolicitudeFactoryImpl;
import com.mybank.credit.usecases.mapper.SolicitudeDetailMapper;
import com.mybank.credit.usecases.mapper.SolicitudeMapper;
import com.mybank.credit.usecases.mapper.impl.SolicitudeDetailMapperImpl;
import com.mybank.credit.usecases.mapper.impl.SolicitudeMapperImpl;
import com.mybank.credit.usecases.ports.out.*;
import com.mybank.credit.usecases.service.SolicitudeInteractor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GlobalConfig {

    @Bean
    public SolicitudeFactory solicitudeFactory() {
        return new SolicitudeFactoryImpl();
    }

    @Bean
    SolicitudeMapper solicitudeMapper() {
        return new SolicitudeMapperImpl();
    }

    @Bean
    SolicitudeDetailMapper solicitudeDetailMapper() {
        return new SolicitudeDetailMapperImpl();
    }

    @Bean
    public SolicitudeInteractor solicitudeInteractor(
            SolicitudeFactory solicitudeFactory
            , SolicitudeQueryBySolicitudeIdBDGateway solicitudeQueryBySolicitudeIdBDGateway
            , SolicitudeMapper solicitudeMapper
            , SolicitudeQueryByTypeDocAndDocNumberBDGateway solicitudeQueryByTypeDocAndDocNumberBDGateway
            , SolicitudeSaveBDGateway solicitudeSaveBDGateway
            , SolicitudeQueryHasCurrentCreditBDGateway solicitudeQueryHasCurrentCreditBDGateway
            , CampaignQueryByTypeDocAndDocNumberBDGateway campaignQueryByTypeDocAndDocNumberBDGateway
            , DesgravamenQueryByTermsBDGateway desgravamenQueryByTermsBDGateway
            , HolidayQueryByDateBDGateway holidayQueryByDateBDGateway
            , SolicitudeDetailSaveBDGateway solicitudeDetailSaveBDGateway
            , SolicitudeDetailQueryBySolicitudeIdBDGateway solicitudeDetailQueryBySolicitudeIdBDGateway
            , SolicitudeDetailMapper solicitudeDetailMapper
    ) {
        return new SolicitudeInteractor(solicitudeFactory
                , solicitudeQueryBySolicitudeIdBDGateway
                , solicitudeMapper
                , solicitudeQueryByTypeDocAndDocNumberBDGateway
                , solicitudeSaveBDGateway
                , solicitudeQueryHasCurrentCreditBDGateway
                , campaignQueryByTypeDocAndDocNumberBDGateway
                , desgravamenQueryByTermsBDGateway
                , holidayQueryByDateBDGateway
                , solicitudeDetailSaveBDGateway
                , solicitudeDetailQueryBySolicitudeIdBDGateway
                , solicitudeDetailMapper
        );
    }
}
