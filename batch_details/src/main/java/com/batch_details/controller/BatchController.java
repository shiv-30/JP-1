package com.batch_details.controller;


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

import com.batch_details.entities.Batch;
import com.batch_details.services.BatchServices;

@RestController
public class BatchController {
	
	@Autowired
	private BatchServices batchServices;
	
	//get all books
	@GetMapping("/batchs")
	public ResponseEntity<List<Batch>> getBatchs() {
		List<Batch> list = batchServices.getAllBatchs();
		if(list.size()<=0)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.ok(list);
	}
	
	// get single batch
	@GetMapping("/batchs/{id}")
	public Batch getBatch(@PathVariable("id") int id) {
		Batch batch = batchServices.getBatchById(id);
//		if(batch==null)
//		{
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//		}
		return batch;
	}
	
	//add new batch
	@PostMapping("/batchs")
	public ResponseEntity<Batch> addBatch(@RequestBody Batch batch) {
		Batch b = null;
		try {
			b = this.batchServices.addBatch(batch);
			return ResponseEntity.of(Optional.of(b));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	//delete batch
	@DeleteMapping("/batchs/{batchId}")
	public ResponseEntity<Void> deleteBatch(@PathVariable("batchId") int batchId) {
		try {
			this.batchServices.deleteBatch(batchId);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			
		}
	}
	
	//update bathc
	@PutMapping("/batchs/{batchId}")
	public ResponseEntity<Batch> updateBatch(@RequestBody Batch batch,@PathVariable("batchId") int batchId) {
		try {
			this.batchServices.updateBatch(batch,batchId);
			return ResponseEntity.ok().body(batch);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
}
