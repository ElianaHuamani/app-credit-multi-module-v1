package com.mybank.credit.restcontroller.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Builder
@JsonPropertyOrder({"solicitudeId", "name", "lastName", "email", "phone", "amount", "lstSolicitudeDetailResponseModel"})
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class SolicitudeRestResponse {
    private Long  solicitudeId;
    private String name;
    private String lastName;
    private String email;
    private String phone;
    private Integer amount;
    private LocalDate disbursementDate;
    private Integer terms;
    private Double tea;
    private Double termAmount;
    private Double totalAmount;
    private List<SolicitudeDetailRestResponse> solicitudeDetail;
}
