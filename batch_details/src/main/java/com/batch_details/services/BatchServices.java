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
	public void updateBatch(Batch batch,int batchId) {
		//list = list.stream().map(b->{
		//	if(b.getBatch_code()==batchId) {
		//		b.setGems_batch(batch.getGems_batch());
		//		b.setTraining_batch(batch.getTraining_batch());
		//	}
		//	return b;
		//}).collect(Collectors.toList());
		batch.setBatch_code(batchId);
		batchRepository.save(batch);
	}
}

/*
 * 
 * public update(Batch batch)
 * */
