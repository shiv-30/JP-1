package com.connectors.model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "connectors")
@Data
public class Connection {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int emp_code;
    private int campus_code;
    private int employee_details_code;
    private int batch_details_code;
    private int joining_details_code;
    private int assessment_details_code;
}
