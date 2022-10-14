package com.batch_details.repository;

import org.springframework.data.repository.CrudRepository;

import com.batch_details.entities.Batch;

public interface BatchRepository extends CrudRepository<Batch, Integer> {
	
	public Batch findById(int id);
	
}
