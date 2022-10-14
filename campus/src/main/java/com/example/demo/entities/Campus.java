package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="campus")
public class Campus {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int campus_code;
	private String comments;
	public Campus(int campus_code, String comments) {
		super();
		this.campus_code = campus_code;
		this.comments = comments;
	}
	public Campus() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getCampus_code() {
		return campus_code;
	}
	public void setCampus_code(int campus_code) {
		this.campus_code = campus_code;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	@Override
	public String toString() {
		return "Campus [campus_code=" + campus_code + ", comments=" + comments + "]";
	}
	
	
}
