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

	public Joining_details saveOrUpdate(Joining_details join_details) {
		return joining_details_Repo.save(join_details);
	}

	public Joining_details getJoiningDetailById(int joining_details_code) {
		return joining_details_Repo.findById(joining_details_code).get();
	}

	public void delete(int joining_details_code) {
		joining_details_Repo.deleteById(joining_details_code);
	}
}
