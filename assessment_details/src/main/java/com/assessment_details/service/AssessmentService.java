package com.assessment_details.service;

import java.time.LocalDate;
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
	
	public Integer update(Assessment assessment, Integer assessment_details_code) {
		LocalDate exam_end_date = assessment.getExam_end_date();
		String exam_end_date_status = assessment.getExam_end_date_status();
		
		Assessment newAssessment = new Assessment();
		newAssessment.setExam_end_date(exam_end_date);
		newAssessment.setExam_end_date_status(exam_end_date_status);
		
		assessment_details_code = assessmentRepository.findByAssessmentDetail(exam_end_date, exam_end_date_status);
		
		if(assessment_details_code == null) {
			Assessment record = assessmentRepository.save(newAssessment);
			assessment_details_code = record.getAssessment_details_code();
		}
		
		return assessment_details_code;
		
	}
	
}
