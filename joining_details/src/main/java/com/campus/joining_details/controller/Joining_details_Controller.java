package com.campus.joining_details.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.campus.joining_details.domain.Joining_details;
import com.campus.joining_details.service.Joining_details_Service;

@RestController
public class Joining_details_Controller {

	@Autowired
	Joining_details_Service joiningService;

	// get data from database
	@GetMapping("/joiningDetails")
	private List<Joining_details> getAllJoiningDetails() {
		return joiningService.getAllJoiningDetails();
	}

	// save data into the database
	@PostMapping("/joiningDetail")
	private Joining_details saveDetail(@RequestBody Joining_details joining_details) {
		return joiningService.saveOrUpdate(joining_details);
	}

	// get data by ID
	@GetMapping("/joiningDetail/{joinCode}")
	private Joining_details getJoiningDetailById(@PathVariable("joinCode") int joinCode) {
		return joiningService.getJoiningDetailById(joinCode);
	}

	// delete data
	@DeleteMapping("/joiningDetail/{joinCode}")
	private void deleteBook(@PathVariable("joinCode") int joinCode) {
		joiningService.delete(joinCode);
	}

	// edit data
	@PutMapping("/joiningDetail")
	private Joining_details update(@RequestBody Joining_details joining_details) {
		joiningService.saveOrUpdate(joining_details);
		return joining_details;
	}

}
