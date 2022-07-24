package com.daniel.evaluacionl2.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

@Data
@Entity
@Table(name = "contracttype")
public class ContractType implements Serializable {

    private static final long serialVersonUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ContractTypeId;
    private String Name;
    private String Description;
    private Integer isActive;
    private Timestamp DateCreated;
}
