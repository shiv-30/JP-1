package com.assessment_details.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table
public class Assessment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int assessment_details_code;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private LocalDate exam_end_date;
	
	private String exam_end_date_status;
	public Assessment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Assessment(int assessment_details_code, LocalDate exam_end_date, String exam_end_date_status) {
		super();
		this.assessment_details_code = assessment_details_code;
		this.exam_end_date = exam_end_date;
		this.exam_end_date_status = exam_end_date_status;
	}
	public int getAssessment_details_code() {
		return assessment_details_code;
	}
	public void setAssessment_details_code(int assessment_details_code) {
		this.assessment_details_code = assessment_details_code;
	}
	public LocalDate getExam_end_date() {
		return exam_end_date;
	}
	public void setExam_end_date(LocalDate exam_end_date) {
		this.exam_end_date = exam_end_date;
	}
	public String getExam_end_date_status() {
		return exam_end_date_status;
	}
	public void setExam_end_date_status(String exam_end_date_status) {
		this.exam_end_date_status = exam_end_date_status;
	}
	
}
