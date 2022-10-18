package com.assessment_details.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.assessment_details.model.Assessment;
import com.assessment_details.service.AssessmentService;

import reactor.core.publisher.Mono;

@RestController
public class HomeController {
	@Autowired
	private AssessmentService assessmentService;
	
	@GetMapping("/assessment/{assessment_details_code}")
	public Assessment getAssessmentById(@PathVariable int assessment_details_code) {
		return assessmentService.getAssessmentById(assessment_details_code);
	}
	
	@GetMapping("/assessment")
	public List<Assessment> getAllAssessment() {
		return assessmentService.getAllAssessmentDetails();
	}
	
	@PutMapping("/assessment/{assessment_details_code}")
	public Mono<Integer> updateAssessmentDetail(@RequestBody Assessment assessment, @PathVariable("assessment_details_code") Integer assessment_details_code) {
		Integer updatedAssessmentDetailsCode = assessmentService.update(assessment, assessment_details_code);
		Mono<Integer> responseObject = Mono.just(updatedAssessmentDetailsCode);
		return responseObject;
	}
	
}
