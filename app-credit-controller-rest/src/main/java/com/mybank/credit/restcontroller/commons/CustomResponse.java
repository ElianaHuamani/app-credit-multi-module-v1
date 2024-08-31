package com.mybank.credit.restcontroller.commons;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@Builder
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "response", "code", "message", "dateTime"})
public class CustomResponse {
    private String code;
    private String message;
    private Object response;
    public String getDateTime() {
        String pattern = "dd/MM/yyyy hh:mm:ss a";
        LocalDateTime now = LocalDateTime.now();
        return now.format(DateTimeFormatter.ofPattern(pattern));
    }
}
