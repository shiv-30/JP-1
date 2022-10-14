package com.employeedetails.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employeedetails.model.EmployeeDetails;

@Repository
public interface EmployeeDetailsRepository  extends JpaRepository<EmployeeDetails, Integer>{

}
