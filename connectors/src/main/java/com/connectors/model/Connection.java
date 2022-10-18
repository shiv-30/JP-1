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
	public int getEmp_code() {
		return emp_code;
	}
	public void setEmp_code(int emp_code) {
		this.emp_code = emp_code;
	}
	public int getCampus_code() {
		return campus_code;
	}
	public void setCampus_code(int campus_code) {
		this.campus_code = campus_code;
	}
	public int getEmployee_details_code() {
		return employee_details_code;
	}
	public void setEmployee_details_code(int employee_details_code) {
		this.employee_details_code = employee_details_code;
	}
	public int getBatch_details_code() {
		return batch_details_code;
	}
	public void setBatch_details_code(int batch_details_code) {
		this.batch_details_code = batch_details_code;
	}
	public int getJoining_details_code() {
		return joining_details_code;
	}
	public void setJoining_details_code(int joining_details_code) {
		this.joining_details_code = joining_details_code;
	}
	public int getAssessment_details_code() {
		return assessment_details_code;
	}
	public void setAssessment_details_code(int assessment_details_code) {
		this.assessment_details_code = assessment_details_code;
	}
	public Connection(int emp_code, int campus_code, int employee_details_code, int batch_details_code,
			int joining_details_code, int assessment_details_code) {
		super();
		this.emp_code = emp_code;
		this.campus_code = campus_code;
		this.employee_details_code = employee_details_code;
		this.batch_details_code = batch_details_code;
		this.joining_details_code = joining_details_code;
		this.assessment_details_code = assessment_details_code;
	}
	public Connection() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}
