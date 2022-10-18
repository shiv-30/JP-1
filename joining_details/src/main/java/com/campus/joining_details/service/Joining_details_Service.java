package com.campus.joining_details.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campus.joining_details.repository.Joining_details_Repository;
import com.campus.joining_details.domain.Joining_details;

@Service
public class Joining_details_Service {
	@Autowired
	private Joining_details_Repository joining_details_Repo;

	public List<Joining_details> getAllJoiningDetails() {
		return joining_details_Repo.findAll();
	}

	public Joining_details save(Joining_details join_details) {
		return joining_details_Repo.save(join_details);
	}

	public Joining_details getJoiningDetailById(int joining_details_code) {
		return joining_details_Repo.findById(joining_details_code).get();
	}

	public void delete(int joining_details_code) {
		joining_details_Repo.deleteById(joining_details_code);
	}
	
	public Integer update(Joining_details joining_details, Integer joining_details_code) {
		

		Joining_details newJoiningDetails = new Joining_details(joining_details.getJoining_fy_as_fte(), joining_details.getFte_joining_date(),joining_details.getPls_joining_date(), joining_details.getJoining_psl(), joining_details.getWfo_date(), joining_details.getBase_location());
		
		joining_details_code = joining_details_Repo.findByJoiningDetails(joining_details.getJoining_fy_as_fte(), joining_details.getFte_joining_date(), joining_details.getPls_joining_date(), joining_details.getJoining_psl(), joining_details.getWfo_date(), joining_details.getBase_location());
		
		if(joining_details_code == null) {
			Joining_details updatedJoining_details = joining_details_Repo.save(newJoiningDetails);
			joining_details_code = updatedJoining_details.getJoining_details_code();
		}
		
		return joining_details_code;
	}
}
