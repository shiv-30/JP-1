package com.employeedetails.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employeedetails.model.EmployeeDetails;
import com.employeedetails.service.EmployeeDetailsService;

import reactor.core.publisher.Mono;

@RestController
public class EmployeeDetailsController {
	
	@Autowired
	EmployeeDetailsService employeeDetailsService;
	
	//get data from database
	@GetMapping("/employeeDetails")
	private List<EmployeeDetails> getAllEmployee(){
		return employeeDetailsService.getAllEmployeeDetails();
	}
	
	
	//save data into the database
	@PostMapping("/employeeDetails")  
	private EmployeeDetails saveEmployee(@RequestBody EmployeeDetails EmployeeDetails)   
	{  
	return employeeDetailsService.save(EmployeeDetails);  
	}  
	
	//get data by ID
	@GetMapping("/employeeDetails/{employee_details_code}")  
	private EmployeeDetails getEmployeeById(@PathVariable("employee_details_code") int employee_details_code)   
	{  
	return employeeDetailsService.getEmployeeById(employee_details_code);  
	}  
	
	//delete data
	@DeleteMapping("/employeeDetails/{employee_details_code}")  
	private void deleteBook(@PathVariable("employee_details_code") int employee_details_code)   
	{  
		employeeDetailsService.deleteEmployeeDetails(employee_details_code);  
	}  
	
	//edit data
	@PutMapping("/employeeDetails/{employee_details_code}")  
	private Mono<Integer> update(@RequestBody EmployeeDetails EmployeeDetails, @PathVariable("employee_details_code") int employee_details_code) {
		Integer employeeDetailsId = employeeDetailsService.update(EmployeeDetails, employee_details_code);
		Mono<Integer> responseObject = Mono.just(employeeDetailsId);
		return responseObject;
	}
	
	
	
}
