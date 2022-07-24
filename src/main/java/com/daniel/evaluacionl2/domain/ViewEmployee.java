package com.daniel.evaluacionl2.domain;

import lombok.Data;

import javax.persistence.Entity;
import java.sql.Date;

@Data
public class ViewEmployee {

    private Long idemployee;
    private String fullname;
    private String taxidnumber;
    private String email;
    private String contractname;
    private Date datefrom;
    private Date dateto;
    private double salary;

}
