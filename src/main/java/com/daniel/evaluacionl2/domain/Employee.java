package com.daniel.evaluacionl2.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;


@Data
@Entity
@Table(name = "employee")
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EmployeeId")
    private Long employeeid;
    @Column(name = "TaxIdNumber")
    private String taxidnumber;
    @Column(name = "Name")
    private String name;
    @Column(name = "LastName")
    private String lastname;
    @Column(name = "BirthDay")
    private Date birthday;
    @Column(name = "Email")
    private String email;
    @Column(name = "CellPhone")
    private String cellphone;
    @Column(name = "IsActive")
    private Integer isactive;
    @Column(name = "DateCreated")
    private Timestamp datecreated;
}
