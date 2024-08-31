package com.mybank.credit.entities.enums;

public enum SolicitudeStatusEnum {
    ACTIVE("A","Active"),
    INACTIVE("I","Inactive");

    private final String key;
    private final String value;

    SolicitudeStatusEnum(final String key, final String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
