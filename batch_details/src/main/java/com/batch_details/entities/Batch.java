package com.batch_details.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="batch")
public class Batch {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int batch_code;
	private String training_batch;
	private String gems_batch;
	public Batch(int batch_code, String training_batch, String gems_batch) {
		super();
		this.batch_code = batch_code;
		this.training_batch = training_batch;
		this.gems_batch = gems_batch;
	}
	
	public Batch() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getBatch_code() {
		return batch_code;
	}
	public void setBatch_code(int batch_code) {
		this.batch_code = batch_code;
	}
	public String getTraining_batch() {
		return training_batch;
	}
	public void setTraining_batch(String training_batch) {
		this.training_batch = training_batch;
	}
	public String getGems_batch() {
		return gems_batch;
	}
	public void setGems_batch(String gems_batch) {
		this.gems_batch = gems_batch;
	}
	@Override
	public String toString() {
		return "Batch [batch_code=" + batch_code + ", training_batch=" + training_batch + ", gems_batch=" + gems_batch
				+ "]";
	}
	
	
}
