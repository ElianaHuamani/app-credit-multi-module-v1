package com.mybank.credit.entities.impl;

import com.mybank.credit.entities.Solicitude;
import com.mybank.credit.entities.enums.SolicitudeStatusEnum;
import com.mybank.credit.entities.exceptions.SolicitudeException;
import com.mybank.credit.common.validators.GenericUtils;

import java.text.MessageFormat;
import java.time.LocalDate;

import static java.util.Objects.isNull;
import static com.mybank.credit.common.constants.GenericMessages.MSG_NULLVALUE;
import static com.mybank.credit.common.constants.GenericMessages.MSG_WRONGVALUE;

public class SolicitudeImpl implements Solicitude {
    private String name;
    private String lastName;
    private String typeDocument;
    private String documentNumber;
    private Integer amount;
    private String email;
    private String phone;
    private SolicitudeStatusEnum status;
    private LocalDate endDate;
    private LocalDate disbursementDate;
    private Integer terms;
    private Double tea;
    private Double termAmount;
    private Double totalAmount;

    public SolicitudeImpl(String name
            , String lastName
            , String typeDocument
            , String documentNumber
            , Integer amount
            , LocalDate disbursementDate
            , Integer terms
            , Double tea
            , Double termAmount
            , Double totalAmount
            , LocalDate endDate
    ) throws SolicitudeException {

        validateMandatoryFields(name, lastName, typeDocument, documentNumber, amount, endDate);
        validateDocumentNumber(documentNumber);
        this.name = name;
        this.lastName = lastName;
        this.typeDocument = typeDocument;
        this.documentNumber = documentNumber;
        this.amount = amount;
        this.disbursementDate = disbursementDate;
        this.terms = terms;
        this.tea = tea;
        this.termAmount = termAmount;
        this.totalAmount = totalAmount;
        this.endDate = endDate;
        this.status = SolicitudeStatusEnum.ACTIVE;
    }

    public SolicitudeImpl(String name
            , String lastName
            , String typeDocument
            , String documentNumber
            , String email
            , String phone
            , Integer amount
            , LocalDate disbursementDate
            , Integer terms
            , Double tea
            , Double termAmount
            , Double totalAmount
            , LocalDate endDate
    ) throws SolicitudeException {

        this(name, lastName, typeDocument, documentNumber
                , amount, disbursementDate, terms, tea, termAmount, totalAmount , endDate);
        validateEmail(email);
        validatePhone(phone);
        this.email = email;
        this.phone = phone;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getLastName() {
        return this.lastName;
    }

    @Override
    public String getTypeDocument() {
        return this.typeDocument;
    }

    @Override
    public String getDocumentNumber() {
        return this.documentNumber;
    }

    @Override
    public Integer getAmount() {
        return this.amount;
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public String getPhone() {
        return this.phone;
    }

    @Override
    public SolicitudeStatusEnum getStatus() {
        return this.status;
    }

    @Override
    public LocalDate getEndDate() {
        return this.endDate;
    }

    @Override
    public LocalDate getDisbursementDate() {
        return this.disbursementDate;
    }

    @Override
    public Integer getTerms() {
        return this.terms;
    }

    @Override
    public Double getTea() {
        return this.tea;
    }

    @Override
    public Double getTermAmount() {
        return this.termAmount;
    }

    @Override
    public Double getTotalAmount() {
        return this.totalAmount;
    }

    private void validateMandatoryFields(String name
            , String lastName, String typeDocument
            , String documentNumber, Integer amount, LocalDate endDate) throws SolicitudeException {

        if (isNull(name) || name.isBlank()) {
            throw new SolicitudeException(MessageFormat.format(MSG_NULLVALUE, "nombre"));
        }

        if (isNull(lastName) || lastName.isBlank()) {
            throw new SolicitudeException(MessageFormat.format(MSG_NULLVALUE, "apellidos"));
        }

        if (isNull(typeDocument) || typeDocument.isBlank()) {
            throw new SolicitudeException(MessageFormat.format(MSG_NULLVALUE, "tipo de documento"));
        }

        if (isNull(documentNumber) || documentNumber.isBlank()) {
            throw new SolicitudeException(MessageFormat.format(MSG_NULLVALUE, "numero de documento"));
        }

        if (isNull(amount)) {
            throw new SolicitudeException(MessageFormat.format(MSG_NULLVALUE, "monto"));
        }

        if (isNull(endDate)) {
            throw new SolicitudeException(MessageFormat.format(MSG_NULLVALUE, "fecha fin"));
        }
    }

    private void validateEmail(String email) throws SolicitudeException {
        if (isNull(email)) {
            throw new SolicitudeException(MessageFormat.format(MSG_NULLVALUE, "correo"));
        }

        if (!GenericUtils.isEmailValid(email)) {
            throw new SolicitudeException(MessageFormat.format(MSG_WRONGVALUE, "correo"));
        }
    }

    private void validatePhone(String phone) throws SolicitudeException {
        if (isNull(phone)) {
            throw new SolicitudeException(MessageFormat.format(MSG_NULLVALUE, "celular"));
        }

        if (!GenericUtils.isPhoneValid(phone)) {
            throw new SolicitudeException(MessageFormat.format(MSG_WRONGVALUE, "celular"));
        }
    }

    private void validateDocumentNumber(String documentNumber) throws SolicitudeException {
        if (isNull(documentNumber)) {
            throw new SolicitudeException(MessageFormat.format(MSG_NULLVALUE, "numero de documento"));
        }

        if (!GenericUtils.isDocumentNumberValid(documentNumber)) {
            throw new SolicitudeException(MessageFormat.format(MSG_WRONGVALUE, "numero de documento"));
        }
    }
}
