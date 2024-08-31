package com.mybank.credit.usecases.service;

import com.mybank.credit.entities.Solicitude;
import com.mybank.credit.entities.exceptions.SolicitudeException;
import com.mybank.credit.entities.factory.SolicitudeFactory;
import com.mybank.credit.usecases.common.CustomPage;
import com.mybank.credit.usecases.exception.UseCaseException;
import com.mybank.credit.usecases.mapper.SolicitudeDetailMapper;
import com.mybank.credit.usecases.mapper.SolicitudeMapper;
import com.mybank.credit.usecases.model.bd.*;
import com.mybank.credit.usecases.model.web.GenericResponseModel;
import com.mybank.credit.usecases.model.web.SolicitudeDetailResponseModel;
import com.mybank.credit.usecases.model.web.SolicitudeRequestModel;
import com.mybank.credit.usecases.model.web.SolicitudeResponseModel;
import com.mybank.credit.usecases.ports.in.SolicitudeQueryBySolicitudeId;
import com.mybank.credit.usecases.ports.in.SolicitudeQueryByTypeDocAndDocNumber;
import com.mybank.credit.usecases.ports.in.SolicitudeSaveUseCase;
import com.mybank.credit.usecases.ports.out.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import static com.mybank.credit.usecases.common.GlobalUseCaseConstant.ITF;
import static com.mybank.credit.usecases.common.GlobalUseCaseConstant.TEA;
import static java.time.temporal.ChronoUnit.DAYS;

