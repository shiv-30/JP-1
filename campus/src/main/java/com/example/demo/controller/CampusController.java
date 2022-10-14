package com.example.demo.controller;
import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Campus;
import com.example.demo.services.CampusServices;


@RestController
public class CampusController {
	@Autowired
	private CampusServices campusServices;
	
	//get all Campus
	@GetMapping("/campus")
	public ResponseEntity<List<Campus>> getCampus() {
		List<Campus> list = campusServices.getAllCampus();
		return  ResponseEntity.ok(list);
	}
	
	// get single Campus 
	@GetMapping("/campus/{id}")
	public Campus getCampus(@PathVariable("id") int id) {
		Campus campus = campusServices.getCampusById(id);
		return campus;
	}
	
	//add new Campus
	@PostMapping("/campus")
	public void addCampus(@RequestBody Campus campus) {
		Campus b = null;
		try {
			b = this.campusServices.addCampus(campus);
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}
		
	}
	
	//delete campus
	@DeleteMapping("/campus/{campusId}")
	public ResponseEntity<Void> deleteCampus(@PathVariable("campusId") int campusId) {
		try {
			this.campusServices.deleteCampus(campusId);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			
		}
	}
	
	//update campus
	@PutMapping("/campuss/{campusId}")
	public ResponseEntity<Campus> updateCampus(@RequestBody Campus campus,@PathVariable("campusId") int campusId) {
		try {
			this.campusServices.updateCampus(campus,campusId);
			return ResponseEntity.ok().body(campus);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}

}
