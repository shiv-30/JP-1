package com.example.demo.services;
import java.util.ArrayList;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Campus;
import com.example.demo.repository.CampusRepository;


@Service
public class CampusServices {
	@Autowired
	private CampusRepository campusRepository;
	
	//private static List<Batch> list = new ArrayList<>();
	
	/*
	 * static { list.add(new Batch(1,"feb","java")); list.add(new
	 * Batch(2,"feb","python")); list.add(new Batch(3,"feb",".net")); }
	 */
	
	
	//get all batch
	public List<Campus> getAllCampus(){
		List<Campus> list = (List<Campus>)this.campusRepository.findAll();
		return list;
	}
	
	//get single batch by id;
	public Campus getCampusById(int id) {
		
		Campus campus = null;
		try {
			//batch=list.stream().filter(e->e.getBatch_code()==id).findAny().get();
			campus = this.campusRepository.findById(id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return campus;
	}
	
	//adding the batch;
	public Campus addCampus(Campus b)
	{
		Campus result = campusRepository.save(b);
		return result;
	}
	
	//delete batch
	public void deleteCampus(int bid) {
		//list = list.stream().filter(batch ->batch.getBatch_code()!=bid).collect(Collectors.toList());
		campusRepository.deleteById(bid);
	}
	
	//update batch
	public Integer updateCampus(Campus campus,Integer campus_code) {
		
		
		
		String comments = campus.getComments();

		
		Campus newCampus = new Campus();
		newCampus.setComments(comments);
		
		campus_code = campusRepository.findByComment(comments);
		
		if(campus_code == null) {
			Campus record = campusRepository.save(newCampus);
			campus_code = record.getCampus_code();
			
		}

		return campus_code;
	}

}
