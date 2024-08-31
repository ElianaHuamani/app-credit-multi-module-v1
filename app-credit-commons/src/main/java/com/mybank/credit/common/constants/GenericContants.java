package com.mybank.credit.common.constants;

public class GenericContants {
    private GenericContants() {
        throw new IllegalStateException("GenericContants is an utility class");
    }

    public static final String REGEX_PHONE = "^\\d{9}$";
    public static final String REGEX_DOC_NUMBER = "^\\d{8}$";
    public static final String REGEX_EMAIL = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";

}
