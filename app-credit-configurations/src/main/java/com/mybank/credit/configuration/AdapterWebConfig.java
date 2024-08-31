package com.mybank.credit.configuration;

import com.mybank.credit.presenter.SolicitudePresenter;
import com.mybank.credit.presenter.SolicitudePresenterImpl;
import com.mybank.credit.restcontroller.mapper.SolicitudeDetailRestMapper;
import com.mybank.credit.restcontroller.mapper.SolicitudeRestMapper;
import com.mybank.credit.restcontroller.mapper.impl.SolicitudeDetailRestMapperImpl;
import com.mybank.credit.restcontroller.mapper.impl.SolicitudeRestMapperImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AdapterWebConfig {
    @Bean
    public SolicitudeRestMapper solicitudeRestMapper() {
        return new SolicitudeRestMapperImpl();
    }

    @Bean
    public SolicitudeDetailRestMapper solicitudeDetailRestMapper() {
        return new SolicitudeDetailRestMapperImpl();
    }

    @Bean
    public SolicitudePresenter solicitudePresenter() {
        return new SolicitudePresenterImpl();
    }
}
