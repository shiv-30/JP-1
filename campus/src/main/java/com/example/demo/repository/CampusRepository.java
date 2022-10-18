package com.example.demo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Campus;

@Repository
public interface CampusRepository extends CrudRepository<Campus, Integer> {
	public Campus findById(int id);
	
	
	@Query(value="SELECT c.campus_code FROM campus c WHERE c.comments = :comments", nativeQuery = true)
	public Integer findByComment(@Param("comments") String comments);

}
