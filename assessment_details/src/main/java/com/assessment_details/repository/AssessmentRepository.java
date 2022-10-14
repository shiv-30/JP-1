package com.assessment_details.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assessment_details.model.Assessment;

@Repository
public interface AssessmentRepository extends JpaRepository<Assessment, Integer> {
	
	public Assessment findById(int assessment_details_code);
}
