package com.daniel.evaluacionl2.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "contract")
public class Contract implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ContractId;
    private Long EmployeeId;
    private Long ContractTypeId;
    private Date DateFrom;
    private Date DateTo;
    private double SalaryPerDay;
    private Integer IsActive;
    private Timestamp DateCreated;


}
