package com.jupyter.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity  
@Table
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int empCode;
	private String empName;
	private String email;
	private String mobileNumber;
	private String gender;
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	public Employee(int empCode, String empName, String email, String mobileNumber, String gender) {
		super();
		this.empCode = empCode;
		this.empName = empName;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.gender = gender;
	}
	public int getEmpCode() {
		return empCode;
	}
	public void setEmpCode(int empCode) {
		this.empCode = empCode;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "Employee [empCode=" + empCode + ", empName=" + empName + ", email=" + email + ", mobileNumber="
				+ mobileNumber + ", gender=" + gender + "]";
	}
	
	
	
	

}