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

	public EmployeeDetails saveOrUpdate(EmployeeDetails EmployeeDetails) {
		return employeeDetailsRepository.save(EmployeeDetails);
	}

	public EmployeeDetails getEmployeeById(int employee_details_code) {
		return employeeDetailsRepository.findById(employee_details_code).get();
	}

	public void deleteEmployeeDetails(int employee_details_code) {
		employeeDetailsRepository.deleteById(employee_details_code);
	}

}