public class SolicitudeInteractor implements
        SolicitudeQueryBySolicitudeId
        , SolicitudeQueryByTypeDocAndDocNumber
        , SolicitudeSaveUseCase
{
    //solicitude
    private final SolicitudeQueryBySolicitudeIdBDGateway solicitudeQueryBySolicitudeIdBDGateway;
    private final SolicitudeQueryByTypeDocAndDocNumberBDGateway solicitudeQueryByTypeDocAndDocNumberBDGateway;
    private final SolicitudeSaveBDGateway solicitudeSaveBDGateway;
    private final SolicitudeQueryHasCurrentCreditBDGateway solicitudeQueryHasCurrentCreditBDGateway;
    private final SolicitudeFactory solicitudeFactory;
    private final SolicitudeMapper solicitudeMapper;


    // campaign & desgravamen & holiday
    private final CampaignQueryByTypeDocAndDocNumberBDGateway campaignQueryByTypeDocAndDocNumberBDGateway;
    private final DesgravamenQueryByTermsBDGateway desgravamenQueryByTermsBDGateway;
    private final HolidayQueryByDateBDGateway holidayQueryByDateBDGateway;

    //solicitude detail
    private final SolicitudeDetailSaveBDGateway solicitudeDetailSaveBDGateway;
    private final SolicitudeDetailQueryBySolicitudeIdBDGateway solicitudeDetailQueryBySolicitudeIdBDGateway;
    private final SolicitudeDetailMapper solicitudeDetailMapper;


    public SolicitudeInteractor(final SolicitudeFactory solicitudeFactory
            , final SolicitudeQueryBySolicitudeIdBDGateway solicitudeQueryBySolicitudeIdBDGateway
            , final SolicitudeMapper solicitudeMapper
            , final SolicitudeQueryByTypeDocAndDocNumberBDGateway solicitudeQueryByTypeDocAndDocNumberBDGateway
            , final SolicitudeSaveBDGateway solicitudeSaveBDGateway
            , final SolicitudeQueryHasCurrentCreditBDGateway solicitudeQueryHasCurrentCreditBDGateway
            , final CampaignQueryByTypeDocAndDocNumberBDGateway campaignQueryByTypeDocAndDocNumberBDGateway
            , final DesgravamenQueryByTermsBDGateway desgravamenQueryByTermsBDGateway
            , final HolidayQueryByDateBDGateway holidayQueryByDateBDGateway
            , final SolicitudeDetailSaveBDGateway solicitudeDetailSaveBDGateway
            , final SolicitudeDetailQueryBySolicitudeIdBDGateway solicitudeDetailQueryBySolicitudeIdBDGateway
            , final SolicitudeDetailMapper solicitudeDetailMapper
    ) {
        this.solicitudeFactory = solicitudeFactory;
        this.solicitudeQueryBySolicitudeIdBDGateway = solicitudeQueryBySolicitudeIdBDGateway;
        this.solicitudeMapper = solicitudeMapper;
        this.solicitudeQueryByTypeDocAndDocNumberBDGateway = solicitudeQueryByTypeDocAndDocNumberBDGateway;
        this.solicitudeSaveBDGateway = solicitudeSaveBDGateway;
        this.solicitudeQueryHasCurrentCreditBDGateway = solicitudeQueryHasCurrentCreditBDGateway;
        this.campaignQueryByTypeDocAndDocNumberBDGateway = campaignQueryByTypeDocAndDocNumberBDGateway;
        this.desgravamenQueryByTermsBDGateway = desgravamenQueryByTermsBDGateway;
        this.holidayQueryByDateBDGateway = holidayQueryByDateBDGateway;
        this.solicitudeDetailSaveBDGateway = solicitudeDetailSaveBDGateway;
        this.solicitudeDetailQueryBySolicitudeIdBDGateway = solicitudeDetailQueryBySolicitudeIdBDGateway;
        this.solicitudeDetailMapper = solicitudeDetailMapper;
    }

    @Override
    public Optional<SolicitudeResponseModel> queryBySolicitudeId(Long solicitudeId) throws UseCaseException {
        Optional<SolicitudeResponseModel> responseModel = solicitudeMapper
                .toOptional(solicitudeQueryBySolicitudeIdBDGateway.queryBySolicitudeId(solicitudeId));

        if (responseModel.isPresent()) {
            List<SolicitudeDetailBDResponseModel> lstSolicitudeDetailBDResponseModel = solicitudeDetailQueryBySolicitudeIdBDGateway
                    .queryBySolicitudeId(solicitudeId);
            List<SolicitudeDetailResponseModel> lstSolicitudeDetailResponseModel = solicitudeDetailMapper
                    .toList(lstSolicitudeDetailBDResponseModel);

            responseModel.get().setLstSolicitudeDetailResponseModel(lstSolicitudeDetailResponseModel);
        }
        return responseModel;
    }

    @Override
    public List<SolicitudeResponseModel> queryByTypeDocAndDocNumber(CustomPage customPage
            , String typeDocument, String documentNumber) throws UseCaseException {
        return solicitudeMapper.toList(solicitudeQueryByTypeDocAndDocNumberBDGateway
                .queryByTypeDocAndDocNumber(customPage, typeDocument, documentNumber));
    }

    @Override
    public GenericResponseModel save(SolicitudeRequestModel request) throws UseCaseException {
        try {
            //validations::
            validateCurrentSolicitude(request);
            Optional<CampaignBDResponseModel> optCampaignBDResponseModel = isRisky(request);

            //calculate schedule payment
            Double tea = getTea(optCampaignBDResponseModel);
            Double rateDesgravamen = getDesgravamenRate(request);
            request.setTea(tea);


            List<SolicitudeDetailBDRequestModel> lstSolicitudeDetailBDRequestModel = new ArrayList<>();
            calculatePaymentSchedule(request, lstSolicitudeDetailBDRequestModel, rateDesgravamen);

            //save solicitude
            GenericResponseModel responseModel = saveSolicitude(request);

            lstSolicitudeDetailBDRequestModel.stream().forEach( l -> l.setSolicitudeId(responseModel.getSolicitudeId()));

            //save solicitudeDetail
            saveSolicitudeDetail(lstSolicitudeDetailBDRequestModel);

            return responseModel;

        } catch (SolicitudeException e) {
            throw new UseCaseException(e.getMessage());
        }
    }

    private void calculatePaymentSchedule(SolicitudeRequestModel solicitudeRequestModel
            , List<SolicitudeDetailBDRequestModel> lstSolicitudeDetailBDRequestModel
            , Double desgravamen) {
        Integer amount = solicitudeRequestModel.getAmount();
        LocalDate disbursementDate = solicitudeRequestModel.getDisbursementDate();
        Double tea = solicitudeRequestModel.getTea();
        Integer terms = solicitudeRequestModel.getTerms();

        Double itfAmount = getItfAmount((double) amount, ITF);
        Double rateAmount = getDesgravamen(amount, itfAmount, desgravamen);
        Double realAmount = Math.round((amount + itfAmount + rateAmount) * 100.0) / 100.0;
        Double ted = getTed(tea);

        int counter = 1;
        long passedDays = 0;
        long passedPeriodDays = 0;
        Double discountFactor = 0.0;
        Double sumDiscountFactor = 0.0;
        LocalDate nextDate = disbursementDate;
        LocalDate priorNextDate = disbursementDate;
        boolean isRightDate;

        while (counter <= terms) {
            nextDate = disbursementDate.plusMonths(counter);
            isRightDate = false;
            while (!isRightDate) {
                if (isValidDay(nextDate)) {
                    isRightDate = true;
                } else {
                    nextDate = nextDate.plusDays(1);
                }
            }
            passedDays = DAYS.between(disbursementDate, nextDate);
            discountFactor = 1.0 / Math.pow(1 + ted, (double) passedDays);
            sumDiscountFactor = sumDiscountFactor + discountFactor;
            passedPeriodDays = DAYS.between(priorNextDate, nextDate);
            priorNextDate = nextDate;

            SolicitudeDetailBDRequestModel solicitudeDetailBDRequestModel = new SolicitudeDetailBDRequestModel();
            solicitudeDetailBDRequestModel.setTermNumber(counter);
            solicitudeDetailBDRequestModel.setPaymentDate(nextDate);
            solicitudeDetailBDRequestModel.setPassedPeriodDays(passedPeriodDays);
            lstSolicitudeDetailBDRequestModel.add(solicitudeDetailBDRequestModel);

            counter++;
        }

        Double termAmount = realAmount / sumDiscountFactor;
        termAmount = Math.floor(termAmount * 100) / 100;
        solicitudeRequestModel.setTermAmount(termAmount);

        counter = 1;
        Double interest = 0.0;
        Double amortization = 0.0;
        Double principal = realAmount;
        Double itfTermAmount = 0.0;
        Double termAmountTotal = 0.0;
        Double sumTermAmountTotal = 0.0;
        while (counter <= terms) {
            SolicitudeDetailBDRequestModel solicitudeDetailBDRequestModel = lstSolicitudeDetailBDRequestModel.get(counter - 1);
            passedPeriodDays = solicitudeDetailBDRequestModel.getPassedPeriodDays();
            if (counter < terms) {
                interest = (principal * (Math.pow(1.0 + ted, passedPeriodDays) - 1));
                interest = Math.round(interest * 100.0) / 100.0;
                amortization = termAmount - interest;
                principal = principal - amortization;
                itfTermAmount = getItfAmount(termAmount, ITF);
                termAmountTotal = termAmount + itfTermAmount;
            } else {
                interest = (principal * (Math.pow(1.0 + ted, passedPeriodDays) - 1));
                interest = Math.round(interest * 100.0) / 100.0;
                amortization = principal;
                termAmount = amortization + interest;
                principal = principal - amortization;
                itfTermAmount = getItfAmount(termAmount, ITF);
                termAmountTotal = termAmount + itfTermAmount;
            }

            solicitudeDetailBDRequestModel.setInterest(interest);
            solicitudeDetailBDRequestModel.setAmortization(amortization);
            solicitudeDetailBDRequestModel.setTermAmount(termAmount);
            solicitudeDetailBDRequestModel.setPrincipal(principal);
            solicitudeDetailBDRequestModel.setItf(itfTermAmount);
            solicitudeDetailBDRequestModel.setTermAmountTotal(termAmountTotal);

            sumTermAmountTotal = sumTermAmountTotal + termAmountTotal;
            counter++;
        }
        solicitudeRequestModel.setTotalAmount(sumTermAmountTotal);
    }

    private Double getDesgravamenRate(SolicitudeRequestModel request) throws UseCaseException {
        DesgravamenBDResponse desgravamenBDResponse = desgravamenQueryByTermsBDGateway.queryByTerms(request.getTerms());
        return desgravamenBDResponse.getRate();
    }

    private Double getTea(Optional<CampaignBDResponseModel> optCampaignBDResponseModel) {
        return optCampaignBDResponseModel.isPresent() ? optCampaignBDResponseModel.get().getTea() : TEA;
    }

    private void validateCurrentSolicitude(SolicitudeRequestModel request) throws UseCaseException {
        //validation exist current solicitude
        Integer counter = solicitudeQueryHasCurrentCreditBDGateway
                .hasCurrentCredit(request.getTypeDocument(), request.getDocumentNumber(), LocalDate.now());

        if (counter > 0) {
            throw new UseCaseException("Existe una solicitude vigente");
        }
    }

    private Optional<CampaignBDResponseModel> isRisky(SolicitudeRequestModel request) throws UseCaseException {
        //validation isRisky
        Optional<CampaignBDResponseModel> optCampaignBDResponseModel = campaignQueryByTypeDocAndDocNumberBDGateway
                .queryByTypeDocAndDocNumber(request.getTypeDocument(),request.getDocumentNumber());

        if (optCampaignBDResponseModel.isPresent() && optCampaignBDResponseModel.get().isRisk()) {
            throw new UseCaseException("Usuario se encuentra en riesgo alto.");
        }

        return optCampaignBDResponseModel;
    }

    private GenericResponseModel saveSolicitude(SolicitudeRequestModel request) throws SolicitudeException, UseCaseException {
        Solicitude solicitude = solicitudeFactory.create(
                request.getName()
                , request.getLastName()
                , request.getTypeDocument()
                , request.getDocumentNumber()
                , request.getEmail()
                , request.getPhone()
                , request.getAmount()
                , request.getDisbursementDate()
                , request.getTerms()
                , request.getTea()
                , request.getTermAmount()
                , request.getTotalAmount()
                , LocalDate.now().plusMonths(1)
        );

        SolicitudeBDRequestModel requestBDModel = new SolicitudeBDRequestModel();
        requestBDModel.setName(solicitude.getName());
        requestBDModel.setLastName(solicitude.getLastName());
        requestBDModel.setTypeDocument(solicitude.getTypeDocument());
        requestBDModel.setDocumentNumber(solicitude.getDocumentNumber());
        requestBDModel.setAmount(solicitude.getAmount());
        requestBDModel.setEmail(solicitude.getEmail());
        requestBDModel.setPhone(solicitude.getPhone());
        requestBDModel.setEndDate(solicitude.getEndDate());
        requestBDModel.setDisbursementDate(solicitude.getDisbursementDate());
        requestBDModel.setTerms(solicitude.getTerms());
        requestBDModel.setTea(solicitude.getTea());
        requestBDModel.setTermAmount(solicitude.getTermAmount());
        requestBDModel.setTotalAmount(solicitude.getTotalAmount());
        requestBDModel.setStatus(solicitude.getStatus().getKey());
        GenericResponseModel responseModel = solicitudeSaveBDGateway.save(requestBDModel);
        return responseModel;
    }

    private void saveSolicitudeDetail(List<SolicitudeDetailBDRequestModel> lstSolicitudeDetailBDRequestModel) throws UseCaseException {
        solicitudeDetailSaveBDGateway.saveAll(lstSolicitudeDetailBDRequestModel);
    }

    private boolean isValidDay(LocalDate nextDate) {
        int dayNumber = nextDate.getDayOfMonth();
        HolidayBDResponse holidayBDResponse = holidayQueryByDateBDGateway.queryByDate(nextDate);
        return dayNumber != Calendar.SATURDAY && dayNumber != Calendar.SUNDAY && !holidayBDResponse.isHoliday();
    }

    private Double getTed(Double tea) {
        tea = tea / 100;
        return Math.pow( (1 + tea) , 1.0 / 360.0) - 1;
    }

    private Double getDesgravamen(Integer amount, Double amountItf, Double desgravamen) {
        desgravamen = desgravamen / 100;
        return ((amount + amountItf) * desgravamen) / (1 - desgravamen);
    }

    private Double getItfAmount(Double amount, Double itf) {
        itf = itf / 100;

        Double itfAmount1 = 0.0;
        Double itfAmount2 = 0.0;

        if ((((amount / (1 - itf)) - amount) * 100 % 10) >= 5) {
            itfAmount1 = 5.0;
        }
        itfAmount1 = itfAmount1 / 100;

        itfAmount2 = (amount / (1 - itf)) - amount;
        itfAmount2 = Math.floor(itfAmount2 * 10) / 10;

        return itfAmount2 + itfAmount1;
    }
}
