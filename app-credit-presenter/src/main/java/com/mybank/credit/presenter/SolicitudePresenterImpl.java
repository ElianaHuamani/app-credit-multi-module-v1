package com.mybank.credit.presenter;

import com.mybank.credit.usecases.model.web.GenericResponseModel;

public class SolicitudePresenterImpl implements SolicitudePresenter {
    @Override
    public String getSolicitudeSuccessMessage(GenericResponseModel genericResponseModel) {
        StringBuilder successMsg = new StringBuilder();
        successMsg.append("<b>Su solicitude se realizo exitosamente!</b>, aqui los detalles:<br>");
        successMsg.append("Codigo de la solicitud: ");
        successMsg.append("<b>");
        successMsg.append(genericResponseModel.getSolicitudeId());
        successMsg.append("</b>");
        return successMsg.toString();
    }
}
