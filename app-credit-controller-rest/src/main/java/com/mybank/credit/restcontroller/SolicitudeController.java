package com.mybank.credit.restcontroller;

import com.mybank.credit.restcontroller.commons.CustomResponse;
import com.mybank.credit.restcontroller.request.SolicitudeRestRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.mybank.credit.restcontroller.constants.GloblaAPIEndPointsConstants.API_SOLICITUDE;
import static com.mybank.credit.restcontroller.constants.GloblaAPIParamsConstants.PAGE_SIZE;
import static com.mybank.credit.restcontroller.constants.GloblaAPIParamsConstants.PAGE_NUMBER;

@RequestMapping(API_SOLICITUDE)
public interface SolicitudeController {

    @GetMapping("/{idSolicitude}")
    ResponseEntity<CustomResponse> findBySolicitudeId(@PathVariable Long idSolicitude);

    @GetMapping
    ResponseEntity<CustomResponse> findAll(
            @RequestParam(value = "typeDocument", defaultValue = "") String typeDocument,
            @RequestParam(value = "documentNumber", defaultValue = "") String documentNumber,
            @RequestParam(value = "size", defaultValue = PAGE_SIZE) Integer size,
            @RequestParam(value = "page", defaultValue = PAGE_NUMBER) Integer page);

    @PostMapping
    ResponseEntity<CustomResponse> save(@RequestBody SolicitudeRestRequest request);
}
