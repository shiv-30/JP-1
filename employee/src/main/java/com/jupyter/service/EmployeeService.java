package com.jupyter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jupyter.model.Employee;

@Service
public class EmployeeService {

	@Autowired
	com.jupyter.repository.EmployeeRepository EmployeeRepository;

	public List<Employee> getAllEmployee() {
		return EmployeeRepository.findAll();
	}

	public Employee saveOrUpdate(Employee Employee) {
		return EmployeeRepository.save(Employee);
	}

	public Employee getEmployeeById(int empCode) {
		return EmployeeRepository.findById(empCode).get();
	}

	public void delete(int empCode) {
		EmployeeRepository.deleteById(empCode);
	}

}
