package com.employeedetails.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeedetails.model.EmployeeDetails;
import com.employeedetails.repository.EmployeeDetailsRepository;


@Service
public class EmployeeDetailsService {

	@Autowired
	EmployeeDetailsRepository employeeDetailsRepository;

	public List<EmployeeDetails> getAllEmployeeDetails() {
		return employeeDetailsRepository.findAll();
	}

	public Integer update(EmployeeDetails employeeDetails, Integer employee_details_code) {
		 
		String emp_type = employeeDetails.getEmp_type();
		String employee_facility = employeeDetails.getEmployee_facility();
		String cs_or_non_cs = employeeDetails.getCs_or_non_cs();
		String grade_or_subgrade = employeeDetails.getGrade_or_subgrade();
		String drona_or_non_drona = employeeDetails.getDrona_or_non_drona();
		
		EmployeeDetails newEmployeeDetails = new EmployeeDetails(emp_type, employee_facility, cs_or_non_cs, grade_or_subgrade,
				drona_or_non_drona);
		
		employee_details_code = employeeDetailsRepository.findByEmployeeDetail(emp_type, employee_facility, cs_or_non_cs, grade_or_subgrade, drona_or_non_drona);
		
		if(employee_details_code == null) {
			EmployeeDetails updatedEmployeeDetails = employeeDetailsRepository.save(newEmployeeDetails);
			employee_details_code = updatedEmployeeDetails.getEmployee_details_code();
			System.out.println(employee_details_code);
		}
		
		return employee_details_code;
	}
	
	public EmployeeDetails save(EmployeeDetails employeeDetails) {
		return employeeDetailsRepository.save(employeeDetails);
	}
	public EmployeeDetails getEmployeeById(int employee_details_code) {
		return employeeDetailsRepository.findById(employee_details_code).get();
	}

	public void deleteEmployeeDetails(int employee_details_code) {
		employeeDetailsRepository.deleteById(employee_details_code);
	}

}
