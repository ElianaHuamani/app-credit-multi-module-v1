package com.mybank.credit.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@Data
@MappedSuperclass
public class GenericMySqlEntity implements Serializable {
    private static final long serialVersionUID = -8476106679682617186L;
    @Column(name = "Status")
    public String status;
}
