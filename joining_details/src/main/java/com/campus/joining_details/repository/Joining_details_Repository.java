package com.campus.joining_details.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.campus.joining_details.domain.Joining_details;

@Repository
public interface Joining_details_Repository extends JpaRepository<Joining_details, Integer>{

}
