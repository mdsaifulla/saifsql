package com.saiful.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.saiful.demo.model.Alien;

public interface AlienRepo extends JpaRepository<Alien,Integer>
{

	/*List<Alien>findByTech(String tech);
	
	List<Alien>findByAidGreaterThan(int aid);
	@Query("from Alien where Tech=?1 order by aname")
	List<Alien>findByTechSorted(String tech);*/
}
