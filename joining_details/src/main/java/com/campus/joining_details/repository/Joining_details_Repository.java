package com.campus.joining_details.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.campus.joining_details.domain.Joining_details;

@Repository
public interface Joining_details_Repository extends JpaRepository<Joining_details, Integer>{
	
	@Query(value="SELECT j.joining_details_code FROM joining_details j WHERE j.joining_fy_as_fte = :joining_fy_as_fte AND j.fte_joining_date = :fte_joining_date AND j.pls_joining_date = :pls_joining_date AND j.joining_psl = :joining_psl AND j.wfo_date = :wfo_date AND j.base_location = :base_location", nativeQuery = true)
	public Integer findByJoiningDetails(@Param("joining_fy_as_fte") String joining_fy_as_fte,@Param("fte_joining_date") LocalDate fte_joining_date,@Param("pls_joining_date") LocalDate pls_joining_date,
			@Param("joining_psl")String joining_psl, @Param("wfo_date")LocalDate wfo_date, @Param("base_location")String base_location);

}
