package com.mybank.credit.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(schema = "credit", name = "Solicitudedetail")
public class SolicitudeDetailMySqlEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="solicitudedetailid")
    private Long solicitudeDetailId;
    @Column(name="solicitudeid")
    private Long solicitudeId;
    @Column(name="termnumber")
    private Integer termNumber;
    @Column(name="paymentdate")
    private LocalDate paymentDate;
    @Column(name="principal")
    private Double principal;
    @Column(name="amortization")
    private Double amortization;
    @Column(name="interest")
    private Double interest;
    @Column(name="termamount")
    private Double termAmount;
    @Column(name="itf")
    private Double itf;
    @Column(name="termamounttotal")
    private Double termAmountTotal;
}
