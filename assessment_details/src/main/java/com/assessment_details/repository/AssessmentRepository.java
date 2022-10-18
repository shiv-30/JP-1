package com.assessment_details.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.assessment_details.model.Assessment;

@Repository
public interface AssessmentRepository extends JpaRepository<Assessment, Integer> {
	
	public Assessment findById(int assessment_details_code);
	
	@Query(value="SELECT a.assessment_details_code FROM assessment a WHERE a.exam_end_date = :exam_end_date AND a.exam_end_date_status = :exam_end_date_status", nativeQuery = true)
	public Integer findByAssessmentDetail(@Param("exam_end_date") LocalDate exam_end_date, @Param("exam_end_date_status") String exam_end_date_status);

	
	
	
}
