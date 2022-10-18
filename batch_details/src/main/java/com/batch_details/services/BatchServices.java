package com.batch_details.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.batch_details.entities.Batch;
import com.batch_details.repository.BatchRepository;

@Component
public class BatchServices {
	@Autowired
	private BatchRepository batchRepository;
	
	//private static List<Batch> list = new ArrayList<>();
	
	/*
	 * static { list.add(new Batch(1,"feb","java")); list.add(new
	 * Batch(2,"feb","python")); list.add(new Batch(3,"feb",".net")); }
	 */
	
	
	//get all batch
	public List<Batch> getAllBatchs(){
		List<Batch> list = (List<Batch>)this.batchRepository.findAll();
		return list;
	}
	
	//get single batch by id;
	public Batch getBatchById(int id) {
		
		Batch batch = null;
		try {
			//batch=list.stream().filter(e->e.getBatch_code()==id).findAny().get();
			batch = this.batchRepository.findById(id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return batch;
	}
	
	//adding the batch;
	public Batch addBatch(Batch b)
	{
		Batch result = batchRepository.save(b);
		return result;
	}
	
	//delete batch
	public void deleteBatch(int bid) {
		//list = list.stream().filter(batch ->batch.getBatch_code()!=bid).collect(Collectors.toList());
		batchRepository.deleteById(bid);
	}
	
	//update batch
	public Integer updateBatch(Batch batch, Integer batchId) {
		
		String training_batch = batch.getTraining_batch();
		String gems_batch = batch.getGems_batch();
		
		Batch newBatch = new Batch();
		newBatch.setTraining_batch(training_batch);
		newBatch.setGems_batch(gems_batch);
		
		batchId = batchRepository.findByBatchDetail(training_batch, gems_batch);
		
		if(batchId == null) {
			Batch updatedBatchRecord = batchRepository.save(newBatch);
			batchId = updatedBatchRecord.getBatch_code();
		}
		
		return batchId;
	}
}

/*
 * 
 * public update(Batch batch)
 * */
