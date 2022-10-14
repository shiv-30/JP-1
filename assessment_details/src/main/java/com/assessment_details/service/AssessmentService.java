package com.assessment_details.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assessment_details.model.Assessment;
import com.assessment_details.repository.AssessmentRepository;

@Service
public class AssessmentService {
	
	@Autowired
	private AssessmentRepository assessmentRepository;
	
	public List<Assessment> getAllAssessmentDetails() {
		return assessmentRepository.findAll();
	}
	
	public Assessment getAssessmentById(int assessment_details_code) {
		return assessmentRepository.findById(assessment_details_code);
	}
	
	public Assessment saveOrUpdate(Assessment assessment) {
		return assessmentRepository.save(assessment);
	}
	
	public void delete(int assessment_details_code) {
		assessmentRepository.deleteById(assessment_details_code);
	}
	
}
