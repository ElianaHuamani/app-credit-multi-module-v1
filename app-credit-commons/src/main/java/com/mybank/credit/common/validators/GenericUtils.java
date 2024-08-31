package com.mybank.credit.common.validators;

import static com.mybank.credit.common.constants.GenericContants.*;

public class GenericUtils {

    public static boolean isPhoneValid(String phone) {
        return phone.matches(REGEX_PHONE);
    }

    public static boolean isEmailValid(String email) {
        return email.matches(REGEX_EMAIL);
    }

    public static boolean isDocumentNumberValid(String documentNumber) {
        return documentNumber.matches(REGEX_DOC_NUMBER);
    }
}
