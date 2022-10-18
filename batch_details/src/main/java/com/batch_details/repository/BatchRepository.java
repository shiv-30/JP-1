package com.batch_details.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.batch_details.entities.Batch;

public interface BatchRepository extends CrudRepository<Batch, Integer> {
	
	public Batch findById(int id);
	
	@Query(value="SELECT b.batch_code FROM batch b WHERE b.training_batch = :training_batch AND b.gems_batch = :gems_batch", nativeQuery = true)
	public Integer findByBatchDetail(@Param("training_batch") String training_batch, @Param("gems_batch") String gems_batch);
	
	
}
