package com.mybank.credit.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(schema = "credit", name = "Solicitude")
public class SolicitudeMySqlEntity extends GenericMySqlEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="solicitudeid")
    private Long solicitudeId;
    @Column(name = "name")
    private String name;
    @Column(name = "lastname")
    private String lastName;
    @Column(name = "typedocument")
    private String typeDocument;
    @Column(name = "documentnumber")
    private String documentNumber;
    @Column(name = "amount")
    private Integer amount;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;
    @Column(name = "enddate")
    private LocalDate endDate;
    @Column(name = "disbursementdate")
    private LocalDate disbursementDate;
    @Column(name = "terms")
    private Integer terms;
    @Column(name = "tea")
    private Double tea;
    @Column(name = "termamount")
    private Double termAmount;
    @Column(name = "totalamount")
    private Double totalAmount;
}
