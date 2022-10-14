package com.jupyter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.jupyter.model.Employee;
import com.jupyter.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	//get data from database
	@GetMapping("/employee")
	private List<Employee> getAllEmployee(){
		return employeeService.getAllEmployee();
	}
	
	
	//save data into the database
	@PostMapping("/employee")  
	private Employee saveEmployee(@RequestBody Employee Employee)   
	{  
	return employeeService.saveOrUpdate(Employee);  
	}  
	
	//get data by ID
	@GetMapping("/employee/{empCode}")  
	private Employee getEmployeeById(@PathVariable("empCode") int empCode)   
	{  
	return employeeService.getEmployeeById(empCode);  
	}  
	
	//delete data
	@DeleteMapping("/employee/{empCode}")  
	private void deleteBook(@PathVariable("empCode") int empCode)   
	{  
	employeeService.delete(empCode);  
	}  
	
	//edit data
	@PutMapping("/employee")  
	private Employee update(@RequestBody Employee Employee)   
	{  
	employeeService.saveOrUpdate(Employee);  
	return Employee;  
	}  
	
}
