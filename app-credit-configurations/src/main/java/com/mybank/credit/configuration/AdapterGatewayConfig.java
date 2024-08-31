package com.mybank.credit.configuration;

import com.mybank.credit.adapter.*;
import com.mybank.credit.adapter.mapper.SolicitudeDetailMySqlAdapterMapper;
import com.mybank.credit.adapter.mapper.SolicitudeMySqlAdapterMapper;
import com.mybank.credit.adapter.mapper.impl.SolicitudeDetailMySqlAdapterMapperImpl;
import com.mybank.credit.adapter.mapper.impl.SolicitudeMySqlAdapterMapperImpl;
import com.mybank.credit.mapper.CampaignMongoAdapterMapper;
import com.mybank.credit.mapper.DesgravamenMongoAdapterMapper;
import com.mybank.credit.mapper.HolidayMongoAdapterMapper;
import com.mybank.credit.mapper.impl.CampaignMongoAdapterMapperImpl;
import com.mybank.credit.mapper.impl.DesgravamenMongoAdapterMapperImpl;
import com.mybank.credit.mapper.impl.HolidayMongoAdapterMapperImpl;
import com.mybank.credit.repository.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AdapterGatewayConfig {
    @Bean
    public SolicitudeMySqlAdapter mySqlAdapter(
            SolicitudeSpringDataRepository solicitudeSpringDataRepository
            , SolicitudeMySqlAdapterMapper solicitudeMySqlAdapterMapper) {
        return new SolicitudeMySqlAdapter(solicitudeSpringDataRepository, solicitudeMySqlAdapterMapper);
    }
    @Bean
    public SolicitudeMySqlAdapterMapper mySqlAdapterMapper() {
        return new SolicitudeMySqlAdapterMapperImpl();
    }

    @Bean
    public SolicitudeDetailMySqlAdapter solicitudeDetailMySqlAdapter(
            SolicitudeDetailSpringDataRepository solicitudeDetailSpringDataRepository
            , SolicitudeDetailMySqlAdapterMapper solicitudeDetailMySqlAdapterMapper) {
        return new SolicitudeDetailMySqlAdapter(solicitudeDetailSpringDataRepository, solicitudeDetailMySqlAdapterMapper);
    }

    @Bean
    public SolicitudeDetailMySqlAdapterMapper solicitudeDetailMySqlAdapterMapper() {
        return new SolicitudeDetailMySqlAdapterMapperImpl();
    }

    @Bean
    public CampaignMongoAdapter campaignMongoAdapter(
            CampaignMongoSpringDataRespository campaignMongoSpringDataRespository
            , CampaignMongoAdapterMapper campaignMongoAdapterMapper) {
        return new CampaignMongoAdapter(campaignMongoSpringDataRespository, campaignMongoAdapterMapper);
    }
    @Bean
    public CampaignMongoAdapterMapper mongoAdapterMapper() {
        return new CampaignMongoAdapterMapperImpl();
    }

    @Bean
    public HolidayMongoAdapter holidayMongoAdapter(
            HolidayMongoSpringDataRespository holidayMongoSpringDataRespository
            , HolidayMongoAdapterMapper holidayMongoAdapterMapper) {
        return new HolidayMongoAdapter(holidayMongoAdapterMapper, holidayMongoSpringDataRespository);
    }
    @Bean
    public HolidayMongoAdapterMapper holidayMongoAdapterMapper() {
        return new HolidayMongoAdapterMapperImpl();
    }

    @Bean
    public DesgravamenMongoAdapter desgravamenMongoAdapter(
            DesgravamenMongoSpringDataRespository desgravamenMongoSpringDataRespository
            , DesgravamenMongoAdapterMapper desgravamenMongoAdapterMapper) {
        return new DesgravamenMongoAdapter(desgravamenMongoAdapterMapper, desgravamenMongoSpringDataRespository);
    }
    @Bean
    public DesgravamenMongoAdapterMapper desgravamenMongoAdapterMapper() {
        return new DesgravamenMongoAdapterMapperImpl();
    }

}
