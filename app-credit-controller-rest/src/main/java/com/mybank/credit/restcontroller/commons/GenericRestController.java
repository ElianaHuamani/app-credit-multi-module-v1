package com.mybank.credit.restcontroller.commons;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static com.mybank.credit.restcontroller.constants.GloblaAPIMessageConstants.API_MSG_GET_NOT_FOUND;
import static com.mybank.credit.restcontroller.constants.GloblaAPIMessageConstants.API_MSG_GET_SUCCESS;
import static java.util.Objects.isNull;

public class GenericRestController {
    protected ResponseEntity<CustomResponse> ok(List<?> lst) {
        return ResponseEntity.ok(CustomResponse.builder()
                .code(String.valueOf(HttpStatus.OK.value()))
                .message(API_MSG_GET_SUCCESS)
                .response(lst)
                .build());
    }

    protected ResponseEntity<CustomResponse> ok(Object object) {
        return ResponseEntity.ok(CustomResponse.builder()
                .code(String.valueOf(HttpStatus.OK.value()))
                .message(API_MSG_GET_SUCCESS)
                .response(object)
                .build());
    }

    protected ResponseEntity<CustomResponse> notFound() {
        return ResponseEntity.ok(CustomResponse.builder()
                .code(HttpStatus.NOT_FOUND.toString())
                .message(API_MSG_GET_NOT_FOUND)
                .build());
    }

    protected ResponseEntity<CustomResponse> badRequest(String msg) {
        return ResponseEntity.badRequest().body(CustomResponse.builder()
                .code(HttpStatus.BAD_REQUEST.toString())
                .message(msg)
                .build());
    }

    protected ResponseEntity<CustomResponse> setListResponse(List<?> lst) {
        return lst.isEmpty() ? notFound() : ok(lst);
    }

    protected ResponseEntity<CustomResponse> setResponse(Object object) {
        return isNull(object) ? notFound() : ok(object);
    }
}
