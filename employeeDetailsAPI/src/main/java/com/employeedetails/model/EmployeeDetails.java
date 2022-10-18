package com.employeedetails.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table
public class EmployeeDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int employee_details_code;
	private String emp_type;
	private String employee_facility;
	private String cs_or_non_cs;
	public EmployeeDetails(String emp_type, String employee_facility, String cs_or_non_cs, String grade_or_subgrade,
			String drona_or_non_drona) {
		super();
		this.emp_type = emp_type;
		this.employee_facility = employee_facility;
		this.cs_or_non_cs = cs_or_non_cs;
		this.grade_or_subgrade = grade_or_subgrade;
		this.drona_or_non_drona = drona_or_non_drona;
	}
	private String grade_or_subgrade;
	private String drona_or_non_drona;
	public EmployeeDetails(int employee_details_code, String emp_type, String employee_facility, String cs_or_non_cs,
			String grade_or_subgrade, String drona_or_non_drona) {
		super();
		this.employee_details_code = employee_details_code;
		this.emp_type = emp_type;
		this.employee_facility = employee_facility;
		this.cs_or_non_cs = cs_or_non_cs;
		this.grade_or_subgrade = grade_or_subgrade;
		this.drona_or_non_drona = drona_or_non_drona;
	}
	public EmployeeDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getEmployee_details_code() {
		return employee_details_code;
	}
	public void setEmployee_details_code(int employee_details_code) {
		this.employee_details_code = employee_details_code;
	}
	public String getEmp_type() {
		return emp_type;
	}
	public void setEmp_type(String emp_type) {
		this.emp_type = emp_type;
	}
	public String getEmployee_facility() {
		return employee_facility;
	}
	public void setEmployee_facility(String employee_facility) {
		this.employee_facility = employee_facility;
	}
	public String getCs_or_non_cs() {
		return cs_or_non_cs;
	}
	public void setCs_or_non_cs(String cs_or_non_cs) {
		this.cs_or_non_cs = cs_or_non_cs;
	}
	public String getGrade_or_subgrade() {
		return grade_or_subgrade;
	}
	public void setGrade_or_subgrade(String grade_or_subgrade) {
		this.grade_or_subgrade = grade_or_subgrade;
	}
	public String getDrona_or_non_drona() {
		return drona_or_non_drona;
	}
	public void setDrona_or_non_drona(String drona_or_non_drona) {
		this.drona_or_non_drona = drona_or_non_drona;
	}
	@Override
	public String toString() {
		return "EmployeeDetails [employee_details_code=" + employee_details_code + ", emp_type=" + emp_type
				+ ", employee_facility=" + employee_facility + ", cs_or_non_cs=" + cs_or_non_cs + ", grade_or_subgrade="
				+ grade_or_subgrade + ", drona_or_non_drona=" + drona_or_non_drona + "]";
	}
	
	
	
	
	
}
