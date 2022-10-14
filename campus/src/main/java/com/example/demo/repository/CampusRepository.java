package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.entities.Campus;

public interface CampusRepository extends CrudRepository<Campus, Integer> {
	public Campus findById(int id);
}
