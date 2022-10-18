package com.employeedetails.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.employeedetails.model.EmployeeDetails;

@Repository
public interface EmployeeDetailsRepository  extends JpaRepository<EmployeeDetails, Integer>{
	
	@Query(value="SELECT e.employee_details_code FROM employee_details e WHERE e.employee_facility = :employee_facility AND e.emp_type = :emp_type AND e.cs_or_non_cs = :cs_or_non_cs AND e.grade_or_subgrade = :grade_or_subgrade AND e.drona_or_non_drona = :drona_or_non_drona", nativeQuery = true)
	public Integer findByEmployeeDetail(@Param("emp_type") String emp_type, @Param("employee_facility") String employee_facility, @Param("cs_or_non_cs") String cs_or_non_cs,
			@Param("grade_or_subgrade") String grade_or_subgrade, @Param("drona_or_non_drona") String drona_or_non_drona);

}
